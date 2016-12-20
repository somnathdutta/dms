package org.mindgentrix.core.createpdf;

import java.io.*;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class EncryptPDF {
	 
	private static final String INPUT_FILENAME = "tmp/test.pdf";
	private static final String OUTPUT_FILENAME = "tmp/test_encrypted.pdf";
	private static final String USER_PASSWORD = "";
	private static final String OWNER_PASSWORD = "ownerpwd";
 
	public static void main(String[] args) {
		PdfReader reader = null;
		FileOutputStream out = null;
		PdfStamper stamper = null;
 
		try {
			// Define input
			reader = new PdfReader(INPUT_FILENAME);
 
			// Define output
			out = new FileOutputStream(OUTPUT_FILENAME);
 
			// Encrypt document
			stamper = new PdfStamper(reader, out);
			stamper.setEncryption(USER_PASSWORD.getBytes(), OWNER_PASSWORD.getBytes(), 0, PdfWriter.STANDARD_ENCRYPTION_128);
		} catch (Exception ex) {
			ex.printStackTrace();
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