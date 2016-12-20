package org.mindgentrix.web.composers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.swing.text.Position.Bias;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Label;

import com.google.api.client.util.IOUtils;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class UserGoogleFileViewerComposer  extends GenericForwardComposer {

	Iframe fileframe ;
	
	private String googleFilePath = "" ;
	private String fileextention = "";
	
	Label lblFileName;
	Label lblFileSize;
	Label lblFileOwner;
	Label lblFileTasks;
	Label lblFileComments;
	
	private String allowview;
	private String allowdownload;
	private String allowprint;

	
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		
		Map<String,String> argument = (Map<String, String>) Executions.getCurrent().getArg();
				
		googleFilePath = argument.get("GOOGLEFILEPATH"); 
		fileextention = argument.get("FILEEXTENSION");
		allowview = argument.get("ALLOWVIEW");
		allowdownload = argument.get("ALLOWDOWNLOAD");
		allowprint = argument.get("ALLOWPRINT");
		
		System.out.println("allowview="+allowview);
		System.out.println("allowdownload="+allowdownload);
		System.out.println("allowprint="+allowprint);
		
		//prepareFileForView() ;
		
		opendocument();
		
		///deleteFileAfterShow();
				
	}
	
	//String encryptedfile ="";
	void opendocument() throws Exception{
		
		System.out.println("in open document");
		
		String randomString = RandomStringUtils.randomAlphabetic(10);
		
		String webDir = desktop.getWebApp().getRealPath("/");
		
		String tempFileName = webDir + "\\repository\\" + randomString + "." + fileextention ;
		
		FileOutputStream tempOutFileOutputStream = new FileOutputStream(tempFileName) ;
		
		InputStream localDriveStream = null; 
		
		try {
			
			localDriveStream = new FileInputStream(googleFilePath); 
			
			IOUtils.copy(localDriveStream, tempOutFileOutputStream, true);
			
			if(allowdownload.equalsIgnoreCase("Y")){
				
				fileframe.setSrc("/customviewer/web/downloadviewer.html?file=/enterpriseadmportal/repository/" + randomString + "." + fileextention);
			
			}else {
				
				if(allowprint.equalsIgnoreCase("Y")){
					
					fileframe.setSrc("/customviewer/web/printviewer.html?file=/enterpriseadmportal/repository/" + randomString + "." + fileextention);
				
				}else{
					
					//fileframe.setSrc("/customviewer/web/viewer.html?file=/enterpriseadmportal/repository/" + randomString + "." + fileextention);
					
					
					final String INPUT_FILENAME = googleFilePath;
					String encryptedfile = googleFilePath.replace(".pdf", "_encrypted.pdf");
					final String OUTPUT_FILENAME = encryptedfile;
					final String USER_PASSWORD = "";
					final String OWNER_PASSWORD = "ownerpwd";
					
					System.out.println("11111111111111111");
			
					PdfReader reader = null;
					FileOutputStream out = null;
					PdfStamper stamper = null;
			 
					try {
						// Define input
						reader = new PdfReader(INPUT_FILENAME);
			 
						// Define output
						out = new FileOutputStream(OUTPUT_FILENAME);
			 
						// Encrypt document
						stamper = new PdfStamper(reader, out);
						stamper.setEncryption(USER_PASSWORD.getBytes(), OWNER_PASSWORD.getBytes(), 0, PdfWriter.STANDARD_ENCRYPTION_128);
					System.out.println("22222222222222222");
					
					} catch (Exception ex) {
						ex.printStackTrace();
					} finally {
						if (stamper != null) {
							try {
								stamper.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
						if (reader != null) {
							try {
								reader.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
						if (out != null) {
							try {
								out.close();
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}

					
					System.out.println("*****************"+googleFilePath+"*********************=="+googleFilePath);
					System.out.println("******************+encryptedfile+*******************=="+encryptedfile);
					
					String fileName = FilenameUtils.getName(encryptedfile);		
					
					FileInputStream fis = new FileInputStream(new File(encryptedfile));

					byte[] ba1 = new byte[1024];

					int baLength;

					ByteArrayOutputStream bios = new ByteArrayOutputStream();

					try {

						while ((baLength = fis.read(ba1)) != -1) {

								bios.write(ba1, 0, baLength);

						}
						
						final AMedia amedia = new AMedia(fileName, "pdf","application/pdf", bios.toByteArray());
						
						System.out.println("33333333333333333333333333333");

						fileframe.setContent(amedia);
						
						System.out.println();

					}catch(Exception ex){
						
						System.out.println(ex.getMessage()); 
						
					}finally{
						
						if(fis != null){
							
							fis.close() ;
							
						}
						
						if(bios != null){
						
							bios.close();
							
						}
						
						deleteFileAfterShow(encryptedfile);
						
					}	
					

					
				}
				
			}
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	void deleteFileAfterShow(String encryptedfile)  throws Exception {
		
		try {
			
			FileUtils.forceDelete(new File(encryptedfile));
			
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
