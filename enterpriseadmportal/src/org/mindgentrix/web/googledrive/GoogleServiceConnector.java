package org.mindgentrix.web.googledrive;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;

import org.apache.commons.io.FileUtils;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.IOUtils;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Files;
import com.google.api.services.drive.Drive.Files.List;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.drive.model.ParentReference;
import com.google.api.services.drive.model.Permission;

public class GoogleServiceConnector {

	private static final String SERVICE_ACCOUNT_EMAIL = "457485884937-immr8cru0io543i2ogp2ejsq6bi2af7c@developer.gserviceaccount.com";
	
	private static final String SERVICE_ACCOUNT_PKCS12_FILE_PATH = "key/877c8bac714c99c7deadd74affd2c11c9ccf54e7-privatekey.p12";
	
	public static Drive getDriveService() throws GeneralSecurityException,IOException, URISyntaxException {

		HttpTransport httpTransport = new NetHttpTransport();

		JacksonFactory jsonFactory = new JacksonFactory();

		GoogleCredential credential = new GoogleCredential.Builder()
				.setTransport(httpTransport)
				.setJsonFactory(jsonFactory)
				.setServiceAccountId(SERVICE_ACCOUNT_EMAIL)
				.setServiceAccountScopes(DriveScopes.all())
				.setServiceAccountPrivateKeyFromP12File(new java.io.File(SERVICE_ACCOUNT_PKCS12_FILE_PATH))
				.build();

		Drive service = new Drive.Builder(httpTransport, jsonFactory, null).setHttpRequestInitializer(credential).build();
		
		return service;
	}

	/**
	 * 
	 * @param service Drive API service instance.
	 * @param fileId  ID of the file to insert permission for.
	 * @param value   User or group e-mail address, domain name or {@code null}  "default" type.
	 * @param type    The value "user", "group", "domain" or "default".
	 * @param role    The value "owner", "writer" or "reader".
	 * @return The inserted permission if successful, {@code null} otherwise.
	 */
	private static Permission insertPermission(Drive service, String fileId,String value, String type, String role) {
		
		Permission newPermission = new Permission();
		
		try {

			newPermission.setValue(value);
			newPermission.setType(type);
			newPermission.setRole(role);
			
			return service.permissions().insert(fileId, newPermission).execute();
			
		} catch (Exception e) {
			
			System.out.println("An error occurred: " + e);
			
		}
		return null;
	}

	/**
	 * Download a file's content. 
	 * @param service   Drive API service instance.
	 * @param file      Drive File instance.
	 * @return InputStream containing the file's content if successful, {@code null} otherwise.
	 */
	private static InputStream downloadFile(Drive service, File file) {
		
		if (file.getDownloadUrl() != null && file.getDownloadUrl().length() > 0) {
			
			try {
				
				HttpResponse resp = service.getRequestFactory().buildGetRequest(new GenericUrl(file.getDownloadUrl())).execute();
				
				return resp.getContent();
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
				return null;
				
			}
		} else {
			
			// The file doesn't have any content stored on Drive.
			return null;
		}
	}

	public static void main(String[] args) throws Exception {

		Drive service = getDriveService();

		// Insert a file
		File body = new File();
		
		body.setTitle("Telephone Bills");
		
		body.setDescription("Airtel Monthly Rentals");
		
		body.setMimeType("application/pdf");

		java.io.File fileContent = new java.io.File("documentsToUpload/TelephoneBill_2231799_133574296.pdf");
		
		FileContent mediaContent = new FileContent("application/pdf", fileContent);

		File file = service.files().insert(body, mediaContent).execute();
		
		System.out.println("File ID: " + file.getId());

		insertPermission(service, file.getId(), "samrat.banerjea@gmail.com","user", "reader");
		insertPermission(service, file.getId(), "samrat.banerjea@mindgentrix.com","user", "reader");

		/*InputStream is = downloadFile(service, file);
		
		System.out.println(is);
		
		int c = 0 ;
		
		while((c = is.read()) != -1){
			
			System.out.print((char)c);
			
		}*/
		
	}

