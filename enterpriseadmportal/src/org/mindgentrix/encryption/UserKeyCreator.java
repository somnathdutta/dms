package org.mindgentrix.encryption;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class UserKeyCreator {
	
	private String applicationPath ;
	
	private UserKeyCreator(String applicationPath$instance) throws Exception {
		
		applicationPath = applicationPath$instance ;
		
		setup();
		
	}

	void setup() throws Exception {
		
		File rootDir = new File(applicationPath + "home/") ;
		
		rootDir.mkdirs();
		
	}
	
	public static UserKeyCreator getInstance(String applicationPath$instance) throws Exception {
		
		return new UserKeyCreator(applicationPath$instance);
		
	}
	
	public void createNewKeyForUser(String username) throws Exception {
	
		try{
			
			File userhomeDir = new File(applicationPath + "home/" + username.toLowerCase()+ "/securedkeys/") ;
			
			File userhomeResourceDir = new File(applicationPath + "home/" + username.toLowerCase()+ "/resources/") ;
			
			File userhomePublicDir = new File(applicationPath + "home/" + username.toLowerCase()+ "/public/") ;
			
			userhomeDir.mkdirs();
			userhomeResourceDir.mkdirs();
			userhomePublicDir.mkdirs();
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally{
			
			//do-nothing
		}
		
	}
	
	void generateKeysForUser(String username) throws Exception {
		
		//for now copy keys from remote location.
		
		File systemhomeDir = new File("home/system/securedkeys/") ;
		
		File userhomeDir = new File("home/" + username.toLowerCase()+ "/securedkeys/") ;
		
		FileUtils.copyDirectory(systemhomeDir, userhomeDir);
		
	}
	
	public static void main(String[] args) throws Exception {
		
		UserKeyCreator userKeyCreator = UserKeyCreator.getInstance("");
		
		userKeyCreator.createNewKeyForUser("admin");
		
		userKeyCreator.generateKeysForUser("admin");
		
	}
}
