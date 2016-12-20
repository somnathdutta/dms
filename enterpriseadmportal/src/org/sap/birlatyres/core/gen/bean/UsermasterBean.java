package org.sap.birlatyres.core.gen.bean;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.sql.Types;

public class UsermasterBean {
	
	public String usercode ;
	public String usertype ;
	public String username ;
	public String password ;
	public Integer companycode ;
	public String employmentcode ;
	public Integer accesslevel ;
	public String emailid ;
	public String contactmobile ;
	public String contactphone ;
	public String homedir ;
	public String isactive ;
	public String isadmin ;
	public String designation;
	public int rank;
	public String downloadallowed;
	public String printallowed;
	public String uploadallowed;
	public String viewallowed;
	
	public String  getUsercode(){
		return this.usercode ; 
	}
	public void  setUsercode(String _usercode){
		this.usercode = _usercode ; 
	}
	public String  getUsertype(){
		return this.usertype ; 
	}
	public void  setUsertype(String _usertype){
		this.usertype = _usertype ; 
	}
	public String  getUsername(){
		return this.username ; 
	}
	public void  setUsername(String _username){
		this.username = _username ; 
	}
	public String  getPassword(){
		return this.password ; 
	}
	public void  setPassword(String _password){
		this.password = _password ; 
	}
	public Integer  getCompanycode(){
		return this.companycode ; 
	}
	public void  setCompanycode(int _companycode){
		this.companycode = _companycode ; 
	}
	public String  getEmploymentcode(){
		return this.employmentcode ; 
	}
	public void  setEmploymentcode(String _employmentcode){
		this.employmentcode = _employmentcode ; 
	}
	public Integer  getAccesslevel(){
		return this.accesslevel ; 
	}
	public void  setAccesslevel(int _accesslevel){
		this.accesslevel = _accesslevel ; 
	}
	public String  getEmailid(){
		return this.emailid ; 
	}
	public void  setEmailid(String _emailid){
		this.emailid = _emailid ; 
	}
	public String  getContactmobile(){
		return this.contactmobile ; 
	}
	public void  setContactmobile(String _contactmobile){
		this.contactmobile = _contactmobile ; 
	}
	public String  getContactphone(){
		return this.contactphone ; 
	}
	public void  setContactphone(String _contactphone){
		this.contactphone = _contactphone ; 
	}
	public String  getHomedir(){
		return this.homedir ; 
	}
	public void  setHomedir(String _homedir){
		this.homedir = _homedir ; 
	}
	public String  getIsactive(){
		return this.isactive ; 
	}
	public void  setIsactive(String _isactive){
		this.isactive = _isactive ; 
	}
	public String getIsadmin() {
		return isadmin;
	}
	public void setCompanycode(Integer companycode) {
		this.companycode = companycode;
	}
	public void setAccesslevel(Integer accesslevel) {
		this.accesslevel = accesslevel;
	}
	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getDownloadallowed() {
		return downloadallowed;
	}
	public void setDownloadallowed(String downloadallowed) {
		this.downloadallowed = downloadallowed;
	}
	public String getPrintallowed() {
		return printallowed;
	}
	public void setPrintallowed(String printallowed) {
		this.printallowed = printallowed;
	}
	public String getUploadallowed() {
		return uploadallowed;
	}
	public void setUploadallowed(String uploadallowed) {
		this.uploadallowed = uploadallowed;
	}
	public String getViewallowed() {
		return viewallowed;
	}
	public void setViewallowed(String viewallowed) {
		this.viewallowed = viewallowed;
	}
	
	
	
}
