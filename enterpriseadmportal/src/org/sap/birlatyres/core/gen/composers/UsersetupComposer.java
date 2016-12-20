package org.sap.birlatyres.core.gen.composers;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkmax.zul.Tablelayout;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.mindgentrix.web.listbox.duallistbox.RoleDualListbox;
import org.sap.birlatyres.core.gen.bean.*;
import org.sap.birlatyres.core.gen.dao.*;

import java.sql.Timestamp;
import java.math.BigDecimal;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UsersetupComposer extends GenericForwardComposer{
	//Define Common members here
	Div zmenu, zgrid, zform, main;
	Menuitem mLoad, mEdit, mNew, mSave, mDelete, mBack, mPrint;
	Listbox listbox;
	Label editId;
	Tablelayout tbl;
	String mode = "";
	//Define ZUL Specific Fields here
	private Textbox usercode ;
	private Combobox usertype ;
	private Textbox username ;
	private Textbox password ;
	private Intbox companycode ;
	private Textbox employmentcode ;
	//private Intbox accesslevel ;
	private Textbox emailid ;
	private Textbox contactmobile ;
	private Textbox contactphone ;
	//private Textbox homedir ;
	private Textbox isactive ;
	private Combobox cmbDesignation;
	private Textbox txtRank;
	private Checkbox chkView;
	private Checkbox chkDownload;
	private Checkbox chkPrint;
	private Checkbox chkUpload;
	
	
	UsermasterDAO daoHandler = new UsermasterDAO();
	UsermasterBean webbean = null ;
	
	Map<String, Integer> mapdesignation = new HashMap<String, Integer>();
	
	@Wire
	private RoleDualListbox dualLBox;
	
	RolemasterDAO rolemaster = new RolemasterDAO() ;
	
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		
		dualLBox.setModel(new ListModelList<RolemasterBean>(rolemaster.getAllRoles()));
		
		Map<String, Integer> localmap = setDesignationAndRole();
		
		for(Entry<String, Integer>  map : localmap.entrySet()){
			
			Comboitem comboitem = new Comboitem();
			
			comboitem.setLabel(map.getKey());
			comboitem.setValue(map.getValue());
			
			cmbDesignation.appendChild(comboitem);
			
		}
		
	}
	
	
	
	public void onSelect$cmbDesignation(){
		
		txtRank.setValue((cmbDesignation.getSelectedItem().getValue()).toString());
	}
	
	public Map<String, Integer> setDesignationAndRole(){
		
		mapdesignation.put("GM - Process & Quality", 1);
		
		mapdesignation.put("Manager – Quality", 2);
		
		mapdesignation.put("Sr. Engineer – Research", 3);
		
		mapdesignation.put("Asst. Manager – Quality", 3);
		
		mapdesignation.put("Jr. Engineer R&D", 4);
		
		mapdesignation.put("Tr. Engineer", 4);
		
		mapdesignation.put("Asst.Supervisor – QC", 4);
		
		return mapdesignation;
		
		
		
	}
	
	public void onCreate$main() {
		mLoad.setDisabled(false);
		mEdit.setDisabled(true);
		mNew.setDisabled(false);
		mSave.setDisabled(true);
		mDelete.setDisabled(true);
		mBack.setDisabled(true);
		mPrint.setDisabled(true);
		mode = "init";
		webbean = new UsermasterBean();
	}
	public void onClick$mNew() {
		formReset();
		usercode.setReadonly(false);
		password.setReadonly(false);
		mLoad.setDisabled(false);
		mEdit.setDisabled(true);
		mNew.setDisabled(true);
		mSave.setDisabled(false);
		mDelete.setDisabled(true);
		mBack.setDisabled(false);
		mPrint.setDisabled(true);
		mode = "NEW";
		webbean = new UsermasterBean();
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
		webbean  = (UsermasterBean)listbox.getSelectedItem().getValue();
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
			webbean  = (UsermasterBean)listbox.getSelectedItem().getValue();
			int result = Messagebox.show("Delete is pressed. Are you sure?", "Question", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION);
			if(result == Messagebox.OK){
				daoHandler.deleteAllByPK(webbean);
				listbox.setModel(new ListModelList(daoHandler.findAll()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void onClick$mSave() {
		
		
		webbean = new UsermasterBean();
		
		try{
			
			String userCodeInStr = usercode.getValue() ;
			
			if(userCodeInStr == null || userCodeInStr.trim().equals("")){
				
				alert("Please select UserCode");
				
				usercode.setFocus(true);
				
				return ;
				
			}
			
			if(usertype.getSelectedItem() == null){
				
				alert("Please select Usertype");
				
				usertype.setFocus(true);
				
				return ;
			}
			
			String usertypeID = usertype.getSelectedItem().getValue().toString();
			
			if(usertypeID == null || usertypeID.equals("")){
				
				usertypeID = "USER" ;
				
			}
			
			
			if(cmbDesignation.getSelectedIndex()==-1){
				
				alert("Please select designation");
				
			}else{
				
				webbean.setDesignation(cmbDesignation.getSelectedItem().getLabel());
				
				webbean.setRank(Integer.valueOf(txtRank.getValue()));
			}
			
			
			if(chkDownload.isChecked()){
				
				webbean.setDownloadallowed("Y");
				
			}else{
				
				webbean.setDownloadallowed("N");
			}
			
			if(chkUpload.isChecked()){
				
				webbean.setUploadallowed("Y");
			}else{
				
				webbean.setUploadallowed("N");
			}

			if(chkPrint.isChecked()){
				
				webbean.setPrintallowed("Y");
			}else{
				
				webbean.setPrintallowed("N");
			}

			if(chkView.isChecked()){
				
				webbean.setViewallowed("Y");
			}else{
				
				webbean.setViewallowed("N");
			}
			
			webbean.setUsercode(usercode.getValue());
			
			////webbean.setUsertype(usertype.getValue());
			webbean.setUsertype(usertype.getValue());
			
			webbean.setUsername(username.getValue());
			webbean.setPassword(password.getValue());
			webbean.setCompanycode(companycode.getValue());
			webbean.setEmploymentcode(employmentcode.getValue());
			//webbean.setAccesslevel(accesslevel.getValue());
			webbean.setEmailid(emailid.getValue());
			webbean.setContactmobile(contactmobile.getValue());
			webbean.setContactphone(contactphone.getValue());
			//webbean.setHomedir(homedir.getValue());
			webbean.setIsactive(isactive.getValue());
			mLoad.setDisabled(false);
			mEdit.setDisabled(true);
			mNew.setDisabled(false);
			mSave.setDisabled(true);
			mDelete.setDisabled(true);
			mBack.setDisabled(false);
			mPrint.setDisabled(true);
			 
			Listbox chosenLb = dualLBox.getChosenLb() ; 
			
			ListModel<RolemasterBean> rolesModel = chosenLb.getListModel();
			
			int dataSize = rolesModel.getSize();
			
			System.out.println("roles size = " + dataSize); 
			
			String[] roles = new String[dataSize];
			
			for(int index = 0 ; index < dataSize ; index++){
				
				RolemasterBean rolemasterBean = rolesModel.getElementAt(index) ;
				
				System.out.println(rolemasterBean.getGroupname()); 
				
				roles[index] = rolemasterBean.groupcode ;
				
			}
			
			UsermasterBean[] userBeans = daoHandler.findByUsercode(webbean.usercode);
			
			if(userBeans.length > 0 ){
				
				daoHandler.updateUserAndPrivileges(webbean, roles);
				
			}else{
				
				daoHandler.insertUserAndPrivileges(webbean, roles);
			}
			
			/*if(mode.equalsIgnoreCase("NEW")){
				
				daoHandler.insertUserAndPrivileges(webbean, roles); 
				
			}else if(mode.equalsIgnoreCase("EDIT")){
				
				alert("Edit is currently disabled");
				
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
		usercode.setReadonly(true);
		mLoad.setDisabled(false);
		mEdit.setDisabled(true);
		mNew.setDisabled(true);
		mSave.setDisabled(false);
		mDelete.setDisabled(true);
		mBack.setDisabled(false);
		webbean  = (UsermasterBean)listbox.getSelectedItem().getValue();
		mode = "EDIT";
		try{
			usercode.setValue(webbean.getUsercode());
			usertype.setValue(webbean.getUsertype());
			username.setValue(webbean.getUsername());
			password.setValue(webbean.getPassword());
			password.setReadonly(true);
			companycode.setValue(webbean.getCompanycode());
			employmentcode.setValue(webbean.getEmploymentcode());
			//accesslevel.setValue(webbean.getAccesslevel());
			emailid.setValue(webbean.getEmailid());
			contactmobile.setValue(webbean.getContactmobile());
			contactphone.setValue(webbean.getContactphone());
			
			cmbDesignation.setValue(webbean.getDesignation());
			
			txtRank.setValue(String.valueOf(webbean.getRank()));
			
			//homedir.setValue(webbean.getHomedir());
			isactive.setValue(webbean.getIsactive());
			
			if(webbean.getViewallowed().equalsIgnoreCase("Y")){
				
				chkView.setChecked(true);
			}else{
				
				chkView.setChecked(false);
			}
			
			if(webbean.getDownloadallowed().equalsIgnoreCase("Y")){
				
				chkDownload.setChecked(true);
			}else{
				
				chkDownload.setChecked(false);
			}
			
			if(webbean.getPrintallowed().equalsIgnoreCase("Y")){
				
				chkPrint.setChecked(true);
			}else{
				
				chkPrint.setChecked(false);
			}
			
			if(webbean.getUploadallowed().equalsIgnoreCase("Y")){
				
				chkUpload.setChecked(true);
			}else{
				
				chkUpload.setChecked(false);
			}
			
			dualLBox.modifyModel(new ListModelList<RolemasterBean>(rolemaster.getUserRoles(webbean.getUsercode()))); 
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void formReset(){
		mode = "NEW";
		usercode.setValue("");
		usertype.setValue("");
		username.setValue("");
		password.setValue("");
		companycode.setValue(0);
		employmentcode.setValue("");
		//accesslevel.setValue(0);
		emailid.setValue("");
		contactmobile.setValue("");
		contactphone.setValue("");
		//homedir.setValue("");
		isactive.setValue("Y");
		listbox.setSelectedItem(null);
	}
}
