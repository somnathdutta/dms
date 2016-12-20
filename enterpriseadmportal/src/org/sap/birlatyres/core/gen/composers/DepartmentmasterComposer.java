package org.sap.birlatyres.core.gen.composers;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkmax.zul.Tablelayout;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.sap.birlatyres.core.gen.bean.*;
import org.sap.birlatyres.core.gen.dao.*;
import java.sql.Timestamp;
import java.sql.Types;

public class DepartmentmasterComposer extends GenericForwardComposer{
	//Define Common members here
	Div zmenu, zgrid, zform, main;
	Menuitem mLoad, mEdit, mNew, mSave, mDelete, mBack, mPrint;
	Listbox listbox;
	Label editId;
	Tablelayout tbl;
	String mode = "";
	//Define ZUL Specific Fields here
	private Textbox departmentcode ;
	private Textbox companycode ;
	private Textbox departmentname ;
	private Textbox departmenthead ;
	private Textbox functionalarea ;
	private Textbox location ;
	DepartmentmasterDAO daoHandler = new DepartmentmasterDAO();
	DepartmentmasterBean webbean = null ;
	public void onCreate$main() {
		mLoad.setDisabled(false);
		mEdit.setDisabled(true);
		mNew.setDisabled(false);
		mSave.setDisabled(true);
		mDelete.setDisabled(true);
		mBack.setDisabled(true);
		mPrint.setDisabled(true);
		mode = "init";
		webbean = new DepartmentmasterBean();
	}
	public void onClick$mNew() {
		formReset();
		mLoad.setDisabled(false);
		mEdit.setDisabled(true);
		mNew.setDisabled(true);
		mSave.setDisabled(false);
		mDelete.setDisabled(true);
		mBack.setDisabled(false);
		mPrint.setDisabled(true);
		mode = "NEW";
		webbean = new DepartmentmasterBean();
	}
	public void onClick$mBack() {
		formReset();
		mLoad.setDisabled(false);
		mEdit.setDisabled(true);
		mNew.setDisabled(false);
		mSave.setDisabled(true);
		mDelete.setDisabled(true);
		mBack.setDisabled(true);
		mPrint.setDisabled(true);
		mode = "NEW";
	}
	public void onSelect$listbox() {
		mLoad.setDisabled(false);
		mEdit.setDisabled(false);
		mNew.setDisabled(true);
		mSave.setDisabled(true);
		mDelete.setDisabled(false);
		mBack.setDisabled(false);
		mPrint.setDisabled(false);
		webbean  = (DepartmentmasterBean)listbox.getSelectedItem().getValue();
	}
	public void onClick$mLoad() {
		try {
			listbox.setModel(new ListModelList(daoHandler.findAll()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void onClick$mDelete() {
		try {
			webbean  = (DepartmentmasterBean)listbox.getSelectedItem().getValue();
			
			/*int result = Messagebox.show("Delete is pressed. Are you sure?", "Question", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION);
			
			if(result == Messagebox.OK){
				daoHandler.deleteAllByPK(webbean);
				listbox.setModel(new ListModelList(daoHandler.findAll()));
			}*/
			
			Messagebox.show("Please go to Transactions for deleting entities.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void onClick$mSave() {
		webbean = new DepartmentmasterBean();
		try{
			
			String departmentCodeInstr = departmentcode.getValue();
			
			if(departmentCodeInstr == null || departmentCodeInstr.trim().equals("")){
				
				alert("Please select Department Code,Department Name");
				
				departmentcode.setFocus(true);
				
				return ;
				
			}
			
			webbean.setDepartmentcode(departmentcode.getValue());
			webbean.setCompanycode(companycode.getValue());
			webbean.setDepartmentname(departmentname.getValue());
			webbean.setDepartmenthead(departmenthead.getValue());
			webbean.setFunctionalarea(functionalarea.getValue());
			webbean.setLocation(location.getValue());
			mLoad.setDisabled(false);
			mEdit.setDisabled(true);
			mNew.setDisabled(false);
			mSave.setDisabled(true);
			mDelete.setDisabled(true);
			mBack.setDisabled(false);
			mPrint.setDisabled(true);
			
			DepartmentmasterBean[] departmentmasterBeans = daoHandler.findByDepartmentcode(webbean.departmentcode); 
			
			if(departmentmasterBeans.length > 0){	
			
				daoHandler.updateAllColsForDepartmentAndGroup(webbean);
				
			}else{
				
				daoHandler.insertAllColsForDepartmentAndGroup(webbean);
				
			}
			
			/*if(mode.equalsIgnoreCase("NEW")){;
				daoHandler.insertAllColsForDepartmentAndGroup(webbean);
			}else if(mode.equalsIgnoreCase("EDIT")){
				daoHandler.updateAllCols(webbean);
			}*/
			
			Messagebox.show("Data saved successfully", "Information", Messagebox.OK, Messagebox.INFORMATION);
			
			formReset();
		}catch(Exception e){
			try{
			Messagebox.show("Data saving failed", "Error", Messagebox.OK, Messagebox.ERROR);
			}catch(Exception ex){}
			e.printStackTrace();
		}
	}
	public void onClick$mEdit(){
		mLoad.setDisabled(false);
		mEdit.setDisabled(true);
		mNew.setDisabled(true);
		mSave.setDisabled(false);
		mDelete.setDisabled(true);
		mBack.setDisabled(false);
		webbean  = (DepartmentmasterBean)listbox.getSelectedItem().getValue();
		mode = "EDIT";
		try{
			departmentcode.setValue(webbean.getDepartmentcode());
			companycode.setValue(webbean.getCompanycode());
			departmentname.setValue(webbean.getDepartmentname());
			departmenthead.setValue(webbean.getDepartmenthead());
			functionalarea.setValue(webbean.getFunctionalarea());
			location.setValue(webbean.getLocation());
			if(webbean == null){
				Messagebox.show("Invalid Edit Key", "Error", Messagebox.OK, Messagebox.ERROR);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void formReset(){
		mode = "NEW";
		departmentcode.setValue("");
		companycode.setValue("");
		departmentname.setValue("");
		departmenthead.setValue("");
		functionalarea.setValue("");
		location.setValue("");
		listbox.setSelectedItem(null);
	}
}
