package org.mindgentrix.web.composers;

import java.util.Map;

import org.sap.birlatyres.core.gen.bean.DocumentMessageBean;
import org.sap.birlatyres.core.gen.dao.ControldocumentDAO;
import org.sap.birlatyres.core.gen.dao.DocumentMessagesHandler;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class RejectionModalComposer extends GenericForwardComposer{

	Window closewinrejection;
	
	Button btnunapprovereason;
	Label lblDocumentno;
	Label lblDocumentname;
	Label lblDocumentrevision;
	Textbox txtmessage;
	
	String googleid;
	String documentid;
	String documentnumber;
	String documentname;
	String documentrevision;
	String usercode;
	
	String mseeage = "";
	
	DocumentMessageBean messagebean ;
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
	
		Map<String,String> argument = (Map<String, String>) Executions.getCurrent().getArg();
		
		googleid = argument.get("googleFileId");
		documentid = argument.get("documentid");
		documentnumber = argument.get("documentno");
		documentname = argument.get("documentname");
		documentrevision = argument.get("documentrevision");
		usercode = argument.get("usercode");
		
		lblDocumentno.setValue(documentnumber);
		lblDocumentname.setValue(documentname);
		lblDocumentrevision.setValue(documentrevision);
		
		System.out.println("------>"+googleid+"||"+documentid+"||"+documentnumber+"||"+documentname+"||"+documentrevision+"||||"+usercode);
	}
	
	
	
	public void onClick$btnunapprovereason() throws Exception{
		
		messagebean = new DocumentMessageBean();
		
		mseeage = txtmessage.getValue();
		
		if(mseeage.length()==0){
			
			alert("Please give the unapprove reason?");
			
			return;
		}
		
		ControldocumentDAO controldocumentDAO = new ControldocumentDAO();
		
		boolean status = controldocumentDAO.filereject(googleid);
		
		if(status){
			
			System.out.println("in message insert---------");
			
			messagebean.documentid = Integer.parseInt(documentid);
			messagebean.documentnumber = documentnumber;
			messagebean.documentversion = documentrevision;
			messagebean.messagetype = "R";
			messagebean.message = mseeage;
			messagebean.usercode = usercode;
			
			DocumentMessagesHandler messagehandler = DocumentMessagesHandler.getNewInstance();
			
			messagehandler.insertData(messagebean);
		
			alert("Document No. "+documentnumber+" unapproved");
			
			closewinrejection.detach();
			
			
		}else{
			
			alert("Document is not successfully unapproved");
		}
		
	}
	
	



}
