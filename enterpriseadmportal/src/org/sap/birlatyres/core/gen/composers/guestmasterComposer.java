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

public class guestmasterComposer extends GenericForwardComposer{
	//Define Common members here
	
	Menuitem mLoad, mEdit, mNew, mSave, mDelete, mBack, mPrint;
	
	String mode = "";
	//Define ZUL Specific Fields here
	private Textbox guestuname ;
	private Textbox guestpassword ;
	private Textbox guestcode ;
	private Textbox phoneno ;
	private Textbox isactive ;
	//private Intbox accesslevel ;
	private Datebox startdate ;
	private Datebox enddate ;
	private Checkbox chkView;
	private Checkbox chkDownload;
	private Checkbox chkPrint;
	private Checkbox chkUpload;
	
	GuestUserMasterDao guestmasterdao = null;
	
	String guestusername = "";
	String guestuserpassword = "";
	String guestusercode = "";
	

	
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		
		guestmasterdao = new GuestUserMasterDao();
		
		mEdit.setDisabled(true);
		mSave.setDisabled(true);
		mDelete.setDisabled(true);
		mBack.setDisabled(true);
		mPrint.setDisabled(true);
		
		
		mLoad.setDisabled(true);
	
	}
	
	public void onClick$mNew(){
		mSave.setDisabled(false);
		mNew.setDisabled(true);
		
	}
	
	public void onClick$mLoad(){
		
		mEdit.setDisabled(false);
		
	}
	
	
	
	public void onClick$mSave() throws Exception{
		
		GuestMasterBean guestmasterbean = new GuestMasterBean();
		
		mSave.setDisabled(true);
		mNew.setDisabled(false);
		
		
		guestusername = guestuname.getValue();
		guestuserpassword = guestpassword.getValue();
		guestusercode = guestcode.getValue();
		
		if(guestusername == null || guestusername == ""){
			
			alert("Guest username is empty..");
			return;
		}

		if(guestuserpassword == null || guestuserpassword == ""){
			
			alert("Guest password is empty..");
			return;
		}
		
		if(guestusercode == null || guestusercode == ""){
			
			alert("Guest code is empty..");
			return;
		}
		
		
		guestmasterbean.setGuestusername(guestusername);
		guestmasterbean.setGuestpassword(guestuserpassword);
		guestmasterbean.setGuestcode(guestusercode);
		
		if(phoneno.getValue() == null){
			
			guestmasterbean.setGuestponeno("");
			
		}else{
			
			guestmasterbean.setGuestponeno(phoneno.getValue());
		}
		
		guestmasterbean.setIsactive(isactive.getValue());
		
		if(startdate.getValue() == null){
			
			guestmasterbean.setStartdate(null);
			
		}else{
			
			guestmasterbean.setStartdate(startdate.getValue());
		}
		
		if(enddate.getValue() == null){
			
			guestmasterbean.setEnddate(null);
		}else{
			
			guestmasterbean.setEnddate(enddate.getValue());
		}
		
		
		if(chkDownload.isChecked()){
			
			guestmasterbean.setAllowdownload("Y");
			
		}else{
			
			guestmasterbean.setAllowdownload("N");
		}
		
		if(chkUpload.isChecked()){
			
			guestmasterbean.setAllowupload("Y");
		}else{
			
			guestmasterbean.setAllowupload("N");
		}

		if(chkPrint.isChecked()){
			
			guestmasterbean.setAllowprint("Y");
		}else{
			
			guestmasterbean.setAllowprint("N");
		}

		if(chkView.isChecked()){
			
			guestmasterbean.setAllowview("Y");
		}else{
			
			guestmasterbean.setAllowview("N");
		}
		
		
		
		int count = guestmasterdao.newGuestregister(guestmasterbean);
		
		if(count == 1){
			
			alert("Guest user create successfully..");
		}else{
			
			alert("Guest user is not create successfully..");
		}
		
		


	}
	
	
	
	
	
}
