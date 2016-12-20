package org.mindgentrix.web.beans;

import java.io.File;

public class FileBean {
	
	
	private String systemKey ;	
	private String displayName ;	
	private File fileHandle ;
	private String ownerId ;
	private String extension ;
	private boolean locked ;
	private boolean directory ;
	private String lastModifiedDate ;
	private Boolean checked = new Boolean(false);
	
	public String getSystemKey() {
		return systemKey;
	}
	public String getDisplayName() {
		return displayName;
	}
	public File getFileHandle() {
		return fileHandle;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public String getExtension() {
		return extension;
	}
	public boolean isLocked() {
		return locked;
	}
	public boolean isDirectory() {
		return directory;
	}
	public String getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setSystemKey(String systemKey) {
		this.systemKey = systemKey;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public void setFileHandle(File fileHandle) {
		this.fileHandle = fileHandle;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public void setDirectory(boolean directory) {
		this.directory = directory;
	}
	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	public Boolean isChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

}
