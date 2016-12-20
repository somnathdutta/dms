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

public class DocumenthistoryDAO {
	private Connection conn ;
	public DocumenthistoryDAO() {
		try {			
			conn = DatabaseHandler.getNewInstance().getConnection();		
		} catch (Exception e) {		
			e.printStackTrace();
		}
	}
	public DocumenthistoryBean[] findAll( )throws Exception{
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DocumenthistoryBean[] beans = null ;
		ArrayList<DocumenthistoryBean> beansList = new ArrayList<DocumenthistoryBean>();
		String sqlSelectByAll = " SELECT  transactionid  , documentid , documentnumber , documentname , operationname , operationdatetime , documentversionnumber , controltargetfilepath , operationauthorizedby , creationdatetime , createdby FROM documenthistory " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByAll );
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DocumenthistoryBean bean = new DocumenthistoryBean();
				bean.setTransactionid( resultSet.getInt("transactionid"));
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setOperationname( resultSet.getString("operationname"));
				bean.setOperationdatetime( resultSet.getTimestamp("operationdatetime"));
				bean.setDocumentversionnumber( resultSet.getInt("documentversionnumber"));
				bean.setControltargetfilepath( resultSet.getString("controltargetfilepath"));
				bean.setOperationauthorizedby( resultSet.getString("operationauthorizedby"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DocumenthistoryBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DocumenthistoryBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return beans ;
	}
	public DocumenthistoryBean[] findByTransactionid(int transactionid )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DocumenthistoryBean[] beans = null ;
		ArrayList<DocumenthistoryBean> beansList = new ArrayList<DocumenthistoryBean>();
		String sqlSelectByTransactionid = " SELECT  transactionid  , documentid , documentnumber , documentname , operationname , operationdatetime , documentversionnumber , controltargetfilepath , operationauthorizedby , creationdatetime , createdby FROM documenthistory WHERE transactionid = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByTransactionid );
			preparedStatement.setInt(1,transactionid); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DocumenthistoryBean bean = new DocumenthistoryBean();
				bean.setTransactionid( resultSet.getInt("transactionid"));
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setOperationname( resultSet.getString("operationname"));
				bean.setOperationdatetime( resultSet.getTimestamp("operationdatetime"));
				bean.setDocumentversionnumber( resultSet.getInt("documentversionnumber"));
				bean.setControltargetfilepath( resultSet.getString("controltargetfilepath"));
				bean.setOperationauthorizedby( resultSet.getString("operationauthorizedby"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DocumenthistoryBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DocumenthistoryBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public DocumenthistoryBean[] findByDocumentid(int documentid )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DocumenthistoryBean[] beans = null ;
		ArrayList<DocumenthistoryBean> beansList = new ArrayList<DocumenthistoryBean>();
		String sqlSelectByDocumentid = " SELECT  transactionid  , documentid , documentnumber , documentname , operationname , operationdatetime , documentversionnumber , controltargetfilepath , operationauthorizedby , creationdatetime , createdby FROM documenthistory WHERE documentid = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByDocumentid );
			preparedStatement.setInt(1,documentid); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DocumenthistoryBean bean = new DocumenthistoryBean();
				bean.setTransactionid( resultSet.getInt("transactionid"));
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setOperationname( resultSet.getString("operationname"));
				bean.setOperationdatetime( resultSet.getTimestamp("operationdatetime"));
				bean.setDocumentversionnumber( resultSet.getInt("documentversionnumber"));
				bean.setControltargetfilepath( resultSet.getString("controltargetfilepath"));
				bean.setOperationauthorizedby( resultSet.getString("operationauthorizedby"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DocumenthistoryBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DocumenthistoryBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public DocumenthistoryBean[] findByDocumentnumber(String documentnumber )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DocumenthistoryBean[] beans = null ;
		ArrayList<DocumenthistoryBean> beansList = new ArrayList<DocumenthistoryBean>();
		String sqlSelectByDocumentnumber = " SELECT  transactionid  , documentid , documentnumber , documentname , operationname , operationdatetime , documentversionnumber , controltargetfilepath , operationauthorizedby , creationdatetime , createdby FROM documenthistory WHERE documentnumber = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByDocumentnumber );
			preparedStatement.setString(1,documentnumber); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DocumenthistoryBean bean = new DocumenthistoryBean();
				bean.setTransactionid( resultSet.getInt("transactionid"));
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setOperationname( resultSet.getString("operationname"));
				bean.setOperationdatetime( resultSet.getTimestamp("operationdatetime"));
				bean.setDocumentversionnumber( resultSet.getInt("documentversionnumber"));
				bean.setControltargetfilepath( resultSet.getString("controltargetfilepath"));
				bean.setOperationauthorizedby( resultSet.getString("operationauthorizedby"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DocumenthistoryBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DocumenthistoryBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public DocumenthistoryBean[] findByDocumentname(String documentname )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DocumenthistoryBean[] beans = null ;
		ArrayList<DocumenthistoryBean> beansList = new ArrayList<DocumenthistoryBean>();
		String sqlSelectByDocumentname = " SELECT  transactionid  , documentid , documentnumber , documentname , operationname , operationdatetime , documentversionnumber , controltargetfilepath , operationauthorizedby , creationdatetime , createdby FROM documenthistory WHERE documentname = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByDocumentname );
			preparedStatement.setString(1,documentname); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DocumenthistoryBean bean = new DocumenthistoryBean();
				bean.setTransactionid( resultSet.getInt("transactionid"));
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setOperationname( resultSet.getString("operationname"));
				bean.setOperationdatetime( resultSet.getTimestamp("operationdatetime"));
				bean.setDocumentversionnumber( resultSet.getInt("documentversionnumber"));
				bean.setControltargetfilepath( resultSet.getString("controltargetfilepath"));
				bean.setOperationauthorizedby( resultSet.getString("operationauthorizedby"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DocumenthistoryBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DocumenthistoryBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public DocumenthistoryBean[] findByOperationname(String operationname )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DocumenthistoryBean[] beans = null ;
		ArrayList<DocumenthistoryBean> beansList = new ArrayList<DocumenthistoryBean>();
		String sqlSelectByOperationname = " SELECT  transactionid  , documentid , documentnumber , documentname , operationname , operationdatetime , documentversionnumber , controltargetfilepath , operationauthorizedby , creationdatetime , createdby FROM documenthistory WHERE operationname = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByOperationname );
			preparedStatement.setString(1,operationname); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DocumenthistoryBean bean = new DocumenthistoryBean();
				bean.setTransactionid( resultSet.getInt("transactionid"));
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setOperationname( resultSet.getString("operationname"));
				bean.setOperationdatetime( resultSet.getTimestamp("operationdatetime"));
				bean.setDocumentversionnumber( resultSet.getInt("documentversionnumber"));
				bean.setControltargetfilepath( resultSet.getString("controltargetfilepath"));
				bean.setOperationauthorizedby( resultSet.getString("operationauthorizedby"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DocumenthistoryBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DocumenthistoryBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public DocumenthistoryBean[] findByOperationdatetime(Timestamp operationdatetime )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DocumenthistoryBean[] beans = null ;
		ArrayList<DocumenthistoryBean> beansList = new ArrayList<DocumenthistoryBean>();
		String sqlSelectByOperationdatetime = " SELECT  transactionid  , documentid , documentnumber , documentname , operationname , operationdatetime , documentversionnumber , controltargetfilepath , operationauthorizedby , creationdatetime , createdby FROM documenthistory WHERE operationdatetime = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByOperationdatetime );
			preparedStatement.setTimestamp(1,operationdatetime); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DocumenthistoryBean bean = new DocumenthistoryBean();
				bean.setTransactionid( resultSet.getInt("transactionid"));
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setOperationname( resultSet.getString("operationname"));
				bean.setOperationdatetime( resultSet.getTimestamp("operationdatetime"));
				bean.setDocumentversionnumber( resultSet.getInt("documentversionnumber"));
				bean.setControltargetfilepath( resultSet.getString("controltargetfilepath"));
				bean.setOperationauthorizedby( resultSet.getString("operationauthorizedby"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DocumenthistoryBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DocumenthistoryBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public DocumenthistoryBean[] findByDocumentversionnumber(int documentversionnumber )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DocumenthistoryBean[] beans = null ;
		ArrayList<DocumenthistoryBean> beansList = new ArrayList<DocumenthistoryBean>();
		String sqlSelectByDocumentversionnumber = " SELECT  transactionid  , documentid , documentnumber , documentname , operationname , operationdatetime , documentversionnumber , controltargetfilepath , operationauthorizedby , creationdatetime , createdby FROM documenthistory WHERE documentversionnumber = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByDocumentversionnumber );
			preparedStatement.setInt(1,documentversionnumber); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DocumenthistoryBean bean = new DocumenthistoryBean();
				bean.setTransactionid( resultSet.getInt("transactionid"));
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setOperationname( resultSet.getString("operationname"));
				bean.setOperationdatetime( resultSet.getTimestamp("operationdatetime"));
				bean.setDocumentversionnumber( resultSet.getInt("documentversionnumber"));
				bean.setControltargetfilepath( resultSet.getString("controltargetfilepath"));
				bean.setOperationauthorizedby( resultSet.getString("operationauthorizedby"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DocumenthistoryBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DocumenthistoryBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public DocumenthistoryBean[] findByControltargetfilepath(String controltargetfilepath )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DocumenthistoryBean[] beans = null ;
		ArrayList<DocumenthistoryBean> beansList = new ArrayList<DocumenthistoryBean>();
		String sqlSelectByControltargetfilepath = " SELECT  transactionid  , documentid , documentnumber , documentname , operationname , operationdatetime , documentversionnumber , controltargetfilepath , operationauthorizedby , creationdatetime , createdby FROM documenthistory WHERE controltargetfilepath = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByControltargetfilepath );
			preparedStatement.setString(1,controltargetfilepath); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DocumenthistoryBean bean = new DocumenthistoryBean();
				bean.setTransactionid( resultSet.getInt("transactionid"));
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setOperationname( resultSet.getString("operationname"));
				bean.setOperationdatetime( resultSet.getTimestamp("operationdatetime"));
				bean.setDocumentversionnumber( resultSet.getInt("documentversionnumber"));
				bean.setControltargetfilepath( resultSet.getString("controltargetfilepath"));
				bean.setOperationauthorizedby( resultSet.getString("operationauthorizedby"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DocumenthistoryBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DocumenthistoryBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public DocumenthistoryBean[] findByOperationauthorizedby(String operationauthorizedby )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DocumenthistoryBean[] beans = null ;
		ArrayList<DocumenthistoryBean> beansList = new ArrayList<DocumenthistoryBean>();
		String sqlSelectByOperationauthorizedby = " SELECT  transactionid  , documentid , documentnumber , documentname , operationname , operationdatetime , documentversionnumber , controltargetfilepath , operationauthorizedby , creationdatetime , createdby FROM documenthistory WHERE operationauthorizedby = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByOperationauthorizedby );
			preparedStatement.setString(1,operationauthorizedby); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DocumenthistoryBean bean = new DocumenthistoryBean();
				bean.setTransactionid( resultSet.getInt("transactionid"));
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setOperationname( resultSet.getString("operationname"));
				bean.setOperationdatetime( resultSet.getTimestamp("operationdatetime"));
				bean.setDocumentversionnumber( resultSet.getInt("documentversionnumber"));
				bean.setControltargetfilepath( resultSet.getString("controltargetfilepath"));
				bean.setOperationauthorizedby( resultSet.getString("operationauthorizedby"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DocumenthistoryBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DocumenthistoryBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public DocumenthistoryBean[] findByCreationdatetime(Timestamp creationdatetime )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DocumenthistoryBean[] beans = null ;
		ArrayList<DocumenthistoryBean> beansList = new ArrayList<DocumenthistoryBean>();
		String sqlSelectByCreationdatetime = " SELECT  transactionid  , documentid , documentnumber , documentname , operationname , operationdatetime , documentversionnumber , controltargetfilepath , operationauthorizedby , creationdatetime , createdby FROM documenthistory WHERE creationdatetime = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByCreationdatetime );
			preparedStatement.setTimestamp(1,creationdatetime); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DocumenthistoryBean bean = new DocumenthistoryBean();
				bean.setTransactionid( resultSet.getInt("transactionid"));
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setOperationname( resultSet.getString("operationname"));
				bean.setOperationdatetime( resultSet.getTimestamp("operationdatetime"));
				bean.setDocumentversionnumber( resultSet.getInt("documentversionnumber"));
				bean.setControltargetfilepath( resultSet.getString("controltargetfilepath"));
				bean.setOperationauthorizedby( resultSet.getString("operationauthorizedby"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DocumenthistoryBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DocumenthistoryBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public DocumenthistoryBean[] findByCreatedby(String createdby )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		DocumenthistoryBean[] beans = null ;
		ArrayList<DocumenthistoryBean> beansList = new ArrayList<DocumenthistoryBean>();
		String sqlSelectByCreatedby = " SELECT  transactionid  , documentid , documentnumber , documentname , operationname , operationdatetime , documentversionnumber , controltargetfilepath , operationauthorizedby , creationdatetime , createdby FROM documenthistory WHERE createdby = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByCreatedby );
			preparedStatement.setString(1,createdby); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				DocumenthistoryBean bean = new DocumenthistoryBean();
				bean.setTransactionid( resultSet.getInt("transactionid"));
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setOperationname( resultSet.getString("operationname"));
				bean.setOperationdatetime( resultSet.getTimestamp("operationdatetime"));
				bean.setDocumentversionnumber( resultSet.getInt("documentversionnumber"));
				bean.setControltargetfilepath( resultSet.getString("controltargetfilepath"));
				bean.setOperationauthorizedby( resultSet.getString("operationauthorizedby"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new DocumenthistoryBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (DocumenthistoryBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public void insertAllCols( DocumenthistoryBean bean )throws Exception{
		PreparedStatement preparedStatement = null ;
		String sqlInsertAllStmt = "INSERT INTO documenthistory  (transactionid  , documentid , documentnumber , documentname , operationname , operationdatetime , documentversionnumber , controltargetfilepath , operationauthorizedby , creationdatetime , createdby) VALUES ( ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ? )" ;
		try{
			preparedStatement = conn.prepareStatement( sqlInsertAllStmt );
			preparedStatement.setInt(1, bean.getTransactionid());
			if(bean.getDocumentid()!= null){
				preparedStatement.setInt(2, bean.getDocumentid());
			}else{
				preparedStatement.setNull(2,Types.INTEGER) ;
			}
			if(bean.getDocumentnumber()!= null){
				preparedStatement.setString(3, bean.getDocumentnumber());
			}else{
				preparedStatement.setNull(3,Types.VARCHAR) ;
			}
			if(bean.getDocumentname()!= null){
				preparedStatement.setString(4, bean.getDocumentname());
			}else{
				preparedStatement.setNull(4,Types.VARCHAR) ;
			}
			if(bean.getOperationname()!= null){
				preparedStatement.setString(5, bean.getOperationname());
			}else{
				preparedStatement.setNull(5,Types.VARCHAR) ;
			}
			if(bean.getOperationdatetime()!= null){
				preparedStatement.setTimestamp(6, bean.getOperationdatetime());
			}else{
				preparedStatement.setNull(6,Types.DATE) ;
			}
			if(bean.getDocumentversionnumber()!= null){
				preparedStatement.setInt(7, bean.getDocumentversionnumber());
			}else{
				preparedStatement.setNull(7,Types.INTEGER) ;
			}
			if(bean.getControltargetfilepath()!= null){
				preparedStatement.setString(8, bean.getControltargetfilepath());
			}else{
				preparedStatement.setNull(8,Types.VARCHAR) ;
			}
			if(bean.getOperationauthorizedby()!= null){
				preparedStatement.setString(9, bean.getOperationauthorizedby());
			}else{
				preparedStatement.setNull(9,Types.VARCHAR) ;
			}
			if(bean.getCreationdatetime()!= null){
				preparedStatement.setTimestamp(10, bean.getCreationdatetime());
			}else{
				preparedStatement.setNull(10,Types.DATE) ;
			}
			if(bean.getCreatedby()!= null){
				preparedStatement.setString(11, bean.getCreatedby());
			}else{
				preparedStatement.setNull(11,Types.VARCHAR) ;
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
	public void updateAllCols( DocumenthistoryBean bean )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlUpdateAllStmt = "UPDATE documenthistory SET   documentid = ?  , documentnumber = ?  , documentname = ?  , operationname = ?  , operationdatetime = ?  , documentversionnumber = ?  , controltargetfilepath = ?  , operationauthorizedby = ?  , creationdatetime = ?  , createdby = ?   WHERE  transactionid = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlUpdateAllStmt );
			if(bean.getDocumentid()!= null){
				preparedStatement.setInt(1, bean.getDocumentid());
			}else{
				preparedStatement.setNull(1,Types.INTEGER) ;
			}
			if(bean.getDocumentnumber()!= null){
				preparedStatement.setString(2, bean.getDocumentnumber());
			}else{
				preparedStatement.setNull(2,Types.VARCHAR) ;
			}
			if(bean.getDocumentname()!= null){
				preparedStatement.setString(3, bean.getDocumentname());
			}else{
				preparedStatement.setNull(3,Types.VARCHAR) ;
			}
			if(bean.getOperationname()!= null){
				preparedStatement.setString(4, bean.getOperationname());
			}else{
				preparedStatement.setNull(4,Types.VARCHAR) ;
			}
			if(bean.getOperationdatetime()!= null){
				preparedStatement.setTimestamp(5, bean.getOperationdatetime());
			}else{
				preparedStatement.setNull(5,Types.DATE) ;
			}
			if(bean.getDocumentversionnumber()!= null){
				preparedStatement.setInt(6, bean.getDocumentversionnumber());
			}else{
				preparedStatement.setNull(6,Types.INTEGER) ;
			}
			if(bean.getControltargetfilepath()!= null){
				preparedStatement.setString(7, bean.getControltargetfilepath());
			}else{
				preparedStatement.setNull(7,Types.VARCHAR) ;
			}
			if(bean.getOperationauthorizedby()!= null){
				preparedStatement.setString(8, bean.getOperationauthorizedby());
			}else{
				preparedStatement.setNull(8,Types.VARCHAR) ;
			}
			if(bean.getCreationdatetime()!= null){
				preparedStatement.setTimestamp(9, bean.getCreationdatetime());
			}else{
				preparedStatement.setNull(9,Types.DATE) ;
			}
			if(bean.getCreatedby()!= null){
				preparedStatement.setString(10, bean.getCreatedby());
			}else{
				preparedStatement.setNull(10,Types.VARCHAR) ;
			}
			preparedStatement.setInt(11, bean.getTransactionid());
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
	public void deleteAllByPK( DocumenthistoryBean bean )throws Exception{
		String sqlDeleteAll = "DELETE FROM documenthistory WHERE  transactionid = ?  " ;
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteAll );
			preparedStatement.setInt(1, bean.getTransactionid());
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
	public void deleteByDocumentid(int documentid )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByDocumentid = " DELETE FROM documenthistory WHERE documentid = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByDocumentid );
			preparedStatement.setInt(1,documentid); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByDocumentnumber(String documentnumber )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByDocumentnumber = " DELETE FROM documenthistory WHERE documentnumber = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByDocumentnumber );
			preparedStatement.setString(1,documentnumber); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByDocumentname(String documentname )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByDocumentname = " DELETE FROM documenthistory WHERE documentname = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByDocumentname );
			preparedStatement.setString(1,documentname); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByOperationname(String operationname )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByOperationname = " DELETE FROM documenthistory WHERE operationname = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByOperationname );
			preparedStatement.setString(1,operationname); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByOperationdatetime(Timestamp operationdatetime )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByOperationdatetime = " DELETE FROM documenthistory WHERE operationdatetime = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByOperationdatetime );
			preparedStatement.setTimestamp(1,operationdatetime); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByDocumentversionnumber(int documentversionnumber )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByDocumentversionnumber = " DELETE FROM documenthistory WHERE documentversionnumber = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByDocumentversionnumber );
			preparedStatement.setInt(1,documentversionnumber); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByControltargetfilepath(String controltargetfilepath )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByControltargetfilepath = " DELETE FROM documenthistory WHERE controltargetfilepath = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByControltargetfilepath );
			preparedStatement.setString(1,controltargetfilepath); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByOperationauthorizedby(String operationauthorizedby )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByOperationauthorizedby = " DELETE FROM documenthistory WHERE operationauthorizedby = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByOperationauthorizedby );
			preparedStatement.setString(1,operationauthorizedby); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByCreationdatetime(Timestamp creationdatetime )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByCreationdatetime = " DELETE FROM documenthistory WHERE creationdatetime = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByCreationdatetime );
			preparedStatement.setTimestamp(1,creationdatetime); 
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
		String sqlDeleteByCreatedby = " DELETE FROM documenthistory WHERE createdby = ? " ;
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
}
