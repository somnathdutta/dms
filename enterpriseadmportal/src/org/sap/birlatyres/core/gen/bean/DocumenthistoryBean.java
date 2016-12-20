package org.sap.birlatyres.core.gen.bean;
import java.sql.Timestamp;
import java.sql.Types;

public class DocumenthistoryBean {
	public int transactionid ;
	public Integer documentid ;
	public String documentnumber ;
	public String documentname ;
	public String operationname ;
	public Timestamp operationdatetime ;
	public Integer documentversionnumber ;
	public String controltargetfilepath ;
	public String operationauthorizedby ;
	public Timestamp creationdatetime ;
	public String createdby ;
	public int  getTransactionid(){
		return this.transactionid ; 
	}
	public void  setTransactionid(int _transactionid){
		this.transactionid = _transactionid ; 
	}
	public Integer  getDocumentid(){
		return this.documentid ; 
	}
	public void  setDocumentid(int _documentid){
		this.documentid = _documentid ; 
	}
	public String  getDocumentnumber(){
		return this.documentnumber ; 
	}
	public void  setDocumentnumber(String _documentnumber){
		this.documentnumber = _documentnumber ; 
	}
	public String  getDocumentname(){
		return this.documentname ; 
	}
	public void  setDocumentname(String _documentname){
		this.documentname = _documentname ; 
	}
	public String  getOperationname(){
		return this.operationname ; 
	}
	public void  setOperationname(String _operationname){
		this.operationname = _operationname ; 
	}
	public Timestamp  getOperationdatetime(){
		return this.operationdatetime ; 
	}
	public void  setOperationdatetime(Timestamp _operationdatetime){
		this.operationdatetime = _operationdatetime ; 
	}
	public Integer  getDocumentversionnumber(){
		return this.documentversionnumber ; 
	}
	public void  setDocumentversionnumber(int _documentversionnumber){
		this.documentversionnumber = _documentversionnumber ; 
	}
	public String  getControltargetfilepath(){
		return this.controltargetfilepath ; 
	}
	public void  setControltargetfilepath(String _controltargetfilepath){
		this.controltargetfilepath = _controltargetfilepath ; 
	}
	public String  getOperationauthorizedby(){
		return this.operationauthorizedby ; 
	}
	public void  setOperationauthorizedby(String _operationauthorizedby){
		this.operationauthorizedby = _operationauthorizedby ; 
	}
	public Timestamp  getCreationdatetime(){
		return this.creationdatetime ; 
	}
	public void  setCreationdatetime(Timestamp _creationdatetime){
		this.creationdatetime = _creationdatetime ; 
	}
	public String  getCreatedby(){
		return this.createdby ; 
	}
	public void  setCreatedby(String _createdby){
		this.createdby = _createdby ; 
	}
}
