package org.sap.birlatyres.core.gen.bean;
import java.sql.Timestamp;
import java.sql.Types;

public class PrivilegeregisterBean {
	public String groupcode ;
	public String usercode ;
	public String isactive ;
	public String  getGroupcode(){
		return this.groupcode ; 
	}
	public void  setGroupcode(String _groupcode){
		this.groupcode = _groupcode ; 
	}
	public String  getUsercode(){
		return this.usercode ; 
	}
	public void  setUsercode(String _usercode){
		this.usercode = _usercode ; 
	}
	public String  getIsactive(){
		return this.isactive ; 
	}
	public void  setIsactive(String _isactive){
		this.isactive = _isactive ; 
	}
}
