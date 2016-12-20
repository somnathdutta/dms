package org.sap.birlatyres.core.gen.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import org.sap.birlatyres.core.gen.bean.*;
import org.sap.birlatyres.core.db.*;

import java.sql.Types;

public class ApplicationDAO { 
	private Connection connection ;
	public ApplicationDAO() {
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
	
	public void synchronizeSystem ()throws Exception{
		
		String synchronizeSQL = "call sp_synchronize_roles() " ;
		
		CallableStatement synchronizeCS = null ;
		
		try{
			
			synchronizeCS = connection.prepareCall(synchronizeSQL);
			
			synchronizeCS.executeUpdate();
			
			connection.commit();
						
		}catch(Exception e){
			connection.rollback();
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
		
			if(synchronizeCS != null){
				
				synchronizeCS.close();
				
			}
			
		}
	}
	
	public ApplicationBean loadApplicationData()throws Exception{
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ApplicationBean bean = null ;
		String sqlSelectByAll = " SELECT  applicationcode  , applicationkey , operatingsystem , applicationroot , applicationtitle , gsserviceaccountemail , gsservicepkcsfilepath , googlerepositorypath FROM application " ;
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByAll );
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				bean = new ApplicationBean();
				bean.setApplicationcode( resultSet.getString("applicationcode"));
				bean.setApplicationkey( resultSet.getString("applicationkey"));
				bean.setOperatingsystem( resultSet.getString("operatingsystem"));
				bean.setApplicationroot( resultSet.getString("applicationroot"));
				bean.setApplicationtitle( resultSet.getString("applicationtitle"));
				bean.setGsserviceaccountemail( resultSet.getString("gsserviceaccountemail"));
				bean.setGsservicepkcsfilepath( resultSet.getString("gsservicepkcsfilepath"));
				bean.setGooglerepositorypath( resultSet.getString("googlerepositorypath"));
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return bean ;
	}
	
