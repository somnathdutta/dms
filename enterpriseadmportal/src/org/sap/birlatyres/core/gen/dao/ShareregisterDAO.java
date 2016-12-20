package org.sap.birlatyres.core.gen.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import org.sap.birlatyres.core.gen.bean.*;
import org.sap.birlatyres.core.db.*;

import java.sql.Timestamp;
import java.math.BigDecimal;
import java.sql.Types;

public class ShareregisterDAO {
	private Connection conn ;
	public ShareregisterDAO() {
		try {			
			conn = DatabaseHandler.getNewInstance().getConnection();		
		} catch (Exception e) {		
			e.printStackTrace();
		}
	}
	public ShareregisterBean[] findAll( )throws Exception{
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ShareregisterBean[] beans = null ;
		ArrayList<ShareregisterBean> beansList = new ArrayList<ShareregisterBean>();
		String sqlSelectByAll = " SELECT  documentid  , publicaccess , groupcode , sharedescription , synchgoogledriveshare , googlesyncheddate , controlfilepath , isreadallowed , isdownloadallowed , isprintallowed , sharestartdate , shareenddate , creationdate , createdby , modifieddate , modifiedby FROM shareregister " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByAll );
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ShareregisterBean bean = new ShareregisterBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setPublicaccess( resultSet.getString("publicaccess"));
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setSharedescription( resultSet.getString("sharedescription"));
				bean.setSynchgoogledriveshare( resultSet.getString("synchgoogledriveshare"));
				bean.setGooglesyncheddate( resultSet.getTimestamp("googlesyncheddate"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setIsreadallowed( resultSet.getString("isreadallowed"));
				bean.setIsdownloadallowed( resultSet.getString("isdownloadallowed"));
				bean.setIsprintallowed( resultSet.getString("isprintallowed"));
				bean.setSharestartdate( resultSet.getTimestamp("sharestartdate"));
				bean.setShareenddate( resultSet.getTimestamp("shareenddate"));
				bean.setCreationdate( resultSet.getTimestamp("creationdate"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddate( resultSet.getTimestamp("modifieddate"));
				bean.setModifiedby( resultSet.getString("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ShareregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ShareregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return beans ;
	}
	public ShareregisterBean[] findByDocumentid(int documentid )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ShareregisterBean[] beans = null ;
		ArrayList<ShareregisterBean> beansList = new ArrayList<ShareregisterBean>();
		String sqlSelectByDocumentid = " SELECT  documentid  , publicaccess , groupcode , sharedescription , synchgoogledriveshare , googlesyncheddate , controlfilepath , isreadallowed , isdownloadallowed , isprintallowed , sharestartdate , shareenddate , creationdate , createdby , modifieddate , modifiedby FROM shareregister WHERE documentid = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByDocumentid );
			preparedStatement.setInt(1,documentid); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ShareregisterBean bean = new ShareregisterBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setPublicaccess( resultSet.getString("publicaccess"));
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setSharedescription( resultSet.getString("sharedescription"));
				bean.setSynchgoogledriveshare( resultSet.getString("synchgoogledriveshare"));
				bean.setGooglesyncheddate( resultSet.getTimestamp("googlesyncheddate"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setIsreadallowed( resultSet.getString("isreadallowed"));
				bean.setIsdownloadallowed( resultSet.getString("isdownloadallowed"));
				bean.setIsprintallowed( resultSet.getString("isprintallowed"));
				bean.setSharestartdate( resultSet.getTimestamp("sharestartdate"));
				bean.setShareenddate( resultSet.getTimestamp("shareenddate"));
				bean.setCreationdate( resultSet.getTimestamp("creationdate"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddate( resultSet.getTimestamp("modifieddate"));
				bean.setModifiedby( resultSet.getString("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ShareregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ShareregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ShareregisterBean[] findByPublicaccess(String publicaccess )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ShareregisterBean[] beans = null ;
		ArrayList<ShareregisterBean> beansList = new ArrayList<ShareregisterBean>();
		String sqlSelectByPublicaccess = " SELECT  documentid  , publicaccess , groupcode , sharedescription , synchgoogledriveshare , googlesyncheddate , controlfilepath , isreadallowed , isdownloadallowed , isprintallowed , sharestartdate , shareenddate , creationdate , createdby , modifieddate , modifiedby FROM shareregister WHERE publicaccess = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByPublicaccess );
			preparedStatement.setString(1,publicaccess); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ShareregisterBean bean = new ShareregisterBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setPublicaccess( resultSet.getString("publicaccess"));
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setSharedescription( resultSet.getString("sharedescription"));
				bean.setSynchgoogledriveshare( resultSet.getString("synchgoogledriveshare"));
				bean.setGooglesyncheddate( resultSet.getTimestamp("googlesyncheddate"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setIsreadallowed( resultSet.getString("isreadallowed"));
				bean.setIsdownloadallowed( resultSet.getString("isdownloadallowed"));
				bean.setIsprintallowed( resultSet.getString("isprintallowed"));
				bean.setSharestartdate( resultSet.getTimestamp("sharestartdate"));
				bean.setShareenddate( resultSet.getTimestamp("shareenddate"));
				bean.setCreationdate( resultSet.getTimestamp("creationdate"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddate( resultSet.getTimestamp("modifieddate"));
				bean.setModifiedby( resultSet.getString("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ShareregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ShareregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ShareregisterBean[] findByGroupcode(String groupcode )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ShareregisterBean[] beans = null ;
		ArrayList<ShareregisterBean> beansList = new ArrayList<ShareregisterBean>();
		String sqlSelectByGroupcode = " SELECT  documentid  , publicaccess , groupcode , sharedescription , synchgoogledriveshare , googlesyncheddate , controlfilepath , isreadallowed , isdownloadallowed , isprintallowed , sharestartdate , shareenddate , creationdate , createdby , modifieddate , modifiedby FROM shareregister WHERE groupcode = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByGroupcode );
			preparedStatement.setString(1,groupcode); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ShareregisterBean bean = new ShareregisterBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setPublicaccess( resultSet.getString("publicaccess"));
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setSharedescription( resultSet.getString("sharedescription"));
				bean.setSynchgoogledriveshare( resultSet.getString("synchgoogledriveshare"));
				bean.setGooglesyncheddate( resultSet.getTimestamp("googlesyncheddate"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setIsreadallowed( resultSet.getString("isreadallowed"));
				bean.setIsdownloadallowed( resultSet.getString("isdownloadallowed"));
				bean.setIsprintallowed( resultSet.getString("isprintallowed"));
				bean.setSharestartdate( resultSet.getTimestamp("sharestartdate"));
				bean.setShareenddate( resultSet.getTimestamp("shareenddate"));
				bean.setCreationdate( resultSet.getTimestamp("creationdate"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddate( resultSet.getTimestamp("modifieddate"));
				bean.setModifiedby( resultSet.getString("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ShareregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ShareregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ShareregisterBean[] findBySharedescription(String sharedescription )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ShareregisterBean[] beans = null ;
		ArrayList<ShareregisterBean> beansList = new ArrayList<ShareregisterBean>();
		String sqlSelectBySharedescription = " SELECT  documentid  , publicaccess , groupcode , sharedescription , synchgoogledriveshare , googlesyncheddate , controlfilepath , isreadallowed , isdownloadallowed , isprintallowed , sharestartdate , shareenddate , creationdate , createdby , modifieddate , modifiedby FROM shareregister WHERE sharedescription = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectBySharedescription );
			preparedStatement.setString(1,sharedescription); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ShareregisterBean bean = new ShareregisterBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setPublicaccess( resultSet.getString("publicaccess"));
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setSharedescription( resultSet.getString("sharedescription"));
				bean.setSynchgoogledriveshare( resultSet.getString("synchgoogledriveshare"));
				bean.setGooglesyncheddate( resultSet.getTimestamp("googlesyncheddate"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setIsreadallowed( resultSet.getString("isreadallowed"));
				bean.setIsdownloadallowed( resultSet.getString("isdownloadallowed"));
				bean.setIsprintallowed( resultSet.getString("isprintallowed"));
				bean.setSharestartdate( resultSet.getTimestamp("sharestartdate"));
				bean.setShareenddate( resultSet.getTimestamp("shareenddate"));
				bean.setCreationdate( resultSet.getTimestamp("creationdate"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddate( resultSet.getTimestamp("modifieddate"));
				bean.setModifiedby( resultSet.getString("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ShareregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ShareregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ShareregisterBean[] findBySynchgoogledriveshare(String synchgoogledriveshare )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ShareregisterBean[] beans = null ;
		ArrayList<ShareregisterBean> beansList = new ArrayList<ShareregisterBean>();
		String sqlSelectBySynchgoogledriveshare = " SELECT  documentid  , publicaccess , groupcode , sharedescription , synchgoogledriveshare , googlesyncheddate , controlfilepath , isreadallowed , isdownloadallowed , isprintallowed , sharestartdate , shareenddate , creationdate , createdby , modifieddate , modifiedby FROM shareregister WHERE synchgoogledriveshare = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectBySynchgoogledriveshare );
			preparedStatement.setString(1,synchgoogledriveshare); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ShareregisterBean bean = new ShareregisterBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setPublicaccess( resultSet.getString("publicaccess"));
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setSharedescription( resultSet.getString("sharedescription"));
				bean.setSynchgoogledriveshare( resultSet.getString("synchgoogledriveshare"));
				bean.setGooglesyncheddate( resultSet.getTimestamp("googlesyncheddate"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setIsreadallowed( resultSet.getString("isreadallowed"));
				bean.setIsdownloadallowed( resultSet.getString("isdownloadallowed"));
				bean.setIsprintallowed( resultSet.getString("isprintallowed"));
				bean.setSharestartdate( resultSet.getTimestamp("sharestartdate"));
				bean.setShareenddate( resultSet.getTimestamp("shareenddate"));
				bean.setCreationdate( resultSet.getTimestamp("creationdate"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddate( resultSet.getTimestamp("modifieddate"));
				bean.setModifiedby( resultSet.getString("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ShareregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ShareregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ShareregisterBean[] findByGooglesyncheddate(Timestamp googlesyncheddate )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ShareregisterBean[] beans = null ;
		ArrayList<ShareregisterBean> beansList = new ArrayList<ShareregisterBean>();
		String sqlSelectByGooglesyncheddate = " SELECT  documentid  , publicaccess , groupcode , sharedescription , synchgoogledriveshare , googlesyncheddate , controlfilepath , isreadallowed , isdownloadallowed , isprintallowed , sharestartdate , shareenddate , creationdate , createdby , modifieddate , modifiedby FROM shareregister WHERE googlesyncheddate = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByGooglesyncheddate );
			preparedStatement.setTimestamp(1,googlesyncheddate); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ShareregisterBean bean = new ShareregisterBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setPublicaccess( resultSet.getString("publicaccess"));
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setSharedescription( resultSet.getString("sharedescription"));
				bean.setSynchgoogledriveshare( resultSet.getString("synchgoogledriveshare"));
				bean.setGooglesyncheddate( resultSet.getTimestamp("googlesyncheddate"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setIsreadallowed( resultSet.getString("isreadallowed"));
				bean.setIsdownloadallowed( resultSet.getString("isdownloadallowed"));
				bean.setIsprintallowed( resultSet.getString("isprintallowed"));
				bean.setSharestartdate( resultSet.getTimestamp("sharestartdate"));
				bean.setShareenddate( resultSet.getTimestamp("shareenddate"));
				bean.setCreationdate( resultSet.getTimestamp("creationdate"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddate( resultSet.getTimestamp("modifieddate"));
				bean.setModifiedby( resultSet.getString("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ShareregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ShareregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ShareregisterBean[] findByControlfilepath(String controlfilepath )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ShareregisterBean[] beans = null ;
		ArrayList<ShareregisterBean> beansList = new ArrayList<ShareregisterBean>();
		String sqlSelectByControlfilepath = " SELECT  documentid  , publicaccess , groupcode , sharedescription , synchgoogledriveshare , googlesyncheddate , controlfilepath , isreadallowed , isdownloadallowed , isprintallowed , sharestartdate , shareenddate , creationdate , createdby , modifieddate , modifiedby FROM shareregister WHERE controlfilepath = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByControlfilepath );
			preparedStatement.setString(1,controlfilepath); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ShareregisterBean bean = new ShareregisterBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setPublicaccess( resultSet.getString("publicaccess"));
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setSharedescription( resultSet.getString("sharedescription"));
				bean.setSynchgoogledriveshare( resultSet.getString("synchgoogledriveshare"));
				bean.setGooglesyncheddate( resultSet.getTimestamp("googlesyncheddate"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setIsreadallowed( resultSet.getString("isreadallowed"));
				bean.setIsdownloadallowed( resultSet.getString("isdownloadallowed"));
				bean.setIsprintallowed( resultSet.getString("isprintallowed"));
				bean.setSharestartdate( resultSet.getTimestamp("sharestartdate"));
				bean.setShareenddate( resultSet.getTimestamp("shareenddate"));
				bean.setCreationdate( resultSet.getTimestamp("creationdate"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddate( resultSet.getTimestamp("modifieddate"));
				bean.setModifiedby( resultSet.getString("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ShareregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ShareregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ShareregisterBean[] findByIsreadallowed(String isreadallowed )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ShareregisterBean[] beans = null ;
		ArrayList<ShareregisterBean> beansList = new ArrayList<ShareregisterBean>();
		String sqlSelectByIsreadallowed = " SELECT  documentid  , publicaccess , groupcode , sharedescription , synchgoogledriveshare , googlesyncheddate , controlfilepath , isreadallowed , isdownloadallowed , isprintallowed , sharestartdate , shareenddate , creationdate , createdby , modifieddate , modifiedby FROM shareregister WHERE isreadallowed = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByIsreadallowed );
			preparedStatement.setString(1,isreadallowed); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ShareregisterBean bean = new ShareregisterBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setPublicaccess( resultSet.getString("publicaccess"));
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setSharedescription( resultSet.getString("sharedescription"));
				bean.setSynchgoogledriveshare( resultSet.getString("synchgoogledriveshare"));
				bean.setGooglesyncheddate( resultSet.getTimestamp("googlesyncheddate"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setIsreadallowed( resultSet.getString("isreadallowed"));
				bean.setIsdownloadallowed( resultSet.getString("isdownloadallowed"));
				bean.setIsprintallowed( resultSet.getString("isprintallowed"));
				bean.setSharestartdate( resultSet.getTimestamp("sharestartdate"));
				bean.setShareenddate( resultSet.getTimestamp("shareenddate"));
				bean.setCreationdate( resultSet.getTimestamp("creationdate"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddate( resultSet.getTimestamp("modifieddate"));
				bean.setModifiedby( resultSet.getString("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ShareregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ShareregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ShareregisterBean[] findByIsdownloadallowed(String isdownloadallowed )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ShareregisterBean[] beans = null ;
		ArrayList<ShareregisterBean> beansList = new ArrayList<ShareregisterBean>();
		String sqlSelectByIsdownloadallowed = " SELECT  documentid  , publicaccess , groupcode , sharedescription , synchgoogledriveshare , googlesyncheddate , controlfilepath , isreadallowed , isdownloadallowed , isprintallowed , sharestartdate , shareenddate , creationdate , createdby , modifieddate , modifiedby FROM shareregister WHERE isdownloadallowed = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByIsdownloadallowed );
			preparedStatement.setString(1,isdownloadallowed); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ShareregisterBean bean = new ShareregisterBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setPublicaccess( resultSet.getString("publicaccess"));
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setSharedescription( resultSet.getString("sharedescription"));
				bean.setSynchgoogledriveshare( resultSet.getString("synchgoogledriveshare"));
				bean.setGooglesyncheddate( resultSet.getTimestamp("googlesyncheddate"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setIsreadallowed( resultSet.getString("isreadallowed"));
				bean.setIsdownloadallowed( resultSet.getString("isdownloadallowed"));
				bean.setIsprintallowed( resultSet.getString("isprintallowed"));
				bean.setSharestartdate( resultSet.getTimestamp("sharestartdate"));
				bean.setShareenddate( resultSet.getTimestamp("shareenddate"));
				bean.setCreationdate( resultSet.getTimestamp("creationdate"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddate( resultSet.getTimestamp("modifieddate"));
				bean.setModifiedby( resultSet.getString("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ShareregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ShareregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ShareregisterBean[] findByIsprintallowed(String isprintallowed )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ShareregisterBean[] beans = null ;
		ArrayList<ShareregisterBean> beansList = new ArrayList<ShareregisterBean>();
		String sqlSelectByIsprintallowed = " SELECT  documentid  , publicaccess , groupcode , sharedescription , synchgoogledriveshare , googlesyncheddate , controlfilepath , isreadallowed , isdownloadallowed , isprintallowed , sharestartdate , shareenddate , creationdate , createdby , modifieddate , modifiedby FROM shareregister WHERE isprintallowed = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByIsprintallowed );
			preparedStatement.setString(1,isprintallowed); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ShareregisterBean bean = new ShareregisterBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setPublicaccess( resultSet.getString("publicaccess"));
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setSharedescription( resultSet.getString("sharedescription"));
				bean.setSynchgoogledriveshare( resultSet.getString("synchgoogledriveshare"));
				bean.setGooglesyncheddate( resultSet.getTimestamp("googlesyncheddate"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setIsreadallowed( resultSet.getString("isreadallowed"));
				bean.setIsdownloadallowed( resultSet.getString("isdownloadallowed"));
				bean.setIsprintallowed( resultSet.getString("isprintallowed"));
				bean.setSharestartdate( resultSet.getTimestamp("sharestartdate"));
				bean.setShareenddate( resultSet.getTimestamp("shareenddate"));
				bean.setCreationdate( resultSet.getTimestamp("creationdate"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddate( resultSet.getTimestamp("modifieddate"));
				bean.setModifiedby( resultSet.getString("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ShareregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ShareregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ShareregisterBean[] findBySharestartdate(Timestamp sharestartdate )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ShareregisterBean[] beans = null ;
		ArrayList<ShareregisterBean> beansList = new ArrayList<ShareregisterBean>();
		String sqlSelectBySharestartdate = " SELECT  documentid  , publicaccess , groupcode , sharedescription , synchgoogledriveshare , googlesyncheddate , controlfilepath , isreadallowed , isdownloadallowed , isprintallowed , sharestartdate , shareenddate , creationdate , createdby , modifieddate , modifiedby FROM shareregister WHERE sharestartdate = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectBySharestartdate );
			preparedStatement.setTimestamp(1,sharestartdate); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ShareregisterBean bean = new ShareregisterBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setPublicaccess( resultSet.getString("publicaccess"));
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setSharedescription( resultSet.getString("sharedescription"));
				bean.setSynchgoogledriveshare( resultSet.getString("synchgoogledriveshare"));
				bean.setGooglesyncheddate( resultSet.getTimestamp("googlesyncheddate"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setIsreadallowed( resultSet.getString("isreadallowed"));
				bean.setIsdownloadallowed( resultSet.getString("isdownloadallowed"));
				bean.setIsprintallowed( resultSet.getString("isprintallowed"));
				bean.setSharestartdate( resultSet.getTimestamp("sharestartdate"));
				bean.setShareenddate( resultSet.getTimestamp("shareenddate"));
				bean.setCreationdate( resultSet.getTimestamp("creationdate"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddate( resultSet.getTimestamp("modifieddate"));
				bean.setModifiedby( resultSet.getString("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ShareregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ShareregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ShareregisterBean[] findByShareenddate(Timestamp shareenddate )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ShareregisterBean[] beans = null ;
		ArrayList<ShareregisterBean> beansList = new ArrayList<ShareregisterBean>();
		String sqlSelectByShareenddate = " SELECT  documentid  , publicaccess , groupcode , sharedescription , synchgoogledriveshare , googlesyncheddate , controlfilepath , isreadallowed , isdownloadallowed , isprintallowed , sharestartdate , shareenddate , creationdate , createdby , modifieddate , modifiedby FROM shareregister WHERE shareenddate = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByShareenddate );
			preparedStatement.setTimestamp(1,shareenddate); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ShareregisterBean bean = new ShareregisterBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setPublicaccess( resultSet.getString("publicaccess"));
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setSharedescription( resultSet.getString("sharedescription"));
				bean.setSynchgoogledriveshare( resultSet.getString("synchgoogledriveshare"));
				bean.setGooglesyncheddate( resultSet.getTimestamp("googlesyncheddate"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setIsreadallowed( resultSet.getString("isreadallowed"));
				bean.setIsdownloadallowed( resultSet.getString("isdownloadallowed"));
				bean.setIsprintallowed( resultSet.getString("isprintallowed"));
				bean.setSharestartdate( resultSet.getTimestamp("sharestartdate"));
				bean.setShareenddate( resultSet.getTimestamp("shareenddate"));
				bean.setCreationdate( resultSet.getTimestamp("creationdate"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddate( resultSet.getTimestamp("modifieddate"));
				bean.setModifiedby( resultSet.getString("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ShareregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ShareregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ShareregisterBean[] findByCreationdate(Timestamp creationdate )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ShareregisterBean[] beans = null ;
		ArrayList<ShareregisterBean> beansList = new ArrayList<ShareregisterBean>();
		String sqlSelectByCreationdate = " SELECT  documentid  , publicaccess , groupcode , sharedescription , synchgoogledriveshare , googlesyncheddate , controlfilepath , isreadallowed , isdownloadallowed , isprintallowed , sharestartdate , shareenddate , creationdate , createdby , modifieddate , modifiedby FROM shareregister WHERE creationdate = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByCreationdate );
			preparedStatement.setTimestamp(1,creationdate); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ShareregisterBean bean = new ShareregisterBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setPublicaccess( resultSet.getString("publicaccess"));
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setSharedescription( resultSet.getString("sharedescription"));
				bean.setSynchgoogledriveshare( resultSet.getString("synchgoogledriveshare"));
				bean.setGooglesyncheddate( resultSet.getTimestamp("googlesyncheddate"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setIsreadallowed( resultSet.getString("isreadallowed"));
				bean.setIsdownloadallowed( resultSet.getString("isdownloadallowed"));
				bean.setIsprintallowed( resultSet.getString("isprintallowed"));
				bean.setSharestartdate( resultSet.getTimestamp("sharestartdate"));
				bean.setShareenddate( resultSet.getTimestamp("shareenddate"));
				bean.setCreationdate( resultSet.getTimestamp("creationdate"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddate( resultSet.getTimestamp("modifieddate"));
				bean.setModifiedby( resultSet.getString("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ShareregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ShareregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ShareregisterBean[] findByCreatedby(String createdby )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ShareregisterBean[] beans = null ;
		ArrayList<ShareregisterBean> beansList = new ArrayList<ShareregisterBean>();
		String sqlSelectByCreatedby = " SELECT  documentid  , publicaccess , groupcode , sharedescription , synchgoogledriveshare , googlesyncheddate , controlfilepath , isreadallowed , isdownloadallowed , isprintallowed , sharestartdate , shareenddate , creationdate , createdby , modifieddate , modifiedby FROM shareregister WHERE createdby = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByCreatedby );
			preparedStatement.setString(1,createdby); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ShareregisterBean bean = new ShareregisterBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setPublicaccess( resultSet.getString("publicaccess"));
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setSharedescription( resultSet.getString("sharedescription"));
				bean.setSynchgoogledriveshare( resultSet.getString("synchgoogledriveshare"));
				bean.setGooglesyncheddate( resultSet.getTimestamp("googlesyncheddate"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setIsreadallowed( resultSet.getString("isreadallowed"));
				bean.setIsdownloadallowed( resultSet.getString("isdownloadallowed"));
				bean.setIsprintallowed( resultSet.getString("isprintallowed"));
				bean.setSharestartdate( resultSet.getTimestamp("sharestartdate"));
				bean.setShareenddate( resultSet.getTimestamp("shareenddate"));
				bean.setCreationdate( resultSet.getTimestamp("creationdate"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddate( resultSet.getTimestamp("modifieddate"));
				bean.setModifiedby( resultSet.getString("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ShareregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ShareregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ShareregisterBean[] findByModifieddate(Timestamp modifieddate )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ShareregisterBean[] beans = null ;
		ArrayList<ShareregisterBean> beansList = new ArrayList<ShareregisterBean>();
		String sqlSelectByModifieddate = " SELECT  documentid  , publicaccess , groupcode , sharedescription , synchgoogledriveshare , googlesyncheddate , controlfilepath , isreadallowed , isdownloadallowed , isprintallowed , sharestartdate , shareenddate , creationdate , createdby , modifieddate , modifiedby FROM shareregister WHERE modifieddate = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByModifieddate );
			preparedStatement.setTimestamp(1,modifieddate); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ShareregisterBean bean = new ShareregisterBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setPublicaccess( resultSet.getString("publicaccess"));
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setSharedescription( resultSet.getString("sharedescription"));
				bean.setSynchgoogledriveshare( resultSet.getString("synchgoogledriveshare"));
				bean.setGooglesyncheddate( resultSet.getTimestamp("googlesyncheddate"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setIsreadallowed( resultSet.getString("isreadallowed"));
				bean.setIsdownloadallowed( resultSet.getString("isdownloadallowed"));
				bean.setIsprintallowed( resultSet.getString("isprintallowed"));
				bean.setSharestartdate( resultSet.getTimestamp("sharestartdate"));
				bean.setShareenddate( resultSet.getTimestamp("shareenddate"));
				bean.setCreationdate( resultSet.getTimestamp("creationdate"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddate( resultSet.getTimestamp("modifieddate"));
				bean.setModifiedby( resultSet.getString("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ShareregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ShareregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ShareregisterBean[] findByModifiedby(String modifiedby )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ShareregisterBean[] beans = null ;
		ArrayList<ShareregisterBean> beansList = new ArrayList<ShareregisterBean>();
		String sqlSelectByModifiedby = " SELECT  documentid  , publicaccess , groupcode , sharedescription , synchgoogledriveshare , googlesyncheddate , controlfilepath , isreadallowed , isdownloadallowed , isprintallowed , sharestartdate , shareenddate , creationdate , createdby , modifieddate , modifiedby FROM shareregister WHERE modifiedby = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByModifiedby );
			preparedStatement.setString(1,modifiedby); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ShareregisterBean bean = new ShareregisterBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setPublicaccess( resultSet.getString("publicaccess"));
				bean.setGroupcode( resultSet.getString("groupcode"));
				bean.setSharedescription( resultSet.getString("sharedescription"));
				bean.setSynchgoogledriveshare( resultSet.getString("synchgoogledriveshare"));
				bean.setGooglesyncheddate( resultSet.getTimestamp("googlesyncheddate"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setIsreadallowed( resultSet.getString("isreadallowed"));
				bean.setIsdownloadallowed( resultSet.getString("isdownloadallowed"));
				bean.setIsprintallowed( resultSet.getString("isprintallowed"));
				bean.setSharestartdate( resultSet.getTimestamp("sharestartdate"));
				bean.setShareenddate( resultSet.getTimestamp("shareenddate"));
				bean.setCreationdate( resultSet.getTimestamp("creationdate"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddate( resultSet.getTimestamp("modifieddate"));
				bean.setModifiedby( resultSet.getString("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ShareregisterBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ShareregisterBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public void insertAllCols( ShareregisterBean bean )throws Exception{
		PreparedStatement preparedStatement = null ;
		String sqlInsertAllStmt = "INSERT INTO shareregister  (documentid  , publicaccess , groupcode , sharedescription , synchgoogledriveshare , googlesyncheddate , controlfilepath , isreadallowed , isdownloadallowed , isprintallowed , sharestartdate , shareenddate , creationdate , createdby , modifieddate , modifiedby) VALUES ( ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ? )" ;
		try{
			preparedStatement = conn.prepareStatement( sqlInsertAllStmt );
			preparedStatement.setInt(1, bean.getDocumentid());
			if(bean.getPublicaccess()!= null){
				preparedStatement.setString(2, bean.getPublicaccess());
			}else{
				preparedStatement.setNull(2,Types.CHAR) ;
			}
			if(bean.getGroupcode()!= null){
				preparedStatement.setString(3, bean.getGroupcode());
			}else{
				preparedStatement.setNull(3,Types.VARCHAR) ;
			}
			if(bean.getSharedescription()!= null){
				preparedStatement.setString(4, bean.getSharedescription());
			}else{
				preparedStatement.setNull(4,Types.VARCHAR) ;
			}
			if(bean.getSynchgoogledriveshare()!= null){
				preparedStatement.setString(5, bean.getSynchgoogledriveshare());
			}else{
				preparedStatement.setNull(5,Types.CHAR) ;
			}
			if(bean.getGooglesyncheddate()!= null){
				preparedStatement.setTimestamp(6, bean.getGooglesyncheddate());
			}else{
				preparedStatement.setNull(6,Types.DATE) ;
			}
			if(bean.getControlfilepath()!= null){
				preparedStatement.setString(7, bean.getControlfilepath());
			}else{
				preparedStatement.setNull(7,Types.VARCHAR) ;
			}
			if(bean.getIsreadallowed()!= null){
				preparedStatement.setString(8, bean.getIsreadallowed());
			}else{
				preparedStatement.setNull(8,Types.CHAR) ;
			}
			if(bean.getIsdownloadallowed()!= null){
				preparedStatement.setString(9, bean.getIsdownloadallowed());
			}else{
				preparedStatement.setNull(9,Types.CHAR) ;
			}
			if(bean.getIsprintallowed()!= null){
				preparedStatement.setString(10, bean.getIsprintallowed());
			}else{
				preparedStatement.setNull(10,Types.CHAR) ;
			}
			if(bean.getSharestartdate()!= null){
				preparedStatement.setTimestamp(11, bean.getSharestartdate());
			}else{
				preparedStatement.setNull(11,Types.DATE) ;
			}
			if(bean.getShareenddate()!= null){
				preparedStatement.setTimestamp(12, bean.getShareenddate());
			}else{
				preparedStatement.setNull(12,Types.DATE) ;
			}
			if(bean.getCreationdate()!= null){
				preparedStatement.setTimestamp(13, bean.getCreationdate());
			}else{
				preparedStatement.setNull(13,Types.DATE) ;
			}
			if(bean.getCreatedby()!= null){
				preparedStatement.setString(14, bean.getCreatedby());
			}else{
				preparedStatement.setNull(14,Types.VARCHAR) ;
			}
			if(bean.getModifieddate()!= null){
				preparedStatement.setTimestamp(15, bean.getModifieddate());
			}else{
				preparedStatement.setNull(15,Types.DATE) ;
			}
			if(bean.getModifiedby()!= null){
				preparedStatement.setString(16, bean.getModifiedby());
			}else{
				preparedStatement.setNull(16,Types.VARCHAR) ;
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
	public void updateAllCols( ShareregisterBean bean )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlUpdateAllStmt = "UPDATE shareregister SET   publicaccess = ?  , groupcode = ?  , sharedescription = ?  , synchgoogledriveshare = ?  , googlesyncheddate = ?  , controlfilepath = ?  , isreadallowed = ?  , isdownloadallowed = ?  , isprintallowed = ?  , sharestartdate = ?  , shareenddate = ?  , creationdate = ?  , createdby = ?  , modifieddate = ?  , modifiedby = ?   WHERE  documentid = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlUpdateAllStmt );
			if(bean.getPublicaccess()!= null){
				preparedStatement.setString(1, bean.getPublicaccess());
			}else{
				preparedStatement.setNull(1,Types.CHAR) ;
			}
			if(bean.getGroupcode()!= null){
				preparedStatement.setString(2, bean.getGroupcode());
			}else{
				preparedStatement.setNull(2,Types.VARCHAR) ;
			}
			if(bean.getSharedescription()!= null){
				preparedStatement.setString(3, bean.getSharedescription());
			}else{
				preparedStatement.setNull(3,Types.VARCHAR) ;
			}
			if(bean.getSynchgoogledriveshare()!= null){
				preparedStatement.setString(4, bean.getSynchgoogledriveshare());
			}else{
				preparedStatement.setNull(4,Types.CHAR) ;
			}
			if(bean.getGooglesyncheddate()!= null){
				preparedStatement.setTimestamp(5, bean.getGooglesyncheddate());
			}else{
				preparedStatement.setNull(5,Types.DATE) ;
			}
			if(bean.getControlfilepath()!= null){
				preparedStatement.setString(6, bean.getControlfilepath());
			}else{
				preparedStatement.setNull(6,Types.VARCHAR) ;
			}
			if(bean.getIsreadallowed()!= null){
				preparedStatement.setString(7, bean.getIsreadallowed());
			}else{
				preparedStatement.setNull(7,Types.CHAR) ;
			}
			if(bean.getIsdownloadallowed()!= null){
				preparedStatement.setString(8, bean.getIsdownloadallowed());
			}else{
				preparedStatement.setNull(8,Types.CHAR) ;
			}
			if(bean.getIsprintallowed()!= null){
				preparedStatement.setString(9, bean.getIsprintallowed());
			}else{
				preparedStatement.setNull(9,Types.CHAR) ;
			}
			if(bean.getSharestartdate()!= null){
				preparedStatement.setTimestamp(10, bean.getSharestartdate());
			}else{
				preparedStatement.setNull(10,Types.DATE) ;
			}
			if(bean.getShareenddate()!= null){
				preparedStatement.setTimestamp(11, bean.getShareenddate());
			}else{
				preparedStatement.setNull(11,Types.DATE) ;
			}
			if(bean.getCreationdate()!= null){
				preparedStatement.setTimestamp(12, bean.getCreationdate());
			}else{
				preparedStatement.setNull(12,Types.DATE) ;
			}
			if(bean.getCreatedby()!= null){
				preparedStatement.setString(13, bean.getCreatedby());
			}else{
				preparedStatement.setNull(13,Types.VARCHAR) ;
			}
			if(bean.getModifieddate()!= null){
				preparedStatement.setTimestamp(14, bean.getModifieddate());
			}else{
				preparedStatement.setNull(14,Types.DATE) ;
			}
			if(bean.getModifiedby()!= null){
				preparedStatement.setString(15, bean.getModifiedby());
			}else{
				preparedStatement.setNull(15,Types.VARCHAR) ;
			}
			preparedStatement.setInt(16, bean.getDocumentid());
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
	public void deleteAllByPK( ShareregisterBean bean )throws Exception{
		String sqlDeleteAll = "DELETE FROM shareregister WHERE  documentid = ?  " ;
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteAll );
			preparedStatement.setInt(1, bean.getDocumentid());
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
	public void deleteByPublicaccess(String publicaccess )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByPublicaccess = " DELETE FROM shareregister WHERE publicaccess = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByPublicaccess );
			preparedStatement.setString(1,publicaccess); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByGroupcode(String groupcode )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByGroupcode = " DELETE FROM shareregister WHERE groupcode = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByGroupcode );
			preparedStatement.setString(1,groupcode); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteBySharedescription(String sharedescription )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteBySharedescription = " DELETE FROM shareregister WHERE sharedescription = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteBySharedescription );
			preparedStatement.setString(1,sharedescription); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteBySynchgoogledriveshare(String synchgoogledriveshare )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteBySynchgoogledriveshare = " DELETE FROM shareregister WHERE synchgoogledriveshare = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteBySynchgoogledriveshare );
			preparedStatement.setString(1,synchgoogledriveshare); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByGooglesyncheddate(Timestamp googlesyncheddate )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByGooglesyncheddate = " DELETE FROM shareregister WHERE googlesyncheddate = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByGooglesyncheddate );
			preparedStatement.setTimestamp(1,googlesyncheddate); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByControlfilepath(String controlfilepath )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByControlfilepath = " DELETE FROM shareregister WHERE controlfilepath = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByControlfilepath );
			preparedStatement.setString(1,controlfilepath); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByIsreadallowed(String isreadallowed )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByIsreadallowed = " DELETE FROM shareregister WHERE isreadallowed = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByIsreadallowed );
			preparedStatement.setString(1,isreadallowed); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByIsdownloadallowed(String isdownloadallowed )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByIsdownloadallowed = " DELETE FROM shareregister WHERE isdownloadallowed = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByIsdownloadallowed );
			preparedStatement.setString(1,isdownloadallowed); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByIsprintallowed(String isprintallowed )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByIsprintallowed = " DELETE FROM shareregister WHERE isprintallowed = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByIsprintallowed );
			preparedStatement.setString(1,isprintallowed); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteBySharestartdate(Timestamp sharestartdate )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteBySharestartdate = " DELETE FROM shareregister WHERE sharestartdate = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteBySharestartdate );
			preparedStatement.setTimestamp(1,sharestartdate); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByShareenddate(Timestamp shareenddate )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByShareenddate = " DELETE FROM shareregister WHERE shareenddate = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByShareenddate );
			preparedStatement.setTimestamp(1,shareenddate); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByCreationdate(Timestamp creationdate )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByCreationdate = " DELETE FROM shareregister WHERE creationdate = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByCreationdate );
			preparedStatement.setTimestamp(1,creationdate); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByCreatedby(String createdby )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByCreatedby = " DELETE FROM shareregister WHERE createdby = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByCreatedby );
			preparedStatement.setString(1,createdby); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByModifieddate(Timestamp modifieddate )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByModifieddate = " DELETE FROM shareregister WHERE modifieddate = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByModifieddate );
			preparedStatement.setTimestamp(1,modifieddate); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByModifiedby(String modifiedby )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByModifiedby = " DELETE FROM shareregister WHERE modifiedby = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByModifiedby );
			preparedStatement.setString(1,modifiedby); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
}
