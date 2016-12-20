package org.sap.birlatyres.core.gen.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import org.sap.birlatyres.core.gen.bean.*;
import org.sap.birlatyres.core.db.*;

import java.sql.Timestamp;
import java.sql.Types;

public class DepartmentmasterDAO {
	private Connection connection ; 
	public DepartmentmasterDAO() {
		
		try {	
			
			connection = DatabaseHandler.getNewInstance().getConnection();
			
		} catch (Exception e) {		
			e.printStackTrace();
		}
	}
	public DepartmentmasterBean[] findAll()throws Exception{
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DepartmentmasterBean[] beans = null ;
		ArrayList<DepartmentmasterBean> beansList = new ArrayList<DepartmentmasterBean>();
		String sqlSelectByAll = " SELECT  companycode  , departmentcode , departmentname , departmenthead , functionalarea , location FROM departmentmaster where activeyn = ? " ;
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByAll );
			preparedStatement.setString(1,"Y");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DepartmentmasterBean bean = new DepartmentmasterBean();
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setCompanycode( resultSet.getString("companycode"));
				bean.setDepartmentname( resultSet.getString("departmentname"));
				bean.setDepartmenthead( resultSet.getString("departmenthead"));
				bean.setFunctionalarea( resultSet.getString("functionalarea"));
				bean.setLocation( resultSet.getString("location"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DepartmentmasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DepartmentmasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return beans ;
	}
	
	
	public DepartmentmasterBean[] findAlldepartmentwise(String usercode)throws Exception{
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DepartmentmasterBean[] beans = null ;
		ArrayList<DepartmentmasterBean> beansList = new ArrayList<DepartmentmasterBean>();
		String sqlSelectByAll = " SELECT  companycode  , departmentcode , departmentname , departmenthead , functionalarea , location FROM departmentmaster where activeyn = ? and  departmentcode in (select groupcode from privilegeregister where usercode = '"+usercode+"');" ;
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByAll );
			preparedStatement.setString(1,"Y");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DepartmentmasterBean bean = new DepartmentmasterBean();
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setCompanycode( resultSet.getString("companycode"));
				bean.setDepartmentname( resultSet.getString("departmentname"));
				bean.setDepartmenthead( resultSet.getString("departmenthead"));
				bean.setFunctionalarea( resultSet.getString("functionalarea"));
				bean.setLocation( resultSet.getString("location"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DepartmentmasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DepartmentmasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return beans ;
	}
	
	
	public ArrayList<DepartmentmasterBean> findAllActiveDepartments()throws Exception{
		
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DepartmentmasterBean[] beans = null ;
		ArrayList<DepartmentmasterBean> beansList = new ArrayList<DepartmentmasterBean>();
		String sqlSelectByDepartmentcode = " SELECT  companycode  , departmentcode , departmentname , departmenthead , functionalarea , location FROM departmentmaster WHERE activeyn = ? " ;
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByDepartmentcode );
			preparedStatement.setString(1,"Y");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DepartmentmasterBean bean = new DepartmentmasterBean();
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setCompanycode( resultSet.getString("companycode"));
				bean.setDepartmentname( resultSet.getString("departmentname"));
				bean.setDepartmenthead( resultSet.getString("departmenthead"));
				bean.setFunctionalarea( resultSet.getString("functionalarea"));
				bean.setLocation( resultSet.getString("location"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DepartmentmasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DepartmentmasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ 
				preparedStatement.close();
			}catch(Exception ioe){
				throw new Exception("Unable to load Departments");
			}
		}
		return beansList ;
	}
	
	public ArrayList<DepartmentmasterBean> findAllInactiveDepartments()throws Exception{
		
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DepartmentmasterBean[] beans = null ;
		ArrayList<DepartmentmasterBean> beansList = new ArrayList<DepartmentmasterBean>();
		String sqlSelectByDepartmentcode = " SELECT  companycode  , departmentcode , departmentname , departmenthead , functionalarea , location FROM departmentmaster WHERE activeyn = ? " ;
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByDepartmentcode );
			preparedStatement.setString(1,"N");
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DepartmentmasterBean bean = new DepartmentmasterBean();
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setCompanycode( resultSet.getString("companycode"));
				bean.setDepartmentname( resultSet.getString("departmentname"));
				bean.setDepartmenthead( resultSet.getString("departmenthead"));
				bean.setFunctionalarea( resultSet.getString("functionalarea"));
				bean.setLocation( resultSet.getString("location"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DepartmentmasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DepartmentmasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ 
				preparedStatement.close();
			}catch(Exception ioe){
				throw new Exception("Unable to load Departments");
			}
		}
		return beansList ;
	}
	