	public ApplicationBean[] findAll( )throws Exception{
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ApplicationBean[] beans = null ;
		ArrayList<ApplicationBean> beansList = new ArrayList<ApplicationBean>();
		String sqlSelectByAll = " SELECT  applicationcode  , applicationkey , operatingsystem , applicationroot , applicationtitle , gsserviceaccountemail , gsservicepkcsfilepath , googlerepositorypath FROM application " ;
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByAll );
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ApplicationBean bean = new ApplicationBean();
				bean.setApplicationcode( resultSet.getString("applicationcode"));
				bean.setApplicationkey( resultSet.getString("applicationkey"));
				bean.setOperatingsystem( resultSet.getString("operatingsystem"));
				bean.setApplicationroot( resultSet.getString("applicationroot"));
				bean.setApplicationtitle( resultSet.getString("applicationtitle"));
				bean.setGsserviceaccountemail( resultSet.getString("gsserviceaccountemail"));
				bean.setGsservicepkcsfilepath( resultSet.getString("gsservicepkcsfilepath"));
				bean.setGooglerepositorypath( resultSet.getString("googlerepositorypath"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ApplicationBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ApplicationBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return beans ;
	}
	public ApplicationBean[] findByApplicationcode(String applicationcode )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ApplicationBean[] beans = null ;
		ArrayList<ApplicationBean> beansList = new ArrayList<ApplicationBean>();
		String sqlSelectByApplicationcode = " SELECT  applicationcode  , applicationkey , operatingsystem , applicationroot , applicationtitle , gsserviceaccountemail , gsservicepkcsfilepath , googlerepositorypath FROM application WHERE applicationcode = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByApplicationcode );
			preparedStatement.setString(1,applicationcode); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ApplicationBean bean = new ApplicationBean();
				bean.setApplicationcode( resultSet.getString("applicationcode"));
				bean.setApplicationkey( resultSet.getString("applicationkey"));
				bean.setOperatingsystem( resultSet.getString("operatingsystem"));
				bean.setApplicationroot( resultSet.getString("applicationroot"));
				bean.setApplicationtitle( resultSet.getString("applicationtitle"));
				bean.setGsserviceaccountemail( resultSet.getString("gsserviceaccountemail"));
				bean.setGsservicepkcsfilepath( resultSet.getString("gsservicepkcsfilepath"));
				bean.setGooglerepositorypath( resultSet.getString("googlerepositorypath"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ApplicationBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ApplicationBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ApplicationBean[] findByApplicationkey(String applicationkey )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ApplicationBean[] beans = null ;
		ArrayList<ApplicationBean> beansList = new ArrayList<ApplicationBean>();
		String sqlSelectByApplicationkey = " SELECT  applicationcode  , applicationkey , operatingsystem , applicationroot , applicationtitle , gsserviceaccountemail , gsservicepkcsfilepath , googlerepositorypath FROM application WHERE applicationkey = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByApplicationkey );
			preparedStatement.setString(1,applicationkey); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ApplicationBean bean = new ApplicationBean();
				bean.setApplicationcode( resultSet.getString("applicationcode"));
				bean.setApplicationkey( resultSet.getString("applicationkey"));
				bean.setOperatingsystem( resultSet.getString("operatingsystem"));
				bean.setApplicationroot( resultSet.getString("applicationroot"));
				bean.setApplicationtitle( resultSet.getString("applicationtitle"));
				bean.setGsserviceaccountemail( resultSet.getString("gsserviceaccountemail"));
				bean.setGsservicepkcsfilepath( resultSet.getString("gsservicepkcsfilepath"));
				bean.setGooglerepositorypath( resultSet.getString("googlerepositorypath"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ApplicationBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ApplicationBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ApplicationBean[] findByOperatingsystem(String operatingsystem )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ApplicationBean[] beans = null ;
		ArrayList<ApplicationBean> beansList = new ArrayList<ApplicationBean>();
		String sqlSelectByOperatingsystem = " SELECT  applicationcode  , applicationkey , operatingsystem , applicationroot , applicationtitle , gsserviceaccountemail , gsservicepkcsfilepath , googlerepositorypath FROM application WHERE operatingsystem = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByOperatingsystem );
			preparedStatement.setString(1,operatingsystem); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ApplicationBean bean = new ApplicationBean();
				bean.setApplicationcode( resultSet.getString("applicationcode"));
				bean.setApplicationkey( resultSet.getString("applicationkey"));
				bean.setOperatingsystem( resultSet.getString("operatingsystem"));
				bean.setApplicationroot( resultSet.getString("applicationroot"));
				bean.setApplicationtitle( resultSet.getString("applicationtitle"));
				bean.setGsserviceaccountemail( resultSet.getString("gsserviceaccountemail"));
				bean.setGsservicepkcsfilepath( resultSet.getString("gsservicepkcsfilepath"));
				bean.setGooglerepositorypath( resultSet.getString("googlerepositorypath"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ApplicationBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ApplicationBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ApplicationBean[] findByApplicationroot(String applicationroot )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ApplicationBean[] beans = null ;
		ArrayList<ApplicationBean> beansList = new ArrayList<ApplicationBean>();
		String sqlSelectByApplicationroot = " SELECT  applicationcode  , applicationkey , operatingsystem , applicationroot , applicationtitle , gsserviceaccountemail , gsservicepkcsfilepath , googlerepositorypath FROM application WHERE applicationroot = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByApplicationroot );
			preparedStatement.setString(1,applicationroot); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ApplicationBean bean = new ApplicationBean();
				bean.setApplicationcode( resultSet.getString("applicationcode"));
				bean.setApplicationkey( resultSet.getString("applicationkey"));
				bean.setOperatingsystem( resultSet.getString("operatingsystem"));
				bean.setApplicationroot( resultSet.getString("applicationroot"));
				bean.setApplicationtitle( resultSet.getString("applicationtitle"));
				bean.setGsserviceaccountemail( resultSet.getString("gsserviceaccountemail"));
				bean.setGsservicepkcsfilepath( resultSet.getString("gsservicepkcsfilepath"));
				bean.setGooglerepositorypath( resultSet.getString("googlerepositorypath"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ApplicationBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ApplicationBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ApplicationBean[] findByApplicationtitle(String applicationtitle )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ApplicationBean[] beans = null ;
		ArrayList<ApplicationBean> beansList = new ArrayList<ApplicationBean>();
		String sqlSelectByApplicationtitle = " SELECT  applicationcode  , applicationkey , operatingsystem , applicationroot , applicationtitle , gsserviceaccountemail , gsservicepkcsfilepath , googlerepositorypath FROM application WHERE applicationtitle = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByApplicationtitle );
			preparedStatement.setString(1,applicationtitle); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ApplicationBean bean = new ApplicationBean();
				bean.setApplicationcode( resultSet.getString("applicationcode"));
				bean.setApplicationkey( resultSet.getString("applicationkey"));
				bean.setOperatingsystem( resultSet.getString("operatingsystem"));
				bean.setApplicationroot( resultSet.getString("applicationroot"));
				bean.setApplicationtitle( resultSet.getString("applicationtitle"));
				bean.setGsserviceaccountemail( resultSet.getString("gsserviceaccountemail"));
				bean.setGsservicepkcsfilepath( resultSet.getString("gsservicepkcsfilepath"));
				bean.setGooglerepositorypath( resultSet.getString("googlerepositorypath"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ApplicationBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ApplicationBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ApplicationBean[] findByGsserviceaccountemail(String gsserviceaccountemail )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ApplicationBean[] beans = null ;
		ArrayList<ApplicationBean> beansList = new ArrayList<ApplicationBean>();
		String sqlSelectByGsserviceaccountemail = " SELECT  applicationcode  , applicationkey , operatingsystem , applicationroot , applicationtitle , gsserviceaccountemail , gsservicepkcsfilepath , googlerepositorypath FROM application WHERE gsserviceaccountemail = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByGsserviceaccountemail );
			preparedStatement.setString(1,gsserviceaccountemail); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ApplicationBean bean = new ApplicationBean();
				bean.setApplicationcode( resultSet.getString("applicationcode"));
				bean.setApplicationkey( resultSet.getString("applicationkey"));
				bean.setOperatingsystem( resultSet.getString("operatingsystem"));
				bean.setApplicationroot( resultSet.getString("applicationroot"));
				bean.setApplicationtitle( resultSet.getString("applicationtitle"));
				bean.setGsserviceaccountemail( resultSet.getString("gsserviceaccountemail"));
				bean.setGsservicepkcsfilepath( resultSet.getString("gsservicepkcsfilepath"));
				bean.setGooglerepositorypath( resultSet.getString("googlerepositorypath"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ApplicationBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ApplicationBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ApplicationBean[] findByGsservicepkcsfilepath(String gsservicepkcsfilepath )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ApplicationBean[] beans = null ;
		ArrayList<ApplicationBean> beansList = new ArrayList<ApplicationBean>();
		String sqlSelectByGsservicepkcsfilepath = " SELECT  applicationcode  , applicationkey , operatingsystem , applicationroot , applicationtitle , gsserviceaccountemail , gsservicepkcsfilepath , googlerepositorypath FROM application WHERE gsservicepkcsfilepath = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByGsservicepkcsfilepath );
			preparedStatement.setString(1,gsservicepkcsfilepath); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ApplicationBean bean = new ApplicationBean();
				bean.setApplicationcode( resultSet.getString("applicationcode"));
				bean.setApplicationkey( resultSet.getString("applicationkey"));
				bean.setOperatingsystem( resultSet.getString("operatingsystem"));
				bean.setApplicationroot( resultSet.getString("applicationroot"));
				bean.setApplicationtitle( resultSet.getString("applicationtitle"));
				bean.setGsserviceaccountemail( resultSet.getString("gsserviceaccountemail"));
				bean.setGsservicepkcsfilepath( resultSet.getString("gsservicepkcsfilepath"));
				bean.setGooglerepositorypath( resultSet.getString("googlerepositorypath"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ApplicationBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ApplicationBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ApplicationBean[] findByGooglerepositorypath(String googlerepositorypath )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ApplicationBean[] beans = null ;
		ArrayList<ApplicationBean> beansList = new ArrayList<ApplicationBean>();
		String sqlSelectByGooglerepositorypath = " SELECT  applicationcode  , applicationkey , operatingsystem , applicationroot , applicationtitle , gsserviceaccountemail , gsservicepkcsfilepath , googlerepositorypath FROM application WHERE googlerepositorypath = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByGooglerepositorypath );
			preparedStatement.setString(1,googlerepositorypath); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ApplicationBean bean = new ApplicationBean();
				bean.setApplicationcode( resultSet.getString("applicationcode"));
				bean.setApplicationkey( resultSet.getString("applicationkey"));
				bean.setOperatingsystem( resultSet.getString("operatingsystem"));
				bean.setApplicationroot( resultSet.getString("applicationroot"));
				bean.setApplicationtitle( resultSet.getString("applicationtitle"));
				bean.setGsserviceaccountemail( resultSet.getString("gsserviceaccountemail"));
				bean.setGsservicepkcsfilepath( resultSet.getString("gsservicepkcsfilepath"));
				bean.setGooglerepositorypath( resultSet.getString("googlerepositorypath"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ApplicationBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ApplicationBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public void insertAllCols( ApplicationBean bean )throws Exception{
		PreparedStatement preparedStatement = null ;
		String sqlInsertAllStmt = "INSERT INTO application  (applicationcode  , applicationkey , operatingsystem , applicationroot , applicationtitle , gsserviceaccountemail , gsservicepkcsfilepath , googlerepositorypath) VALUES ( ?  , ?  , ?  , ?  , ?  , ?  , ?  , ? )" ;
		try{
			preparedStatement = connection.prepareStatement( sqlInsertAllStmt );
			preparedStatement.setString(1, bean.getApplicationcode());
			if(bean.getApplicationkey()!= null){
				preparedStatement.setString(2, bean.getApplicationkey());
			}else{
				preparedStatement.setNull(2,Types.VARCHAR) ;
			}
			if(bean.getOperatingsystem()!= null){
				preparedStatement.setString(3, bean.getOperatingsystem());
			}else{
				preparedStatement.setNull(3,Types.VARCHAR) ;
			}
			if(bean.getApplicationroot()!= null){
				preparedStatement.setString(4, bean.getApplicationroot());
			}else{
				preparedStatement.setNull(4,Types.VARCHAR) ;
			}
			if(bean.getApplicationtitle()!= null){
				preparedStatement.setString(5, bean.getApplicationtitle());
			}else{
				preparedStatement.setNull(5,Types.VARCHAR) ;
			}
			if(bean.getGsserviceaccountemail()!= null){
				preparedStatement.setString(6, bean.getGsserviceaccountemail());
			}else{
				preparedStatement.setNull(6,Types.VARCHAR) ;
			}
			if(bean.getGsservicepkcsfilepath()!= null){
				preparedStatement.setString(7, bean.getGsservicepkcsfilepath());
			}else{
				preparedStatement.setNull(7,Types.VARCHAR) ;
			}
			if(bean.getGooglerepositorypath()!= null){
				preparedStatement.setString(8, bean.getGooglerepositorypath());
			}else{
				preparedStatement.setNull(8,Types.VARCHAR) ;
			}
			preparedStatement.executeUpdate();
			connection.commit();
		}catch(Exception e){
			connection.rollback();
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
		if(preparedStatement != null) { preparedStatement.close() ;}
		}
	}
	public void updateAllCols( ApplicationBean bean )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlUpdateAllStmt = "UPDATE application SET   applicationkey = ?  , operatingsystem = ?  , applicationroot = ?  , applicationtitle = ?  , gsserviceaccountemail = ?  , gsservicepkcsfilepath = ?  , googlerepositorypath = ?   WHERE  applicationcode = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlUpdateAllStmt );
			if(bean.getApplicationkey()!= null){
				preparedStatement.setString(1, bean.getApplicationkey());
			}else{
				preparedStatement.setNull(1,Types.VARCHAR) ;
			}
			if(bean.getOperatingsystem()!= null){
				preparedStatement.setString(2, bean.getOperatingsystem());
			}else{
				preparedStatement.setNull(2,Types.VARCHAR) ;
			}
			if(bean.getApplicationroot()!= null){
				preparedStatement.setString(3, bean.getApplicationroot());
			}else{
				preparedStatement.setNull(3,Types.VARCHAR) ;
			}
			if(bean.getApplicationtitle()!= null){
				preparedStatement.setString(4, bean.getApplicationtitle());
			}else{
				preparedStatement.setNull(4,Types.VARCHAR) ;
			}
			if(bean.getGsserviceaccountemail()!= null){
				preparedStatement.setString(5, bean.getGsserviceaccountemail());
			}else{
				preparedStatement.setNull(5,Types.VARCHAR) ;
			}
			if(bean.getGsservicepkcsfilepath()!= null){
				preparedStatement.setString(6, bean.getGsservicepkcsfilepath());
			}else{
				preparedStatement.setNull(6,Types.VARCHAR) ;
			}
			if(bean.getGooglerepositorypath()!= null){
				preparedStatement.setString(7, bean.getGooglerepositorypath());
			}else{
				preparedStatement.setNull(7,Types.VARCHAR) ;
			}
			preparedStatement.setString(8, bean.getApplicationcode());
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
	public void deleteAllByPK( ApplicationBean bean )throws Exception{
		String sqlDeleteAll = "DELETE FROM application WHERE  applicationcode = ?  " ;
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteAll );
			preparedStatement.setString(1, bean.getApplicationcode());
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
	public void deleteByApplicationkey(String applicationkey )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByApplicationkey = " DELETE FROM application WHERE applicationkey = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByApplicationkey );
			preparedStatement.setString(1,applicationkey); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByOperatingsystem(String operatingsystem )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByOperatingsystem = " DELETE FROM application WHERE operatingsystem = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByOperatingsystem );
			preparedStatement.setString(1,operatingsystem); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByApplicationroot(String applicationroot )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByApplicationroot = " DELETE FROM application WHERE applicationroot = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByApplicationroot );
			preparedStatement.setString(1,applicationroot); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByApplicationtitle(String applicationtitle )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByApplicationtitle = " DELETE FROM application WHERE applicationtitle = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByApplicationtitle );
			preparedStatement.setString(1,applicationtitle); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByGsserviceaccountemail(String gsserviceaccountemail )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByGsserviceaccountemail = " DELETE FROM application WHERE gsserviceaccountemail = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByGsserviceaccountemail );
			preparedStatement.setString(1,gsserviceaccountemail); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByGsservicepkcsfilepath(String gsservicepkcsfilepath )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByGsservicepkcsfilepath = " DELETE FROM application WHERE gsservicepkcsfilepath = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByGsservicepkcsfilepath );
			preparedStatement.setString(1,gsservicepkcsfilepath); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByGooglerepositorypath(String googlerepositorypath )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByGooglerepositorypath = " DELETE FROM application WHERE googlerepositorypath = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByGooglerepositorypath );
			preparedStatement.setString(1,googlerepositorypath); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
}
