package org.mindgentrix.web.composers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.swing.text.Position.Bias;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Label;

public class GoogleFileViewerComposer  extends GenericForwardComposer {

	Iframe fileframe ;
	
	private String googleFilePath = "" ;
	private String fileextention = "";
	
	Label lblFileName;
	Label lblFileSize;
	Label lblFileOwner;
	Label lblFileTasks;
	Label lblFileComments;

	
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		
		Map<String,String> argument = (Map<String, String>) Executions.getCurrent().getArg();
				
		googleFilePath = argument.get("GOOGLEFILEPATH"); 
		fileextention = argument.get("FILEEXTENSION");
		
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
	
}
