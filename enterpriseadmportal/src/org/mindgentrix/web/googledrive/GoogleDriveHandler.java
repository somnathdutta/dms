package org.mindgentrix.web.googledrive;

import java.io.IOException;
import java.io.InputStream;

import org.sap.birlatyres.core.gen.bean.ApplicationBean;
import org.sap.birlatyres.core.gen.dao.ApplicationDAO;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Files;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.Permission;

public class GoogleDriveHandler {
		
	private static GoogleDriveHandler instance ;
	
	private ApplicationDAO applicationDAO = null ;
	
	private ApplicationBean applicationBean ;
	
	private Drive serviceDrive ;
	
	private GoogleDriveHandler() throws Exception {
		
		//initialize() ;
		
	}

	void initialize() throws Exception {
		
		applicationDAO = new ApplicationDAO() ;
		
		applicationBean = applicationDAO.loadApplicationData();
	
		String SERVICE_ACCOUNT_EMAIL = "457485884937-immr8cru0io543i2ogp2ejsq6bi2af7c@developer.gserviceaccount.com";
		
		String SERVICE_ACCOUNT_PKCS12_FILE_PATH = applicationBean.getApplicationroot() + "key/877c8bac714c99c7deadd74affd2c11c9ccf54e7-privatekey.p12";
		
		
		HttpTransport httpTransport = new NetHttpTransport();

		JacksonFactory jsonFactory = new JacksonFactory();

		GoogleCredential credential = new GoogleCredential.Builder()
				.setTransport(httpTransport)
				.setJsonFactory(jsonFactory)
				.setServiceAccountId(SERVICE_ACCOUNT_EMAIL)
				.setServiceAccountScopes(DriveScopes.all())
				.setServiceAccountPrivateKeyFromP12File(new java.io.File(SERVICE_ACCOUNT_PKCS12_FILE_PATH))
				.build();

		serviceDrive = new Drive.Builder(httpTransport, jsonFactory, null).setHttpRequestInitializer(credential).build();
		
	}
	
	public static GoogleDriveHandler getInstance() throws Exception {
		
		//if(instance == null){
			
			GoogleDriveHandler instance$local = new GoogleDriveHandler() ;
			
		//}	
		
		return instance$local ;
		
	}
	
	public String addFileToGoogleDriveRoot(String filePath,String docTitle,String docDescription) throws Exception {
		
		File body = new File();
		
		body.setTitle(docTitle);
		
		body.setDescription(docDescription);
						
		body.setMimeType("application/pdf");

		java.io.File fileContent = new java.io.File(filePath);
		
		FileContent mediaContent = new FileContent("application/pdf", fileContent);

		File file = serviceDrive.files().insert(body, mediaContent).execute();
		
		return file.getId();	
		
	}
	
	public InputStream downloadFile(String fileId) throws Exception {
		
		File file = serviceDrive.files().get(fileId).execute();
		
		if (file.getDownloadUrl() != null && file.getDownloadUrl().length() > 0) {
			
			try {
				
				HttpResponse resp = serviceDrive.getRequestFactory().buildGetRequest(new GenericUrl(file.getDownloadUrl())).execute();
				
				return resp.getContent();
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
				return null;
				
			}
		} else {
			
			return null;
		}
	}
	
	public Permission insertPermission(String fileId ,String value, String type, String role) {
		
		Permission newPermission = new Permission();
		
		try {

			newPermission.setValue(value);
			newPermission.setType(type);
			newPermission.setRole(role);
			
			return serviceDrive.permissions().insert(fileId, newPermission).execute();
			
		} catch (Exception e) {
			
			e.printStackTrace() ;
			
			System.out.println("An error occurred: " + e);
			
		}
		return null;
	}
	
	private File trashFile(String fileId) {
	    
		try {
	      
			return serviceDrive.files().trash(fileId).execute();
	    
		} catch (IOException e) {
	    
			System.out.println("An error occurred: " + e);
	    
		}
	    
		return null;
	  }

	private File updateFile(String fileId,String newTitle, String newDescription, String newMimeType,	String newFilename, boolean newRevision) {
		try {
			// First retrieve the file from the API.
			File file = serviceDrive.files().get(fileId).execute();

			// File's new metadata.
			file.setTitle(newTitle);
			file.setDescription(newDescription);
			file.setMimeType(newMimeType);

			// File's new content.
			java.io.File fileContent = new java.io.File(newFilename);
			
			FileContent mediaContent = new FileContent(newMimeType, fileContent);

			// Send the request to the API.
			File updatedFile = serviceDrive.files().update(fileId, file, mediaContent).execute();

			return updatedFile;
			
		} catch (IOException e) {
			
			System.out.println("An error occurred: " + e);
			
			return null;
		}
	}
	
	private File copyFile(String originFileId,String copyTitle) {
		
		File copiedFile = new File();
		
		copiedFile.setTitle(copyTitle);
		
		try {
			
			return serviceDrive.files().copy(originFileId, copiedFile).execute();
		
		} catch (IOException e) {
		
			System.out.println("An error occurred: " + e);
		
		}
		
		return null;
	}

	private void searchDrive(String query){
		
		try{
			
			serviceDrive.files().list().setQ("" + query);
			
			Files.List request = serviceDrive.files().list().setQ("mimeType = 'application/vnd.google-apps.folder'");
			
		}catch(Exception e){
			
			System.out.println("An error occurred: " + e);
			
		}
				
	}
	
	
}
