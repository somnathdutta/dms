package org.sap.birlatyres.core.gen.composers;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkmax.zul.Tablelayout;
import org.zkoss.zul.Checkbox;
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

public class SharecreatorComposer extends GenericForwardComposer{
	//Define Common members here
	Div zmenu, zgrid, zform, main;
	Menuitem mLoad, mEdit, mNew, mSave, mDelete, mBack, mPrint;
	Listbox listbox;
	Label editId;
	Tablelayout tbl;
	String mode = "";
	//Define ZUL Specific Fields here
	private Intbox documentid ;
	private Checkbox publicaccess ;
	
	//private Textbox groupcode ;
	
	Listbox groupcodelist ;
	
	private Textbox sharedescription ;
	private Checkbox synchgoogledriveshare ;
	private Datebox googlesyncheddate ;
	private Textbox controlfilepath ;
	private Checkbox isreadallowed ;
	private Checkbox isdownloadallowed ;
	private Checkbox isprintallowed ;
	private Datebox sharestartdate ;
	private Datebox shareenddate ;
		
	ShareregisterDAO daoHandler = new ShareregisterDAO();
	ShareregisterBean webbean = null ;
	UsermasterBean  usermasterBean ;
	
	ControldocumentBean controldocumentBean$instance  ;	
	
	RolemasterDAO rolemasterDAO = new RolemasterDAO() ;
	
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		
		Map<String,Object> argument = (Map<String, Object>) Executions.getCurrent().getArg();
		
		usermasterBean = (UsermasterBean)argument.get("USERBEAN");
		
		controldocumentBean$instance = (ControldocumentBean) argument.get("CONTROLBEAN");
		
		documentid.setValue(controldocumentBean$instance.documentid);
		
		RolemasterBean[] rolemasterBeans = rolemasterDAO.findAll(); 
		
		String[] roles = new String[rolemasterBeans.length];
		
		for(int index = 0 ; index < rolemasterBeans.length ; index++){
			
			RolemasterBean bean = rolemasterBeans[index];
			
			roles[index] = bean.groupcode + ":" + bean.groupname;		
			
		}
		
		groupcodelist.setModel(new ListModelList(roles));
		
		
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
			
			String publicAccessState 		= publicaccess.isChecked() ? "Y" : "N";
			String synchgoogledriveState 	= synchgoogledriveshare.isChecked() ? "Y" : "N";
			String isreadallowedState 		= isreadallowed.isChecked() ? "Y" : "N";
			String isdownloadallowedState	= isdownloadallowed.isChecked() ? "Y" : "N";
			String isprintallowedState 		= isprintallowed.isChecked() ? "Y" : "N";
						
			webbean.setDocumentid(documentid.getValue());
			webbean.setPublicaccess(publicAccessState);
			
			////webbean.setGroupcode(groupcode.getValue());
			
			webbean.setSharedescription(sharedescription.getValue());
			webbean.setSynchgoogledriveshare(synchgoogledriveState);
			webbean.setGooglesyncheddate(googlesyncheddate.getValue() != null ? new Timestamp(googlesyncheddate.getValue().getTime()) : null );
			webbean.setControlfilepath(controlfilepath.getValue());
			webbean.setIsreadallowed(isreadallowedState);
			webbean.setIsdownloadallowed(isdownloadallowedState);
			webbean.setIsprintallowed(isprintallowedState);
			webbean.setSharestartdate(sharestartdate.getValue() != null ? new Timestamp(sharestartdate.getValue().getTime()) : null );
			webbean.setShareenddate(shareenddate.getValue() != null ? new Timestamp(shareenddate.getValue().getTime()) : null );
			
			String selectedRoleCodeID = "GEN" ;
			
			String selectedRole = groupcodelist.getSelectedItem().getValue();
			
			if(selectedRole != null || selectedRole.trim().equals("")){
			
				selectedRoleCodeID = selectedRole.split("[:]")[0] ;
				
			}
			
			webbean.setGroupcode(selectedRoleCodeID);
			
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
			
			boolean publicAccessBool 			= webbean.getPublicaccess().equalsIgnoreCase("Y") ? true : false;
			boolean synchgoogledriveshareBool 	= webbean.getSynchgoogledriveshare().equalsIgnoreCase("Y") ? true : false;
			boolean isreadallowedBool			= webbean.getIsreadallowed().equalsIgnoreCase("Y") ? true : false;
			boolean isdownloadallowedBool		= webbean.getIsdownloadallowed().equalsIgnoreCase("Y") ? true : false;
			boolean isprintallowedBool		 	= webbean.getIsprintallowed().equalsIgnoreCase("Y") ? true : false;
			
			documentid.setValue(webbean.getDocumentid());
			publicaccess.setValue(publicAccessBool);
			
			///groupcode.setValue(webbean.getGroupcode());
			
			sharedescription.setValue(webbean.getSharedescription());
			synchgoogledriveshare.setValue(synchgoogledriveshareBool);
			googlesyncheddate.setValue(webbean.getGooglesyncheddate());
			controlfilepath.setValue(webbean.getControlfilepath());
			isreadallowed.setValue(isreadallowedBool);
			isdownloadallowed.setValue(isdownloadallowedBool);
			isprintallowed.setValue(isprintallowedBool);
			sharestartdate.setValue(webbean.getSharestartdate());
			shareenddate.setValue(webbean.getShareenddate());
			
			group : {
				
				RolemasterBean[] rolemasterBeans = rolemasterDAO.findAll();
				
				String[] roles = new String[rolemasterBeans.length]; 
				
				String code = webbean.groupcode ;
				
				int selectedIndex = 0 ;
				
				for(int index = 0 ; index < rolemasterBeans.length ; index++){
					
					RolemasterBean bean = rolemasterBeans[index];
					
					roles[index] = bean.groupcode + ":" + bean.groupname;		
					
					if(code.startsWith(bean.groupcode)){  
						
						selectedIndex = index ;
						
					}
					
				}
				
				groupcodelist.setModel(new ListModelList(roles));
				
				groupcodelist.setSelectedIndex(selectedIndex);				
				
			}
			
			
			if(webbean == null){
				Messagebox.show("Invalid Edit Key", "Error", Messagebox.OK, Messagebox.ERROR);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void formReset(){
		mode = "NEW";
		documentid.setValue(controldocumentBean$instance.documentid);
		publicaccess.setChecked(false);
		
		///groupcode.setValue("");
		
		sharedescription.setValue("");
		synchgoogledriveshare.setChecked(true);
		googlesyncheddate.setValue(new java.util.Date());
		controlfilepath.setValue("");
		isreadallowed.setChecked(true);
		isdownloadallowed.setChecked(true);
		isprintallowed.setChecked(true);
		sharestartdate.setValue(new java.util.Date());
		shareenddate.setValue(new java.util.Date());
		
		listbox.setSelectedItem(null);
	}
}
