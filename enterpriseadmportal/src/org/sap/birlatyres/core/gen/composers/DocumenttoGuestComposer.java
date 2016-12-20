package org.sap.birlatyres.core.gen.composers;

import java.util.Map;

import org.sap.birlatyres.core.gen.bean.ControldocumentBean;
import org.sap.birlatyres.core.gen.dao.GuestUserMasterDao;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;

public class DocumenttoGuestComposer extends GenericForwardComposer{
	
	Textbox txtguestcode;
	Button btnConfirm;
	
	Row rwguname;
	Label lblGuestusername;
	
	Row rwdname;
	Label lbldocname;
	
	Row rwdnumber;
	Label lbldocumentnumber;
	
	Row rwsubmit;
	Button btnSubmit;
	
	ControldocumentBean controldocumentbean = null;
	
	GuestUserMasterDao guestusermastDao = null;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		
		rwguname.setVisible(false);
		rwdnumber.setVisible(false);
		rwsubmit.setVisible(false);
		rwdname.setVisible(false);
		
		guestusermastDao = new GuestUserMasterDao();
		
		Map<String,ControldocumentBean> argument = (Map<String, ControldocumentBean>) Executions.getCurrent().getArg();
		
		controldocumentbean = argument.get("CONTROLDOCUMENTBEAN");
		
		System.out.println("controldocumentbean======"+controldocumentbean.getDocumentid()+"name==="+controldocumentbean.getDocumentnumber());
		
	}
	
	String guestusercode ="";
	String guestusername = "";
	public void onClick$btnConfirm() throws Exception{
		
		guestusercode =txtguestcode.getValue();
		
		if( guestusercode.length() == 0){
			
			alert("please enter guest usercode.. ");
			
			return;
		}else{
		
			guestusername = guestusermastDao.getGusetusername(txtguestcode.getValue());
			
			if(guestusername == null || guestusername == ""){
				
				alert("you have entered wrong guestusercode..");
				
			}else{
			
				rwguname.setVisible(true);
				rwdnumber.setVisible(true);
				rwsubmit.setVisible(true);
				rwdname.setVisible(true);
				
				
				lblGuestusername.setValue(guestusername);
				lbldocumentnumber.setValue(controldocumentbean.getDocumentnumber());
				lbldocname.setValue(controldocumentbean.getDocumentname());
			}
		}
	}
	
	public void onClick$btnSubmit() throws Exception{
		
		String guestusercode =txtguestcode.getValue();
		int documentid = controldocumentbean.getDocumentid();
		String isactive = "Y";
		
		int result = guestusermastDao.insertGuestDocumentMatrix(guestusercode, documentid, isactive);
		
		if(result == 1){
			
			alert("Document shared to guest successfully..");
			rwguname.setVisible(false);
			rwdnumber.setVisible(false);
			rwsubmit.setVisible(false);
			rwdname.setVisible(false);
			txtguestcode.setValue("");
			
		}else{
			
			alert("Document is not shared to guest successfully..");
		}
		
		
		
		
	}

}
