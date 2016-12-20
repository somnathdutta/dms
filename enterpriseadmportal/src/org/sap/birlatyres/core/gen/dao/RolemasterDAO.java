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

public class RolemasterDAO {
	private Connection conn ;
	public RolemasterDAO(){
		try {			
			conn = DatabaseHandler.getNewInstance().getConnection();		
		} catch (Exception e) {		
			e.printStackTrace();
		}
	}
	
	public ArrayList<RolemasterBean> getAllRoles() throws Exception { 
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ArrayList<RolemasterBean> beansList = new ArrayList<RolemasterBean>();
		String sqlSelectByAll = " SELECT  groupcode  , groupname , isactive FROM rolemaster where isactive = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByAll );
			preparedStatement.setString(1, "Y");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				RolemasterBean bean = new RolemasterBean();
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setGroupname( resultSet.getString("groupname"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return beansList ;
	}
	
	public ArrayList<RolemasterBean> getUserRoles(String userCode) throws Exception { 
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ArrayList<RolemasterBean> beansList = new ArrayList<RolemasterBean>();
		String sqlSelectAllByUserCode = " SELECT  groupcode  , groupname , isactive FROM rolemaster  " +
								" where isactive = ? and groupcode in (" +
								" select groupcode from privilegeregister where usercode = ? " +
								" " +
								") " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectAllByUserCode);
			preparedStatement.setString(1, "Y");
			preparedStatement.setString(2,userCode);
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				RolemasterBean bean = new RolemasterBean();
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setGroupname( resultSet.getString("groupname"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return beansList ;
	}
	
	public RolemasterBean[] findAll( )throws Exception{
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		RolemasterBean[] beans = null ;
		ArrayList<RolemasterBean> beansList = new ArrayList<RolemasterBean>();
		String sqlSelectByAll = " SELECT  groupcode  , groupname , isactive FROM rolemaster where isactive = ? " ; 
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByAll );
			preparedStatement.setString(1, "Y");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				RolemasterBean bean = new RolemasterBean();
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setGroupname( resultSet.getString("groupname"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new RolemasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (RolemasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return beans ;
	}
	public RolemasterBean[] findByGroupcode(String groupcode )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		RolemasterBean[] beans = null ;
		ArrayList<RolemasterBean> beansList = new ArrayList<RolemasterBean>();
		String sqlSelectByGroupcode = " SELECT  groupcode  , groupname , isactive FROM rolemaster WHERE groupcode = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByGroupcode );
			preparedStatement.setString(1,groupcode); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				RolemasterBean bean = new RolemasterBean();
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setGroupname( resultSet.getString("groupname"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new RolemasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (RolemasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public RolemasterBean[] findByGroupname(String groupname )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		RolemasterBean[] beans = null ;
		ArrayList<RolemasterBean> beansList = new ArrayList<RolemasterBean>();
		String sqlSelectByGroupname = " SELECT  groupcode  , groupname , isactive FROM rolemaster WHERE groupname = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByGroupname );
			preparedStatement.setString(1,groupname); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				RolemasterBean bean = new RolemasterBean();
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setGroupname( resultSet.getString("groupname"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new RolemasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (RolemasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public RolemasterBean[] findByIsactive(String isactive )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		RolemasterBean[] beans = null ;
		ArrayList<RolemasterBean> beansList = new ArrayList<RolemasterBean>();
		String sqlSelectByIsactive = " SELECT  groupcode  , groupname , isactive FROM rolemaster WHERE isactive = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByIsactive );
			preparedStatement.setString(1,isactive); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				RolemasterBean bean = new RolemasterBean();
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setGroupname( resultSet.getString("groupname"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new RolemasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (RolemasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public void insertAllCols( RolemasterBean bean )throws Exception{
		PreparedStatement preparedStatement = null ;
		String sqlInsertAllStmt = "INSERT INTO rolemaster  (groupcode  , groupname , isactive) VALUES ( ?  , ?  , ? )" ;
		try{
			preparedStatement = conn.prepareStatement( sqlInsertAllStmt );
			preparedStatement.setString(1, bean.getGroupcode());
			if(bean.getGroupname()!= null){
				preparedStatement.setString(2, bean.getGroupname());
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
	public void updateAllCols( RolemasterBean bean )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlUpdateAllStmt = "UPDATE rolemaster SET   groupname = ?  , isactive = ?   WHERE  groupcode = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlUpdateAllStmt );
			if(bean.getGroupname()!= null){
				preparedStatement.setString(1, bean.getGroupname());
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
	public void deleteAllByPK( RolemasterBean bean )throws Exception{
		String sqlDeleteAll = "DELETE FROM rolemaster WHERE  groupcode = ?  " ;
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
	public void deleteByGroupname(String groupname )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByGroupname = " DELETE FROM rolemaster WHERE groupname = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByGroupname );
			preparedStatement.setString(1,groupname); 
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
		String sqlDeleteByIsactive = " DELETE FROM rolemaster WHERE isactive = ? " ;
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
