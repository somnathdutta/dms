package org.mindgentrix.web.composers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.sap.birlatyres.core.gen.bean.ControldocumentBean;
import org.sap.birlatyres.core.gen.bean.DepartmentmasterBean;
import org.sap.birlatyres.core.gen.dao.ControldocumentDAO;
import org.sap.birlatyres.core.gen.dao.DepartmentmasterDAO;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Messagebox;

public class DepartmentOperationsComposer {

	private DepartmentmasterDAO departmentDAO = new DepartmentmasterDAO() ; 
	
	private List<DepartmentmasterBean> allDepartments = new ArrayList<DepartmentmasterBean>();
	
	private DepartmentmasterBean selectedDepartment;
	 
	private List<DepartmentmasterBean> selectedDepartments;

	public DepartmentOperationsComposer() {

		loadAllActiveDepartments(); 		
	}
	
	void loadAllActiveDepartments() {
		
		try {
			
			allDepartments = departmentDAO.findAllActiveDepartments();
			
		} catch (Exception e) {
			
			Messagebox.show(" Failed to fetch data due " + e.getMessage());
			
			e.printStackTrace();
			
		}		
		
	}

	@NotifyChange("*")
	@Command
	public void onUpdateDeleteStatusForDepartments() {

		if (this.selectedDepartments == null) {
			Messagebox.show(" No Department selected");
			return;
		}

		if (this.selectedDepartments.size() == 0) {
			Messagebox.show(" No Department selected");
			return;
		}
		
		try {
			Messagebox.show("The selected Departments will be deleted. Are you sure ?", "Confirm Dialog", 
					Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, 
					new org.zkoss.zk.ui.event.EventListener() {
					    public void onEvent(Event evt) throws Exception {
					        if (evt.getName().equals("onOK")) {    	
					        	
					        	handleUpdateDeleteStatusForDepartments() ;
					        } 
					    }
					}
			);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	public void handleUpdateDeleteStatusForDepartments() {
		
		try {
			
			departmentDAO.updateDeleteStatusForDepartments(selectedDepartments,"N");
			
			Messagebox.show("Deleted " + selectedDepartments.size() + " Department(s).");
			
			loadAllActiveDepartments() ;
			
		} catch (Exception e) {
			
			Messagebox.show("Failed to update datastore.");
			
		}
		
	}
	
	public List<DepartmentmasterBean> getAllDepartments() {
		return allDepartments;
	}

	public DepartmentmasterBean getSelectedDepartment() {
		return selectedDepartment;
	}

	public List<DepartmentmasterBean> getSelectedDepartments() {
		return selectedDepartments;
	}

	public void setAllDepartments(List<DepartmentmasterBean> allDepartments) {
		this.allDepartments = allDepartments;
	}

	public void setSelectedDepartment(DepartmentmasterBean selectedDepartment) {
		this.selectedDepartment = selectedDepartment;
	}

	public void setSelectedDepartments(
			List<DepartmentmasterBean> selectedDepartments) {
		this.selectedDepartments = selectedDepartments;
	}

}
