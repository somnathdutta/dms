package org.sap.birlatyres.core.gen.bean;
import java.sql.Timestamp;
import java.sql.Types;

import org.apache.commons.io.FilenameUtils;

public class ControldocumentBean {
	public int documentid ;
	public String documentnumber ;
	public String documenttype ;
	public String documentname ;
	public String documentversion ;
	public String documenthashkey ;
	public String description ;
	public String controlfilepath ;
	public Timestamp controlfilecreationdate ;
	public Integer controlfilesize ;
	public String synchgoogledrive ;
	public Timestamp googledrivesynchedtime ;
	public String googlefolderpath ;
	public String googledrivefileid ;
	public Integer ownerid ;
	public String isblocked ;
	public String isdeleted ;
	public String ispasswordprotected ;
	public String departmentcode ;
	public String location ;
	public String approvedyn ;
	public Timestamp creationdatetime ;
	public String createdby ;
	public Timestamp modifieddatetime ;
	public Timestamp modifiedby ;
	public String formattedcreationdate ;
	public String documentreason ;
	public String userCode;
	public String message;
	
	
	
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public int  getDocumentid(){
		return this.documentid ; 
	}
	
	public String getControlFileName(){
		
		return FilenameUtils.getName(controlfilepath);
		
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
	public String  getDocumenttype(){
		return this.documenttype ; 
	}
	public void  setDocumenttype(String _documenttype){
		this.documenttype = _documenttype ; 
	}
	public String  getDocumentname(){
		return this.documentname ; 
	}
	public void  setDocumentname(String _documentname){
		this.documentname = _documentname ; 
	}
	public String  getDocumentversion(){
		return this.documentversion ; 
	}
	public void  setDocumentversion(String _documentversion){
		this.documentversion = _documentversion ; 
	}
	public String  getDocumenthashkey(){
		return this.documenthashkey ; 
	}
	public void  setDocumenthashkey(String _documenthashkey){
		this.documenthashkey = _documenthashkey ; 
	}
	public String  getDescription(){
		return this.description ; 
	}
	public void  setDescription(String _description){
		this.description = _description ; 
	}
	public String  getControlfilepath(){
		return this.controlfilepath ; 
	}
	public void  setControlfilepath(String _controlfilepath){
		this.controlfilepath = _controlfilepath ; 
	}
	public Timestamp  getControlfilecreationdate(){
		return this.controlfilecreationdate ; 
	}
	public void  setControlfilecreationdate(Timestamp _controlfilecreationdate){
		this.controlfilecreationdate = _controlfilecreationdate ; 
	}
	public Integer  getControlfilesize(){
		return this.controlfilesize ; 
	}
	public void  setControlfilesize(int _controlfilesize){
		this.controlfilesize = _controlfilesize ; 
	}
	public String  getSynchgoogledrive(){
		return this.synchgoogledrive ; 
	}
	public void  setSynchgoogledrive(String _synchgoogledrive){
		this.synchgoogledrive = _synchgoogledrive ; 
	}
	public Timestamp  getGoogledrivesynchedtime(){
		return this.googledrivesynchedtime ; 
	}
	public void  setGoogledrivesynchedtime(Timestamp _googledrivesynchedtime){
		this.googledrivesynchedtime = _googledrivesynchedtime ; 
	}
	public String  getGooglefolderpath(){
		return this.googlefolderpath ; 
	}
	public void  setGooglefolderpath(String _googlefolderpath){
		this.googlefolderpath = _googlefolderpath ; 
	}
	public String  getGoogledrivefileid(){
		return this.googledrivefileid ; 
	}
	public void  setGoogledrivefileid(String _googledrivefileid){
		this.googledrivefileid = _googledrivefileid ; 
	}
	public Integer  getOwnerid(){
		return this.ownerid ; 
	}
	public void  setOwnerid(int _ownerid){
		this.ownerid = _ownerid ; 
	}
	public String  getIsblocked(){
		return this.isblocked ; 
	}
	public void  setIsblocked(String _isblocked){
		this.isblocked = _isblocked ; 
	}
	public String  getIsdeleted(){
		return this.isdeleted ; 
	}
	public void  setIsdeleted(String _isdeleted){
		this.isdeleted = _isdeleted ; 
	}
	public String  getIspasswordprotected(){
		return this.ispasswordprotected ; 
	}
	public void  setIspasswordprotected(String _ispasswordprotected){
		this.ispasswordprotected = _ispasswordprotected ; 
	}
	public String  getDepartmentcode(){
		return this.departmentcode ; 
	}
	public void  setDepartmentcode(String _departmentcode){
		this.departmentcode = _departmentcode ; 
	}
	public String  getLocation(){
		return this.location ; 
	}
	public void  setLocation(String _location){
		this.location = _location ; 
	}
	public String  getApprovedyn(){
		return this.approvedyn ; 
	}
	public void  setApprovedyn(String _approvedyn){
		this.approvedyn = _approvedyn ; 
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
	public Timestamp  getModifieddatetime(){
		return this.modifieddatetime ; 
	}
	public void  setModifieddatetime(Timestamp _modifieddatetime){
		this.modifieddatetime = _modifieddatetime ; 
	}
	public Timestamp  getModifiedby(){
		return this.modifiedby ; 
	}
	public void  setModifiedby(Timestamp _modifiedby){
		this.modifiedby = _modifiedby ; 
	}

	public String getFormattedcreationdate() {
		return formattedcreationdate;
	}

	public void setFormattedcreationdate(String formattedcreationdate) {
		this.formattedcreationdate = formattedcreationdate;
	}

	public String getDocumentreason() {
		return documentreason;
	}

	public void setDocumentreason(String documentreason) {
		this.documentreason = documentreason;
	}

	public void setControlfilesize(Integer controlfilesize) {
		this.controlfilesize = controlfilesize;
	}

	public void setOwnerid(Integer ownerid) {
		this.ownerid = ownerid;
	}
}
