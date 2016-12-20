package org.mindgentrix.web.listbox.duallistbox;

import org.sap.birlatyres.core.gen.bean.RolemasterBean;
import org.sap.birlatyres.core.gen.dao.RolemasterDAO;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.ListModelList;

public class RoleDualComposer extends GenericForwardComposer<Component> { 
	
	private static final long serialVersionUID = 8243942703081449079L;
	
	@Wire
	private RoleDualListbox dualLBox;

	RolemasterDAO rolemaster = new RolemasterDAO() ;
	
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		
		dualLBox.setModel(new ListModelList<RolemasterBean>(rolemaster.getAllRoles()));
		
	}
}
