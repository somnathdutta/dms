package org.mindgentrix.web.composers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.mindgentrix.core.createpdf.PDFPasswordProtector;
import org.mindgentrix.encryption.DocumentDecryptor;
import org.mindgentrix.encryption.DocumentEncryptor;
import org.mindgentrix.web.beans.FileBean;
import org.mindgentrix.web.googledrive.GoogleDriveHandler;
import org.sap.birlatyres.core.gen.bean.ApplicationBean;
import org.sap.birlatyres.core.gen.bean.ControldocumentBean;
import org.sap.birlatyres.core.gen.bean.UsermasterBean;
import org.sap.birlatyres.core.gen.dao.ApplicationDAO;
import org.sap.birlatyres.core.gen.dao.ControldocumentDAO;
import org.zkoss.io.Files;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.metainfo.ComponentInfo;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Menu;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Panel;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Toolbarbutton;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treechildren;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Treerow;
import org.zkoss.zul.Window;

import com.google.api.client.util.IOUtils;


public class ResourceIndexUserComposer extends GenericForwardComposer {

	
    Menuitem mpDiropOpen;
 
    Menuitem mpDiropShare;
    Menuitem mpDiropAddTask;
    
    Menuitem mpDiropCreateSubFolder;
            
    Menuitem mpDiropMove;
    Menuitem mpDiropCopy;
    Menuitem mpDiropRename;
    Menuitem mpDiropTrash;
    Menuitem mpDiropDownload;
    Menuitem mpDiropProperties;
    ////////////////////////////////////////
    Menuitem mpfileopOpen;
    
    Menuitem mpfileopShare ;
    Menuitem mpfileopAddTask;
    Menuitem mpfileopSendMail;
            
    Menuitem mpfileopMove;
    Menuitem mpfileopCopy;
    Menuitem mpfileopRename;
    Menuitem mpfileopTrash;
    Menuitem mpfileopDownload;
    Menuitem mpfileopProperties;
                               
	///////////////////////////////////////
    
    Menuitem gdmpfileopOpen ;
        
	Menuitem gdmpfileopShare ;
	Menuitem gdmpfileopGroupShare ;
	Menuitem gdmpfileopGoogleShare ;
		
    Menuitem gdmpfileopAddTask ;
    Menuitem gdmpfileopSendMail ;
            
    Menuitem gdmpfileopMove ;
    Menuitem gdmpfileopCopy ;
    Menuitem gdmpfileopRename ;
    Menuitem gdmpfileopTrash ;
    Menuitem gdmpfileopDownload ;
    Menuitem gdmpfileopProperties ;
     
    Menuitem gdmpfileopCheckOut ;
    Menuitem gdmpfileopRevisions;
    Menuitem gdmpfileopAddTag ;
    Menuitem gdmpfileopComments ;
    
    /////////////////////////////////////
    Menuitem departmentmenu;
	Menuitem usersetupmenu;
	
	Menuitem deletedepartments;
	Menuitem deleteusers;
	
	Menuitem undeletedepartments;
	Menuitem undeleteusers;
	
	Menuitem creategoogledocument;
	
	Menuitem synchronize;
	
	Menu transactionuploaddocument;
	
    //////////////////////////////////////
    Menuitem logout ;
    
    /////////////////////////////////////
	Tree fileBrowserTree ;
	Treechildren treechildren$root ;
	Panel workingpanel;
	Fileupload fileupload ;
	//Button btncreatedocument;
	//Button btnrefresh ;
	Label googlefileref ;
	
	
	Iframe fileframeforuser;
	
	private String currentWorkingDirPath = "" ;	 
	private String workingDirectory ;
	private String homeDirPath; 
	private String displayTitle ;
	private File selectedFile ;
	
	private String googleFileId = "" ;
	
	private Listbox drivedatagrid,datagrid, datagridprod, datagridqad, datagridmaint, datagridpur ;
	
	Listbox searchdatalistbox;
	
	Bandbox searchbox ;
	
	Datebox searchdatefrom ;
	
	Datebox searchdateto ;
	
	Textbox version ;
	
	Textbox documentno ;
	
	Textbox documentname ;

	Textbox documenttype ;
	
	Textbox departmentno ;
	
	Button btnsearch ;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
	
	private Map<String, Component> componentRegister = new Hashtable<String, Component>();
	
	private UsermasterBean usermasterBean ;
		
	private ApplicationDAO applicationDAO = new ApplicationDAO();
	
	private ApplicationBean applicationBean = null ;
	
	private ControldocumentDAO controldocumentDAO = null ;
	
	private GoogleDriveHandler googleDriveHandler ;

	private ControldocumentBean controldocumentBean$instance;
	
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		
		usermasterBean = (UsermasterBean) session.getAttribute("USERBEAN");
	
