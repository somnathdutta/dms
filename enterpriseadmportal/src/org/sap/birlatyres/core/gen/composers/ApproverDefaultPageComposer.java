package org.sap.birlatyres.core.gen.composers;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkmax.zul.Tablelayout;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Textbox;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.mindgentrix.encryption.DocumentDecryptor;
import org.mindgentrix.encryption.DocumentEncryptor;
import org.mindgentrix.web.googledrive.GoogleDriveHandler;
import org.sap.birlatyres.core.gen.bean.*;
import org.sap.birlatyres.core.gen.dao.*;

import com.google.api.client.util.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;

public class ApproverDefaultPageComposer extends GenericForwardComposer{
	//Define Common members here
	Div zmenu, zgrid, zform, main;
	Menuitem mLoad, mPrint;
	Listbox datalistbox,searchdatalistbox;
	Label editId;
	Tablelayout tbl;
	String mode = "";
	//Define ZUL Specific Fields here
	
	ControldocumentDAO controldocumentDAO = new ControldocumentDAO(); 
	ControldocumentBean webbean = null ;
	private UsermasterBean usermasterBean; 
	private PrivilegeregisterDAO privilegeregisterDAO ;
	
	String groupCode = "" ;
	
	Iframe fileframe ;
	
	private GoogleDriveHandler googleDriveHandler ;
	
	private ApplicationBean applicationBean = null ;
	
	Bandbox searchbox ;
	
	Datebox searchdatefrom ;
	
	Datebox searchdateto ;
	
	Textbox version ;
	
	Textbox documentno ;
	
	Textbox documentname ;

	Button btnsearch ;
	
	Tab maintab ;
	Tab searchtab;
	
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		
		usermasterBean = (UsermasterBean) session.getAttribute("USERBEAN");
		
		if(usermasterBean == null){
			
			Executions.sendRedirect("/welcome.zul");
									
		}
	
		applicationBean = (ApplicationBean) session.getAttribute("APPLICATIONBEAN");
		
		privilegeregisterDAO = new PrivilegeregisterDAO() ;
		
		googleDriveHandler = GoogleDriveHandler.getInstance();
		
		PrivilegeregisterBean[] privilegeregisterBeans = privilegeregisterDAO.findByUsercode(usermasterBean.usercode);
		
		if(privilegeregisterBeans.length > 0){
			
			groupCode = privilegeregisterBeans[0].getGroupcode();
			
		}
	
