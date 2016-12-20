package org.mindgentrix.web.composers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.Position.Bias;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.sap.birlatyres.core.gen.dao.ControldocumentDAO;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

public class GoogleFileViewerForApproverComposer  extends GenericForwardComposer {

	Iframe fileframe ;
	
	private String googleFilePath = "" ;
	private String fileextention = "";
	private String googleFileId = "";
	
	Label lblFileName;
	Label lblFileSize;
	Label lblFileOwner;
	Label lblFileTasks;
	Label lblFileComments;
	Button btnApproved;
	Button btnUnapproved;
	Window winApproverView;
	
	String googleid;
	String documentid;
	String documentnumber;
	String documentname;
	String documentrevision;
	String usercode;

	
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		
		Map<String,String> argument = (Map<String, String>) Executions.getCurrent().getArg();
				
		googleFilePath = argument.get("GOOGLEFILEPATH"); 
		fileextention = argument.get("FILEEXTENSION");
		googleFileId = argument.get("GOOGLEFIELDID");
		
		googleid = argument.get("googleFileId");
		documentid = argument.get("documentid");
		documentnumber = argument.get("documentno");
		documentname = argument.get("documentname");
		documentrevision = argument.get("documentrevision");
		usercode = argument.get("usercode");
		
		
		System.out.println("------>"+googleid+"||"+documentid+"||"+documentnumber+"||"+documentname+"||"+documentrevision+"||||"+usercode);
		
		prepareFileForView() ;
		
		/////deleteFileAfterShow();
				
	}
	
	void deleteFileAfterShow()  throws Exception {
		
		try {
			
			FileUtils.forceDelete(new File(googleFilePath));
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	void prepareFileForView() throws Exception {
		
		String fileName = FilenameUtils.getName(googleFilePath);
		lblFileName.setValue(fileName);
				
		FileInputStream fis = new FileInputStream(new File(googleFilePath));

		byte[] ba1 = new byte[1024];

		int baLength;

		ByteArrayOutputStream bios = new ByteArrayOutputStream();

		try {

			while ((baLength = fis.read(ba1)) != -1) {

					bios.write(ba1, 0, baLength);

			}
			
			//final AMedia amedia = new AMedia(fileName, "pdf","application/pdf", bios.toByteArray());
			
			final AMedia amedia = new AMedia(fileName, fileextention,"application/"+fileextention, bios.toByteArray());


			fileframe.setContent(amedia);

			///$FileUtils.forceDelete(new File(googleFilePath));
			
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
	
	public void onClick$btnApproved(Event e) throws Exception{
		
		boolean status = new ControldocumentDAO().fileApproved(FilenameUtils.getName(googleFileId));
		
		if(status){
			
			Messagebox.show("File Approved Successfully!!", "Information", Messagebox.OK, Messagebox.INFORMATION);
			winApproverView.detach();
			
		
		}else{
		
			Messagebox.show("File Not Approved !!", "Information", Messagebox.OK, Messagebox.ERROR);
		}
	}
	
	public void onClick$btnUnapproved(Event e){
		
		
		Map<String, String> docunapprovedetailsMap = new HashMap<String, String>();


		
		docunapprovedetailsMap.put("googleFileId", googleid);
		docunapprovedetailsMap.put("documentid", documentid);
		docunapprovedetailsMap.put("documentno", documentnumber);
		docunapprovedetailsMap.put("documentname", documentname);
		docunapprovedetailsMap.put("documentrevision", documentrevision);
		docunapprovedetailsMap.put("usercode", usercode);

		
		
		Window win = (Window) Executions.createComponents("rejectionModal.zul", null, docunapprovedetailsMap);
		
		win.doModal();
	}
}
