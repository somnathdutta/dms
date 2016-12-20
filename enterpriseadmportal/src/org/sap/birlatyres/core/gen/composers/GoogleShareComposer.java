package org.sap.birlatyres.core.gen.composers;

import java.util.Map;

import org.mindgentrix.web.googledrive.GoogleDriveHandler;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

public class GoogleShareComposer  extends GenericForwardComposer {

	Textbox email;
	Button btncreatepermission;
	
	private String googleFileId ;
	
	GoogleDriveHandler googleDriveHandler = null ;
	
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
	
		Map<String,Object> argument = (Map<String, Object>) Executions.getCurrent().getArg();
		
		googleFileId = (String) argument.get("GOOGLEFILEID");
		
		googleDriveHandler = (GoogleDriveHandler) argument.get("GOOGLEDRIVEHANDLER");
		
	}
	
	public void onClick$btncreatepermission() throws Exception {
		
		googleDriveHandler.insertPermission(googleFileId, email.getText(), "user", "reader");
		
	}
	

}
