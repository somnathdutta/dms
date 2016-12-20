package org.mindgentrix.web.composers;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Menuitem;

public class AccountingIndexComposer extends GenericForwardComposer {
	
	Menuitem logout;
	
	public void onClick$logout(Event event) {
		
		session.invalidate();
		
		Executions.sendRedirect("/welcome.zul");
		
	}
	

}
