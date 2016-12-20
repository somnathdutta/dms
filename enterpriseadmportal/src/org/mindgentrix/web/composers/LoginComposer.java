package org.mindgentrix.web.composers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.mindgentrix.web.beans.UserBean;
import org.sap.birlatyres.core.gen.bean.ApplicationBean;
import org.sap.birlatyres.core.gen.bean.GuestUserMastBean;
import org.sap.birlatyres.core.gen.bean.UsermasterBean;
import org.sap.birlatyres.core.gen.dao.ApplicationDAO;
import org.sap.birlatyres.core.gen.dao.GuestUserMasterDao;
import org.sap.birlatyres.core.gen.dao.UsermasterDAO;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class LoginComposer extends GenericForwardComposer {

	private static final long serialVersionUID = -5174049179807288330L;
	Textbox username;
	Textbox password;
	Button login;
	String lastupdatedate;
	UsermasterDAO usermasterDAO ;
	GuestUserMasterDao guestusermastDao;
	
	Checkbox chkIsguest;
	
	private UsermasterBean usermasterBean ;
	private ApplicationDAO applicationDAO = new ApplicationDAO();
	private GuestUserMastBean guestusermasterbean;
	private ApplicationBean applicationBean = null ;	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {

		super.doAfterCompose(comp);

		usermasterDAO = new UsermasterDAO();
		guestusermastDao = new GuestUserMasterDao();
		
	}

	public void onClick$login() throws Exception {

		String userNameValue = username.getText();

		String passwordValue = password.getText();

		if (passwordValue == null) {

			passwordValue = "";

		}
		
		if(chkIsguest.isChecked()){
			
			simpleControlFlowforGuest(userNameValue, passwordValue);
			
		}else{
			
			simpleControlFlow(userNameValue, passwordValue);
		}

		

	}

	void simpleControlFlow(String userNameValue, String passwordValue) throws Exception {

		Calendar currentDate = Calendar.getInstance();

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

		usermasterBean = usermasterDAO.authenticateUser(userNameValue,passwordValue);
		
		if(usermasterBean == null){
			
			alert("Oops! your credentials are not correct.");
			
		}else{
			
			session.setAttribute("USERBEAN", usermasterBean);
			
			applicationBean = applicationDAO.loadApplicationData();
			
			session.setAttribute("APPLICATIONBEAN", applicationBean);
			
			String userType = usermasterBean.getUsertype() ;
			
			System.out.println("current usertype = "+usermasterBean.getUsertype());
			
			if(userType.equalsIgnoreCase("SYS")){
				
				Executions.sendRedirect("/views/resourceIndex2.zul") ;
				
			}else if(userType.equalsIgnoreCase("MGR")){
				
				Executions.sendRedirect("/views/accountingIndex2.zul") ;				
				
			}else if(userType.equalsIgnoreCase("APR")){
				
				/*Executions.sendRedirect("/views/approverIndex2.zul") ;*/		
				Executions.sendRedirect("/views/resourceIndex2Approver.zul") ;
				
			}else if(userType.equalsIgnoreCase("DSYS")){
				
				
				Executions.sendRedirect("/views/resourceIndex2Dsys.zul") ;
				
			}else if(userType.equalsIgnoreCase("DAPR")){
				
				Executions.sendRedirect("/views/resourceIndex2Dapprover.zul") ;
				
			}else if(userType.equalsIgnoreCase("DSYS-DAPR")){
				
				Executions.sendRedirect("/views/resourceIndex2DsysDapprover.zul") ;
				
			}else{
				
				Executions.sendRedirect("/views/resourceIndex2User.zul") ;
				
			}
									
		}
		
	}
	
	
	
	void simpleControlFlowforGuest(String userNameValue, String passwordValue) throws Exception {
		
		System.out.println("in guest portaion");

		Calendar currentDate = Calendar.getInstance();

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

		//usermasterBean = usermasterDAO.authenticateUser(userNameValue,passwordValue);
		
		guestusermasterbean = guestusermastDao.getGuest(userNameValue, passwordValue);
		
		if(guestusermasterbean == null){
			
			alert("Oops! your credentials are not correct.");
			
		}else{
			if(guestusermasterbean.getIsactive().equalsIgnoreCase("N")){
				
				alert("This Guest user is not active now...");
			}else{
			
				session.setAttribute("GUESTUSERBEAN", guestusermasterbean);
				
				applicationBean = applicationDAO.loadApplicationData();
				
				session.setAttribute("APPLICATIONBEAN", applicationBean);
				
				Executions.sendRedirect("/views/resourceIndex2Guest.zul") ;
				
			}
									
		}
		
	}
	
	

}
