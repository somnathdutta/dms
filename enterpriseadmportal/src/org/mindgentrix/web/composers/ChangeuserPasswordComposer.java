package org.mindgentrix.web.composers;

import java.sql.SQLException;

import org.sap.birlatyres.core.gen.dao.ChangeUserpasswordDao;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

public class ChangeuserPasswordComposer extends GenericForwardComposer{
	
	Textbox usercode;
	Button btnConfirm;
	
	
	Row rowUsername;
	Row rownewpassword;
	Row rowreenteredpassword;
	Row rowsubmit;
	
	Label lbluserName;
	Textbox txtPassword;
	Textbox txtReenterpassword;
	Button btnSubmit;
	
	
	
	String usercodeforchangePass = "";
	
	ChangeUserpasswordDao changeuserpassworddao = null;
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		
		rowUsername.setVisible(false);
		rownewpassword.setVisible(false);
		rowreenteredpassword.setVisible(false);
		rowsubmit.setVisible(false);
		
		
	}
	
	public void onClick$btnConfirm() throws Exception {
		
		usercodeforchangePass = usercode.getValue();
		
		if(usercodeforchangePass.length()==0){
			
			alert("Please Type usercode ...");
			
			return;
			
		}else{
			
			String username = "";
			
			changeuserpassworddao = new ChangeUserpasswordDao();
			
			username = changeuserpassworddao.getUsername(usercodeforchangePass);
			
			if(username.length() == 0){
				
				alert("You have entered a worng usercode...");
				
				return;
			}else{
				
				rowUsername.setVisible(true);
				rownewpassword.setVisible(true);
				rowreenteredpassword.setVisible(true);
				rowsubmit.setVisible(true);
				lbluserName.setValue(username);
				
			}
			
		}
		
	}
	
	
	public void onClick$btnSubmit() throws Exception{
		
		String newpassword = "";
		String reEnteredpassword ="";
		
		newpassword = txtPassword.getValue();
		reEnteredpassword = txtReenterpassword.getValue();
		
		if(newpassword.length() == 0){
			
			alert("Please entered new password..");
			
			return;
		}
		
		if(reEnteredpassword.length() == 0){
			
			alert("Please entered retype new password..");
			
			return;
			
		}
		
		
		if(!newpassword.equalsIgnoreCase(reEnteredpassword)){
			
			alert("new password is not match with reenteredpassword ");
			
			return;
			
		}
		
		int count = changeuserpassworddao.changePassword(usercode.getValue(), reEnteredpassword);
		
		if(count == 0){
			
			alert("password is not changed successfully");
			
		}else{
			
			alert("password changed successfully!");
		}
		
		rowUsername.setVisible(false);
		rownewpassword.setVisible(false);
		rowreenteredpassword.setVisible(false);
		rowsubmit.setVisible(false);
		
	}

}
