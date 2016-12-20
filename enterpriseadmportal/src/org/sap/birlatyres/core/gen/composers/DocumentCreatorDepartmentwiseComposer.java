package org.sap.birlatyres.core.gen.composers;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkmax.zul.Tablelayout;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.mindgentrix.encryption.DocumentEncryptor;
import org.mindgentrix.web.googledrive.GoogleDriveHandler;
import org.sap.birlatyres.core.gen.bean.*;
import org.sap.birlatyres.core.gen.dao.*;

import java.io.File;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Map;

import javax.print.DocFlavor;

public class DocumentCreatorDepartmentwiseComposer extends GenericForwardComposer{
	//Define Common members here
	Div zmenu, zgrid, zform, main;
	Menuitem mLoad, mEdit, mNew, mSave, mDelete, mBack, mPrint;
	Listbox listbox;
	Label editId;
	Tablelayout tbl;
	String mode = "";
	//Define ZUL Specific Fields here
	private Intbox documentid ;
	private Textbox documentnumber ;
	private Textbox documenttype ;
	private Textbox documentname ;
	private Textbox documentversion ;
	private Textbox documenthashkey ;
	private Textbox description ;
	private Textbox controlfilepath ;
	private Datebox controlfilecreationdate ;
	private Intbox controlfilesize ;
	private Checkbox synchgoogledrive ;
	private Datebox googledrivesynchedtime ;
	private Textbox googlefolderpath ;
	private Textbox googledrivefileid ;
	private Intbox ownerid ;
	private Checkbox isblocked ;
	private Checkbox isdeleted ;
	private Checkbox ispasswordprotected ;
	private Textbox location ;
	private Checkbox approvedyn ;
	private Combobox combouserCode;
	private Fileupload docfileupload;
	
	Textbox documentreason ;
	
	Groupbox mandatorydata,optionaldata ;
	
	//private Combobox departmentcode ;
	
	Listbox departmentcodelist ;
	
	ControldocumentDAO daoHandler = new ControldocumentDAO();
	
	//RolemasterDAO roleMasterDao	  = new RolemasterDAO();
	
	DepartmentmasterDAO departmentmasterDAO = new DepartmentmasterDAO();
	
	private ApplicationDAO applicationDAO = new ApplicationDAO();
	
	private ApplicationBean applicationBean = null ;
	
	ControldocumentBean webbean = null ;
	
	private String selectedDirPath = ""; 
	
	private String applicationRepositoryPath = "" ;
	
	String usercode = "";
	
	String usertype = "";
	
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		
		Map<String,String> argument = (Map<String, String>) Executions.getCurrent().getArg();
				
		selectedDirPath  = argument.get("SELECTEDDIR");
		
		usercode = argument.get("USERCODE");
		usertype = argument.get("USERTYPE");
		
		DepartmentmasterBean[] departmentmasterBeans = departmentmasterDAO.findAlldepartmentwise(usercode);
		
		String[] roles = new String[departmentmasterBeans.length];
		
		for(int index = 0 ; index < departmentmasterBeans.length ; index++){
			
			DepartmentmasterBean bean = departmentmasterBeans[index];
			
			roles[index] = bean.departmentcode + ":" + bean.departmentname;		
			
		}
		
		departmentcodelist.setModel(new ListModelList(roles));
		
		
		applicationBean = applicationDAO.loadApplicationData();
		
		applicationRepositoryPath = applicationBean.getGooglerepositorypath();
		
		System.out.println("PATH CHECK: "+applicationRepositoryPath);
		
