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
import java.math.BigDecimal;
import java.sql.Types;

public class UsermasterDAO {
	private Connection connection ; 
	public UsermasterDAO(){
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
	
	public UsermasterBean authenticateUser(String username , String password )throws Exception{
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		UsermasterBean bean = null ;
		String sqlSelectByCredentials = " SELECT  usercode  , usertype , username , password , companycode , employmentcode , accesslevel , emailid , contactmobile , contactphone , homedir , isactive, isadmin, viewallowed, uploadallowed, printallowed, downloadallowed FROM usermaster where username = ? and password = password(?) and isactive = ? " ;
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByCredentials);
			
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,password);
			preparedStatement.setString(3,"Y");
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				bean = new UsermasterBean();
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setUsertype( resultSet.getString("usertype"));
				bean.setUsername( resultSet.getString("username"));
				bean.setPassword( resultSet.getString("password"));
				bean.setCompanycode( resultSet.getInt("companycode"));
				bean.setEmploymentcode( resultSet.getString("employmentcode"));
				bean.setAccesslevel( resultSet.getInt("accesslevel"));
				bean.setEmailid( resultSet.getString("emailid"));
				bean.setContactmobile( resultSet.getString("contactmobile"));
				bean.setContactphone( resultSet.getString("contactphone"));
				bean.setHomedir( resultSet.getString("homedir"));
				bean.setIsactive( resultSet.getString("isactive"));
				bean.setIsadmin( resultSet.getString("isadmin"));
				bean.setViewallowed(resultSet.getString("viewallowed"));
				bean.setUploadallowed(resultSet.getString("uploadallowed"));
				bean.setPrintallowed(resultSet.getString("printallowed"));
				bean.setDownloadallowed(resultSet.getString("downloadallowed"));
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return bean ;
	}
	
	public ArrayList<UsermasterBean> findAllActiveUsers( )throws Exception{
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		UsermasterBean[] beans = null ;
		ArrayList<UsermasterBean> beansList = new ArrayList<UsermasterBean>();
		String sqlSelectByAll = " SELECT  usercode  , usertype , username , password , companycode , employmentcode , accesslevel , emailid , contactmobile , contactphone , homedir , isactive FROM usermaster where isactive = ? " ;
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByAll );
			
			preparedStatement.setString(1,"Y");
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				UsermasterBean bean = new UsermasterBean();
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setUsertype( resultSet.getString("usertype"));
				bean.setUsername( resultSet.getString("username"));
				bean.setPassword( resultSet.getString("password"));
				bean.setCompanycode( resultSet.getInt("companycode"));
				bean.setEmploymentcode( resultSet.getString("employmentcode"));
				bean.setAccesslevel( resultSet.getInt("accesslevel"));
				bean.setEmailid( resultSet.getString("emailid"));
				bean.setContactmobile( resultSet.getString("contactmobile"));
				bean.setContactphone( resultSet.getString("contactphone"));
				bean.setHomedir( resultSet.getString("homedir"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new UsermasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (UsermasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return beansList ;
	}
	
	
	
	public ArrayList<UsermasterBean> findAllActiveUsersDepartmentwise(String departmentcode)throws Exception{
		
		
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		UsermasterBean[] beans = null ;
		ArrayList<UsermasterBean> beansList = new ArrayList<UsermasterBean>();
		//String sqlSelectByAll = " SELECT  usercode  , usertype , username , password , companycode , employmentcode , accesslevel , emailid , contactmobile , contactphone , homedir , isactive FROM usermaster where isactive = ? " ;
		
		String sqlSelectByAll = "select usercode from privilegeregister where groupcode = ?";
		
		
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByAll );
			
			preparedStatement.setString(1,departmentcode);
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				UsermasterBean bean = new UsermasterBean();
				bean.setUsercode( resultSet.getString("usercode"));
				/*bean.setUsertype( resultSet.getString("usertype"));
				bean.setUsername( resultSet.getString("username"));
				bean.setPassword( resultSet.getString("password"));
				bean.setCompanycode( resultSet.getInt("companycode"));
				bean.setEmploymentcode( resultSet.getString("employmentcode"));
				bean.setAccesslevel( resultSet.getInt("accesslevel"));
				bean.setEmailid( resultSet.getString("emailid"));
				bean.setContactmobile( resultSet.getString("contactmobile"));
				bean.setContactphone( resultSet.getString("contactphone"));
				bean.setHomedir( resultSet.getString("homedir"));
				bean.setIsactive( resultSet.getString("isactive"));*/
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new UsermasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (UsermasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return beansList ;
	}
	
	
	
	public ArrayList<UsermasterBean> AAAAAAAfindAllActiveUsersdepartmentWise(String usercode )throws Exception{
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		UsermasterBean[] beans = null ;
		ArrayList<UsermasterBean> beansList = new ArrayList<UsermasterBean>();
		String sqlSelectByAll = " SELECT  usercode  , usertype , username , password , companycode , employmentcode , accesslevel , emailid , contactmobile , contactphone , homedir , isactive FROM usermaster where usertype = (select privilegeregister.groupcode from privilegeregister where privilegeregister.usercode = '"+ usercode +"') and isactive = ? " ;
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByAll );
			
			preparedStatement.setString(1,"Y");
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				UsermasterBean bean = new UsermasterBean();
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setUsertype( resultSet.getString("usertype"));
				bean.setUsername( resultSet.getString("username"));
				bean.setPassword( resultSet.getString("password"));
				bean.setCompanycode( resultSet.getInt("companycode"));
				bean.setEmploymentcode( resultSet.getString("employmentcode"));
				bean.setAccesslevel( resultSet.getInt("accesslevel"));
				bean.setEmailid( resultSet.getString("emailid"));
				bean.setContactmobile( resultSet.getString("contactmobile"));
				bean.setContactphone( resultSet.getString("contactphone"));
				bean.setHomedir( resultSet.getString("homedir"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new UsermasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (UsermasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return beansList ;
	}
	
	
	
	
	public ArrayList<UsermasterBean> findAllInactiveUsers( )throws Exception{
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		UsermasterBean[] beans = null ;
		ArrayList<UsermasterBean> beansList = new ArrayList<UsermasterBean>();
		String sqlSelectByAll = " SELECT  usercode  , usertype , username , password , companycode , employmentcode , accesslevel , emailid , contactmobile , contactphone , homedir , isactive FROM usermaster where isactive = ? " ;
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByAll );
			
			preparedStatement.setString(1,"N");
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				UsermasterBean bean = new UsermasterBean();
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setUsertype( resultSet.getString("usertype"));
				bean.setUsername( resultSet.getString("username"));
				bean.setPassword( resultSet.getString("password"));
				bean.setCompanycode( resultSet.getInt("companycode"));
				bean.setEmploymentcode( resultSet.getString("employmentcode"));
				bean.setAccesslevel( resultSet.getInt("accesslevel"));
				bean.setEmailid( resultSet.getString("emailid"));
				bean.setContactmobile( resultSet.getString("contactmobile"));
				bean.setContactphone( resultSet.getString("contactphone"));
				bean.setHomedir( resultSet.getString("homedir"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new UsermasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (UsermasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return beansList ;
	}
	
	public UsermasterBean[] findAll( )throws Exception{
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		UsermasterBean[] beans = null ;
		ArrayList<UsermasterBean> beansList = new ArrayList<UsermasterBean>();
		String sqlSelectByAll = " SELECT  usercode  , usertype , username , password , companycode , employmentcode , accesslevel , emailid ,employeedesignation, contactmobile , contactphone , homedir , isactive,viewallowed , printallowed, downloadallowed, uploadallowed,employeerank FROM usermaster where isactive = ? " ;
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByAll );
			
			preparedStatement.setString(1,"Y");
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				UsermasterBean bean = new UsermasterBean();
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setUsertype( resultSet.getString("usertype"));
				bean.setUsername( resultSet.getString("username"));
				bean.setPassword( resultSet.getString("password"));
				bean.setCompanycode( resultSet.getInt("companycode"));
				bean.setEmploymentcode( resultSet.getString("employmentcode"));
				bean.setAccesslevel( resultSet.getInt("accesslevel"));
				bean.setEmailid( resultSet.getString("emailid"));
				bean.setDesignation(resultSet.getString("employeedesignation"));
				bean.setContactmobile( resultSet.getString("contactmobile"));
				bean.setContactphone( resultSet.getString("contactphone"));
				bean.setHomedir( resultSet.getString("homedir"));
				bean.setIsactive( resultSet.getString("isactive"));
				bean.setViewallowed(resultSet.getString("viewallowed"));
				bean.setPrintallowed(resultSet.getString("printallowed"));
				bean.setDownloadallowed(resultSet.getString("downloadallowed"));
				bean.setUploadallowed(resultSet.getString("uploadallowed"));
				bean.setRank(resultSet.getInt("employeerank"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new UsermasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (UsermasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return beans ;
	}
	public UsermasterBean[] findByUsercode(String usercode )throws Exception{
		
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		UsermasterBean[] beans = null ;
		ArrayList<UsermasterBean> beansList = new ArrayList<UsermasterBean>();
		String sqlSelectByUsercode = " SELECT  usercode  , usertype , username , password , companycode , employmentcode , accesslevel , emailid , contactmobile , contactphone , homedir , isactive FROM usermaster WHERE usercode = ? " ;
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByUsercode );
			preparedStatement.setString(1,usercode); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				UsermasterBean bean = new UsermasterBean();
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setUsertype( resultSet.getString("usertype"));
				bean.setUsername( resultSet.getString("username"));
				bean.setPassword( resultSet.getString("password"));
				bean.setCompanycode( resultSet.getInt("companycode"));
				bean.setEmploymentcode( resultSet.getString("employmentcode"));
				bean.setAccesslevel( resultSet.getInt("accesslevel"));
				bean.setEmailid( resultSet.getString("emailid"));
				bean.setContactmobile( resultSet.getString("contactmobile"));
				bean.setContactphone( resultSet.getString("contactphone"));
				bean.setHomedir( resultSet.getString("homedir"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new UsermasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (UsermasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally{
			try{
				
				preparedStatement.close();
				
			}catch(SQLException ioe){
				
			}
		}
		return beans ;
	}
	public UsermasterBean[] findByUsertype(String usertype )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		UsermasterBean[] beans = null ;
		ArrayList<UsermasterBean> beansList = new ArrayList<UsermasterBean>();
		String sqlSelectByUsertype = " SELECT  usercode  , usertype , username , password , companycode , employmentcode , accesslevel , emailid , contactmobile , contactphone , homedir , isactive FROM usermaster WHERE usertype = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByUsertype );
			preparedStatement.setString(1,usertype); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				UsermasterBean bean = new UsermasterBean();
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setUsertype( resultSet.getString("usertype"));
				bean.setUsername( resultSet.getString("username"));
				bean.setPassword( resultSet.getString("password"));
				bean.setCompanycode( resultSet.getInt("companycode"));
				bean.setEmploymentcode( resultSet.getString("employmentcode"));
				bean.setAccesslevel( resultSet.getInt("accesslevel"));
				bean.setEmailid( resultSet.getString("emailid"));
				bean.setContactmobile( resultSet.getString("contactmobile"));
				bean.setContactphone( resultSet.getString("contactphone"));
				bean.setHomedir( resultSet.getString("homedir"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new UsermasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (UsermasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public UsermasterBean[] findByUsername(String username )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		UsermasterBean[] beans = null ;
		ArrayList<UsermasterBean> beansList = new ArrayList<UsermasterBean>();
		String sqlSelectByUsername = " SELECT  usercode  , usertype , username , password , companycode , employmentcode , accesslevel , emailid , contactmobile , contactphone , homedir , isactive FROM usermaster WHERE username = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByUsername );
			preparedStatement.setString(1,username); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				UsermasterBean bean = new UsermasterBean();
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setUsertype( resultSet.getString("usertype"));
				bean.setUsername( resultSet.getString("username"));
				bean.setPassword( resultSet.getString("password"));
				bean.setCompanycode( resultSet.getInt("companycode"));
				bean.setEmploymentcode( resultSet.getString("employmentcode"));
				bean.setAccesslevel( resultSet.getInt("accesslevel"));
				bean.setEmailid( resultSet.getString("emailid"));
				bean.setContactmobile( resultSet.getString("contactmobile"));
				bean.setContactphone( resultSet.getString("contactphone"));
				bean.setHomedir( resultSet.getString("homedir"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new UsermasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (UsermasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public UsermasterBean[] findByPassword(String password )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		UsermasterBean[] beans = null ;
		ArrayList<UsermasterBean> beansList = new ArrayList<UsermasterBean>();
		String sqlSelectByPassword = " SELECT  usercode  , usertype , username , password , companycode , employmentcode , accesslevel , emailid , contactmobile , contactphone , homedir , isactive FROM usermaster WHERE password = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByPassword );
			preparedStatement.setString(1,password); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				UsermasterBean bean = new UsermasterBean();
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setUsertype( resultSet.getString("usertype"));
				bean.setUsername( resultSet.getString("username"));
				bean.setPassword( resultSet.getString("password"));
				bean.setCompanycode( resultSet.getInt("companycode"));
				bean.setEmploymentcode( resultSet.getString("employmentcode"));
				bean.setAccesslevel( resultSet.getInt("accesslevel"));
				bean.setEmailid( resultSet.getString("emailid"));
				bean.setContactmobile( resultSet.getString("contactmobile"));
				bean.setContactphone( resultSet.getString("contactphone"));
				bean.setHomedir( resultSet.getString("homedir"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new UsermasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (UsermasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public UsermasterBean[] findByCompanycode(int companycode )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		UsermasterBean[] beans = null ;
		ArrayList<UsermasterBean> beansList = new ArrayList<UsermasterBean>();
		String sqlSelectByCompanycode = " SELECT  usercode  , usertype , username , password , companycode , employmentcode , accesslevel , emailid , contactmobile , contactphone , homedir , isactive FROM usermaster WHERE companycode = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByCompanycode );
			preparedStatement.setInt(1,companycode); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				UsermasterBean bean = new UsermasterBean();
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setUsertype( resultSet.getString("usertype"));
				bean.setUsername( resultSet.getString("username"));
				bean.setPassword( resultSet.getString("password"));
				bean.setCompanycode( resultSet.getInt("companycode"));
				bean.setEmploymentcode( resultSet.getString("employmentcode"));
				bean.setAccesslevel( resultSet.getInt("accesslevel"));
				bean.setEmailid( resultSet.getString("emailid"));
				bean.setContactmobile( resultSet.getString("contactmobile"));
				bean.setContactphone( resultSet.getString("contactphone"));
				bean.setHomedir( resultSet.getString("homedir"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new UsermasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (UsermasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public UsermasterBean[] findByEmploymentcode(String employmentcode )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		UsermasterBean[] beans = null ;
		ArrayList<UsermasterBean> beansList = new ArrayList<UsermasterBean>();
		String sqlSelectByEmploymentcode = " SELECT  usercode  , usertype , username , password , companycode , employmentcode , accesslevel , emailid , contactmobile , contactphone , homedir , isactive FROM usermaster WHERE employmentcode = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByEmploymentcode );
			preparedStatement.setString(1,employmentcode); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				UsermasterBean bean = new UsermasterBean();
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setUsertype( resultSet.getString("usertype"));
				bean.setUsername( resultSet.getString("username"));
				bean.setPassword( resultSet.getString("password"));
				bean.setCompanycode( resultSet.getInt("companycode"));
				bean.setEmploymentcode( resultSet.getString("employmentcode"));
				bean.setAccesslevel( resultSet.getInt("accesslevel"));
				bean.setEmailid( resultSet.getString("emailid"));
				bean.setContactmobile( resultSet.getString("contactmobile"));
				bean.setContactphone( resultSet.getString("contactphone"));
				bean.setHomedir( resultSet.getString("homedir"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new UsermasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (UsermasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public UsermasterBean[] findByAccesslevel(int accesslevel )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		UsermasterBean[] beans = null ;
		ArrayList<UsermasterBean> beansList = new ArrayList<UsermasterBean>();
		String sqlSelectByAccesslevel = " SELECT  usercode  , usertype , username , password , companycode , employmentcode , accesslevel , emailid , contactmobile , contactphone , homedir , isactive FROM usermaster WHERE accesslevel = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByAccesslevel );
			preparedStatement.setInt(1,accesslevel); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				UsermasterBean bean = new UsermasterBean();
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setUsertype( resultSet.getString("usertype"));
				bean.setUsername( resultSet.getString("username"));
				bean.setPassword( resultSet.getString("password"));
				bean.setCompanycode( resultSet.getInt("companycode"));
				bean.setEmploymentcode( resultSet.getString("employmentcode"));
				bean.setAccesslevel( resultSet.getInt("accesslevel"));
				bean.setEmailid( resultSet.getString("emailid"));
				bean.setContactmobile( resultSet.getString("contactmobile"));
				bean.setContactphone( resultSet.getString("contactphone"));
				bean.setHomedir( resultSet.getString("homedir"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new UsermasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (UsermasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public UsermasterBean[] findByEmailid(String emailid )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		UsermasterBean[] beans = null ;
		ArrayList<UsermasterBean> beansList = new ArrayList<UsermasterBean>();
		String sqlSelectByEmailid = " SELECT  usercode  , usertype , username , password , companycode , employmentcode , accesslevel , emailid , contactmobile , contactphone , homedir , isactive FROM usermaster WHERE emailid = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByEmailid );
			preparedStatement.setString(1,emailid); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				UsermasterBean bean = new UsermasterBean();
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setUsertype( resultSet.getString("usertype"));
				bean.setUsername( resultSet.getString("username"));
				bean.setPassword( resultSet.getString("password"));
				bean.setCompanycode( resultSet.getInt("companycode"));
				bean.setEmploymentcode( resultSet.getString("employmentcode"));
				bean.setAccesslevel( resultSet.getInt("accesslevel"));
				bean.setEmailid( resultSet.getString("emailid"));
				bean.setContactmobile( resultSet.getString("contactmobile"));
				bean.setContactphone( resultSet.getString("contactphone"));
				bean.setHomedir( resultSet.getString("homedir"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new UsermasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (UsermasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public UsermasterBean[] findByContactmobile(String contactmobile )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		UsermasterBean[] beans = null ;
		ArrayList<UsermasterBean> beansList = new ArrayList<UsermasterBean>();
		String sqlSelectByContactmobile = " SELECT  usercode  , usertype , username , password , companycode , employmentcode , accesslevel , emailid , contactmobile , contactphone , homedir , isactive FROM usermaster WHERE contactmobile = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByContactmobile );
			preparedStatement.setString(1,contactmobile); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				UsermasterBean bean = new UsermasterBean();
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setUsertype( resultSet.getString("usertype"));
				bean.setUsername( resultSet.getString("username"));
				bean.setPassword( resultSet.getString("password"));
				bean.setCompanycode( resultSet.getInt("companycode"));
				bean.setEmploymentcode( resultSet.getString("employmentcode"));
				bean.setAccesslevel( resultSet.getInt("accesslevel"));
				bean.setEmailid( resultSet.getString("emailid"));
				bean.setContactmobile( resultSet.getString("contactmobile"));
				bean.setContactphone( resultSet.getString("contactphone"));
				bean.setHomedir( resultSet.getString("homedir"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new UsermasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (UsermasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public UsermasterBean[] findByContactphone(String contactphone )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		UsermasterBean[] beans = null ;
		ArrayList<UsermasterBean> beansList = new ArrayList<UsermasterBean>();
		String sqlSelectByContactphone = " SELECT  usercode  , usertype , username , password , companycode , employmentcode , accesslevel , emailid , contactmobile , contactphone , homedir , isactive FROM usermaster WHERE contactphone = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByContactphone );
			preparedStatement.setString(1,contactphone); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				UsermasterBean bean = new UsermasterBean();
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setUsertype( resultSet.getString("usertype"));
				bean.setUsername( resultSet.getString("username"));
				bean.setPassword( resultSet.getString("password"));
				bean.setCompanycode( resultSet.getInt("companycode"));
				bean.setEmploymentcode( resultSet.getString("employmentcode"));
				bean.setAccesslevel( resultSet.getInt("accesslevel"));
				bean.setEmailid( resultSet.getString("emailid"));
				bean.setContactmobile( resultSet.getString("contactmobile"));
				bean.setContactphone( resultSet.getString("contactphone"));
				bean.setHomedir( resultSet.getString("homedir"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new UsermasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (UsermasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public UsermasterBean[] findByHomedir(String homedir )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		UsermasterBean[] beans = null ;
		ArrayList<UsermasterBean> beansList = new ArrayList<UsermasterBean>();
		String sqlSelectByHomedir = " SELECT  usercode  , usertype , username , password , companycode , employmentcode , accesslevel , emailid , contactmobile , contactphone , homedir , isactive FROM usermaster WHERE homedir = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByHomedir );
			preparedStatement.setString(1,homedir); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				UsermasterBean bean = new UsermasterBean();
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setUsertype( resultSet.getString("usertype"));
				bean.setUsername( resultSet.getString("username"));
				bean.setPassword( resultSet.getString("password"));
				bean.setCompanycode( resultSet.getInt("companycode"));
				bean.setEmploymentcode( resultSet.getString("employmentcode"));
				bean.setAccesslevel( resultSet.getInt("accesslevel"));
				bean.setEmailid( resultSet.getString("emailid"));
				bean.setContactmobile( resultSet.getString("contactmobile"));
				bean.setContactphone( resultSet.getString("contactphone"));
				bean.setHomedir( resultSet.getString("homedir"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new UsermasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (UsermasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public UsermasterBean[] findByIsactive(String isactive )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		UsermasterBean[] beans = null ;
		ArrayList<UsermasterBean> beansList = new ArrayList<UsermasterBean>();
		String sqlSelectByIsactive = " SELECT  usercode  , usertype , username , password , companycode , employmentcode , accesslevel , emailid , contactmobile , contactphone , homedir , isactive FROM usermaster WHERE isactive = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByIsactive );
			preparedStatement.setString(1,isactive); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				UsermasterBean bean = new UsermasterBean();
				bean.setUsercode( resultSet.getString("usercode"));
				bean.setUsertype( resultSet.getString("usertype"));
				bean.setUsername( resultSet.getString("username"));
				bean.setPassword( resultSet.getString("password"));
				bean.setCompanycode( resultSet.getInt("companycode"));
				bean.setEmploymentcode( resultSet.getString("employmentcode"));
				bean.setAccesslevel( resultSet.getInt("accesslevel"));
				bean.setEmailid( resultSet.getString("emailid"));
				bean.setContactmobile( resultSet.getString("contactmobile"));
				bean.setContactphone( resultSet.getString("contactphone"));
				bean.setHomedir( resultSet.getString("homedir"));
				bean.setIsactive( resultSet.getString("isactive"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new UsermasterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (UsermasterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	
	
	
	public void insertUserAndPrivileges( UsermasterBean bean , String[] roles )throws Exception{
		
		try{
			
			insertConditionalUsers(bean);
			
			for(String role : roles){
				
				PrivilegeregisterBean privilegeregisterBean = new PrivilegeregisterBean();
				
				privilegeregisterBean.setUsercode(bean.usercode);
				
				privilegeregisterBean.setGroupcode(role);
				
				privilegeregisterBean.setIsactive("Y");
				
				insertPrivileges(privilegeregisterBean);
				
			}
			
			connection.commit();
			
		}catch(Exception e){
			
			connection.rollback() ;
			
			e.printStackTrace() ;
			
			throw new Exception("Operation failed due to " + e.getMessage());
			
		}		
	}	
	
	public void insertPrivileges( PrivilegeregisterBean bean )throws Exception{
		PreparedStatement preparedStatement = null ;
		String sqlInsertAllStmt = "INSERT INTO privilegeregister  (groupcode  , usercode , isactive) VALUES ( ?  , ?  , ? )" ;
		try{
			preparedStatement = connection.prepareStatement( sqlInsertAllStmt );
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
			
		}catch(Exception e){
			
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
		if(preparedStatement != null) { preparedStatement.close() ;}
		}
	}
	
	
	public void insertConditionalUsers( UsermasterBean bean )throws Exception{
		
		PreparedStatement preparedStatement = null ;
		
		String sqlInsertAllStmt = "INSERT INTO usermaster  (usercode  , usertype , username , password , companycode , employmentcode , accesslevel , emailid , contactmobile , contactphone , homedir , isactive,employeedesignation, employeerank, uploadallowed, downloadallowed, printallowed, viewallowed) VALUES ( ?  , ?  , ?  , password(?)  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ? , ? , ? , ?, ?, ?, ?)" ;
		try{
			preparedStatement = connection.prepareStatement( sqlInsertAllStmt );
			preparedStatement.setString(1, bean.getUsercode());
			if(bean.getUsertype()!= null){
				preparedStatement.setString(2, bean.getUsertype());
			}else{
				preparedStatement.setNull(2,Types.VARCHAR) ;
			}
			if(bean.getUsername()!= null){
				preparedStatement.setString(3, bean.getUsername());
			}else{
				preparedStatement.setNull(3,Types.VARCHAR) ;
			}
			if(bean.getPassword()!= null){
				preparedStatement.setString(4, bean.getPassword());
			}else{
				preparedStatement.setNull(4,Types.VARCHAR) ;
			}
			if(bean.getCompanycode()!= null){
				preparedStatement.setInt(5, bean.getCompanycode());
			}else{
				preparedStatement.setNull(5,Types.INTEGER) ;
			}
			if(bean.getEmploymentcode()!= null){
				preparedStatement.setString(6, bean.getEmploymentcode());
			}else{
				preparedStatement.setNull(6,Types.VARCHAR) ;
			}
			if(bean.getAccesslevel()!= null){
				preparedStatement.setInt(7, bean.getAccesslevel());
			}else{
				preparedStatement.setNull(7,Types.INTEGER) ;
			}
			if(bean.getEmailid()!= null){
				preparedStatement.setString(8, bean.getEmailid());
			}else{
				preparedStatement.setNull(8,Types.VARCHAR) ;
			}
			if(bean.getContactmobile()!= null){
				preparedStatement.setString(9, bean.getContactmobile());
			}else{
				preparedStatement.setNull(9,Types.VARCHAR) ;
			}
			if(bean.getContactphone()!= null){
				preparedStatement.setString(10, bean.getContactphone());
			}else{
				preparedStatement.setNull(10,Types.VARCHAR) ;
			}
			if(bean.getHomedir()!= null){
				preparedStatement.setString(11, bean.getHomedir());
			}else{
				preparedStatement.setNull(11,Types.VARCHAR) ;
			}
			if(bean.getIsactive()!= null){
				preparedStatement.setString(12, bean.getIsactive());
			}else{
				preparedStatement.setNull(12,Types.CHAR) ;
			}
			
			preparedStatement.setString(13, bean.getDesignation());
			
			preparedStatement.setInt(14, bean.getRank());
			
			preparedStatement.setString(15, bean.getUploadallowed());
			
			preparedStatement.setString(16, bean.getDownloadallowed());
			
			preparedStatement.setString(17, bean.getPrintallowed());
			
			preparedStatement.setString(18, bean.getViewallowed());
			
			
			preparedStatement.executeUpdate();
			
		}catch(Exception e){
			
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
		if(preparedStatement != null) { preparedStatement.close() ;}
		}
	}
	
	/////////////////////////////UPDATE/////////////////////////////////////////////////
	public void updateUserAndPrivileges( UsermasterBean bean , String[] roles )throws Exception{
		
		try{
			
			updateConditionalUsers(bean);
			
			deletePrivilegeByUsercode(bean.usercode); 
			
			for(String role : roles){
				
				PrivilegeregisterBean privilegeregisterBean = new PrivilegeregisterBean();
				
				privilegeregisterBean.setUsercode(bean.usercode);
				
				privilegeregisterBean.setGroupcode(role);
				
				privilegeregisterBean.setIsactive("Y");
				
				insertPrivileges(privilegeregisterBean);
				
			}
			
			connection.commit();
			
		}catch(Exception e){
			
			connection.rollback() ;
			
			e.printStackTrace() ;
			
			throw new Exception("Operation failed due to " + e.getMessage());
			
		}		
	}
	
	public void deletePrivilegeByUsercode(String usercode )throws Exception{
		
		PreparedStatement preparedStatement = null ;
		
		String sqlDeleteByUsercode = " DELETE FROM privilegeregister WHERE usercode = ? " ;
		
		try{
			preparedStatement = connection.prepareStatement( sqlDeleteByUsercode );
			preparedStatement.setString(1,usercode); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException ioe) {
			}
		}
	}
	
	public void updateConditionalUsers( UsermasterBean bean )throws Exception{
		
		PreparedStatement preparedStatement = null ;
		
		String sqlUpdateAllStmt = "UPDATE usermaster SET   usertype = ?  , username = ? , companycode = ?  , employmentcode = ?  , accesslevel = ?  , emailid = ?  , contactmobile = ?  , contactphone = ?  , homedir = ?  , isactive = ?, employeedesignation=?, employeerank=?,uploadallowed =?, downloadallowed = ?, viewallowed =?, printallowed = ?   WHERE  usercode = ? " ;
		
		try{
			
			preparedStatement = connection.prepareStatement( sqlUpdateAllStmt );
			
			if(bean.getUsertype()!= null){
				preparedStatement.setString(1, bean.getUsertype());
			}else{
				preparedStatement.setNull(1,Types.VARCHAR) ;
			}
			if(bean.getUsername()!= null){
				preparedStatement.setString(2, bean.getUsername());
			}else{
				preparedStatement.setNull(2,Types.VARCHAR) ;
			}
			
			if(bean.getCompanycode()!= null){
				preparedStatement.setInt(3, bean.getCompanycode());
			}else{
				preparedStatement.setNull(3,Types.INTEGER) ;
			}
			if(bean.getEmploymentcode()!= null){
				preparedStatement.setString(4, bean.getEmploymentcode());
			}else{
				preparedStatement.setNull(4,Types.VARCHAR) ;
			}
			if(bean.getAccesslevel()!= null){
				preparedStatement.setInt(5, bean.getAccesslevel());
			}else{
				preparedStatement.setNull(5,Types.INTEGER) ;
			}
			if(bean.getEmailid()!= null){
				preparedStatement.setString(6, bean.getEmailid());
			}else{
				preparedStatement.setNull(6,Types.VARCHAR) ;
			}
			if(bean.getContactmobile()!= null){
				preparedStatement.setString(7, bean.getContactmobile());
			}else{
				preparedStatement.setNull(7,Types.VARCHAR) ;
			}
			if(bean.getContactphone()!= null){
				preparedStatement.setString(8, bean.getContactphone());
			}else{
				preparedStatement.setNull(8,Types.VARCHAR) ;
			}
			if(bean.getHomedir()!= null){
				preparedStatement.setString(9, bean.getHomedir());
			}else{
				preparedStatement.setNull(9,Types.VARCHAR) ;
			}
			if(bean.getIsactive()!= null){
				preparedStatement.setString(10, bean.getIsactive());
			}else{
				preparedStatement.setNull(10,Types.CHAR) ;
			}
			
			preparedStatement.setString(11, bean.getDesignation());
			
			preparedStatement.setInt(12, bean.getRank());
			
			preparedStatement.setString(13, bean.getUploadallowed());
			
			preparedStatement.setString(14, bean.getDownloadallowed());
			
			preparedStatement.setString(15, bean.getViewallowed());
			
			preparedStatement.setString(16, bean.getPrintallowed());
			
			preparedStatement.setString(17, bean.getUsercode());
			
			preparedStatement.executeUpdate();
			
		}catch(Exception e){
			
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				preparedStatement.close();
			} catch (SQLException ioe) {
			}
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////
	public void insertAllCols( UsermasterBean bean )throws Exception{
		
		PreparedStatement preparedStatement = null ;
		
		String sqlInsertAllStmt = "INSERT INTO usermaster  (usercode  , usertype , username , password , companycode , employmentcode , accesslevel , emailid , contactmobile , contactphone , homedir , isactive) VALUES ( ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ? )" ;
		try{
			preparedStatement = connection.prepareStatement( sqlInsertAllStmt );
			preparedStatement.setString(1, bean.getUsercode());
			if(bean.getUsertype()!= null){
				preparedStatement.setString(2, bean.getUsertype());
			}else{
				preparedStatement.setNull(2,Types.VARCHAR) ;
			}
			if(bean.getUsername()!= null){
				preparedStatement.setString(3, bean.getUsername());
			}else{
				preparedStatement.setNull(3,Types.VARCHAR) ;
			}
			if(bean.getPassword()!= null){
				preparedStatement.setString(4, bean.getPassword());
			}else{
				preparedStatement.setNull(4,Types.VARCHAR) ;
			}
			if(bean.getCompanycode()!= null){
				preparedStatement.setInt(5, bean.getCompanycode());
			}else{
				preparedStatement.setNull(5,Types.INTEGER) ;
			}
			if(bean.getEmploymentcode()!= null){
				preparedStatement.setString(6, bean.getEmploymentcode());
			}else{
				preparedStatement.setNull(6,Types.VARCHAR) ;
			}
			if(bean.getAccesslevel()!= null){
				preparedStatement.setInt(7, bean.getAccesslevel());
			}else{
				preparedStatement.setNull(7,Types.INTEGER) ;
			}
			if(bean.getEmailid()!= null){
				preparedStatement.setString(8, bean.getEmailid());
			}else{
				preparedStatement.setNull(8,Types.VARCHAR) ;
			}
			if(bean.getContactmobile()!= null){
				preparedStatement.setString(9, bean.getContactmobile());
			}else{
				preparedStatement.setNull(9,Types.VARCHAR) ;
			}
			if(bean.getContactphone()!= null){
				preparedStatement.setString(10, bean.getContactphone());
			}else{
				preparedStatement.setNull(10,Types.VARCHAR) ;
			}
			if(bean.getHomedir()!= null){
				preparedStatement.setString(11, bean.getHomedir());
			}else{
				preparedStatement.setNull(11,Types.VARCHAR) ;
			}
			if(bean.getIsactive()!= null){
				preparedStatement.setString(12, bean.getIsactive());
			}else{
				preparedStatement.setNull(12,Types.CHAR) ;
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
	public void updateAllCols( UsermasterBean bean )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlUpdateAllStmt = "UPDATE usermaster SET   usertype = ?  , username = ?  , password = ?  , companycode = ?  , employmentcode = ?  , accesslevel = ?  , emailid = ?  , contactmobile = ?  , contactphone = ?  , homedir = ?  , isactive = ?   WHERE  usercode = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlUpdateAllStmt );
			if(bean.getUsertype()!= null){
				preparedStatement.setString(1, bean.getUsertype());
			}else{
				preparedStatement.setNull(1,Types.VARCHAR) ;
			}
			if(bean.getUsername()!= null){
				preparedStatement.setString(2, bean.getUsername());
			}else{
				preparedStatement.setNull(2,Types.VARCHAR) ;
			}
			if(bean.getPassword()!= null){
				preparedStatement.setString(3, bean.getPassword());
			}else{
				preparedStatement.setNull(3,Types.VARCHAR) ;
			}
			if(bean.getCompanycode()!= null){
				preparedStatement.setInt(4, bean.getCompanycode());
			}else{
				preparedStatement.setNull(4,Types.INTEGER) ;
			}
			if(bean.getEmploymentcode()!= null){
				preparedStatement.setString(5, bean.getEmploymentcode());
			}else{
				preparedStatement.setNull(5,Types.VARCHAR) ;
			}
			if(bean.getAccesslevel()!= null){
				preparedStatement.setInt(6, bean.getAccesslevel());
			}else{
				preparedStatement.setNull(6,Types.INTEGER) ;
			}
			if(bean.getEmailid()!= null){
				preparedStatement.setString(7, bean.getEmailid());
			}else{
				preparedStatement.setNull(7,Types.VARCHAR) ;
			}
			if(bean.getContactmobile()!= null){
				preparedStatement.setString(8, bean.getContactmobile());
			}else{
				preparedStatement.setNull(8,Types.VARCHAR) ;
			}
			if(bean.getContactphone()!= null){
				preparedStatement.setString(9, bean.getContactphone());
			}else{
				preparedStatement.setNull(9,Types.VARCHAR) ;
			}
			if(bean.getHomedir()!= null){
				preparedStatement.setString(10, bean.getHomedir());
			}else{
				preparedStatement.setNull(10,Types.VARCHAR) ;
			}
			if(bean.getIsactive()!= null){
				preparedStatement.setString(11, bean.getIsactive());
			}else{
				preparedStatement.setNull(11,Types.CHAR) ;
			}
			preparedStatement.setString(12, bean.getUsercode());
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
	public void deleteAllByPK( UsermasterBean bean )throws Exception{
		String sqlDeleteAll = "DELETE FROM usermaster WHERE  usercode = ?  " ;
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteAll );
			preparedStatement.setString(1, bean.getUsercode());
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
	public void deleteByUsertype(String usertype )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByUsertype = " DELETE FROM usermaster WHERE usertype = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByUsertype );
			preparedStatement.setString(1,usertype); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByUsername(String username )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByUsername = " DELETE FROM usermaster WHERE username = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByUsername );
			preparedStatement.setString(1,username); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByPassword(String password )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByPassword = " DELETE FROM usermaster WHERE password = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByPassword );
			preparedStatement.setString(1,password); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByCompanycode(int companycode )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByCompanycode = " DELETE FROM usermaster WHERE companycode = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByCompanycode );
			preparedStatement.setInt(1,companycode); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByEmploymentcode(String employmentcode )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByEmploymentcode = " DELETE FROM usermaster WHERE employmentcode = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByEmploymentcode );
			preparedStatement.setString(1,employmentcode); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByAccesslevel(int accesslevel )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByAccesslevel = " DELETE FROM usermaster WHERE accesslevel = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByAccesslevel );
			preparedStatement.setInt(1,accesslevel); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByEmailid(String emailid )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByEmailid = " DELETE FROM usermaster WHERE emailid = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByEmailid );
			preparedStatement.setString(1,emailid); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByContactmobile(String contactmobile )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByContactmobile = " DELETE FROM usermaster WHERE contactmobile = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByContactmobile );
			preparedStatement.setString(1,contactmobile); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByContactphone(String contactphone )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByContactphone = " DELETE FROM usermaster WHERE contactphone = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByContactphone );
			preparedStatement.setString(1,contactphone); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByHomedir(String homedir )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByHomedir = " DELETE FROM usermaster WHERE homedir = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByHomedir );
			preparedStatement.setString(1,homedir); 
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
		String sqlDeleteByIsactive = " DELETE FROM usermaster WHERE isactive = ? " ;
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
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void updateActiveStatusForUsers(List<UsermasterBean> selectedDepartments,String activeStatus) throws Exception {

		try {

			for (UsermasterBean departmentBean : selectedDepartments) {

				updateDeleteStatusForUserAndGroup(departmentBean,activeStatus);

			}

			connection.commit();

		} catch (Exception e) {

			connection.rollback();

			e.printStackTrace();

			throw new Exception(e.getMessage());
		}
	}

	public void updateDeleteStatusForUserAndGroup(UsermasterBean bean,String activeStatus) throws Exception {

		try {

			updateDeleteStatusForDepartment(bean,activeStatus);
			///$updateDeleteStatusForRolemaster(bean);

			connection.commit();

		} catch (Exception e) {

			connection.rollback();
			e.printStackTrace();
			throw new Exception(e.getMessage());

		}

	}

	public void updateDeleteStatusForDepartment(UsermasterBean bean,String activeStatus)
			throws Exception {

		PreparedStatement preparedStatement = null;

		String sqlUpdateAllStmt = "UPDATE usermaster SET   isactive = ?   WHERE  usercode = ? ";

		try {
			preparedStatement = connection.prepareStatement(sqlUpdateAllStmt);

			preparedStatement.setString(1,activeStatus);
			preparedStatement.setString(2, bean.usercode);

			preparedStatement.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception(e.getMessage());

		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException ioe) {
			}
		}
	}

/*	public void updateDeleteStatusForRolemaster(UsermasterBean bean)
			throws Exception {

		PreparedStatement preparedStatement = null;

		String sqlUpdateAllStmt = "UPDATE rolemaster SET   isactive = ?   WHERE  groupcode = ? ";

		try {
			preparedStatement = connection.prepareStatement(sqlUpdateAllStmt);

			preparedStatement.setString(1, "N");
			preparedStatement.setString(2, bean.);

			preparedStatement.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
			throw new Exception(e.getMessage());

		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException ioe) {
			}
		}
	}*/

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