	public static void main1(String[] args) throws Exception {

		Drive service = getDriveService();
	
		/*String fileId = "0BxGkGW97lpOLLXNuUTRlZWRob0U" ;
		
		printFile(service, fileId);*/
		
		searchDrive(service, "");
		
		
	}	
		
	private static void printFile(Drive service, String fileId) throws Exception {

		FileOutputStream fos =  null ;
		
	    try {
	      File file = service.files().get(fileId).execute();

	      System.out.println("Title: " + file.getTitle());
	      System.out.println("Description: " + file.getDescription());
	      System.out.println("MIME type: " + file.getMimeType());
	    
	      InputStream gis = downloadFile(service, file);
	    
	      fos = new FileOutputStream("google/abc.pdf"); 
	      
	      IOUtils.copy(gis, fos, true);
	      
	    } catch (IOException e) {
	      
	    	System.out.println("An error occured: " + e);
	    
	    }finally{
	    	
	    	if(fos != null){
	    		
	    		fos.close();
	    	}
	    }
	}

	/**
	 * 
	 * It will create folder named title in google drive.
	 * 
	 */
	void createEmptyFolder(Drive service) throws Exception {
		
		File body = new File();
		body.setTitle("title");
		body.setMimeType("application/vnd.google-apps.folder");
		File file = service.files().insert(body).execute();
		
		/*
		  	File body = new File();
    		body.setTitle("Folder-Name-Here");
    		body.setMimeType("application/vnd.google-apps.folder");
    		File file = service.files().insert(body).execute();
    		folderId = file.getId(); // <= mark here....
		 */
	}
	
	/**
	   * Insert a file into a folder.
	   *
	   * @param service Drive API service instance.
	   * @param folderId ID of the folder to insert the file into
	   * @param fileId ID of the file to insert.
	   * @return The inserted parent if successful, {@code null} otherwise.
	   */
	  private static ParentReference insertFileIntoFolder(Drive service, String folderId,String fileId) {
	    ParentReference newParent = new ParentReference();
	    newParent.setId(folderId);
	    try {
	      return service.parents().insert(fileId, newParent).execute();
	    } catch (IOException e) {
	      System.out.println("An error occurred: " + e);
	    }
	    return null;
	  }

	
	
	public static void main3(String[] args) throws Exception {

		Drive service = getDriveService();

		// Insert a file
		
		List files = service.files().list();
		
		FileList fileList = files.execute();
		
		java.util.List<File> googleFileList = fileList.getItems();
		
		for(File  googleFile : googleFileList){
			
			System.out.println(googleFile.getDownloadUrl());
			
			/*if(googleFile.getExportLinks() != null){
			
				String downloadUrl = googleFile.getExportLinks().get("application/pdf");
			
				System.out.println(googleFile.getTitle() + "\t|" + downloadUrl);*/
				
				HttpResponse resp = service.getRequestFactory().buildGetRequest(new GenericUrl(googleFile.getDownloadUrl())).execute();

				InputStream is = resp.getContent();
				
				System.out.println("available =>" + is.available());
				
				FileOutputStream fos = new FileOutputStream(new java.io.File("google/" + googleFile.getTitle() + ".pdf"));
				
				byte[] buffer = new byte[2048];
							
				while((is.read(buffer)) != -1){
					
					fos.write(buffer);
					
				}
				
				fos.flush() ;
				
				fos.close();
				
				is.close();
				
			}					 
			
		//}
		
	}
	
	private static void searchDrive(Drive serviceDrive, String query){
		
		try{
			
			serviceDrive.files().list().setQ("" + query);
			
			//Files.List request = serviceDrive.files().list().setQ("mimeType = 'application/vnd.google-apps.folder'");

			Files.List request = serviceDrive.files().list().setQ("q");
			
			FileList fileList = request.execute();

			java.util.List<File> files = fileList.getItems();
			
			for(File file : files){
				
				System.out.println(file.getTitle() + "\t"+ file.getId()); 
				
				
			}
			
			
		}catch(Exception e){
			
			System.out.println("An error occurred: " + e);
			
		}
				
	}
	
}
