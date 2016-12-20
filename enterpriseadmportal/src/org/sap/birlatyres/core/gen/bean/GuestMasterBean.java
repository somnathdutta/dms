package org.sap.birlatyres.core.gen.bean;

import java.sql.Timestamp;
import java.util.Date;

public class GuestMasterBean {
	
	private String guestusername;
	private String guestpassword;
	private String guestcode;
	private String guestponeno;
	private String isactive;
	private Date startdate;
	private Date enddate;
	private String allowview;
	private String allowdownload;
	private String allowprint;
	private String allowupload;
	
	
	public String getGuestusername() {
		return guestusername;
	}
	public void setGuestusername(String guestusername) {
		this.guestusername = guestusername;
	}
	public String getGuestpassword() {
		return guestpassword;
	}
	public void setGuestpassword(String guestpassword) {
		this.guestpassword = guestpassword;
	}
	public String getGuestcode() {
		return guestcode;
	}
	public void setGuestcode(String guestcode) {
		this.guestcode = guestcode;
	}
	public String getGuestponeno() {
		return guestponeno;
	}
	public void setGuestponeno(String guestponeno) {
		this.guestponeno = guestponeno;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	
	public String getAllowview() {
		return allowview;
	}
	public void setAllowview(String allowview) {
		this.allowview = allowview;
	}
	public String getAllowdownload() {
		return allowdownload;
	}
	public void setAllowdownload(String allowdownload) {
		this.allowdownload = allowdownload;
	}
	public String getAllowprint() {
		return allowprint;
	}
	public void setAllowprint(String allowprint) {
		this.allowprint = allowprint;
	}
	public String getAllowupload() {
		return allowupload;
	}
	public void setAllowupload(String allowupload) {
		this.allowupload = allowupload;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}


}