		/*ArrayList<UsermasterBean> usermasterBeanList=  new UsermasterDAO().findAllActiveUsers();
		
		System.out.println("LIST SIZE: "+ usermasterBeanList.size());
		
		for(UsermasterBean bean: usermasterBeanList){
			
			
			Comboitem comboitem = new Comboitem();
			
			comboitem.setLabel(bean.getUsername());
			comboitem.setValue(bean.getUsercode());
			System.out.println("USER CODE: "+ bean.getUsercode());
			
			combouserCode.appendChild(comboitem);
			
		}*/
		
	}
	
	public void onSelect$departmentcodelist() throws Exception{
		
	String selectedDepartment = departmentcodelist.getSelectedItem().getValue();
	
	if(selectedDepartment != null || selectedDepartment.trim().equals("")){
	
		String departmentCodeID = selectedDepartment.split("[:]")[0] ;
		
		System.out.println("departmentCodeID = "+departmentCodeID);
		
		ArrayList<UsermasterBean> usermasterBeanList=  new UsermasterDAO().findAllActiveUsersDepartmentwise(departmentCodeID);
		
		System.out.println("LIST SIZE: "+ usermasterBeanList.size());
		
		for(UsermasterBean bean: usermasterBeanList){
			
			
			Comboitem comboitem = new Comboitem();
			
			comboitem.setLabel(bean.getUsercode());
			comboitem.setValue(bean.getUsercode());
			
			
			combouserCode.appendChild(comboitem);
			
		}
		
	}
	}
	
	public void onSelect$combouserCode(){
		
		webbean.setUserCode(combouserCode.getSelectedItem().getValue().toString());
	}
	
	public void onCreate$main() {
		mLoad.setDisabled(false);
		mEdit.setDisabled(true);
		mNew.setDisabled(false);
		mSave.setDisabled(true);
		mDelete.setDisabled(true);
		mBack.setDisabled(true);
		mPrint.setDisabled(true);
		mode = "init";
		webbean = new ControldocumentBean();
	}
	public void onClick$mNew() {
		formReset();
		mLoad.setDisabled(false);
		mEdit.setDisabled(true);
		mNew.setDisabled(true);
		mSave.setDisabled(false);
		mDelete.setDisabled(true);
		mBack.setDisabled(false);
		mPrint.setDisabled(true);
		mode = "NEW";
		
		documentnumber.setDisabled(false);
		documentversion.setDisabled(false);
		docfileupload.setDisabled(false);
		
		webbean = new ControldocumentBean();
	}
	public void onClick$mBack() {
		formReset();
		mLoad.setDisabled(false);
		mEdit.setDisabled(true);
		mNew.setDisabled(false);
		mSave.setDisabled(true);
		mDelete.setDisabled(true);
		mBack.setDisabled(true);
		mPrint.setDisabled(true);
		mode = "NEW";
	}
	public void onSelect$listbox() {
		mLoad.setDisabled(false);
		mEdit.setDisabled(false);
		mNew.setDisabled(true);
		mSave.setDisabled(true);
		mDelete.setDisabled(false);
		mBack.setDisabled(false);
		mPrint.setDisabled(false);
		webbean  = (ControldocumentBean)listbox.getSelectedItem().getValue();
	}
	public void onClick$mLoad() {
		try {
			listbox.setModel(new ListModelList(daoHandler.findAll(usercode,usertype)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void onClick$mDelete() {
		try {
			webbean  = (ControldocumentBean)listbox.getSelectedItem().getValue();
			int result = Messagebox.show("Delete is pressed. Are you sure?", "Question", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION);
			if(result == Messagebox.OK){
				daoHandler.deleteAllByPK(webbean);
				listbox.setModel(new ListModelList(daoHandler.findAll(usercode,usertype)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void onClick$mSave() throws Exception {
		
		System.out.println("Inside onClick$mSave"); 
		
		boolean validate = checkMandatoryFields();
		
		if(!validate){
			
			Messagebox.show("Some mandatory fields not filled. Please fillup all mandatory fields.", "Error", Messagebox.OK, Messagebox.ERROR);
			return ;
			
		}else{
		
			ControldocumentBean[] controldocumentBeans =daoHandler.findByDocumentnumber(documentnumber.getValue());
			
			if(controldocumentBeans.length > 0){
				
				System.out.println("Inside onClick$mSave:Duplicate DocNo found"); 
				
				try {
					Messagebox.show("The Document No. already exists. Do you wish to proceed ?", "Confirm Dialog", 
							Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, 
							new org.zkoss.zk.ui.event.EventListener() {
							    public void onEvent(Event evt) throws Exception {
							        if (evt.getName().equals("onOK")) {    	
		
							        								        	
							        	handleSave() ;
							        	
							        }else{
							        	
							        	return ;
							        	
							        }
							    }
							}
					);
				} catch (Exception e) {
					
					alert("Operation failed due to " + e.getMessage());
					
					e.printStackTrace();
				}
				
			}else{
				
				System.out.println("Inside onClick$mSave:NO Duplicate DocNo found. OK to proceed...");
				
				handleSave() ;
				
			}
		}		
	}
	
	public void handleSave() {
		
		/*boolean validate = checkMandatoryFields();
		
		if(!validate){
			
			Messagebox.show("Some mandatory fields not filled. Please fillup all mandatory fields.", "Error", Messagebox.OK, Messagebox.ERROR);
			return ;
			
		}*/
		
		mSave.setDisabled(true);
		
		webbean = new ControldocumentBean();
		try{
			
			String synchgoogledriveState 	= synchgoogledrive.isChecked() ? "Y" : "N";
			String isblockedState 			= isblocked.isChecked() ? "Y" : "N";
			String isdeletedState 			= isdeleted.isChecked() ? "Y" : "N";
			String ispasswordprotectedState = ispasswordprotected.isChecked() ? "Y" : "N";
			String approvedynState 			= approvedyn.isChecked() ? "Y" : "N";
									
			String departmentCodeID = "GEN" ;
			
			String selectedDepartment = departmentcodelist.getSelectedItem().getValue();
			
			if(selectedDepartment != null || selectedDepartment.trim().equals("")){
			
				departmentCodeID = selectedDepartment.split("[:]")[0] ;
				
			}
			
			String mediaName = controlfilepath.getValue();
			
			controlfilepath.setValue(selectedDirPath + mediaName);
			
			if(mediaName == null || mediaName.equals("")){
				
				alert("Please select & upload the control file.");
				
				controlfilepath.setFocus(true);
				
				return ;
				
			}
			
			webbean.setDocumentid(documentid.getValue());
			webbean.setDocumentnumber(documentnumber.getValue());
			webbean.setDocumenttype(documenttype.getValue());
			webbean.setDocumentname(documentname.getValue());
			webbean.setDocumentversion(documentversion.getValue());
			webbean.setDocumenthashkey(documenthashkey.getValue());
			webbean.setDescription(description.getValue());
			webbean.setControlfilepath(controlfilepath.getValue());
			webbean.setControlfilecreationdate(controlfilecreationdate.getValue() != null ? new Timestamp(controlfilecreationdate.getValue().getTime()) : null );
			webbean.setControlfilesize(controlfilesize.getValue());
			webbean.setSynchgoogledrive(synchgoogledriveState);
			webbean.setGoogledrivesynchedtime(googledrivesynchedtime.getValue() != null ? new Timestamp(googledrivesynchedtime.getValue().getTime()) : null );
			webbean.setGooglefolderpath(googlefolderpath.getValue());
			webbean.setGoogledrivefileid(googledrivefileid.getValue());
			webbean.setOwnerid(ownerid.getValue());
			webbean.setIsblocked(isblockedState);
			webbean.setIsdeleted(isdeletedState);
			webbean.setIspasswordprotected(ispasswordprotectedState);
			webbean.setDepartmentcode(departmentCodeID);
			webbean.setLocation(location.getValue());
			webbean.setApprovedyn(approvedynState);
			webbean.setDocumentreason(documentreason.getValue());
			webbean.setUserCode(combouserCode.getSelectedItem().getValue().toString());
			mLoad.setDisabled(false);
			mEdit.setDisabled(true);
			mNew.setDisabled(false);
			mSave.setDisabled(true);
			mDelete.setDisabled(true);
			mBack.setDisabled(false);
			mPrint.setDisabled(true);			
			
			ControldocumentBean[] controldocumentBeans =daoHandler.findByDocumentid(webbean.documentid);
			
			if(controldocumentBeans.length > 0){
				
				daoHandler.updateColumns(webbean);
				
				Messagebox.show("Data update successfully", "Information", Messagebox.OK, Messagebox.INFORMATION);
				
				formReset();
				
			}else{
			
				/*google_drive : {
					
					GoogleDriveHandler googleDriveHandler = GoogleDriveHandler.getInstance();
					
					String googleFileID = googleDriveHandler.addFileToGoogleDriveRoot(webbean.getControlfilepath(), webbean.getDocumentname(), webbean.getDescription());
					
					webbean.setGoogledrivefileid(googleFileID);
					
					webbean.setGoogledrivesynchedtime(new Timestamp(System.currentTimeMillis())); 
					
				}*/
				
				google_drive : {
				
					DocumentEncryptor documentEncryptor = DocumentEncryptor.getInstance(applicationRepositoryPath,"admin");
												
					String googleFileID = documentEncryptor.encryptDocumentForUser("admin", mediaName);
					
					webbean.setGoogledrivefileid(googleFileID);
					
					webbean.setGoogledrivesynchedtime(new Timestamp(System.currentTimeMillis())); 
					
				}
				
				daoHandler.insertAllCols(webbean);
							
				Messagebox.show("Data saved successfully", "Information", Messagebox.OK, Messagebox.INFORMATION);
				
				formReset();
				
				onClick$mLoad();
			}
		}catch(Exception e){
			try{
			Messagebox.show("Data saving failed", "Error", Messagebox.OK, Messagebox.ERROR);
			}catch(Exception ex){}
			e.printStackTrace();
		}finally{
			
			mSave.setDisabled(false);
			
		}
	}
	
	public void onClick$mEdit(){
		
		documentnumber.setDisabled(true);
		documentversion.setDisabled(true);
		docfileupload.setDisabled(true);
		
		
		
		mLoad.setDisabled(false);
		mEdit.setDisabled(true);
		mNew.setDisabled(true);
		mSave.setDisabled(false);
		mDelete.setDisabled(true);
		mBack.setDisabled(false);
		webbean  = (ControldocumentBean)listbox.getSelectedItem().getValue();
		mode = "EDIT";
		
		if(webbean == null){
			Messagebox.show("Invalid Edit Key", "Error", Messagebox.OK, Messagebox.ERROR);
			return ;
		}
		
		try{
			
			boolean synchgoogledriveBool 	= webbean.getSynchgoogledrive().equalsIgnoreCase("Y") ? true : false;
			boolean isblockedBool 			= webbean.getIsblocked().equalsIgnoreCase("Y") ? true : false;
			boolean isdeletedBool 			= webbean.getIsdeleted().equalsIgnoreCase("Y") ? true : false;
			boolean ispasswordprotectedBool = webbean.getIspasswordprotected().equalsIgnoreCase("Y") ? true : false;
			boolean approvedynBool 			= webbean.getApprovedyn().equalsIgnoreCase("Y") ? true : false;
			
			String uploadedFilePath = FilenameUtils.getBaseName(webbean.getControlfilepath()) ;
					
			documentid.setValue(webbean.getDocumentid());
			documentnumber.setValue(webbean.getDocumentnumber());
			documenttype.setValue(webbean.getDocumenttype());
			documentname.setValue(webbean.getDocumentname());
			documentversion.setValue(webbean.getDocumentversion());
			documenthashkey.setValue(webbean.getDocumenthashkey());
			description.setValue(webbean.getDescription());
			
			//System.out.println("***********************************"+webbean.getUserCode());
			
			combouserCode.setValue(webbean.getUserCode());
			
			documentreason.setValue(webbean.getDocumentreason());
			
			controlfilepath.setValue(uploadedFilePath);
			
			controlfilecreationdate.setValue(webbean.getControlfilecreationdate());
			controlfilesize.setValue(webbean.getControlfilesize());
			synchgoogledrive.setValue(synchgoogledriveBool);
			googledrivesynchedtime.setValue(webbean.getGoogledrivesynchedtime());
			googlefolderpath.setValue(webbean.getGooglefolderpath());
			googledrivefileid.setValue(webbean.getGoogledrivefileid());
			ownerid.setValue(webbean.getOwnerid());
			isblocked.setValue(isblockedBool);
			isdeleted.setValue(isdeletedBool);
			ispasswordprotected.setValue(ispasswordprotectedBool);
			
			location.setValue(webbean.getLocation());
			approvedyn.setValue(approvedynBool);
			
			department : {
				
				DepartmentmasterBean[] departmentmasterBeans = departmentmasterDAO.findAll();
				
				String[] roles = new String[departmentmasterBeans.length];
				
				String code = webbean.departmentcode ;
				
				int selectedIndex = 0 ;
				
				for(int index = 0 ; index < departmentmasterBeans.length ; index++){
					
					DepartmentmasterBean bean = departmentmasterBeans[index];
					
					roles[index] = bean.departmentcode + ":" + bean.departmentname;		
					
					if(code.startsWith(bean.departmentcode)){  
						
						selectedIndex = index ;
						
					}
					
				}
				
				departmentcodelist.setModel(new ListModelList(roles));
				
				departmentcodelist.setSelectedIndex(selectedIndex);				
				
			}	
			
			documenthashkey.setReadonly(true);
			controlfilecreationdate.setReadonly(true);
			controlfilesize.setReadonly(true);
			synchgoogledrive.setDisabled(true);
			googledrivesynchedtime.setReadonly(true);
			ownerid.setReadonly(true);
			isblocked.setDisabled(true);
			isdeleted.setDisabled(true);
			ispasswordprotected.setDisabled(true);		
			googledrivefileid.setDisabled(true);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void onUpload$docfileupload(UploadEvent event) {
		
		System.out.println("onUpload event");
		
		String eventName = event.getName();
		
		Media media = event.getMedia();
		
		String mediaName = media.getName() ;
		
		File destinationFile = new File(applicationRepositoryPath + "home/admin/resources/" + mediaName) ; 
			
		System.out.println("media.getByteData() size = " + media.getByteData().length);
		
		System.out.println("destinationFile = " + destinationFile); 
				
		try {
			
			FileUtils.writeByteArrayToFile(destinationFile, media.getByteData());
			
			controlfilepath.setValue(mediaName);
			
			long fileSize = destinationFile.length() ;
			
			if(fileSize > Integer.MAX_VALUE){
				
				fileSize = Integer.MAX_VALUE ;
			}
			
			controlfilesize.setValue((int)fileSize);
			
			//$Messagebox.show("File uploaded successfully");
						
		} catch (Exception e) {
			
			e.printStackTrace() ;
			
			Messagebox.show("Upload Operation Failed due to " + e.getMessage());
			
		}
		
	}
	
	/*ORIGINAL METHOD: NEED TO REFACTOR THE DESTINATION FOR UPLOAD LOCATION
	public void onUpload$docfileupload(UploadEvent event) {
		
		System.out.println("onUpload event");
		
		String eventName = event.getName();
		
		Media media = event.getMedia();
		
		String mediaName = media.getName() ;
		
		File destinationFile = new File(selectedDirPath + mediaName) ; 
				
		try {
			
			FileUtils.writeByteArrayToFile(destinationFile, media.getByteData());
			
			controlfilepath.setValue(mediaName);
			
			long fileSize = destinationFile.length() ;
			
			if(fileSize > Integer.MAX_VALUE){
				
				fileSize = Integer.MAX_VALUE ;
			}
			
			controlfilesize.setValue((int)fileSize);
			
			//$Messagebox.show("File uploaded successfully");
						
		} catch (Exception e) {
			
			e.printStackTrace() ;
			
			Messagebox.show("Upload Operation Failed due to " + e.getMessage());
			
		}
		
	}*/	
	
	public boolean checkMandatoryFields() {
		
		boolean result = true ;
		
		String documentnumberValue 	= documentnumber.getValue();
		String documenttypeValue   	= documenttype.getValue();
		String documentnameValue   	= documentname.getValue();
		String documentversionValue = documentversion.getValue();
		String descriptionValue 	= description.getValue();
		String controlfilepathValue = controlfilepath.getValue();
		String documentreasonValue 	= documentreason.getValue();
		String locationValue 		= location.getValue();
		if(combouserCode.getSelectedIndex() == -1){
			
			return false;
		}
		
		String usercode 	= combouserCode.getSelectedItem().getValue();
		
		if(departmentcodelist.getSelectedItem() == null){
			
			return false ;
			
		}
		
		String selectedDepartment 	= departmentcodelist.getSelectedItem().getValue();
		
		if(documentnumberValue == null || documentnumberValue.trim().equals("")){ 
			
			documentnumber.setFocus(true);
			result = false ;
			
		}else if(documenttypeValue == null || documenttypeValue.trim().equals("")){
			
			documenttype.setFocus(true);
			result = false ;
			
		}else if(documentnameValue == null || documentnameValue.trim().equals("")){
			
			documentname.setFocus(true);
			result = false ;
			
		}else if(documentversionValue == null || documentversionValue.trim().equals("")){
			
			documentversion.setFocus(true);
			result = false ;
			
		}else if(descriptionValue == null || descriptionValue.trim().equals("")){
			
			description.setFocus(true);
			result = false ;
			
		}else if(controlfilepathValue == null || controlfilepathValue.trim().equals("")){
			
			controlfilepath.setFocus(true);
			result = false ;
			
		}else if(documentreasonValue == null || documentreasonValue.trim().equals("")){
			
			documentreason.setFocus(true);
			result = false ;
			
		}else if(locationValue == null || locationValue.trim().equals("")){
			
			location.setFocus(true);
			result = false ;
			
		}else if(selectedDepartment == null || selectedDepartment.trim().equals("")){
			
			departmentcodelist.setFocus(true);
			result = false ;
			
		}else if(usercode == null || usercode.trim().equals("")){
			
			combouserCode.setFocus(true);
			result = false;
			
		}
			
		return result ;
	}
	
	public void formReset(){
		mode = "NEW";
		documentid.setValue(0);
		documentnumber.setValue("");
		documenttype.setValue("");
		documentname.setValue("");
		documentversion.setValue("");		
		description.setValue("");
		controlfilepath.setValue("");		
		googlefolderpath.setValue("");
				
		location.setValue("");
		approvedyn.setChecked(false);
		listbox.setSelectedItem(null);
		
		documenthashkey.setValue("");
		controlfilecreationdate.setValue(new java.util.Date());
		controlfilesize.setValue(0);
		synchgoogledrive.setChecked(true);
		googledrivesynchedtime.setValue(new java.util.Date());
		ownerid.setValue(0);
		isblocked.setChecked(false);
		isdeleted.setChecked(false);
		ispasswordprotected.setChecked(false);
		googledrivefileid.setValue("");
		
		
		documenthashkey.setReadonly(true);
		controlfilecreationdate.setReadonly(true);
		controlfilesize.setReadonly(true);
		synchgoogledrive.setDisabled(true);
		googledrivesynchedtime.setReadonly(true);
		ownerid.setReadonly(true);
		isblocked.setDisabled(true);
		isdeleted.setDisabled(true);
		ispasswordprotected.setDisabled(true);		
		googledrivefileid.setDisabled(true);
		
	}
}
