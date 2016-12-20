package org.sap.birlatyres.core.gen.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import org.sap.birlatyres.core.gen.bean.*;
import org.sap.birlatyres.core.db.*;

import java.sql.Timestamp;
import java.sql.Types;

public class PrivilegeregisterDAO {
	private Connection conn ;
	public PrivilegeregisterDAO() {
		try {			
			conn = DatabaseHandler.getNewInstance().getConnection();		
		} catch (Exception e) {		
			e.printStackTrace();
		}
	}
	public PrivilegeregisterBean[] findAll( )throws Exception{
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		PrivilegeregisterBean[] beans = null ;
		ArrayList<PrivilegeregisterBean> beansList = new ArrayList<PrivilegeregisterBean>();
		String sqlSelectByAll = " SELECT  groupcode  , usercode , isactive FROM privilegeregister " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByAll );
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				PrivilegeregisterBean bean = new PrivilegeregisterBean();
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new PrivilegeregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (PrivilegeregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return beans ;
	}
	public PrivilegeregisterBean[] findByGroupcode(String groupcode )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		PrivilegeregisterBean[] beans = null ;
		ArrayList<PrivilegeregisterBean> beansList = new ArrayList<PrivilegeregisterBean>();
		String sqlSelectByGroupcode = " SELECT  groupcode  , usercode , isactive FROM privilegeregister WHERE groupcode = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByGroupcode );
			preparedStatement.setString(1,groupcode); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				PrivilegeregisterBean bean = new PrivilegeregisterBean();
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new PrivilegeregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (PrivilegeregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public PrivilegeregisterBean[] findByUsercode(String usercode )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		PrivilegeregisterBean[] beans = null ;
		ArrayList<PrivilegeregisterBean> beansList = new ArrayList<PrivilegeregisterBean>();
		String sqlSelectByUsercode = " SELECT  groupcode  , usercode , isactive FROM privilegeregister WHERE usercode = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByUsercode );
			preparedStatement.setString(1,usercode); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				PrivilegeregisterBean bean = new PrivilegeregisterBean();
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new PrivilegeregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (PrivilegeregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public PrivilegeregisterBean[] findByIsactive(String isactive )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		PrivilegeregisterBean[] beans = null ;
		ArrayList<PrivilegeregisterBean> beansList = new ArrayList<PrivilegeregisterBean>();
		String sqlSelectByIsactive = " SELECT  groupcode  , usercode , isactive FROM privilegeregister WHERE isactive = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByIsactive );
			preparedStatement.setString(1,isactive); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				PrivilegeregisterBean bean = new PrivilegeregisterBean();
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new PrivilegeregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (PrivilegeregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public void insertAllCols( PrivilegeregisterBean bean )throws Exception{
		PreparedStatement preparedStatement = null ;
		String sqlInsertAllStmt = "INSERT INTO privilegeregister  (groupcode  , usercode , isactive) VALUES ( ?  , ?  , ? )" ;
		try{
			preparedStatement = conn.prepareStatement( sqlInsertAllStmt );
			preparedStatement.setString(1, bean.getGroupcode());
			if(bean.getUsercode()!= null){
				preparedStatement.setString(2, bean.getUsercode());
			}else{
				preparedStatement.setNull(2,Types.VARCHAR) ;
			}
			if(bean.getIsactive()!= null){
				preparedStatement.setString(3, bean.getIsactive());
			}else{
				preparedStatement.setNull(3,Types.CHAR) ;
			}
			preparedStatement.executeUpdate();
			conn.commit();
		}catch(Exception e){
			conn.rollback();
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
		if(preparedStatement != null) { preparedStatement.close() ;}
		}
	}
	public void updateAllCols( PrivilegeregisterBean bean )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlUpdateAllStmt = "UPDATE privilegeregister SET   usercode = ?  , isactive = ?   WHERE  groupcode = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlUpdateAllStmt );
			if(bean.getUsercode()!= null){
				preparedStatement.setString(1, bean.getUsercode());
			}else{
				preparedStatement.setNull(1,Types.VARCHAR) ;
			}
			if(bean.getIsactive()!= null){
				preparedStatement.setString(2, bean.getIsactive());
			}else{
				preparedStatement.setNull(2,Types.CHAR) ;
			}
			preparedStatement.setString(3, bean.getGroupcode());
			preparedStatement.executeUpdate();
			conn.commit();
		}catch(Exception e){
			conn.rollback();
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
		try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteAllByPK( PrivilegeregisterBean bean )throws Exception{
		String sqlDeleteAll = "DELETE FROM privilegeregister WHERE  groupcode = ?  " ;
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteAll );
			preparedStatement.setString(1, bean.getGroupcode());
			preparedStatement.executeUpdate();
			conn.commit();
		}catch(Exception e){
			conn.rollback();
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
		try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByUsercode(String usercode )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByUsercode = " DELETE FROM privilegeregister WHERE usercode = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByUsercode );
			preparedStatement.setString(1,usercode); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByIsactive(String isactive )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByIsactive = " DELETE FROM privilegeregister WHERE isactive = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByIsactive );
			preparedStatement.setString(1,isactive); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
}
