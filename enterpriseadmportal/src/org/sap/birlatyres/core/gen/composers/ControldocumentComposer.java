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
import java.sql.Types;

public class ControldocumentComposer extends GenericForwardComposer{
	//Define Common members here
	Div zmenu, zgrid, zform, main;
	Menuitem mLoad, mEdit, mNew, mSave, mDelete, mBack, mPrint;
	Listbox listbox;
	Label editId;
	Tablelayout tbl;
	String mode = "";
	//Define ZUL Specific Fields here
	private Intbox documentid ;
	private Textbox documentnumber ;
	private Textbox documenttype ;
	private Textbox documentname ;
	private Textbox documentversion ;
	private Textbox documenthashkey ;
	private Textbox description ;
	private Textbox controlfilepath ;
	private Datebox controlfilecreationdate ;
	private Intbox controlfilesize ;
	private Textbox synchgoogledrive ;
	private Datebox googledrivesynchedtime ;
	private Textbox googlefolderpath ;
	private Textbox googledrivefileid ;
	private Intbox ownerid ;
	private Textbox isblocked ;
	private Textbox isdeleted ;
	private Textbox ispasswordprotected ;
	private Textbox departmentcode ;
	private Textbox location ;
	private Textbox approvedyn ;
	private Datebox creationdatetime ;
	private Textbox createdby ;
	private Datebox modifieddatetime ;
	private Datebox modifiedby ;
	ControldocumentDAO daoHandler = new ControldocumentDAO();
	ControldocumentBean webbean = null ;
	public void onCreate$main() {
		mLoad.setDisabled(false);
		mEdit.setDisabled(true);
		mNew.setDisabled(false);
		mSave.setDisabled(true);
		mDelete.setDisabled(true);
		mBack.setDisabled(true);
		mPrint.setDisabled(true);
		mode = "init";
		webbean = new ControldocumentBean();
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
		webbean = new ControldocumentBean();
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
		webbean  = (ControldocumentBean)listbox.getSelectedItem().getValue();
	}
	public void onClick$mLoad() {
		
		String usercode="";
		String usertype = "";
		try {
			listbox.setModel(new ListModelList(daoHandler.findAll(usercode,usertype)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void onClick$mDelete() {
		
		String usercode="";
		String usertype = "";
		try {
			webbean  = (ControldocumentBean)listbox.getSelectedItem().getValue();
			int result = Messagebox.show("Delete is pressed. Are you sure?", "Question", Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION);
			if(result == Messagebox.OK){
				daoHandler.deleteAllByPK(webbean);
				listbox.setModel(new ListModelList(daoHandler.findAll(usercode,usertype)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void onClick$mSave() {
		webbean = new ControldocumentBean();
		try{
			webbean.setDocumentid(documentid.getValue());
			webbean.setDocumentnumber(documentnumber.getValue());
			webbean.setDocumenttype(documenttype.getValue());
			webbean.setDocumentname(documentname.getValue());
			webbean.setDocumentversion(documentversion.getValue());
			webbean.setDocumenthashkey(documenthashkey.getValue());
			webbean.setDescription(description.getValue());
			webbean.setControlfilepath(controlfilepath.getValue());
			webbean.setControlfilecreationdate(controlfilecreationdate.getValue() != null ? new Timestamp(controlfilecreationdate.getValue().getTime()) : null );
			webbean.setControlfilesize(controlfilesize.getValue());
			webbean.setSynchgoogledrive(synchgoogledrive.getValue());
			webbean.setGoogledrivesynchedtime(googledrivesynchedtime.getValue() != null ? new Timestamp(googledrivesynchedtime.getValue().getTime()) : null );
			webbean.setGooglefolderpath(googlefolderpath.getValue());
			webbean.setGoogledrivefileid(googledrivefileid.getValue());
			webbean.setOwnerid(ownerid.getValue());
			webbean.setIsblocked(isblocked.getValue());
			webbean.setIsdeleted(isdeleted.getValue());
			webbean.setIspasswordprotected(ispasswordprotected.getValue());
			webbean.setDepartmentcode(departmentcode.getValue());
			webbean.setLocation(location.getValue());
			webbean.setApprovedyn(approvedyn.getValue());
			webbean.setCreationdatetime(creationdatetime.getValue() != null ? new Timestamp(creationdatetime.getValue().getTime()) : null );
			webbean.setCreatedby(createdby.getValue());
			webbean.setModifieddatetime(modifieddatetime.getValue() != null ? new Timestamp(modifieddatetime.getValue().getTime()) : null );
			webbean.setModifiedby(modifiedby.getValue() != null ? new Timestamp(modifiedby.getValue().getTime()) : null );
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
		webbean  = (ControldocumentBean)listbox.getSelectedItem().getValue();
		mode = "EDIT";
		try{
			documentid.setValue(webbean.getDocumentid());
			documentnumber.setValue(webbean.getDocumentnumber());
			documenttype.setValue(webbean.getDocumenttype());
			documentname.setValue(webbean.getDocumentname());
			documentversion.setValue(webbean.getDocumentversion());
			documenthashkey.setValue(webbean.getDocumenthashkey());
			description.setValue(webbean.getDescription());
			controlfilepath.setValue(webbean.getControlfilepath());
			controlfilecreationdate.setValue(webbean.getControlfilecreationdate());
			controlfilesize.setValue(webbean.getControlfilesize());
			synchgoogledrive.setValue(webbean.getSynchgoogledrive());
			googledrivesynchedtime.setValue(webbean.getGoogledrivesynchedtime());
			googlefolderpath.setValue(webbean.getGooglefolderpath());
			googledrivefileid.setValue(webbean.getGoogledrivefileid());
			ownerid.setValue(webbean.getOwnerid());
			isblocked.setValue(webbean.getIsblocked());
			isdeleted.setValue(webbean.getIsdeleted());
			ispasswordprotected.setValue(webbean.getIspasswordprotected());
			departmentcode.setValue(webbean.getDepartmentcode());
			location.setValue(webbean.getLocation());
			approvedyn.setValue(webbean.getApprovedyn());
			creationdatetime.setValue(webbean.getCreationdatetime());
			createdby.setValue(webbean.getCreatedby());
			modifieddatetime.setValue(webbean.getModifieddatetime());
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
		documentnumber.setValue("");
		documenttype.setValue("");
		documentname.setValue("");
		documentversion.setValue("");
		documenthashkey.setValue("");
		description.setValue("");
		controlfilepath.setValue("");
		controlfilecreationdate.setValue(new java.util.Date());
		controlfilesize.setValue(0);
		synchgoogledrive.setValue("");
		googledrivesynchedtime.setValue(new java.util.Date());
		googlefolderpath.setValue("");
		googledrivefileid.setValue("");
		ownerid.setValue(0);
		isblocked.setValue("");
		isdeleted.setValue("");
		ispasswordprotected.setValue("");
		departmentcode.setValue("");
		location.setValue("");
		approvedyn.setValue("");
		creationdatetime.setValue(new java.util.Date());
		createdby.setValue("");
		modifieddatetime.setValue(new java.util.Date());
		modifiedby.setValue(new java.util.Date());
		listbox.setSelectedItem(null);
	}
}
