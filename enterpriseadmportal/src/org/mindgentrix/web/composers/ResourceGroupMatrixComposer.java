package org.mindgentrix.web.composers;

import java.util.Map;

import org.mindgentrix.web.listbox.duallistbox.RoleDualListbox;
import org.sap.birlatyres.core.gen.bean.RolemasterBean;
import org.sap.birlatyres.core.gen.dao.RolemasterDAO;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

public class ResourceGroupMatrixComposer extends GenericForwardComposer {

	private static final long serialVersionUID = 8243942703081449079L;
	
	Label resourcename ;
	Button btnsetup ;
	
	@Wire
	private RoleDualListbox dualLBox;

	RolemasterDAO rolemaster = new RolemasterDAO() ;

	private String selectedFile; 
	
	private String googleFileId ;
	
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		
		dualLBox.setModel(new ListModelList<RolemasterBean>(rolemaster.getAllRoles()));
		
		Map<String,String> argument = (Map<String, String>) Executions.getCurrent().getArg();
		
		googleFileId = argument.get("GOOGLEFILEID");
		
		resourcename.setValue(googleFileId);
		
	}	
	
	public void onClick$btnsetup(Event event) throws Exception {
		
		Listbox candidateLb = dualLBox.getCandidateLb() ; 
		
		ListModel<RolemasterBean> rolesModel = candidateLb.getListModel();
		
		int dataSize = rolesModel.getSize();
		
		System.out.println("roles size = " + dataSize); 
		
		for(int index = 0 ; index < dataSize ; index++){
			
			RolemasterBean rolemasterBean = rolesModel.getElementAt(index) ;
			
			System.out.println(rolemasterBean.getGroupname()); 
			
		}
		
	}
	
}
