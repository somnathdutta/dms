package org.mindgentrix.encryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class DocumentDecryptor {

	public static final int AESKEYSIZE = 256 ;
	
	Cipher pkCipher,aesCipher;
	byte[] aesKey;
	SecretKeySpec aeskeySpec;
	
	private String applicationPath ;
	
	private static DocumentDecryptor instance ;
	
	private DocumentDecryptor(String applicationPath$instance) throws Exception {
			
		init();
		pkCipher = Cipher.getInstance("RSA");		
		aesCipher= Cipher.getInstance("AES");
	
		applicationPath = applicationPath$instance ;		
		
	}
	
	 void init(){

	        try {
	            Field field = Class.forName("javax.crypto.JceSecurity").getDeclaredField("isRestricted");
	            field.setAccessible(true);
	            field.set(null, java.lang.Boolean.FALSE);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }

	/**
	 * The trick is to prepare the aeskey and the aeskeySpec
	 * 
	 */
	private void makeKeyX() throws NoSuchAlgorithmException {
		
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(AESKEYSIZE);
		SecretKey key = kgen.generateKey();
		aesKey = key.getEncoded();
		aeskeySpec = new SecretKeySpec(aesKey, "AES");
		
	}
	
	private void saveKeyX(File encryptedKeyFile, File publicKeyFile) throws IOException, GeneralSecurityException {
		
		byte[] encodedKey = new byte[(int)publicKeyFile.length()];
		new FileInputStream(publicKeyFile).read(encodedKey);
		
		X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(encodedKey);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PublicKey  pk = kf.generatePublic(publicKeySpec);
		
		pkCipher.init(Cipher.ENCRYPT_MODE,pk);
		CipherOutputStream os = new CipherOutputStream(new FileOutputStream(encryptedKeyFile), pkCipher);
		os.write(aesKey);
		os.close();
		
	}
	
	private void loadKeyForEncryption(File encryptedKeyFile, File publicKeyFile) throws GeneralSecurityException,IOException { 
		
		byte[] encodedKey = new byte[(int) publicKeyFile.length()];
		new FileInputStream(publicKeyFile).read(encodedKey); 
		
		X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(encodedKey); 
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PublicKey pk = kf.generatePublic(publicKeySpec);
		
		//read AES key
		pkCipher.init(Cipher.ENCRYPT_MODE, pk);
		aesKey = new byte[AESKEYSIZE/8];
		CipherInputStream cipherIs = new CipherInputStream(new FileInputStream(encryptedKeyFile), pkCipher);
		cipherIs.read(aesKey);
		aeskeySpec = new SecretKeySpec(aesKey,"AES");
		
	}
	
	private void encrypt(File fileToEncrypt, File encryptedFile) throws IOException, InvalidKeyException {
		
		aesCipher.init(Cipher.ENCRYPT_MODE, aeskeySpec);
		
		FileInputStream is = new FileInputStream(fileToEncrypt);
		CipherOutputStream cipherOs = new CipherOutputStream(new FileOutputStream(encryptedFile), aesCipher);
		
		copy(is, cipherOs);		
		cipherOs.close();
		is.close();
		
	}
	
	private void decrypt(File encryptedFile, File decryptedFile) throws IOException, InvalidKeyException {
		aesCipher.init(Cipher.DECRYPT_MODE, aeskeySpec);
		
		CipherInputStream cipherIs = new CipherInputStream(new FileInputStream(encryptedFile), aesCipher);
		FileOutputStream os = new FileOutputStream(decryptedFile);
		
		copy(cipherIs, os);
		
		cipherIs.close();
		os.close();
		
	}
	
	/**
	 * Decrypts an AES key from a file using an RSA key
	 * 
	 */
	private void loadKey(File encryptedKeyFile, File privateKeyFile) throws GeneralSecurityException,IOException {
	
		byte[] encodedKey = new byte[(int) privateKeyFile.length()];
		new FileInputStream(privateKeyFile).read(encodedKey); 
		
		PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(encodedKey);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PrivateKey pk = kf.generatePrivate(privateKeySpec);
		
		//read AES key
		pkCipher.init(Cipher.DECRYPT_MODE, pk);
		aesKey = new byte[AESKEYSIZE/8];
		CipherInputStream cipherIs = new CipherInputStream(new FileInputStream(encryptedKeyFile), pkCipher);
		cipherIs.read(aesKey);
		aeskeySpec = new SecretKeySpec(aesKey,"AES");
		
	}
	
	private void copy(InputStream is, OutputStream os) throws IOException {
		int i;
		byte[] b = new byte[1024];
		while((i=is.read(b))!=-1) {
			os.write(b, 0, i);
		}
	} 
	
	
	public static DocumentDecryptor getInstance(String applicationPath$instance) throws Exception {
			
		return new DocumentDecryptor(applicationPath$instance); 
		
	}
	
	public File retrieveDocumentForUser(String username, String keyHandle,String extension) throws Exception {
		
		String userHomeDirPath 	= applicationPath + "home/" + username.toLowerCase()+ "/" ; 
		
		System.out.println("applicationPath="+applicationPath);
		
		File encryptedKeyFile 	= new File(userHomeDirPath  + "securedkeys/encryptedKey.enc");
		
		File encryptedFile	 	= new File(userHomeDirPath   + "resources/" + keyHandle); 	
		
		File privateKeyFile  	= new File(userHomeDirPath   + "securedkeys/private.der");
		
		String randomFileKey  = RandomStringUtils.randomAlphanumeric(21);
		
		File unencryptedFile   	= new File(userHomeDirPath   + "public/" + randomFileKey + "." + extension);
		 
		// to decrypt it again
		loadKey(encryptedKeyFile, privateKeyFile);
		
		decrypt(encryptedFile, unencryptedFile);
				
		return unencryptedFile;
		
	}

	void deleteFile(File fileToEncrypt) throws Exception {
		
		FileUtils.forceDelete(fileToEncrypt.getAbsoluteFile());
		
	}
	
	public static void main(String[] args) throws Exception {
		
						
	}
	
}
