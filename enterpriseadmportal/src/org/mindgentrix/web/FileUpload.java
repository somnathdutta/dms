package org.mindgentrix.web;

import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Window;

public class FileUpload extends GenericForwardComposer {

	private Window window;
	private Fileupload fileupload;

	public void doAfterCompose(Component comp) {
		try {
			super.doAfterCompose(comp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onUpload$fileupload(UploadEvent event) {
		System.out.println("onUpload event");
		
		String eventName = event.getName();
		
		Media media = event.getMedia();
		
		String mediaName = media.getName() ;
		
		System.out.println("eventName = " + eventName + "\tmediaName = " + mediaName);
		
	}

}