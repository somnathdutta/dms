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

public class DocumenthistoryComposer extends GenericForwardComposer{
	//Define Common members here
	Div zmenu, zgrid, zform, main;
	Menuitem mLoad, mEdit, mNew, mSave, mDelete, mBack, mPrint;
	Listbox listbox;
	Label editId;
	Tablelayout tbl;
	String mode = "";
	//Define ZUL Specific Fields here
	private Intbox transactionid ;
	private Intbox documentid ;
	private Textbox documentnumber ;
	private Textbox documentname ;
	private Textbox operationname ;
	private Datebox operationdatetime ;
	private Intbox documentversionnumber ;
	private Textbox controltargetfilepath ;
	private Textbox operationauthorizedby ;
	private Datebox creationdatetime ;
	private Textbox createdby ;
	DocumenthistoryDAO daoHandler = new DocumenthistoryDAO();
	DocumenthistoryBean webbean = null ;
	public void onCreate$main() {
		mLoad.setDisabled(false);
		mEdit.setDisabled(true);
		mNew.setDisabled(false);
		mSave.setDisabled(true);
		mDelete.setDisabled(true);
		mBack.setDisabled(true);
		mPrint.setDisabled(true);
		mode = "init";
		webbean = new DocumenthistoryBean();
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
		webbean = new DocumenthistoryBean();
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
		webbean  = (DocumenthistoryBean)listbox.getSelectedItem().getValue();
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
			webbean  = (DocumenthistoryBean)listbox.getSelectedItem().getValue();
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
		webbean = new DocumenthistoryBean();
		try{
			webbean.setTransactionid(transactionid.getValue());
			webbean.setDocumentid(documentid.getValue());
			webbean.setDocumentnumber(documentnumber.getValue());
			webbean.setDocumentname(documentname.getValue());
			webbean.setOperationname(operationname.getValue());
			webbean.setOperationdatetime(operationdatetime.getValue() != null ? new Timestamp(operationdatetime.getValue().getTime()) : null );
			webbean.setDocumentversionnumber(documentversionnumber.getValue());
			webbean.setControltargetfilepath(controltargetfilepath.getValue());
			webbean.setOperationauthorizedby(operationauthorizedby.getValue());
			webbean.setCreationdatetime(creationdatetime.getValue() != null ? new Timestamp(creationdatetime.getValue().getTime()) : null );
			webbean.setCreatedby(createdby.getValue());
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
		webbean  = (DocumenthistoryBean)listbox.getSelectedItem().getValue();
		mode = "EDIT";
		try{
			transactionid.setValue(webbean.getTransactionid());
			documentid.setValue(webbean.getDocumentid());
			documentnumber.setValue(webbean.getDocumentnumber());
			documentname.setValue(webbean.getDocumentname());
			operationname.setValue(webbean.getOperationname());
			operationdatetime.setValue(webbean.getOperationdatetime());
			documentversionnumber.setValue(webbean.getDocumentversionnumber());
			controltargetfilepath.setValue(webbean.getControltargetfilepath());
			operationauthorizedby.setValue(webbean.getOperationauthorizedby());
			creationdatetime.setValue(webbean.getCreationdatetime());
			createdby.setValue(webbean.getCreatedby());
			if(webbean == null){
				Messagebox.show("Invalid Edit Key", "Error", Messagebox.OK, Messagebox.ERROR);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void formReset(){
		mode = "NEW";
		transactionid.setValue(0);
		documentid.setValue(0);
		documentnumber.setValue("");
		documentname.setValue("");
		operationname.setValue("");
		operationdatetime.setValue(new java.util.Date());
		documentversionnumber.setValue(0);
		controltargetfilepath.setValue("");
		operationauthorizedby.setValue("");
		creationdatetime.setValue(new java.util.Date());
		createdby.setValue("");
		listbox.setSelectedItem(null);
	}
}