	public DepartmentmasterBean[] findByDepartmentcode(String departmentcode )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DepartmentmasterBean[] beans = null ;
		ArrayList<DepartmentmasterBean> beansList = new ArrayList<DepartmentmasterBean>();
		String sqlSelectByDepartmentcode = " SELECT  companycode  , departmentcode , departmentname , departmenthead , functionalarea , location FROM departmentmaster WHERE departmentcode = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByDepartmentcode );
			preparedStatement.setString(1,departmentcode); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DepartmentmasterBean bean = new DepartmentmasterBean();
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setCompanycode( resultSet.getString("companycode"));
				bean.setDepartmentname( resultSet.getString("departmentname"));
				bean.setDepartmenthead( resultSet.getString("departmenthead"));
				bean.setFunctionalarea( resultSet.getString("functionalarea"));
				bean.setLocation( resultSet.getString("location"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DepartmentmasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DepartmentmasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public DepartmentmasterBean[] findByCompanycode(String companycode )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DepartmentmasterBean[] beans = null ;
		ArrayList<DepartmentmasterBean> beansList = new ArrayList<DepartmentmasterBean>();
		String sqlSelectByCompanycode = " SELECT  companycode  , departmentcode , departmentname , departmenthead , functionalarea , location FROM departmentmaster WHERE companycode = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByCompanycode );
			preparedStatement.setString(1,companycode); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DepartmentmasterBean bean = new DepartmentmasterBean();
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setCompanycode( resultSet.getString("companycode"));
				bean.setDepartmentname( resultSet.getString("departmentname"));
				bean.setDepartmenthead( resultSet.getString("departmenthead"));
				bean.setFunctionalarea( resultSet.getString("functionalarea"));
				bean.setLocation( resultSet.getString("location"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DepartmentmasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DepartmentmasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public DepartmentmasterBean[] findByDepartmentname(String departmentname )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DepartmentmasterBean[] beans = null ;
		ArrayList<DepartmentmasterBean> beansList = new ArrayList<DepartmentmasterBean>();
		String sqlSelectByDepartmentname = " SELECT  companycode  , departmentcode , departmentname , departmenthead , functionalarea , location FROM departmentmaster WHERE departmentname = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByDepartmentname );
			preparedStatement.setString(1,departmentname); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DepartmentmasterBean bean = new DepartmentmasterBean();
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setCompanycode( resultSet.getString("companycode"));
				bean.setDepartmentname( resultSet.getString("departmentname"));
				bean.setDepartmenthead( resultSet.getString("departmenthead"));
				bean.setFunctionalarea( resultSet.getString("functionalarea"));
				bean.setLocation( resultSet.getString("location"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DepartmentmasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DepartmentmasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public DepartmentmasterBean[] findByDepartmenthead(String departmenthead )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DepartmentmasterBean[] beans = null ;
		ArrayList<DepartmentmasterBean> beansList = new ArrayList<DepartmentmasterBean>();
		String sqlSelectByDepartmenthead = " SELECT  companycode  , departmentcode , departmentname , departmenthead , functionalarea , location FROM departmentmaster WHERE departmenthead = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByDepartmenthead );
			preparedStatement.setString(1,departmenthead); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DepartmentmasterBean bean = new DepartmentmasterBean();
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setCompanycode( resultSet.getString("companycode"));
				bean.setDepartmentname( resultSet.getString("departmentname"));
				bean.setDepartmenthead( resultSet.getString("departmenthead"));
				bean.setFunctionalarea( resultSet.getString("functionalarea"));
				bean.setLocation( resultSet.getString("location"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DepartmentmasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DepartmentmasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public DepartmentmasterBean[] findByFunctionalarea(String functionalarea )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DepartmentmasterBean[] beans = null ;
		ArrayList<DepartmentmasterBean> beansList = new ArrayList<DepartmentmasterBean>();
		String sqlSelectByFunctionalarea = " SELECT  companycode  , departmentcode , departmentname , departmenthead , functionalarea , location FROM departmentmaster WHERE functionalarea = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByFunctionalarea );
			preparedStatement.setString(1,functionalarea); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DepartmentmasterBean bean = new DepartmentmasterBean();
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setCompanycode( resultSet.getString("companycode"));
				bean.setDepartmentname( resultSet.getString("departmentname"));
				bean.setDepartmenthead( resultSet.getString("departmenthead"));
				bean.setFunctionalarea( resultSet.getString("functionalarea"));
				bean.setLocation( resultSet.getString("location"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DepartmentmasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DepartmentmasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public DepartmentmasterBean[] findByLocation(String location )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DepartmentmasterBean[] beans = null ;
		ArrayList<DepartmentmasterBean> beansList = new ArrayList<DepartmentmasterBean>();
		String sqlSelectByLocation = " SELECT  companycode  , departmentcode , departmentname , departmenthead , functionalarea , location FROM departmentmaster WHERE location = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByLocation );
			preparedStatement.setString(1,location); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DepartmentmasterBean bean = new DepartmentmasterBean();
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setCompanycode( resultSet.getString("companycode"));
				bean.setDepartmentname( resultSet.getString("departmentname"));
				bean.setDepartmenthead( resultSet.getString("departmenthead"));
				bean.setFunctionalarea( resultSet.getString("functionalarea"));
				bean.setLocation( resultSet.getString("location"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DepartmentmasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DepartmentmasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	
	public void insertAllColsForDepartmentAndGroup( DepartmentmasterBean bean )throws Exception{
		
		try{
			
			insertDeptColsInTransaction(bean);
			
			RolemasterBean rolemasterBean = new RolemasterBean();
			
			rolemasterBean.groupcode = bean.departmentcode;
			rolemasterBean.groupname = bean.departmentname;
			rolemasterBean.isactive  = "Y" ;
			
			insertRolesColsInTransaction(rolemasterBean);
			
			connection.commit() ;
			
		}catch(Exception e){
			
			connection.rollback();
			e.printStackTrace();
			throw new Exception(e.getMessage());
			
		}	
		
	}
	
	public void insertRolesColsInTransaction( RolemasterBean bean )throws Exception{
		PreparedStatement preparedStatement = null ;
		String sqlInsertAllStmt = "INSERT INTO rolemaster  (groupcode  , groupname , isactive) VALUES ( ?  , ?  , ? )" ;
		try{
			preparedStatement = connection.prepareStatement( sqlInsertAllStmt );
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
			
		}catch(Exception e){
			
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
		if(preparedStatement != null) { preparedStatement.close() ;}
		}
	}
	
	public void insertDeptColsInTransaction( DepartmentmasterBean bean )throws Exception{
		PreparedStatement preparedStatement = null ;
		String sqlInsertAllStmt = "INSERT INTO departmentmaster  (departmentcode, companycode , departmentname , departmenthead , functionalarea , location) VALUES ( ?  , ?  , ?  , ?  , ?  , ? )" ;
		try{
			preparedStatement = connection.prepareStatement( sqlInsertAllStmt );
			preparedStatement.setString(1, bean.getDepartmentcode());
			if(bean.getCompanycode()!= null){
				preparedStatement.setString(2, bean.getCompanycode());
			}else{
				preparedStatement.setNull(2,Types.VARCHAR) ;
			}
			if(bean.getDepartmentname()!= null){
				preparedStatement.setString(3, bean.getDepartmentname());
			}else{
				preparedStatement.setNull(3,Types.VARCHAR) ;
			}
			if(bean.getDepartmenthead()!= null){
				preparedStatement.setString(4, bean.getDepartmenthead());
			}else{
				preparedStatement.setNull(4,Types.VARCHAR) ;
			}
			if(bean.getFunctionalarea()!= null){
				preparedStatement.setString(5, bean.getFunctionalarea());
			}else{
				preparedStatement.setNull(5,Types.VARCHAR) ;
			}
			if(bean.getLocation()!= null){
				preparedStatement.setString(6, bean.getLocation());
			}else{
				preparedStatement.setNull(6,Types.VARCHAR) ;
			}
			preparedStatement.executeUpdate();
			
		}catch(Exception e){
			
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
		if(preparedStatement != null) { preparedStatement.close() ;}
		}
	}
	
	/////////////////////////////////////////////////////////////////////
	public void updateAllColsForDepartmentAndGroup( DepartmentmasterBean bean )throws Exception{
		
		try{
			
			updateDeptColsInTransaction(bean);
			
			deleteRoleByRoleCode(bean.departmentcode);
			
			RolemasterBean rolemasterBean = new RolemasterBean();
			
			rolemasterBean.groupcode = bean.departmentcode;
			rolemasterBean.groupname = bean.departmentname;
			rolemasterBean.isactive  = "Y" ;
			
			insertRolesColsInTransaction(rolemasterBean);
			
			connection.commit() ;
			
		}catch(Exception e){
			
			connection.rollback();
			e.printStackTrace();
			throw new Exception(e.getMessage());
			
		}	
		
	}
	
	public void updateDeptColsInTransaction( DepartmentmasterBean bean )throws Exception{
		
		PreparedStatement preparedStatement = null ;
		
		String sqlUpdateAllStmt = "UPDATE departmentmaster SET   companycode = ?  , departmentname = ?  , departmenthead = ?  , functionalarea = ?  , location = ?   WHERE  departmentcode = ? " ;
		
		try{
			preparedStatement = connection.prepareStatement( sqlUpdateAllStmt );
			if(bean.getCompanycode()!= null){
				preparedStatement.setString(1, bean.getCompanycode());
			}else{
				preparedStatement.setNull(1,Types.VARCHAR) ;
			}
			if(bean.getDepartmentname()!= null){
				preparedStatement.setString(2, bean.getDepartmentname());
			}else{
				preparedStatement.setNull(2,Types.VARCHAR) ;
			}
			if(bean.getDepartmenthead()!= null){
				preparedStatement.setString(3, bean.getDepartmenthead());
			}else{
				preparedStatement.setNull(3,Types.VARCHAR) ;
			}
			if(bean.getFunctionalarea()!= null){
				preparedStatement.setString(4, bean.getFunctionalarea());
			}else{
				preparedStatement.setNull(4,Types.VARCHAR) ;
			}
			if(bean.getLocation()!= null){
				preparedStatement.setString(5, bean.getLocation());
			}else{
				preparedStatement.setNull(5,Types.VARCHAR) ;
			}
			preparedStatement.setString(6, bean.getDepartmentcode());
			
			preparedStatement.executeUpdate();
			
		}catch(Exception e){
			
			e.printStackTrace();
			throw new Exception(e.getMessage());
			
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException ioe) {
			}
		}
	}
	
	public void deleteRoleByRoleCode( String roleCode )throws Exception{
		
		String sqlDeleteAll = "DELETE FROM rolemaster WHERE  groupcode = ?  " ;
		
		PreparedStatement preparedStatement = null ;
		try{
			preparedStatement = connection.prepareStatement( sqlDeleteAll );
			preparedStatement.setString(1, roleCode);
			preparedStatement.executeUpdate();
			
		}catch(Exception e){
			
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException ioe) {
			}
		}
	}
	
	////////////////////////////////////////////////////////////////////
	public void insertAllCols( DepartmentmasterBean bean )throws Exception{
		PreparedStatement preparedStatement = null ;
		String sqlInsertAllStmt = "INSERT INTO departmentmaster  (companycode  , departmentcode , departmentname , departmenthead , functionalarea , location) VALUES ( ?  , ?  , ?  , ?  , ?  , ? )" ;
		try{
			preparedStatement = connection.prepareStatement( sqlInsertAllStmt );
			preparedStatement.setString(1, bean.getDepartmentcode());
			if(bean.getCompanycode()!= null){
				preparedStatement.setString(2, bean.getCompanycode());
			}else{
				preparedStatement.setNull(2,Types.VARCHAR) ;
			}
			if(bean.getDepartmentname()!= null){
				preparedStatement.setString(3, bean.getDepartmentname());
			}else{
				preparedStatement.setNull(3,Types.VARCHAR) ;
			}
			if(bean.getDepartmenthead()!= null){
				preparedStatement.setString(4, bean.getDepartmenthead());
			}else{
				preparedStatement.setNull(4,Types.VARCHAR) ;
			}
			if(bean.getFunctionalarea()!= null){
				preparedStatement.setString(5, bean.getFunctionalarea());
			}else{
				preparedStatement.setNull(5,Types.VARCHAR) ;
			}
			if(bean.getLocation()!= null){
				preparedStatement.setString(6, bean.getLocation());
			}else{
				preparedStatement.setNull(6,Types.VARCHAR) ;
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
	public void updateAllCols( DepartmentmasterBean bean )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlUpdateAllStmt = "UPDATE departmentmaster SET   companycode = ?  , departmentname = ?  , departmenthead = ?  , functionalarea = ?  , location = ?   WHERE  departmentcode = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlUpdateAllStmt );
			if(bean.getCompanycode()!= null){
				preparedStatement.setString(1, bean.getCompanycode());
			}else{
				preparedStatement.setNull(1,Types.VARCHAR) ;
			}
			if(bean.getDepartmentname()!= null){
				preparedStatement.setString(2, bean.getDepartmentname());
			}else{
				preparedStatement.setNull(2,Types.VARCHAR) ;
			}
			if(bean.getDepartmenthead()!= null){
				preparedStatement.setString(3, bean.getDepartmenthead());
			}else{
				preparedStatement.setNull(3,Types.VARCHAR) ;
			}
			if(bean.getFunctionalarea()!= null){
				preparedStatement.setString(4, bean.getFunctionalarea());
			}else{
				preparedStatement.setNull(4,Types.VARCHAR) ;
			}
			if(bean.getLocation()!= null){
				preparedStatement.setString(5, bean.getLocation());
			}else{
				preparedStatement.setNull(5,Types.VARCHAR) ;
			}
			preparedStatement.setString(6, bean.getDepartmentcode());
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
	public void deleteAllByPK( DepartmentmasterBean bean )throws Exception{
		String sqlDeleteAll = "DELETE FROM departmentmaster WHERE  departmentcode = ?  " ;
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteAll );
			preparedStatement.setString(1, bean.getDepartmentcode());
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
	public void deleteByCompanycode(String companycode )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByCompanycode = " DELETE FROM departmentmaster WHERE companycode = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByCompanycode );
			preparedStatement.setString(1,companycode); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByDepartmentname(String departmentname )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByDepartmentname = " DELETE FROM departmentmaster WHERE departmentname = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByDepartmentname );
			preparedStatement.setString(1,departmentname); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByDepartmenthead(String departmenthead )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByDepartmenthead = " DELETE FROM departmentmaster WHERE departmenthead = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByDepartmenthead );
			preparedStatement.setString(1,departmenthead); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByFunctionalarea(String functionalarea )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByFunctionalarea = " DELETE FROM departmentmaster WHERE functionalarea = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByFunctionalarea );
			preparedStatement.setString(1,functionalarea); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByLocation(String location )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByLocation = " DELETE FROM departmentmaster WHERE location = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByLocation );
			preparedStatement.setString(1,location); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void updateDeleteStatusForDepartments(List<DepartmentmasterBean> selectedDepartments, String deleteStatus)throws Exception{
		
		try{
			
			for(DepartmentmasterBean departmentBean : selectedDepartments){ 
				
				updateDeleteStatusForDepartmentAndGroup(departmentBean,deleteStatus);
				
			}			
					
			connection.commit();
			
		} catch (Exception e) {
			
			connection.rollback();
			
			e.printStackTrace();
			
			throw new Exception(e.getMessage());		
		} 
	}
	
	public void updateDeleteStatusForDepartmentAndGroup( DepartmentmasterBean bean,String deleteStatus )throws Exception{
		
		try{
			
			updateDeleteStatusForDepartment(bean,deleteStatus);
			updateDeleteStatusForRolemaster(bean,deleteStatus);
			
			connection.commit() ;
			
		}catch(Exception e){
			
			connection.rollback();
			e.printStackTrace();
			throw new Exception(e.getMessage());
			
		}	
		
	}
	
	public void updateDeleteStatusForDepartment( DepartmentmasterBean bean,String deleteStatus)throws Exception{
		
		PreparedStatement preparedStatement = null ;
		
		String sqlUpdateAllStmt = "UPDATE departmentmaster SET   activeyn = ?   WHERE  departmentcode = ? " ;
		
		try{
			preparedStatement = connection.prepareStatement( sqlUpdateAllStmt );
			
			preparedStatement.setString(1, deleteStatus);
			preparedStatement.setString(2, bean.getDepartmentcode());
						
			preparedStatement.executeUpdate();
			
		}catch(Exception e){
			
			e.printStackTrace();
			throw new Exception(e.getMessage());
			
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException ioe) {
			}
		}
	}
	
	public void updateDeleteStatusForRolemaster( DepartmentmasterBean bean,String deleteStatus)throws Exception{
		
		PreparedStatement preparedStatement = null ;
		
		String sqlUpdateAllStmt = "UPDATE rolemaster SET   isactive = ?   WHERE  groupcode = ? " ;
		
		try{
			preparedStatement = connection.prepareStatement( sqlUpdateAllStmt );
						
			preparedStatement.setString(1,deleteStatus);
			preparedStatement.setString(2, bean.getDepartmentcode());
			
			preparedStatement.executeUpdate();
			
		}catch(Exception e){
			
			e.printStackTrace();
			throw new Exception(e.getMessage());
			
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException ioe) {
			}
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
