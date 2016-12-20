package org.sap.birlatyres.core.gen.composers;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
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
import java.util.Map;

public class ShareregisterComposer extends GenericForwardComposer{
	//Define Common members here
	Div zmenu, zgrid, zform, main;
	Menuitem mLoad, mEdit, mNew, mSave, mDelete, mBack, mPrint;
	Listbox listbox;
	Label editId;
	Tablelayout tbl;
	String mode = "";
	//Define ZUL Specific Fields here
	private Intbox documentid ;
	private Textbox publicaccess ;
	private Textbox groupcode ;
	private Textbox sharedescription ;
	private Textbox synchgoogledriveshare ;
	private Datebox googlesyncheddate ;
	private Textbox controlfilepath ;
	private Textbox isreadallowed ;
	private Textbox isdownloadallowed ;
	private Textbox isprintallowed ;
	private Datebox sharestartdate ;
	private Datebox shareenddate ;
	private Datebox creationdate ;
	private Textbox createdby ;
	private Datebox modifieddate ;
	private Textbox modifiedby ;
	ShareregisterDAO daoHandler = new ShareregisterDAO();
	ShareregisterBean webbean = null ;
	
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		
		Map<String,Object> argument = (Map<String, Object>) Executions.getCurrent().getArg();
		
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
		webbean = new ShareregisterBean();
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
		webbean = new ShareregisterBean();
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
		webbean  = (ShareregisterBean)listbox.getSelectedItem().getValue();
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
			webbean  = (ShareregisterBean)listbox.getSelectedItem().getValue();
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
		webbean = new ShareregisterBean();
		try{
			webbean.setDocumentid(documentid.getValue());
			webbean.setPublicaccess(publicaccess.getValue());
			webbean.setGroupcode(groupcode.getValue());
			webbean.setSharedescription(sharedescription.getValue());
			webbean.setSynchgoogledriveshare(synchgoogledriveshare.getValue());
			webbean.setGooglesyncheddate(googlesyncheddate.getValue() != null ? new Timestamp(googlesyncheddate.getValue().getTime()) : null );
			webbean.setControlfilepath(controlfilepath.getValue());
			webbean.setIsreadallowed(isreadallowed.getValue());
			webbean.setIsdownloadallowed(isdownloadallowed.getValue());
			webbean.setIsprintallowed(isprintallowed.getValue());
			webbean.setSharestartdate(sharestartdate.getValue() != null ? new Timestamp(sharestartdate.getValue().getTime()) : null );
			webbean.setShareenddate(shareenddate.getValue() != null ? new Timestamp(shareenddate.getValue().getTime()) : null );
			webbean.setCreationdate(creationdate.getValue() != null ? new Timestamp(creationdate.getValue().getTime()) : null );
			webbean.setCreatedby(createdby.getValue());
			webbean.setModifieddate(modifieddate.getValue() != null ? new Timestamp(modifieddate.getValue().getTime()) : null );
			webbean.setModifiedby(modifiedby.getValue());
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
		webbean  = (ShareregisterBean)listbox.getSelectedItem().getValue();
		mode = "EDIT";
		try{
			documentid.setValue(webbean.getDocumentid());
			publicaccess.setValue(webbean.getPublicaccess());
			groupcode.setValue(webbean.getGroupcode());
			sharedescription.setValue(webbean.getSharedescription());
			synchgoogledriveshare.setValue(webbean.getSynchgoogledriveshare());
			googlesyncheddate.setValue(webbean.getGooglesyncheddate());
			controlfilepath.setValue(webbean.getControlfilepath());
			isreadallowed.setValue(webbean.getIsreadallowed());
			isdownloadallowed.setValue(webbean.getIsdownloadallowed());
			isprintallowed.setValue(webbean.getIsprintallowed());
			sharestartdate.setValue(webbean.getSharestartdate());
			shareenddate.setValue(webbean.getShareenddate());
			creationdate.setValue(webbean.getCreationdate());
			createdby.setValue(webbean.getCreatedby());
			modifieddate.setValue(webbean.getModifieddate());
			modifiedby.setValue(webbean.getModifiedby());
			if(webbean == null){
				Messagebox.show("Invalid Edit Key", "Error", Messagebox.OK, Messagebox.ERROR);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void formReset(){
		mode = "NEW";
		documentid.setValue(0);
		publicaccess.setValue("");
		groupcode.setValue("");
		sharedescription.setValue("");
		synchgoogledriveshare.setValue("");
		googlesyncheddate.setValue(new java.util.Date());
		controlfilepath.setValue("");
		isreadallowed.setValue("");
		isdownloadallowed.setValue("");
		isprintallowed.setValue("");
		sharestartdate.setValue(new java.util.Date());
		shareenddate.setValue(new java.util.Date());
		creationdate.setValue(new java.util.Date());
		createdby.setValue("");
		modifieddate.setValue(new java.util.Date());
		modifiedby.setValue("");
		listbox.setSelectedItem(null);
	}
}