		onClick$mLoad();
		
	}
	
	public void onCreate$main() {
		mLoad.setDisabled(false);		
		mPrint.setDisabled(true);
		mode = "init";
		webbean = new ControldocumentBean();
	}
		
	public void onSelect$listbox() {
		mLoad.setDisabled(false);
		mPrint.setDisabled(false);
		webbean  = (ControldocumentBean)datalistbox.getSelectedItem().getValue();
		
		String controlfilePath = webbean.controlfilepath ;
		
		try {
			showControlFile(controlfilePath);
		} catch (Exception e) {
			alert("Failed to render file contents due to " + e.getMessage());
		}
		
	}
	
	public void onClick$btnsearch() throws Exception {
		
		searchbox.close();	
		
		String usercode = usermasterBean.usercode ;
		
		String documentNo$value 	= documentno.getText() != null ? documentno.getText() : "";
		String documentName$value	= documentname.getText() != null ? documentname.getText() : "";
		String version$value		= version.getText() != null ? version.getText() : "";
		Date   startDate$value      = null ;
		Date   endDate$value		= null ;
		
		ControldocumentBean[] groupDocList = controldocumentDAO.findDocumentsByRolesAndSearchCriteria(usercode, documentNo$value, documentName$value, version$value, null, null);
		
		searchdatalistbox.setModel(new ListModelList<ControldocumentBean>(groupDocList));		
		
		searchdatalistbox.setItemRenderer(new ListitemRenderer<ControldocumentBean>() {
			@Override
			public void render(Listitem listitem, final ControldocumentBean data,int index) throws Exception {
				listitem.setValue(data);							
				addListcell(listitem, data.documentnumber);
				addListcell(listitem, data.documentname);
				addListcell(listitem, data.documenttype);
				addListcell(listitem, data.getControlFileName());				
				addListcell(listitem, data.documentversion);
				addListcell(listitem, data.description);
				addListcell(listitem, data.departmentcode);
				
				listitem.addEventListener("onClick", new EventListener<Event>() {					
					public void onEvent(Event arg0) throws Exception {						
						System.out.println("onClick"); 						
						handleGroupListEvent(data);	
					}
			});
			}
			private void addListcell(Listitem listitem, String value) {
				Listcell lc = new Listcell();
				Label lb = new Label(value);
				lb.setParent(lc);
				lc.setParent(listitem);
				lc.setContext("gdfileOperationsPopup");
			}
		});
		
		searchtab.setSelected(true);
		
	}
	
	public void onClick$mLoad() {
		try {
			
			///$ControldocumentBean[] groupDocList = controldocumentDAO.findByDepartmentcode(groupCode);
			
			String usercode = usermasterBean.usercode ;
			
			ControldocumentBean[] groupDocList = controldocumentDAO.findDocumentsByApproverRoles(usercode);
			
			datalistbox.setModel(new ListModelList<ControldocumentBean>(groupDocList));		
			
			datalistbox.setItemRenderer(new ListitemRenderer<ControldocumentBean>() {
				@Override
				public void render(Listitem listitem, final ControldocumentBean data,int index) throws Exception {
					listitem.setValue(data);							
					addListcell(listitem, data.documentnumber);
					addListcell(listitem, data.documentname);
					addListcell(listitem, data.documenttype);
					addListcell(listitem, data.getControlFileName());				
					addListcell(listitem, data.documentversion);
					addListcell(listitem, data.description);
					addListcell(listitem, data.departmentcode);
					
					listitem.addEventListener("onClick", new EventListener<Event>() {					
						public void onEvent(Event arg0) throws Exception {						
							System.out.println("onClick"); 						
							handleGroupListEvent(data);	
						}
				});
				}
				private void addListcell(Listitem listitem, String value) {
					Listcell lc = new Listcell();
					Label lb = new Label(value);
					lb.setParent(lc);
					lc.setParent(listitem);
					lc.setContext("gdfileOperationsPopup");
				}
			});
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	private void handleGroupListEvent(ControldocumentBean data) {
	
		try {
			
			////showControlFile(data.controlfilepath);
			
			String googleFileId = data.googledrivefileid; 
			
			String documentName = data.documentname ;
		
			if(googleFileId.equals("")){
				
				alert("Please select the file to view");
				
				return ;
				
			}
			
			///showControlFileFromDrive(documentName,googleFileId);
			
			showControlFileFromLocalDrive(data);
			
		} catch (Exception e) {
			
			alert("Failed to render the file.");
		}
		
	}
	
	public void showControlFileFromLocalDrive(ControldocumentBean controldocumentBean$instance) throws Exception {
		
		String randomString = RandomStringUtils.randomAlphabetic(10); 
				
		String googleFileId = controldocumentBean$instance.googledrivefileid;
		
		String selectedfilename = controldocumentBean$instance.getControlfilepath();
		
		String extentionName = new FilenameUtils().getExtension(selectedfilename);
		
		DocumentDecryptor documentEncryptor = DocumentDecryptor.getInstance(applicationBean.getGooglerepositorypath());
		
		File decryptedFile = documentEncryptor.retrieveDocumentForUser("admin", googleFileId, extentionName); 
		
		String webDir = desktop.getWebApp().getRealPath("/");
		
		String tempFileName = webDir + "\\repository\\" + randomString + "." + extentionName ;
		
		FileOutputStream tempOutFileOutputStream = new FileOutputStream(tempFileName) ; 
				
		InputStream localDriveStream = null ; 
		
		try{
		
			localDriveStream = new FileInputStream(decryptedFile); 
			
			IOUtils.copy(localDriveStream, tempOutFileOutputStream, true);			
			
			fileframe.setSrc("/customviewer/web/viewer.html?file=/enterpriseadmportal/repository/" + randomString + "." + extentionName);
			
		}catch(Exception e){
			
			e.printStackTrace() ;
			
			throw new Exception("Failed to fetch the file from Drive.");
			
		}finally{
			
			if(tempOutFileOutputStream != null){
				
				tempOutFileOutputStream.close() ;
				
			}
			
			if(localDriveStream != null){
				
				localDriveStream.close() ;
				
			}
			
		}
		
	}
	
	@Deprecated
	public void showControlFileFromDrive(String documentName, String googleFileId) throws Exception {
		
		if(googleFileId.equals("")){
			
			alert("Please select the file to view");
			
			return ;
			
		}
		
		String randomString = RandomStringUtils.randomAlphabetic(10); 
				
		String webDir = desktop.getWebApp().getRealPath("/");
		
		String tempFileName = webDir + "\\repository\\" + randomString + ".pdf" ;
		
		FileOutputStream tempOutFileOutputStream = new FileOutputStream(tempFileName) ; 
				
		try{
		
			InputStream googleStream = googleDriveHandler.downloadFile(googleFileId);
			
			IOUtils.copy(googleStream, tempOutFileOutputStream, true);			
			
			fileframe.setSrc("/customviewer/web/viewer.html?file=/enterpriseadmportal/repository/" + randomString + ".pdf");
			
		}catch(Exception e){
			
			e.printStackTrace() ;
			
			throw new Exception("Failed to fetch the file from Drive.");
			
		}finally{
			
			if(tempOutFileOutputStream != null){
				
				tempOutFileOutputStream.close() ;
				
			}
		}	
		
	}
	
	
	public void showControlFile(String controlfilePath) throws Exception {
		
		String fileName = FilenameUtils.getName(controlfilePath);		
		
		FileInputStream fis = new FileInputStream(new File(controlfilePath));

		byte[] ba1 = new byte[1024];

		int baLength;

		ByteArrayOutputStream bios = new ByteArrayOutputStream();

		try {

			while ((baLength = fis.read(ba1)) != -1) {

					bios.write(ba1, 0, baLength);

			}
			
			final AMedia amedia = new AMedia(fileName, "pdf","application/pdf", bios.toByteArray());

			fileframe.setContent(amedia);

		}catch(Exception ex){
			
			System.out.println(ex.getMessage()); 
			
		}finally{
			
			if(fis != null){
				
				fis.close() ;
				
			}
			
			if(bios != null){
			
				bios.close();
				
			}
			
		}	
		
	}
	
}
