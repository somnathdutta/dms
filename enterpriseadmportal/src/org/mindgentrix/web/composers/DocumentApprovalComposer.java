package org.mindgentrix.web.composers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.sap.birlatyres.core.gen.bean.ControldocumentBean;
import org.sap.birlatyres.core.gen.dao.ControldocumentDAO;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.Messagebox;

public class DocumentApprovalComposer {

	private ControldocumentDAO controldocumentDAO = new ControldocumentDAO() ;
	
	private List<ControldocumentBean> allDocuments = new ArrayList<ControldocumentBean>();
	
	private ControldocumentBean selectedDocument;
	
	private List<ControldocumentBean> selectedDocuments;

	public ControldocumentBean getSelectedDocument() {
		return selectedDocument;
	}

	public void setSelectedDocument(ControldocumentBean selectedDocument) {
		this.selectedDocument = selectedDocument;
	}

	public List<ControldocumentBean> getSelectedDocuments() {
		return selectedDocuments;
	}

	public void setSelectedDocuments(List<ControldocumentBean> selectedDocuments) {
		this.selectedDocuments = selectedDocuments;
	}

	public List<ControldocumentBean> getAllDocuments() {
		return allDocuments;
	}

	public void setAllDocuments(List<ControldocumentBean> allDocuments) {
		this.allDocuments = allDocuments;
	}

	public DocumentApprovalComposer() {

		loadUnapprovedDocuments() ;		
	}
	
	void loadUnapprovedDocuments() {
		
		try {
			
			allDocuments = controldocumentDAO.findByApprovedynAsList("N");
			
		} catch (Exception e) {
			
			Messagebox.show(" Failed to fetch data due " + e.getMessage());
			
			e.printStackTrace();
			
		}		
		
	}

	@NotifyChange("*")
	@Command
	public void onApproveSelectedDocuments() {

		if (this.selectedDocuments == null) {
			Messagebox.show(" No Documents selected");
			return;
		}

		if (this.selectedDocuments.size() == 0) {
			Messagebox.show(" No Documents selected");
			return;
		}
		
		try {
			controldocumentDAO.updateApproveStatusForDocuments(selectedDocuments);
			
			Messagebox.show("Approved " + selectedDocuments.size() + " documents.");
			
			loadUnapprovedDocuments() ;
			
		} catch (Exception e) {
			
			Messagebox.show("Failed to update datastore.");
			
		}
		
	}

}
