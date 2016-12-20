package org.sap.birlatyres.core.gen.bean;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.sql.Types;

public class ShareregisterBean {
	public int documentid ;
	public String publicaccess ;
	public String groupcode ;
	public String sharedescription ;
	public String synchgoogledriveshare ;
	public Timestamp googlesyncheddate ;
	public String controlfilepath ;
	public String isreadallowed ;
	public String isdownloadallowed ;
	public String isprintallowed ;
	public Timestamp sharestartdate ;
	public Timestamp shareenddate ;
	public Timestamp creationdate ;
	public String createdby ;
	public Timestamp modifieddate ;
	public String modifiedby ;
	public int  getDocumentid(){
		return this.documentid ; 
	}
	public void  setDocumentid(int _documentid){
		this.documentid = _documentid ; 
	}
	public String  getPublicaccess(){
		return this.publicaccess ; 
	}
	public void  setPublicaccess(String _publicaccess){
		this.publicaccess = _publicaccess ; 
	}
	public String  getGroupcode(){
		return this.groupcode ; 
	}
	public void  setGroupcode(String _groupcode){
		this.groupcode = _groupcode ; 
	}
	public String  getSharedescription(){
		return this.sharedescription ; 
	}
	public void  setSharedescription(String _sharedescription){
		this.sharedescription = _sharedescription ; 
	}
	public String  getSynchgoogledriveshare(){
		return this.synchgoogledriveshare ; 
	}
	public void  setSynchgoogledriveshare(String _synchgoogledriveshare){
		this.synchgoogledriveshare = _synchgoogledriveshare ; 
	}
	public Timestamp  getGooglesyncheddate(){
		return this.googlesyncheddate ; 
	}
	public void  setGooglesyncheddate(Timestamp _googlesyncheddate){
		this.googlesyncheddate = _googlesyncheddate ; 
	}
	public String  getControlfilepath(){
		return this.controlfilepath ; 
	}
	public void  setControlfilepath(String _controlfilepath){
		this.controlfilepath = _controlfilepath ; 
	}
	public String  getIsreadallowed(){
		return this.isreadallowed ; 
	}
	public void  setIsreadallowed(String _isreadallowed){
		this.isreadallowed = _isreadallowed ; 
	}
	public String  getIsdownloadallowed(){
		return this.isdownloadallowed ; 
	}
	public void  setIsdownloadallowed(String _isdownloadallowed){
		this.isdownloadallowed = _isdownloadallowed ; 
	}
	public String  getIsprintallowed(){
		return this.isprintallowed ; 
	}
	public void  setIsprintallowed(String _isprintallowed){
		this.isprintallowed = _isprintallowed ; 
	}
	public Timestamp  getSharestartdate(){
		return this.sharestartdate ; 
	}
	public void  setSharestartdate(Timestamp _sharestartdate){
		this.sharestartdate = _sharestartdate ; 
	}
	public Timestamp  getShareenddate(){
		return this.shareenddate ; 
	}
	public void  setShareenddate(Timestamp _shareenddate){
		this.shareenddate = _shareenddate ; 
	}
	public Timestamp  getCreationdate(){
		return this.creationdate ; 
	}
	public void  setCreationdate(Timestamp _creationdate){
		this.creationdate = _creationdate ; 
	}
	public String  getCreatedby(){
		return this.createdby ; 
	}
	public void  setCreatedby(String _createdby){
		this.createdby = _createdby ; 
	}
	public Timestamp  getModifieddate(){
		return this.modifieddate ; 
	}
	public void  setModifieddate(Timestamp _modifieddate){
		this.modifieddate = _modifieddate ; 
	}
	public String  getModifiedby(){
		return this.modifiedby ; 
	}
	public void  setModifiedby(String _modifiedby){
		this.modifiedby = _modifiedby ; 
	}
}