		if(usermasterBean == null){
			
			Executions.sendRedirect("/welcome.zul");
									
		}else{
			
			if(usermasterBean.getUploadallowed().equalsIgnoreCase("Y")){
				
				transactionuploaddocument.setVisible(true);
				
			}else{
				
				transactionuploaddocument.setVisible(false);
				
			}
		
			googleDriveHandler = GoogleDriveHandler.getInstance();
			
			applicationBean = (ApplicationBean) session.getAttribute("APPLICATIONBEAN");
			
			controldocumentDAO = new ControldocumentDAO() ;
			
			workingDirectory = applicationBean.getGooglerepositorypath() ;
			
			homeDirPath = workingDirectory + usermasterBean.getHomedir();
				
			System.out.println(homeDirPath);
			
			/////createContextualView(homeDirPath);
			
			loadGroupWiseDocuments() ;
			
			loadDriveDocuments();
			
			currentWorkingDirPath = workingDirectory ;
			
			workingpanel.setTitle("Path :" + usermasterBean.getHomedir());
			
		}
				
	}

	public ComponentInfo doBeforeCompose(Page page, Component parent,ComponentInfo compInfo) {
		
		return super.doBeforeCompose(page, parent, compInfo);
		
	}
	
	public void loadDriveDocuments() throws Exception {
		
		String usercode = usermasterBean.usercode ;
		
		ControldocumentBean[] groupDocList = controldocumentDAO.findDocumentsByRoles(usercode,true);
				
		drivedatagrid.setModel(new ListModelList<ControldocumentBean>(groupDocList));		
		drivedatagrid.setItemRenderer(new ListitemRenderer<ControldocumentBean>() {
			@Override
			public void render(Listitem listitem, final ControldocumentBean data,int index) throws Exception {
				listitem.setValue(data);
				
				addListcellCB(listitem, "");
				addListcell(listitem, data.documentnumber);
				addListcell(listitem, data.documentname);
				addListcell(listitem, data.documentversion);
				addListcell(listitem, data.documenttype);
				addListcell(listitem, data.controlfilecreationdate.toString());
				addListcell(listitem, data.departmentcode);
				/*addListcell(listitem, data.approvedyn);*/
				
				listitem.addEventListener("onClick", new EventListener<Event>() {					
					public void onEvent(Event arg0) throws Exception {						
						System.out.println("onClick"); 						
						handleGroupListEvent(data,"*");					}
				});
				
				
				listitem.addEventListener("onDoubleClick", new EventListener<Event>() {
					
					public void onEvent(Event arg0) throws Exception {						
						System.out.println("Double Click.."); 						
						openFile();					
						}
				});
			}
			private void addListcellCB(Listitem listitem, String value) {
				Listcell lc = new Listcell();
				Checkbox chk = new Checkbox();
				chk.setParent(lc);
				lc.setParent(listitem);
				
			}
			private void addListcell(Listitem listitem, String value) {
				Listcell lc = new Listcell();
				Label lb = new Label(value);
				lb.setParent(lc);
				lc.setParent(listitem);
				lc.setContext("gdfileOperationsPopup");
			}
		});		
		
	}
	
	public void loadGroupWiseDocuments() throws Exception {
		
		ControldocumentBean[] prodDocList = controldocumentDAO.findByDepartmentcode("PROD");		
		datagridprod.setModel(new ListModelList<ControldocumentBean>(prodDocList));		
		datagridprod.setItemRenderer(new ListitemRenderer<ControldocumentBean>() {
			@Override
			public void render(Listitem listitem, final ControldocumentBean data,int index) throws Exception {
				listitem.setValue(data);							
				addListcell(listitem, data.documentnumber);
				addListcell(listitem, data.documentname);
				addListcell(listitem, data.getControlFileName());				
				
				listitem.addEventListener("onClick", new EventListener<Event>() {					
					public void onEvent(Event arg0) throws Exception {						
						System.out.println("onClick"); 						
						handleGroupListEvent(data,"PROD");					}
				});
			}
			private void addListcell(Listitem listitem, String value) {
				Listcell lc = new Listcell();
				Label lb = new Label(value);
				lb.setParent(lc);
				lc.setParent(listitem);
				lc.setContext("gdfileOperationsPopup");
			}
		});
		/////////////////////////////////////////////////////////////////////
		ControldocumentBean[] qadDocList = controldocumentDAO.findByDepartmentcode("QAD");
		datagridqad.setModel(new ListModelList<ControldocumentBean>(qadDocList));		
		datagridqad.setItemRenderer(new ListitemRenderer<ControldocumentBean>() {
			@Override
			public void render(Listitem listitem, final ControldocumentBean data,int index) throws Exception {
				listitem.setValue(data);							
				addListcell(listitem, data.documentnumber);
				addListcell(listitem, data.documentname);
				addListcell(listitem, data.getControlFileName());				
				
				listitem.addEventListener("onClick", new EventListener<Event>() {					
					public void onEvent(Event arg0) throws Exception {						
						System.out.println("onClick"); 						
						handleGroupListEvent(data,"QAD");					}
				});
			}
			private void addListcell(Listitem listitem, String value) {
				Listcell lc = new Listcell();
				Label lb = new Label(value);
				lb.setParent(lc);
				lc.setParent(listitem);
				lc.setContext("gdfileOperationsPopup");
			}
		});
		/////////////////////////////////////////////////////////////////////
		ControldocumentBean[] maintDocList = controldocumentDAO.findByDepartmentcode("MAINT");
		datagridmaint.setModel(new ListModelList<ControldocumentBean>(maintDocList));		
		datagridmaint.setItemRenderer(new ListitemRenderer<ControldocumentBean>() {
			@Override
			public void render(Listitem listitem, final ControldocumentBean data,int index) throws Exception {
				listitem.setValue(data);							
				addListcell(listitem, data.documentnumber);
				addListcell(listitem, data.documentname);
				addListcell(listitem, data.getControlFileName());				
				
				listitem.addEventListener("onClick", new EventListener<Event>() {					
					public void onEvent(Event arg0) throws Exception {						
						System.out.println("onClick"); 						
						handleGroupListEvent(data,"MAINT");					}
				});
			}
			private void addListcell(Listitem listitem, String value) {
				Listcell lc = new Listcell();
				Label lb = new Label(value);
				lb.setParent(lc);
				lc.setParent(listitem);
				lc.setContext("gdfileOperationsPopup");
			}
		});
		/////////////////////////////////////////////////////////////////////
		ControldocumentBean[] purDocList = controldocumentDAO.findByDepartmentcode("PUR");
		datagridpur.setModel(new ListModelList<ControldocumentBean>(purDocList));		
		datagridpur.setItemRenderer(new ListitemRenderer<ControldocumentBean>() {
			@Override
			public void render(Listitem listitem, final ControldocumentBean data,int index) throws Exception {
				listitem.setValue(data);							
				addListcell(listitem, data.documentnumber);
				addListcell(listitem, data.documentname);
				addListcell(listitem, data.getControlFileName());				
				
				listitem.addEventListener("onClick", new EventListener<Event>() {					
					public void onEvent(Event arg0) throws Exception {						
						System.out.println("onClick"); 						
						handleGroupListEvent(data,"PUR");					}
				});
			}
			private void addListcell(Listitem listitem, String value) {
				Listcell lc = new Listcell();
				Label lb = new Label(value);
				lb.setParent(lc);
				lc.setParent(listitem);
				lc.setContext("gdfileOperationsPopup");
			}
		});
		//////////////////////////////////////////////////////////////////////
	}	
	
	public void createContextualView(String startDirPath) throws Exception {
		
		File currentDir = new File(startDirPath);
		
		treechildren$root = new Treechildren();
		
		Treeitem treeitem$root = new Treeitem() ;
		
		Treerow treerow$root = new Treerow();
		
		Treecell treecell$root = new Treecell();
		
		Toolbarbutton toolbarbutton$root = new Toolbarbutton("Folders");
		
		treecell$root.appendChild(toolbarbutton$root);
		
		treerow$root.appendChild(treecell$root);
		
		treeitem$root.appendChild(treerow$root);
		
		Treechildren treechildren$parent = new Treechildren();
		
		createDirectoryWiseTree(currentDir,treechildren$parent);
		
		treeitem$root.appendChild(treechildren$parent);
		
		treechildren$root.appendChild(treeitem$root);
		
		fileBrowserTree.appendChild(treechildren$root);
		
	}
	
	public void createDirectoryWiseTree(File currentDir, final Treechildren treechildren$parent) throws Exception { 
		
		componentRegister.put(currentDir.getAbsolutePath(), treechildren$parent);
		
		File[] currentDirChildren = currentDir.listFiles();
		
		for(File fileChild : currentDirChildren){
			
			final File ffileChild = fileChild;
			
			if(fileChild.isDirectory()){
				
				final String dirName = FilenameUtils.getName(fileChild.getAbsolutePath());
				
				Treeitem treeitem$level = new Treeitem() ;
				
				Treerow treerow$level = new Treerow();
				
				Treecell treecell$level = new Treecell();
				
				Toolbarbutton toolbarbutton$level = new Toolbarbutton(dirName);
				
				toolbarbutton$level.setContext("dirOperationsPopup");
				
				toolbarbutton$level.addEventListener("onClick", new EventListener<Event>() {

					@Override
					public void onEvent(Event arg0) throws Exception {
						
						handleTreeEvent(ffileChild,true);
						
					}
				});
				
				treecell$level.appendChild(toolbarbutton$level); 
				
				treerow$level.appendChild(treecell$level);
				
				treeitem$level.appendChild(treerow$level);
				
				Treechildren treechildren$nextlevel = new Treechildren();
				
				createDirectoryWiseTree(fileChild,treechildren$nextlevel);
				
				treeitem$level.appendChild(treechildren$nextlevel);
				
				treechildren$parent.appendChild(treeitem$level);
				
			}else {
				
				final String fileName = FilenameUtils.getName(fileChild.getAbsolutePath()); 
				
				Treeitem treeitem$level = new Treeitem() ;
				
				Treerow treerow$level = new Treerow();
				
				Treecell treecell$level = new Treecell();
				
				Toolbarbutton toolbarbutton$level = new Toolbarbutton(fileName);
				
				toolbarbutton$level.setContext("fileOperationsPopup");
				
				toolbarbutton$level.setImage("/views/images/pdf.png");
				
				toolbarbutton$level.addEventListener("onClick", new EventListener<Event>() {

					@Override
					public void onEvent(Event arg0) throws Exception {
						
						handleTreeEvent(ffileChild,false);
						
					}
				});
				
				treecell$level.appendChild(toolbarbutton$level); 
				
				treerow$level.appendChild(treecell$level);
				
				treeitem$level.appendChild(treerow$level);
				
				treechildren$parent.appendChild(treeitem$level);
				
			}
			
		}	
		
	}
	
	public void handleGroupListEvent(ControldocumentBean controldocumentBean,String groupName) throws Exception { 
	
		controldocumentBean$instance = controldocumentBean ; 
		
		googleFileId = controldocumentBean.getGoogledrivefileid() ;
		
		System.out.println("googleFileId = "+googleFileId);
		
		googlefileref.setValue(controldocumentBean.getControlFileName());
				
		//showControlFileFromLocalDrive(controldocumentBean);
	}
	
	
	public void showControlFileFromLocalDrive(ControldocumentBean controldocumentBean$instance) throws Exception {
		
		String randomString = RandomStringUtils.randomAlphabetic(10); 
				
		String googleFileId = controldocumentBean$instance.googledrivefileid;
		
		String selectedfilename = controldocumentBean$instance.getControlfilepath();
		
		String extentionName = new FilenameUtils().getExtension(selectedfilename);
		
		DocumentDecryptor documentEncryptor = DocumentDecryptor.getInstance(applicationBean.getGooglerepositorypath());
		
		File decryptedFile = documentEncryptor.retrieveDocumentForUser("admin", googleFileId, extentionName); 
		
		String webDir = desktop.getWebApp().getRealPath("/");
		
		String tempFileName = webDir + "\\repository\\" + randomString + "." + extentionName ;
		
		/*FileOutputStream tempOutFileOutputStream = new FileOutputStream(tempFileName) ; 
				
		InputStream localDriveStream = null ; 
		
		try{
		
			localDriveStream = new FileInputStream(decryptedFile); 
			
			IOUtils.copy(localDriveStream, tempOutFileOutputStream, true);			
			
			fileframeforuser.setSrc("/customviewer/web/viewer.html?file=/enterpriseadmportal/repository/" + randomString + "." + extentionName);
			
		}catch(Exception e){
			
			e.printStackTrace() ;
			
			throw new Exception("Failed to fetch the file from Drive.");
			
		}finally{
			
			if(tempOutFileOutputStream != null){
				
				tempOutFileOutputStream.close() ;
				
			}
			
			if(localDriveStream != null){
				
				localDriveStream.close() ;
				
			}
			
		}*/
		
	}
	
	public void handleListEvent(FileBean fileBean) throws Exception { 
		
		File refFile = fileBean.getFileHandle() ;
		
		boolean directory = fileBean.isDirectory() ;
		
		if(directory){
			
			currentWorkingDirPath = systemWiseDirTerminator(refFile.getAbsolutePath()) ;
			displayTitle = refFile.getName() + " - " + currentWorkingDirPath.replace(workingDirectory, "$") ;						
		}else{
			currentWorkingDirPath = systemWiseDirTerminator(refFile.getParentFile().getAbsolutePath()) ;
			displayTitle = refFile.getName() + " - " + currentWorkingDirPath.replace(workingDirectory, "$") ;			
		}		
		
		selectedFile = refFile ;
		
		workingpanel.setTitle("Folders:" + displayTitle); 
		
		populateFilesForDirectory() ;
				
	}
	
	public void handleTreeEvent(File refFile ,boolean directory) throws Exception { 
		
		if(directory){
			
			currentWorkingDirPath = systemWiseDirTerminator(refFile.getAbsolutePath()) ;
			displayTitle = refFile.getName() + " - " + currentWorkingDirPath.replace(workingDirectory, "$") ;						
		}else{
			currentWorkingDirPath = systemWiseDirTerminator(refFile.getParentFile().getAbsolutePath()) ;
			displayTitle = refFile.getName() + " - " + currentWorkingDirPath.replace(workingDirectory, "$") ;			
		}		
		
		selectedFile = refFile ;
		
		workingpanel.setTitle("Path : " + displayTitle); 
		
		populateFilesForDirectory() ;
				
	}
	
	String systemWiseDirTerminator(String dirPath) {
		
		if(!dirPath.endsWith("\\")){
		
			dirPath = dirPath + "\\" ;
			
		}
		
		return dirPath ;
	}
	
	public void populateFilesForDirectory() throws Exception {
		
		ArrayList<FileBean> filesList = new ArrayList<FileBean>();
		
		File[] children = new File(currentWorkingDirPath).listFiles();
		
		for(File childFile : children){
			
			long lastModifiedTime = childFile.lastModified();
			
			String dateModifiedInStringFormat = sdf.format(new Date(lastModifiedTime));
			
			boolean directory = childFile.isDirectory();
			
			FileBean fileBean = new FileBean();
			
			fileBean.setDisplayName(childFile.getName());
			
			fileBean.setDirectory(directory);
			
			fileBean.setLastModifiedDate(dateModifiedInStringFormat);
			
			fileBean.setFileHandle(childFile);
			
			filesList.add(fileBean);
			
		}	
		
		datagrid.setModel(new ListModelList(filesList));

		datagrid.setItemRenderer(new ListitemRenderer<FileBean>() {

			@Override
			public void render(Listitem listitem, final FileBean data,int index) throws Exception {

				listitem.setValue(data);
						
				
				addListcellCB(listitem, "");
				addListcell(listitem, "");
				addListcell(listitem, "");
				addListcell(listitem, data.getDisplayName());
				addListcell(listitem, data.getLastModifiedDate());
				addListcell(listitem, "");
				
				listitem.addEventListener("onClick", new EventListener<Event>() {
					
					public void onEvent(Event arg0) throws Exception {
						
						System.out.println("onClick"); 
						
						handleListEvent(data);
					}
				});
			}

			private void addListcellCB(Listitem listitem, String value) {
				Listcell lc = new Listcell();
				Checkbox chk = new Checkbox();
				chk.setParent(lc);
				lc.setParent(listitem);
				
			}
			private void addListcell(Listitem listitem, String value) {
				Listcell lc = new Listcell();
				Label lb = new Label(value);
				lb.setParent(lc);
				lc.setParent(listitem);
				
				lc.setContext("fileOperationsPopup");
				
			}		
			
		});
		
		
	}	
	
	void initializeHome() throws Exception {
		
		File homeDir = new File(homeDirPath + "\\home\\");
		
		if(!homeDir.exists()){
			
			homeDir.mkdirs();
			
		}
		
	}
	
	public void reload() throws Exception{ 
		
		fileBrowserTree.removeChild(treechildren$root);
	 	
		createContextualView(homeDirPath);
		
		loadGroupWiseDocuments() ;
		
		loadDriveDocuments();
		
	}
	
	/**Field Level events below this line*/
	
	public void onClick$btncreatedocument(Event event) throws Exception {
		
		if(currentWorkingDirPath.equals("")){
			
			alert("Please select the directory to upload to...");
			
			return ;
			
		}
		
		Map<String, String> fileParameters = new Hashtable<String,String>();
		
		fileParameters.put("SELECTEDDIR", currentWorkingDirPath);
		
		Window win = (Window) Executions.createComponents("documentcreator.zul", null, fileParameters);
		
		win.doModal();
			
	}
	
	/*public void onClick$btnrefresh(Event event) throws Exception {
		
		reload() ;
		
		loadGroupWiseDocuments() ;
		
	}*/
	
	public void onUpload$fileupload(UploadEvent event) {
		
		System.out.println("onUpload event");
		
		String eventName = event.getName();
		
		Media media = event.getMedia();
		
		String mediaName = media.getName() ;
		
		System.out.println("eventName = " + eventName + "\tmediaName = " + mediaName);
		
		System.out.println("currentWorkingDirPath = " + currentWorkingDirPath); 
		
		System.out.println("mediaName = " + mediaName);
		
		File destinationFile = new File(currentWorkingDirPath + mediaName) ; 
		
		try {
			
			FileUtils.writeByteArrayToFile(destinationFile, media.getByteData());
			
			Messagebox.show("File uploaded successfully");
			
			reload() ;
			
		} catch (Exception e) {
			
			e.printStackTrace() ;
			
			Messagebox.show("Upload Operation Failed due to " + e.getMessage());
			
		}
		
	}
	
	public void onClick$mpDiropOpen(Event event) {
		
		alert("onClick$mpDiropOpen");
		
	}
	 
	public void onClick$mpDiropShare(Event event) {
		
		alert("onClick$mpDiropShare");
		
	}
	public void onClick$mpDiropAddTask(Event event) {
		
		alert("onClick$mpDiropAddTask");
		
	}
    
	public void onClick$mpDiropCreateSubFolder(Event event) throws Exception { 
		
		Window win = (Window) Executions.createComponents("createsubfolder.zul", null, null);
		
		win.doModal();
		
		reload() ;
		
	}
            
	public void onClick$mpDiropMove(Event event) {
		
		alert("onClick$mpDiropMove");
		
	}
	public void onClick$mpDiropCopy(Event event) {
		
		alert("onClick$mpDiropCopy");
		
	}
	public void onClick$mpDiropRename(Event event) {
		
		alert("onClick$mpDiropRename");
		
	}
	public void onClick$mpDiropTrash(Event event) {
		
		alert("onClick$mpDiropTrash");
		
	}
	public void onClick$mpDiropDownload(Event event) {
		
		alert("onClick$mpDiropDownload");
		
	}
	public void onClick$mpDiropProperties(Event event) {
		
		alert("onClick$mpDiropProperties");
		
	}
    
	public void onClick$mpfileopOpen(Event event) {
		
		if(selectedFile.equals("")){
			
			alert("Please select the file to view");
			
			return ;
			
		}
		
		Map<String, String> fileParameters = new Hashtable<String,String>();
		
		fileParameters.put("SELECTEDFILE", selectedFile.getAbsolutePath());
		
		fileParameters.put("DELETEAFTERSHOW", "false");	
		
		Window win = (Window) Executions.createComponents("fileviewer.zul", null, fileParameters);
		
		win.doModal();
		
	}
    
	public void onClick$mpfileopShare(Event event) {
		
		if(selectedFile.equals("")){
			
			alert("Please select the file to share");
			
			return ;
			
		}
		
		Map<String, String> fileParameters = new Hashtable<String,String>();
		
		fileParameters.put("SELECTEDFILE", selectedFile.getAbsolutePath());
		
		Window win = (Window) Executions.createComponents("resourcegroupmatrix.zul", null, fileParameters);
		
		win.doModal();
		
	}
	
	public void onClick$mpfileopAddTask(Event event) {
		
		alert("onClick$mpfileopAddTask");
		
	}
	public void onClick$mpfileopSendMail(Event event) {
		
		alert("onClick$mpfileopSendMail");
		
	}
            
	public void onClick$mpfileopMove(Event event) {
		
		alert("onClick$mpfileopMove");
		
	}
	public void onClick$mpfileopCopy(Event event) {
		
		alert("onClick$mpfileopCopy");
		
	}
	public void onClick$mpfileopRename(Event event) {
		
		alert("onClick$mpfileopRename");
		
	}
	public void onClick$mpfileopTrash(Event event) {
		
		if(selectedFile.equals("")){
			
			alert("Please select the file to delete");
			
			return ;
			
		}
		
		try {
			Messagebox.show("This will physically delete the file. Are you sure ?", "Confirm Dialog", 
					Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, 
					new org.zkoss.zk.ui.event.EventListener() {
					    public void onEvent(Event evt) throws Exception {
					        if (evt.getName().equals("onOK")) {    	
					        	
					        	FileUtils.forceDelete(selectedFile) ;
					           
					        	alert("File Deleted");
					        } 
					    }
					}
			);
		} catch (Exception e) {
			
			alert("Operation failed due to " + e.getMessage());
			
			e.printStackTrace();
		}
		
		
	}
	public void onClick$mpfileopDownload(Event event) {
		
		alert("onClick$mpfileopTrash");
		
	}
	public void onClick$mpfileopProperties(Event event) {
		
		alert("onClick$mpfileopProperties");
		
	}
     
	/////////////////////////////////////////////////////////////
	public void onClick$gdmpfileopOpen(Event event) throws Exception {
		
		if(googleFileId.equals("")){
			
			alert("Please select the file to view");
			
			return ;
			
		}
		
		/*String selectedfilename = controldocumentBean$instance.getControlfilepath();
		
		String extentionName = new FilenameUtils().getExtension(selectedfilename);
		
		String randomString = RandomStringUtils.randomAlphabetic(10);
		
		DocumentDecryptor documentEncryptor = DocumentDecryptor.getInstance(applicationBean.getGooglerepositorypath());
		
		File tempFile = documentEncryptor.retrieveDocumentForUser("admin", googleFileId, extentionName);
		
		String tempFileName = tempFile.getAbsolutePath();
			
		Map<String, String> fileParameters = new Hashtable<String,String>();
		
		fileParameters.put("GOOGLEFILEPATH", tempFileName);
		fileParameters.put("FILEEXTENSION", extentionName);		
		
		Window win = (Window) Executions.createComponents("googlefileviewer.zul", null, fileParameters);
		
		win.doModal();*/

		openFile();
		
	}
    
	public void onClick$gdmpfileopShare(Event event) {
		
		if(googleFileId.equals("")){
			
			alert("Please select the file to view");
			
			return ;
			
		}
		
		Map<String, Object> fileParameters = new Hashtable<String,Object>();
						
		fileParameters.put("USERBEAN", usermasterBean);
		
		fileParameters.put("CONTROLBEAN", controldocumentBean$instance);
		
		Window win = (Window) Executions.createComponents("sharemapper.zul", null, fileParameters);
		
		win.doModal();
		
	}
	
	public void onClick$gdmpfileopGroupShare(Event event) {
		
		if(googleFileId.equals("")){
			
			alert("Please select the file to view");
			
			return ;
			
		}
		
		Map<String, String> fileParameters = new Hashtable<String,String>();
		
		fileParameters.put("GOOGLEFILEID",googleFileId);
		
		Window win = (Window) Executions.createComponents("resourcegroupmatrix.zul", null, fileParameters);
		
		win.doModal();
		
	}
	
	public void onClick$gdmpfileopGoogleShare(Event event) {
		
		if(googleFileId.equals("")){
			
			alert("Please select the file to view");
			
			return ;
			
		}
		
		Map<String, Object> fileParameters = new Hashtable<String,Object>();
		
		fileParameters.put("GOOGLEFILEID",googleFileId);
		
		fileParameters.put("GOOGLEDRIVEHANDLER",googleDriveHandler);
		
		Window win = (Window) Executions.createComponents("googleshare.zul", null, fileParameters);
		
		win.doModal();
		
	}
	
	public void onClick$gdmpfileopAddTask(Event event) {
		
		////alert("onClick$mpfileopAddTask");
		
	}
	public void onClick$gdmpfileopSendMail(Event event) {
		
		///alert("onClick$mpfileopSendMail");
		
	}
            
	public void onClick$gdmpfileopMove(Event event) {
		
		///alert("onClick$mpfileopMove");
		
	}
	public void onClick$gdmpfileopCopy(Event event) {
		
		////alert("onClick$mpfileopCopy");
		
	}
	public void onClick$gdmpfileopRename(Event event) {
		
		/////alert("onClick$mpfileopRename");
		
	}
	public void onClick$gdmpfileopTrash(Event event) {
		
		/////alert("onClick$gdmpfileopTrash");
		
		if(googleFileId.equals("")){
			
			alert("Please select the file to trash");
			
			return ;
			
		}
		
		try {
			Messagebox.show("This will trash the file. Are you sure ?", "Confirm Dialog", 
					Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, 
					new org.zkoss.zk.ui.event.EventListener() {
					    public void onEvent(Event evt) throws Exception {
					        if (evt.getName().equals("onOK")) {    	
					        	
					        	controldocumentDAO.updateDeleteStatusForGoogleFile(googleFileId, "Y"); 
					           
					        	alert("File Trashed");
					        } 
					    }
					}
			);
		} catch (Exception e) {
			
			alert("Operation failed due to " + e.getMessage());
			
			e.printStackTrace();
		}
		
		
	}
	public void onClick$gdmpfileopDownload(Event event) {
		
		
		
	}
	public void onClick$gdmpfileopProperties(Event event) {
		
		
		
	}
     
	public void onClick$gdmpfileopCheckOut(Event event) {
		
		
		
	}
	public void onClick$gdmpfileopRevisions(Event event) {
		
		
		
	}
	public void onClick$gdmpfileopAddTag(Event event) {
		
		
		
	}
	public void onClick$gdmpfileopComments(Event event) {
		
		
		
	}
	
	/////////////////////////////////////////////////////////
	
	public void onClick$btnsearch() throws Exception {
		
		searchbox.close();	
		
		String usercode = usermasterBean.usercode ;
		
		String documentNo$value 	= documentno.getText() != null ? documentno.getText() : "";
		String documentName$value	= documentname.getText() != null ? documentname.getText() : "";
		String version$value		= version.getText() != null ? version.getText() : "";
		Date   startDate$value      = null ;
		Date   endDate$value		= null ;
		String documentType$value 	= documenttype.getText() != null ? documenttype.getText() : "";
		String departmentNo$value 	= departmentno.getText() != null ? departmentno.getText() : "";
		
		ControldocumentBean[] groupDocList = controldocumentDAO.findDocumentsByAdminRolesAndSearchCriteria(usercode, documentNo$value, documentName$value, version$value, null, null,documentType$value,departmentNo$value);
		
		searchdatalistbox.setModel(new ListModelList<ControldocumentBean>(groupDocList));		
		
		searchdatalistbox.setItemRenderer(new ListitemRenderer<ControldocumentBean>() {
			@Override
			public void render(Listitem listitem, final ControldocumentBean data,int index) throws Exception {
				listitem.setValue(data);							
				addListcell(listitem, data.documentnumber);
				addListcell(listitem, data.documentname);
				addListcell(listitem, data.documenttype);
				addListcell(listitem, data.getControlFileName());				
				addListcell(listitem, data.documentversion);
				addListcell(listitem, data.description);
				addListcell(listitem, data.departmentcode);
				
				listitem.addEventListener("onClick", new EventListener<Event>() {					
					public void onEvent(Event arg0) throws Exception {						
						//System.out.println("onClick"); 						
						handleGroupListEvent(data,"SEARCH");
						
						
						
						
						
						
						
						
						
						
						openFile();
					}
			});
			}
			private void addListcell(Listitem listitem, String value) {
				Listcell lc = new Listcell();
				Label lb = new Label(value);
				lb.setParent(lc);
				lc.setParent(listitem);
				lc.setContext("gdfileOperationsPopup");
			}
		});
		
		
	}
	/////////////////////////////////////////////////////////
	public void onClick$departmentmenu(Event event) {
		
		Window win = (Window) Executions.createComponents("DepartmentmasterWin.zul", null, null);
		
		win.doModal();
		
	}
	
	public void onClick$usersetupmenu(Event event) {
		
		Window win = (Window) Executions.createComponents("UsersetupWin.zul", null, null);
		
		win.doModal();
		
	}
	
	public void onClick$deletedepartments(Event event) {
		
		Window win = (Window) Executions.createComponents("deletedepartment.zul", null, null);
		
		win.doModal();
		
	}
	
	public void onClick$deleteusers(Event event) {
		
		Window win = (Window) Executions.createComponents("deleteusermaster.zul", null, null);
		
		win.doModal();
		
	}
	
	public void onClick$undeletedepartments(Event event) {
		
		Window win = (Window) Executions.createComponents("undeletedepartment.zul", null, null);
		
		win.doModal();
		
	}
	
	public void onClick$undeleteusers(Event event) {
		
		Window win = (Window) Executions.createComponents("undeleteusermaster.zul", null, null);
		
		win.doModal();
		
	}
	
	public void onClick$creategoogledocument(Event event) throws Exception {
		
		if(currentWorkingDirPath.equals("")){
			
			alert("Please select the directory to upload to...");
			
			return ;
			
		}
		
		Map<String, String> fileParameters = new Hashtable<String,String>();
		
		fileParameters.put("SELECTEDDIR", currentWorkingDirPath);
		fileParameters.put("USERTYPE", usermasterBean.getUsertype());
		fileParameters.put("USERCODE", usermasterBean.getUsercode());
		
		
		Window win = (Window) Executions.createComponents("documentcreatorfordepartmentwise.zul", null, fileParameters);
		
		win.doModal();
			
	}
	
	public void onClick$synchronize(Event event) {
						
		try {
			Messagebox.show("This will take some time depending on data volume. Are you sure ?", "Confirm Dialog", 
					Messagebox.OK | Messagebox.CANCEL, Messagebox.QUESTION, 
					new org.zkoss.zk.ui.event.EventListener() {
					    public void onEvent(Event evt) throws Exception {
					        if (evt.getName().equals("onOK")) {    	
					        	
					        	applicationDAO.synchronizeSystem();
					        	
					        	alert("System Restored.");
					        } 
					    }
					}
			);
		} catch (Exception e) {
			
			alert("Operation failed due to " + e.getMessage());
			
			e.printStackTrace();
		}
		
		
	}
	
	/////////////////////////////////////////////////////////
	public void onClick$logout(Event event) {
		
		session.invalidate();
		
		Executions.sendRedirect("/welcome.zul");
		
	}
	
	
	public void openFile() throws Exception{
		
		String selectedfilename = controldocumentBean$instance.getControlfilepath();
		
		String extentionName = new FilenameUtils().getExtension(selectedfilename);
		
		String randomString = RandomStringUtils.randomAlphabetic(10);
		
		DocumentDecryptor documentEncryptor = DocumentDecryptor.getInstance(applicationBean.getGooglerepositorypath());
		
		File tempFile = documentEncryptor.retrieveDocumentForUser("admin", googleFileId, extentionName);
		
		String tempFileName = tempFile.getAbsolutePath();
			
		Map<String, String> fileParameters = new Hashtable<String,String>();
		
		if(usermasterBean.getViewallowed().equalsIgnoreCase("N")){
			
			alert("Document view is not allowed. Please contact Administrator.");
			
			return;
		}
		
		fileParameters.put("GOOGLEFILEPATH", tempFileName);
		fileParameters.put("FILEEXTENSION", extentionName);
		fileParameters.put("ALLOWVIEW", usermasterBean.getViewallowed());
		fileParameters.put("ALLOWDOWNLOAD", usermasterBean.getDownloadallowed());
		fileParameters.put("ALLOWPRINT", usermasterBean.getPrintallowed());
		
		
		//Window win = (Window) Executions.createComponents("usergooglefileviewer.zul", null, fileParameters);
		
		//win.doModal();
		
		opendocument(fileParameters);
		
	}
	
	
	void opendocument(Map<String,String> argument) throws Exception{
		
		String googleFilePath = argument.get("GOOGLEFILEPATH"); 
		String fileextention = argument.get("FILEEXTENSION");
		String allowview = argument.get("ALLOWVIEW");
		String allowdownload = argument.get("ALLOWDOWNLOAD");
		String allowprint = argument.get("ALLOWPRINT");
		
		fileextention = "pdf"; 
		
		String randomString = RandomStringUtils.randomAlphabetic(10);
		
		String webDir = desktop.getWebApp().getRealPath("/");
		
		String tempFileName = webDir + "\\repository\\" + randomString + "." + fileextention ;
		
		FileOutputStream tempOutFileOutputStream = new FileOutputStream(tempFileName) ;
		
		InputStream localDriveStream = null; 
		
		try {
			
			localDriveStream = new FileInputStream(googleFilePath); 
			
			IOUtils.copy(localDriveStream, tempOutFileOutputStream, true);
			
			if(allowdownload.equalsIgnoreCase("Y")){
				
				String downloadurl = "/enterpriseadmportal/customviewer/web/downloadviewer.html?file=/enterpriseadmportal/repository/" + randomString + "." + fileextention ;
				
				/////fileframe.setSrc(downloadurl);
			
				/////Executions.sendRedirect(downloadurl);
				
				Clients.evalJavaScript("window.open('"+ downloadurl +"','','top=100,left=200,height=600,width=800,scrollbars=1,resizable=1')");
				
			}else {
				
				if(allowprint.equalsIgnoreCase("Y")){
					
					String printurl = "/enterpriseadmportal/customviewer/web/printviewer.html?file=/enterpriseadmportal/repository/" + randomString + "." + fileextention ;
					
					/////fileframe.setSrc(printurl);
				
					/////Executions.sendRedirect(printurl);
					
					Clients.evalJavaScript("window.open('"+ printurl +"','','top=100,left=200,height=600,width=800,scrollbars=1,resizable=1')");
					
				}else{

					passwordProtectPDF(tempFileName);
					
					String viewurl = "/enterpriseadmportal/customviewer/web/viewer.html?file=/enterpriseadmportal/repository/" + randomString + "." + fileextention + ".secured" ;
					
					/////fileframe.setSrc(viewurl);
				
					/////Executions.sendRedirect(viewurl);
					
					Clients.evalJavaScript("window.open('"+ viewurl +"','','top=100,left=200,height=600,width=800,scrollbars=1,resizable=1,modal=yes')");
				
				}
				
			}		
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
		
	}
	
	String passwordProtectPDF(String tempPDFFilePath) throws Exception{
		
		String tempProtectedPDFFilePath = tempPDFFilePath + ".secured" ;
		
		PDFPasswordProtector passwordProtector = PDFPasswordProtector.getInstance();
		
		passwordProtector.protectPDF(tempPDFFilePath, tempProtectedPDFFilePath);		
		
		return tempProtectedPDFFilePath ;
	}
	
	
}
