package org.mindgentrix.web.listbox.duallistbox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.sap.birlatyres.core.gen.bean.RolemasterBean;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.IdSpace;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

public class RoleDualListbox extends Div implements IdSpace {
	
	private static final long serialVersionUID = 4371804205813998369L;
	@Wire
	private Listbox candidateLb ;	
	@Wire
	private Listbox chosenLb ;	
	private ListModelList<RolemasterBean> primaryModel ;
	private ListModelList<RolemasterBean> candidateModel ;
	private ListModelList<RolemasterBean> chosenDataModel ;
	private ListModelList<RolemasterBean> userSpecificDataModel ; 
	
	public RoleDualListbox() {
		
		Executions.createComponents("/widgets/listbox/dual_listbox/v_roledualListbox.zul", this, null);
		Selectors.wireComponents(this, this, false);
		Selectors.wireEventListeners(this, this) ;
		chosenDataModel = new ListModelList<RolemasterBean>();
		chosenLb.setModel(chosenDataModel);		
		
	}
	
	@Listen("onClick = #chooseBtn")
	public void chooseItem(){
		
		Events.postEvent(new ChooseEvent(this,chooseOne()));
	}
	
	@Listen("onClick = #removeBtn")
	public void unchooseItem(){
		
		System.out.println("Single Remove Button Click!!");
		
		Events.postEvent(new ChooseEvent(this, unchooseOne())); 
		
	}
	
	@Listen("onClick = #chooseAllBtn")
	public void chooseAllItem(){
		
		int candidateModelSize = candidateModel.getSize();
		
		for(int index = 0 ; index < candidateModelSize ; index++){
			
			if(!chosenDataModel.contains(candidateModel.getElementAt(index))){
				
				chosenDataModel.add(candidateModel.getElementAt(index));
			}
				
				 		
		}
		
		candidateModel.clear();
	}
	
	@Listen("onClick = #removeAllBtn")
	public void unchooseAll() {
		
		System.out.println("ALL Remove Button Click!!");
		
		for (int i = 0, j = chosenDataModel.getSize(); i < j; i++) {
			
			if(!candidateModel.contains(chosenDataModel.getElementAt(i))){
				
				candidateModel.add(chosenDataModel.getElementAt(i));
			}
		}
		chosenDataModel.clear();
	}
	
	public void setModel(List<RolemasterBean> candidate){
		
		candidateModel = new ListModelList<RolemasterBean>(candidate);
		
		primaryModel = new ListModelList<RolemasterBean>(candidate);
		
		candidateLb.setModel(candidateModel);
		
		chosenDataModel.clear();
		
	}
	
	void resetModel(){
						
		chosenDataModel.clear();
		
		candidateModel.clear();
		
		Iterator<RolemasterBean> userSpecificDataModelIterator = primaryModel.iterator();
		
		while(userSpecificDataModelIterator.hasNext()){
			
			RolemasterBean selectedItem = userSpecificDataModelIterator.next() ;
			
			candidateModel.add(selectedItem);	
			
		}		
		
	}
	
	public void modifyModel(List<RolemasterBean> userspecificdata){ 
		
		resetModel();
		
		userSpecificDataModel = new ListModelList<RolemasterBean>(userspecificdata);
		
		Iterator<RolemasterBean> userSpecificDataModelIterator = userSpecificDataModel.iterator();
		
		while(userSpecificDataModelIterator.hasNext()){
			
			RolemasterBean selectedItem = userSpecificDataModelIterator.next() ;
			
			if(!chosenDataModel.contains(selectedItem)){ 
				
				chosenDataModel.add(selectedItem);			
			
			}		
			
		}
		
	}
	
	public List<RolemasterBean> getChosenDataList(){
		return new ArrayList<>(chosenDataModel);
	}
	
	
	private Set<RolemasterBean> chooseOne(){
	
		Set<RolemasterBean> dealerSet = candidateModel.getSelection() ;
		
		for(RolemasterBean selectedItem : dealerSet){
			
			if(!chosenDataModel.contains(selectedItem)){ 
				
						
				chosenDataModel.add(selectedItem);
				
				candidateModel.remove(selectedItem);
			
			}	
		}		
		
		return dealerSet ;
		
	}	
	
	private Set<RolemasterBean> unchooseOne(){
		
		Set<RolemasterBean> dealerSet = chosenDataModel.getSelection() ;
		
		System.out.println("Inside UnChooseOne function");
		
		for(RolemasterBean selectedItem : dealerSet){
			
			if(!candidateModel.contains(selectedItem)){
				
				System.out.println("--Inside If Condition in UnChooseOne Function");
				
				candidateModel.add(selectedItem);
				
				chosenDataModel.remove(selectedItem);
								
			}else if(candidateModel.contains(selectedItem)){
				
				System.out.println("--Inside Else Condition in UnChooseOne Function");
				
				//candidateModel.add(selectedItem);
				
				chosenDataModel.remove(selectedItem);
				
			}
			
		}		
		
		return dealerSet ;
		
	}
	
	public class ChooseEvent extends Event {
		
		private static final long serialVersionUID = 7971756123041299125L;

		public ChooseEvent(Component target, Set<RolemasterBean> data) {
			 
			super("onChoose",target,data);
		}		
		
	}
	
	//////////////////////////////////////////////////////////////////
	public Listbox getCandidateLb() {
		return candidateLb;
	}

	public Listbox getChosenLb() {
		return chosenLb;
	}

	public ListModelList<RolemasterBean> getCandidateModel() {
		return candidateModel;
	}

	public ListModelList<RolemasterBean> getChosenDataModel() {
		return chosenDataModel;
	}

	public void setCandidateLb(Listbox candidateLb) {
		this.candidateLb = candidateLb;
	}

	public void setChosenLb(Listbox chosenLb) {
		this.chosenLb = chosenLb;
	}

	public void setCandidateModel(ListModelList<RolemasterBean> candidateModel) {
		this.candidateModel = candidateModel;
	}

	public void setChosenDataModel(ListModelList<RolemasterBean> chosenDataModel) {
		this.chosenDataModel = chosenDataModel;
	}	
	
}