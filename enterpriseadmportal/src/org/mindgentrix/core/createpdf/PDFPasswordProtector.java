package org.mindgentrix.core.createpdf;

import java.io.*;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFPasswordProtector {
	
	private static final String USER_PASSWORD = "";
	private static final String OWNER_PASSWORD = "ownerpwd";
 
	public static PDFPasswordProtector getInstance(){
		
		return new PDFPasswordProtector();
		
	}
	
	public void protectPDF(String inputFileName,String outputFileName) throws Exception {
		PdfReader reader = null;
		FileOutputStream out = null;
		PdfStamper stamper = null;
 
		try {
			
			reader = new PdfReader(inputFileName);
		
			out = new FileOutputStream(outputFileName);
 			
			stamper = new PdfStamper(reader, out);
			
			stamper.setEncryption(USER_PASSWORD.getBytes(), OWNER_PASSWORD.getBytes(), 0, PdfWriter.STANDARD_ENCRYPTION_128);
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
			
			throw new Exception("Unable to protect PDF");
			
		} finally {
			if (stamper != null) {
				try {
					stamper.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}