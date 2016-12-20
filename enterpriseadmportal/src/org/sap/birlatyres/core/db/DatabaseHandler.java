package org.sap.birlatyres.core.db;
import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
public class DatabaseHandler {
		private Connection dbConnection = null ;
		private String uniqueID ;
		private DatabaseHandler(){
		}
		public static DatabaseHandler getNewInstance(){
				return new DatabaseHandler();
		}
		public Connection getConnection()throws Exception{
				try{
						Context initCtx = new InitialContext();
			           Context envCtx = (Context)initCtx.lookup("java:/comp/env");
			            DataSource dataSource = (DataSource)envCtx.lookup("jdbc/mbpl");
			           dbConnection = dataSource.getConnection();
			            dbConnection.setAutoCommit(false);
				}catch(Exception e){
						dbConnection = null ;
						throw new Exception("Error in creating a connection");
				}
				return dbConnection ;
		}
		public boolean closeConnection() throws Exception{
				boolean result = false ;
				if(dbConnection != null){
						try {
								dbConnection.close();
						} catch (Exception e) {
								result = false ;
						}
						result = true ;
				}
				return result ;
		}
}
