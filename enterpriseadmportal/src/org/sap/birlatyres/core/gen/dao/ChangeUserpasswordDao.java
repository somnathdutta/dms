package org.sap.birlatyres.core.gen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.sap.birlatyres.core.db.DatabaseHandler;
import org.sap.birlatyres.core.gen.bean.UsermasterBean;

public class ChangeUserpasswordDao {
	
	private Connection connection ; 
	
	public ChangeUserpasswordDao(){
		try {			
			try {			
				connection = DatabaseHandler.getNewInstance().getConnection();		
			} catch (Exception e) {		
				e.printStackTrace();
			}		
		} catch (Exception e) {		
			e.printStackTrace();
		}
	}
	
	
	public String getUsername(String usercode) throws SQLException{
		
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		String username = "";
		String sqlSelectByCredentials = " SELECT username FROM usermaster where usercode = ? " ;
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByCredentials);
			
			preparedStatement.setString(1,usercode);
		
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				
				username = resultSet.getString("username");
				
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return username ;
		
	}
	
	
	public int changePassword(String usercode, String password) throws Exception{
		
		PreparedStatement preparedStatement = null ;
		
		
		int count = 0;
		
		
		String sqlSelectByCredentials = " UPDATE usermaster set password = password(?) where usercode = ? " ;
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByCredentials);
			
			preparedStatement.setString(1,password);
			System.out.println("pwd"+password);
			preparedStatement.setString(2,usercode);
			System.out.println("uc"+usercode);
			count = preparedStatement.executeUpdate();
			
			System.out.println("count==="+count);
		
					
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;
			
			if(count>0){
				
				connection.commit();
				
			}
			
			}
		}
		
		return count;
	}
	

}
