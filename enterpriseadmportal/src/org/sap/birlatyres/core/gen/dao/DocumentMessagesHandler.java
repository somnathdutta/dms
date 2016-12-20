package org.sap.birlatyres.core.gen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.sap.birlatyres.core.db.DatabaseHandler;
import org.sap.birlatyres.core.gen.bean.DocumentMessageBean;

public class DocumentMessagesHandler {
	
	private Connection connection ;

	public DocumentMessagesHandler() {
		try {			
			connection = DatabaseHandler.getNewInstance().getConnection();		
		} catch (Exception e) {		
			e.printStackTrace();
		}	
	}

	public static DocumentMessagesHandler getNewInstance() {
		
		return new DocumentMessagesHandler();
		
	}
	
	public void insertData(DocumentMessageBean documentMessageBean) throws Exception {
		
		String insertSQL = getInsertSQL();
		
		PreparedStatement insertPS = null ;
		
		try{
			
			insertPS = connection.prepareStatement(insertSQL);
			
			insertPS.setInt(1, documentMessageBean.documentid);
			insertPS.setString(2, documentMessageBean.documentnumber);
			insertPS.setString(3, documentMessageBean.documentversion);
			insertPS.setString(4, documentMessageBean.usercode);
			insertPS.setString(5, documentMessageBean.messagetype);
			insertPS.setString(6, documentMessageBean.message);
			
			insertPS.executeUpdate();
		
			connection.commit();
			
		}catch(Exception e){
			
			e.printStackTrace() ;
			
			throw new Exception("Failed to insert data due to " + e.getMessage());
			
		}finally{
			
			if(insertPS != null){
				
				insertPS.close();
				
			}
			
		}
		
	}
	
	String getInsertSQL() {
		
		String sql = "" +
			"insert into solardmsdb.documentmessages " +
			"(	documentid,  " +
			"	documentnumber,  " +
			"	documentversion,  " +
			"	usercode,  " +
			"	messagetype,  " +
			"	message  " +
			") " +
			"values " +
			"(	?, " + 
			"	?, " + 
			"	?,  " +
			"	?,  " +
			"	?,  " +
			"	? " +
			") " ;
		return sql ;
	}
	
}
