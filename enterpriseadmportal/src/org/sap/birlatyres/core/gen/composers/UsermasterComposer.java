package org.sap.birlatyres.core.gen.composers;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkmax.zul.Tablelayout;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Decimalbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.sap.birlatyres.core.gen.bean.*;
import org.sap.birlatyres.core.gen.dao.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.sql.Types;

public class UsermasterComposer extends GenericForwardComposer{
	//Define Common members here
	Div zmenu, zgrid, zform, main;
	Menuitem mLoad, mEdit, mNew, mSave, mDelete, mBack, mPrint;
	Listbox listbox;
	Label editId;
	Tablelayout tbl;
	String mode = "";
	//Define ZUL Specific Fields here
	private Textbox usercode ;
	private Textbox usertype ;
	private Textbox username ;
	private Textbox password ;
	private Intbox companycode ;
	private Textbox employmentcode ;
	private Intbox accesslevel ;
	private Textbox emailid ;
	private Textbox contactmobile ;
	private Textbox contactphone ;
	private Textbox homedir ;
	private Textbox isactive ;
	UsermasterDAO daoHandler = new UsermasterDAO();
	UsermasterBean webbean = null ;
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
			webbean.setUsercode(usercode.getValue());
			webbean.setUsertype(usertype.getValue());
			webbean.setUsername(username.getValue());
			webbean.setPassword(password.getValue());
			webbean.setCompanycode(companycode.getValue());
			webbean.setEmploymentcode(employmentcode.getValue());
			webbean.setAccesslevel(accesslevel.getValue());
			webbean.setEmailid(emailid.getValue());
			webbean.setContactmobile(contactmobile.getValue());
			webbean.setContactphone(contactphone.getValue());
			webbean.setHomedir(homedir.getValue());
			webbean.setIsactive(isactive.getValue());
			mLoad.setDisabled(false);
			mEdit.setDisabled(true);
			mNew.setDisabled(false);
			mSave.setDisabled(true);
			mDelete.setDisabled(true);
			mBack.setDisabled(false);
			mPrint.setDisabled(true);
			if(mode.equalsIgnoreCase("NEW")){;
				daoHandler.insertAllCols(webbean);
			}else if(mode.equalsIgnoreCase("EDIT")){
				daoHandler.updateAllCols(webbean);
			}
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
		webbean  = (UsermasterBean)listbox.getSelectedItem().getValue();
		mode = "EDIT";
		try{
			usercode.setValue(webbean.getUsercode());
			usertype.setValue(webbean.getUsertype());
			username.setValue(webbean.getUsername());
			password.setValue(webbean.getPassword());
			companycode.setValue(webbean.getCompanycode());
			employmentcode.setValue(webbean.getEmploymentcode());
			accesslevel.setValue(webbean.getAccesslevel());
			emailid.setValue(webbean.getEmailid());
			contactmobile.setValue(webbean.getContactmobile());
			contactphone.setValue(webbean.getContactphone());
			homedir.setValue(webbean.getHomedir());
			isactive.setValue(webbean.getIsactive());
			if(webbean == null){
				Messagebox.show("Invalid Edit Key", "Error", Messagebox.OK, Messagebox.ERROR);
			}
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
		accesslevel.setValue(0);
		emailid.setValue("");
		contactmobile.setValue("");
		contactphone.setValue("");
		homedir.setValue("");
		isactive.setValue("");
		listbox.setSelectedItem(null);
	}
}
