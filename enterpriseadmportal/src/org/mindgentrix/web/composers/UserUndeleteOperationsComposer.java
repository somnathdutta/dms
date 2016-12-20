package org.mindgentrix.web.composers;

import java.util.ArrayList;
import java.util.List;

import org.sap.birlatyres.core.gen.bean.UsermasterBean;
import org.sap.birlatyres.core.gen.dao.UsermasterDAO;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.Messagebox;

public class UserUndeleteOperationsComposer {

	private UsermasterDAO usermasterDAO = new UsermasterDAO() ;  
	
	private List<UsermasterBean> allUsers = new ArrayList<UsermasterBean>();
	
	private UsermasterBean selectedUser; 
	 
	private List<UsermasterBean> selectedUsers; 
 
	public UserUndeleteOperationsComposer() {

		loadAllInactiveUsers(); 		
	}
	
	void loadAllInactiveUsers() { 
		
		try {
			
			allUsers = usermasterDAO.findAllInactiveUsers();
			
		} catch (Exception e) {
			
			Messagebox.show(" Failed to fetch data due " + e.getMessage());
			
			e.printStackTrace();
			
		}		
		
	}

	@NotifyChange("*")
	@Command
	public void onUpdateUnDeleteStatusForUsers() {

		if (this.selectedUsers == null) {
			Messagebox.show(" No User selected");
			return;
		}

		if (this.selectedUsers.size() == 0) {
			Messagebox.show(" No User selected");
			return;
		}
		
		try {
			usermasterDAO.updateActiveStatusForUsers(selectedUsers,"Y");
			
			Messagebox.show("Activated " + selectedUsers.size() + " User(s).");
			
			loadAllInactiveUsers() ;
			
		} catch (Exception e) {
			
			Messagebox.show("Failed to update datastore.");
			
		}
		
	}

	public List<UsermasterBean> getAllUsers() {
		return allUsers;
	}

	public UsermasterBean getSelectedUser() {
		return selectedUser;
	}

	public List<UsermasterBean> getSelectedUsers() {
		return selectedUsers;
	}

	public void setAllUsers(List<UsermasterBean> allUsers) {
		this.allUsers = allUsers;
	}

	public void setSelectedUser(UsermasterBean selectedUser) {
		this.selectedUser = selectedUser;
	}

	public void setSelectedUsers(List<UsermasterBean> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}

}
