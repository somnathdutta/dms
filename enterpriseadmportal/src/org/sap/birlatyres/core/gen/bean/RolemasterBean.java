package org.sap.birlatyres.core.gen.bean;
import java.sql.Timestamp;
import java.sql.Types;

public class RolemasterBean {
	public String groupcode ;
	public String groupname ;
	public String isactive ;
	public String  getGroupcode(){
		return this.groupcode ; 
	}
	public void  setGroupcode(String _groupcode){
		this.groupcode = _groupcode ; 
	}
	public String  getGroupname(){
		return this.groupname ; 
	}
	public void  setGroupname(String _groupname){
		this.groupname = _groupname ; 
	}
	public String  getIsactive(){
		return this.isactive ; 
	}
	public void  setIsactive(String _isactive){
		this.isactive = _isactive ; 
	}

	public boolean equals(Object obj) {

		RolemasterBean nextBean = (RolemasterBean) obj ;
		
		if(this.groupcode.equals(nextBean.groupcode)){
			
			return true ;
			
		}else{
			
			return false ;
			
		}
		
	}
	
}
