package org.sap.birlatyres.core.gen.bean;
import java.sql.Timestamp;
import java.sql.Types;

public class DepartmentmasterBean {
	public String departmentcode ;
	public String companycode ;
	public String departmentname ;
	public String departmenthead ;
	public String functionalarea ;
	public String location ;
	public String  getDepartmentcode(){
		return this.departmentcode ; 
	}
	public void  setDepartmentcode(String _departmentcode){
		this.departmentcode = _departmentcode ; 
	}
	public String  getCompanycode(){
		return this.companycode ; 
	}
	public void  setCompanycode(String _companycode){
		this.companycode = _companycode ; 
	}
	public String  getDepartmentname(){
		return this.departmentname ; 
	}
	public void  setDepartmentname(String _departmentname){
		this.departmentname = _departmentname ; 
	}
	public String  getDepartmenthead(){
		return this.departmenthead ; 
	}
	public void  setDepartmenthead(String _departmenthead){
		this.departmenthead = _departmenthead ; 
	}
	public String  getFunctionalarea(){
		return this.functionalarea ; 
	}
	public void  setFunctionalarea(String _functionalarea){
		this.functionalarea = _functionalarea ; 
	}
	public String  getLocation(){
		return this.location ; 
	}
	public void  setLocation(String _location){
		this.location = _location ; 
	}
}
