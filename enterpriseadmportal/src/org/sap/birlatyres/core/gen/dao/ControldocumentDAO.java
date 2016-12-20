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

public class ControldocumentDAO {
	private Connection connection ;
	
	public ControldocumentDAO(){ 
		try {			
			connection = DatabaseHandler.getNewInstance().getConnection();		
		} catch (Exception e) {		
			e.printStackTrace();
		}
	}
	
	
	public ControldocumentBean[] findAllForUser( )throws Exception{
		
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		
		String sqlSelectByAll = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument where isdeleted = 'N' and approvedyn = 'Y' order by controlfilecreationdate desc " ;
		
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByAll );
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return beans ;
	}
	
	
	
	
	public ControldocumentBean[] findAllForUserDepartmentwise(String usercode)throws Exception{
		
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		
		String sqlSelectByAll = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument where controldocument.departmentcode = (select privilegeregister.groupcode from privilegeregister where privilegeregister.usercode = '"+ usercode +"') and isdeleted = 'N' and approvedyn = 'Y' order by controlfilecreationdate desc " ;
		
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByAll );
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return beans ;
	}
	
	
	
	
	
	public int findTotalPendingForApprover()throws Exception{
		
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		int total = 0;		
		
		String sqlSelectByAll = "SELECT count(*) FROM controldocument where  isdeleted = 'N' and approvedyn = 'N'" ;
		
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByAll );
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				
				total = resultSet.getInt(1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return total ;
	}
	
	
	public int findTotalPendingForApproverDepartmentwise(String usercode)throws Exception{
		
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		int total = 0;		
		
		String sqlSelectByAll = "SELECT count(*) FROM controldocument where controldocument.departmentcode = (select privilegeregister.groupcode from privilegeregister where privilegeregister.usercode = '"+ usercode +"') and isdeleted = 'N' and approvedyn = 'N'" ;
		
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByAll );
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				
				total = resultSet.getInt(1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return total ;
	}
	
	
	public ControldocumentBean[] findPendingForApprover()throws Exception{
		
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		
		String sqlSelectByAll = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument where isdeleted = 'N' and approvedyn = 'N' order by controlfilecreationdate desc " ;
		
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByAll );
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return beans ;
	}
	
	
	
	public ControldocumentBean[] findPendingForApproverDepartmentwise(String usercode)throws Exception{
		
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		
		String sqlSelectByAll = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument where controldocument.departmentcode = (select privilegeregister.groupcode from privilegeregister where privilegeregister.usercode = '"+ usercode +"') and isdeleted = 'N' and approvedyn = 'N' order by controlfilecreationdate desc " ;
		
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByAll );
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return beans ;
	}
	
	
	
public ControldocumentBean[] findrejectedbyApprover( )throws Exception{
		
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		
		String sqlSelectByAll = " SELECT  controldocument.documentid  , controldocument.documentnumber , controldocument.documenttype , controldocument.documentname , controldocument.documentversion , controldocument.documenthashkey , controldocument.description , controldocument.controlfilepath , controldocument.controlfilecreationdate , controldocument.controlfilesize , controldocument.synchgoogledrive , controldocument.googledrivesynchedtime , controldocument.googlefolderpath , controldocument.googledrivefileid , controldocument.ownerid , controldocument.isblocked , controldocument.isdeleted , controldocument.ispasswordprotected , controldocument.departmentcode , controldocument.location , controldocument.approvedyn , controldocument.creationdatetime , controldocument.createdby , controldocument.modifieddatetime , controldocument.modifiedby,documentmessages.message FROM controldocument ,documentmessages  where controldocument.documentid = documentmessages.documentid  and documentmessages.messagetype = 'R' order by controldocument.controlfilecreationdate desc";
		
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByAll );
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				bean.setMessage(resultSet.getString("message"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return beans ;
	}



	public ControldocumentBean[] findrejectedbyApproverdepartmentwise(String usercode)throws Exception{
	
	PreparedStatement preparedStatement = null ;
	ResultSet resultSet = null ;
	ControldocumentBean[] beans = null ;
	
	ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
	
	String sqlSelectByAll = "select documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted ,ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime ,modifiedby, usercode,documentreason from controldocument where controldocument.departmentcode in(select privilegeregister.groupcode from privilegeregister where privilegeregister.usercode = '"+usercode+"') and isdeleted = 'N' and approvedyn = 'R' order by controlfilecreationdate desc" ;
	
	try{
		preparedStatement = connection.prepareStatement( sqlSelectByAll );
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()){
			ControldocumentBean bean = new ControldocumentBean();
			bean.setDocumentid( resultSet.getInt("documentid"));
			bean.setDocumentnumber( resultSet.getString("documentnumber"));
			bean.setDocumenttype( resultSet.getString("documenttype"));
			bean.setDocumentname( resultSet.getString("documentname"));
			bean.setDocumentversion( resultSet.getString("documentversion"));
			bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
			bean.setDescription( resultSet.getString("description"));
			bean.setControlfilepath( resultSet.getString("controlfilepath"));
			bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
			bean.setControlfilesize( resultSet.getInt("controlfilesize"));
			bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
			bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
			bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
			bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
			bean.setOwnerid( resultSet.getInt("ownerid"));
			bean.setIsblocked( resultSet.getString("isblocked"));
			bean.setIsdeleted( resultSet.getString("isdeleted"));
			bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
			bean.setDepartmentcode( resultSet.getString("departmentcode"));
			bean.setLocation( resultSet.getString("location"));
			bean.setApprovedyn( resultSet.getString("approvedyn"));
			bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
			bean.setCreatedby( resultSet.getString("createdby"));
			bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
			bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
			bean.setMessage(resultSet.getString("message"));
			beansList.add(bean);
		}
		Object[] objectArray = beansList.toArray();
		beans = new ControldocumentBean[objectArray.length];
		for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
			beans[jindex] = (ControldocumentBean)objectArray[jindex];
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(preparedStatement != null) { preparedStatement.close() ;}
	}
	return beans ;
}
	
	
	
	public ControldocumentBean[] findAll(String usercode ,String usertype)throws Exception{
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		
       // String sqlSelectByAll = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby, usercode,documentreason FROM controldocument where isdeleted = 'N' and approvedyn <> 'R' order by controlfilecreationdate desc " ;
		
        
        //String sqlSelectByAll = "select documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby, usercode,documentreason from controldocument where 	controldocument.departmentcode = (select privilegeregister.groupcode from privilegeregister where privilegeregister.usercode = "+ usercode +") where isdeleted = 'N' and approvedyn <> 'R' order by controlfilecreationdate desc ";
        
		String sqlSelectByAll = "";
		
		System.out.println("**************************************"+usertype);
		
        if(usertype.equalsIgnoreCase("SYS")){
        	
        	sqlSelectByAll = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby, usercode,documentreason FROM controldocument where isdeleted = 'N' and approvedyn <> 'R' order by controlfilecreationdate desc " ;
        	
        }else{
        	
        	sqlSelectByAll = "select documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby, usercode,documentreason from controldocument where 	controldocument.departmentcode = (select privilegeregister.groupcode from privilegeregister where privilegeregister.usercode = '"+ usercode +"') and isdeleted = 'N' and approvedyn <> 'R' order by controlfilecreationdate desc ";
        }
        
        
        try{
			preparedStatement = connection.prepareStatement( sqlSelectByAll );
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				bean.setUserCode(resultSet.getString("usercode"));
				bean.setDocumentreason(resultSet.getString("documentreason"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(preparedStatement != null) { preparedStatement.close() ;}
		}
		return beans ;
	}
	
	public ControldocumentBean[] findByDocumentid(int documentid )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByDocumentid = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE documentid = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByDocumentid );
			preparedStatement.setInt(1,documentid); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByDocumentnumber(String documentnumber )throws Exception{
		
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByDocumentnumber = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE documentnumber = ? " ;
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByDocumentnumber );
			preparedStatement.setString(1,documentnumber); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ 
				preparedStatement.close();
			}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByDocumenttype(String documenttype )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByDocumenttype = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE documenttype = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByDocumenttype );
			preparedStatement.setString(1,documenttype); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByDocumentname(String documentname )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByDocumentname = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE documentname = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByDocumentname );
			preparedStatement.setString(1,documentname); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByDocumentversion(String documentversion )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByDocumentversion = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE documentversion = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByDocumentversion );
			preparedStatement.setString(1,documentversion); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByDocumenthashkey(String documenthashkey )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByDocumenthashkey = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE documenthashkey = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByDocumenthashkey );
			preparedStatement.setString(1,documenthashkey); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByDescription(String description )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByDescription = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE description = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByDescription );
			preparedStatement.setString(1,description); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByControlfilepath(String controlfilepath )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByControlfilepath = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE controlfilepath = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByControlfilepath );
			preparedStatement.setString(1,controlfilepath); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByControlfilecreationdate(Timestamp controlfilecreationdate )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByControlfilecreationdate = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE controlfilecreationdate = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByControlfilecreationdate );
			preparedStatement.setTimestamp(1,controlfilecreationdate); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByControlfilesize(int controlfilesize )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByControlfilesize = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE controlfilesize = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByControlfilesize );
			preparedStatement.setInt(1,controlfilesize); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findBySynchgoogledrive(String synchgoogledrive )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectBySynchgoogledrive = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE synchgoogledrive = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectBySynchgoogledrive );
			preparedStatement.setString(1,synchgoogledrive); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByGoogledrivesynchedtime(Timestamp googledrivesynchedtime )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByGoogledrivesynchedtime = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE googledrivesynchedtime = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByGoogledrivesynchedtime );
			preparedStatement.setTimestamp(1,googledrivesynchedtime); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByGooglefolderpath(String googlefolderpath )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByGooglefolderpath = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE googlefolderpath = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByGooglefolderpath );
			preparedStatement.setString(1,googlefolderpath); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByGoogledrivefileid(String googledrivefileid )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByGoogledrivefileid = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE googledrivefileid = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByGoogledrivefileid );
			preparedStatement.setString(1,googledrivefileid); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByOwnerid(int ownerid )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByOwnerid = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE ownerid = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByOwnerid );
			preparedStatement.setInt(1,ownerid); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByIsblocked(String isblocked )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByIsblocked = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE isblocked = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByIsblocked );
			preparedStatement.setString(1,isblocked); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByIsdeleted(String isdeleted )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByIsdeleted = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE isdeleted = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByIsdeleted );
			preparedStatement.setString(1,isdeleted); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByIspasswordprotected(String ispasswordprotected )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByIspasswordprotected = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE ispasswordprotected = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByIspasswordprotected );
			preparedStatement.setString(1,ispasswordprotected); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	
	public ControldocumentBean[] findDocumentsByRolesAndSearchCriteria(String usercode, String documentNo,String documentName, String version, String startDate, String endDate )throws Exception{
		
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByDepartmentcode = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , " +
										   "controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath ," +
										   " googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , " +
										   "creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE departmentcode in " +
										   "	( select groupcode from privilegeregister where usercode = ? ) " +
										   "  and documentnumber like  '" + documentNo + "%'" + 
										   "  and documentname like  '" + documentName + "%'" +
										   "  and documentversion like  '" + version + "%'" +
										   "  and isdeleted = 'N' " ;
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByDepartmentcode );
			preparedStatement.setString(1,usercode); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	
	public ControldocumentBean[] findDocumentsByAdminRolesAndSearchCriteria(String usercode, String documentNo,String documentName, String version, String startDate, String endDate,String documentType, String departmentCode )throws Exception{
		
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByDepartmentcode = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , " +
										   "controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath ," +
										   " googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , " +
										   "creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument " +
								
										   "where  documentnumber like  '" + documentNo + "%'" + 
										   "  and documentname like  '" + documentName + "%'" +
										   "  and documentversion like  '" + version + "%'" +
										   "  and documenttype like  '" + documentType + "%'" +
										   "  and departmentcode like  '" + departmentCode + "%'" +
										   "  and isdeleted = 'N' " ;
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByDepartmentcode );
			
			/////preparedStatement.setString(1,usercode); 
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}


public ControldocumentBean[] findDocumentsByAdminRolesAndSearchCriteriaDepartmentwise(String usercode, String documentNo,String documentName, String version, String startDate, String endDate,String documentType, String departmentCode )throws Exception{
	
	PreparedStatement preparedStatement = null ;
	ResultSet resultSet = null ;
	ControldocumentBean[] beans = null ;
	ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
	String sqlSelectByDepartmentcode = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , " +
									   "controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath ," +
									   " googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , " +
									   "creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument " +
							
									   "where 	controldocument.departmentcode in" +
									   "(select privilegeregister.groupcode from privilegeregister where privilegeregister.usercode = '"+ usercode +"') " +
									   ///"  departmentcode in 	( select groupcode from privilegeregister where usercode = ? )  and " +
									   "  and documentnumber like  '" + documentNo + "%'" + 
									   "  and documentname like  '" + documentName + "%'" +
									   "  and documentversion like  '" + version + "%'" +
									   "  and documenttype like  '" + documentType + "%'" +
									   "  and departmentcode like  '" + departmentCode + "%'" +
									   "  and isdeleted = 'N' " ;
	try{
		preparedStatement = connection.prepareStatement( sqlSelectByDepartmentcode );
		
		/////preparedStatement.setString(1,usercode); 
		
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()){
			ControldocumentBean bean = new ControldocumentBean();
			bean.setDocumentid( resultSet.getInt("documentid"));
			bean.setDocumentnumber( resultSet.getString("documentnumber"));
			bean.setDocumenttype( resultSet.getString("documenttype"));
			bean.setDocumentname( resultSet.getString("documentname"));
			bean.setDocumentversion( resultSet.getString("documentversion"));
			bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
			bean.setDescription( resultSet.getString("description"));
			bean.setControlfilepath( resultSet.getString("controlfilepath"));
			bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
			bean.setControlfilesize( resultSet.getInt("controlfilesize"));
			bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
			bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
			bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
			bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
			bean.setOwnerid( resultSet.getInt("ownerid"));
			bean.setIsblocked( resultSet.getString("isblocked"));
			bean.setIsdeleted( resultSet.getString("isdeleted"));
			bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
			bean.setDepartmentcode( resultSet.getString("departmentcode"));
			bean.setLocation( resultSet.getString("location"));
			bean.setApprovedyn( resultSet.getString("approvedyn"));
			bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
			bean.setCreatedby( resultSet.getString("createdby"));
			bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
			bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
			beansList.add(bean);
		}
		Object[] objectArray = beansList.toArray();
		beans = new ControldocumentBean[objectArray.length];
		for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
			beans[jindex] = (ControldocumentBean)objectArray[jindex];
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{ preparedStatement.close();}catch(SQLException ioe){}
	}
	return beans ;
}
	
	
	public ControldocumentBean[] findDocumentsByRoles(String usercode,boolean checkApproval )throws Exception{
		
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByDepartmentcode = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , " +
										   " controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath ," +
										   " googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , " +
										   " creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument " +
										   " WHERE departmentcode in " +
										   "	( select distinct x.groupcode from privilegeregister x,rolemaster r " +
										   "      where " +
										   "		x.groupcode = r.groupcode " +
										   "		and x.usercode = ? " +
										   "		and r.isactive = ? ) " +
										   " and approvedyn = ? " +
										   " and isdeleted = ? " ;
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByDepartmentcode );
			preparedStatement.setString(1,usercode); 
			preparedStatement.setString(2,"Y");
			preparedStatement.setString(3,"Y");
			preparedStatement.setString(4,"N");
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	
	
	public ControldocumentBean[] findDocumentforGuest(String usercode){
		
		String sqlSelectByDepartmentcode = "SELECT * FROM controldocument where approvedyn = ? and isdeleted = ? and documentid in " +
				           "(select documentid from guestdocumentmatrix where guestusercode = ? and isactive = ?)";
		
		
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByDepartmentcode );
			
			preparedStatement.setString(1,"Y");
			preparedStatement.setString(2,"N");
			preparedStatement.setString(3,usercode);
			preparedStatement.setString(4,"Y");
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
		
		
	}
	
	
	
	public ControldocumentBean[] findDocumentsByApproverRoles(String usercode)throws Exception{
		
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByDepartmentcode = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , " +
										   " controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath ," +
										   " googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , " +
										   " creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument " +
										   " WHERE departmentcode in " +
										   "	( select distinct x.groupcode from privilegeregister x,rolemaster r " +
										   "      where " +
										   "		x.groupcode = r.groupcode " +
										   "		and x.usercode = ? " +
										   "		and r.isactive = ? ) " +
										   " and isdeleted = ? " ;
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByDepartmentcode );
			preparedStatement.setString(1,usercode);
			preparedStatement.setString(2,"Y");
			preparedStatement.setString(3,"N");
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	
	public ControldocumentBean[] findByDepartmentcode(String departmentcode )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByDepartmentcode = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE departmentcode = ? and isdeleted = 'N' " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByDepartmentcode );
			preparedStatement.setString(1,departmentcode); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByLocation(String location )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByLocation = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE location = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByLocation );
			preparedStatement.setString(1,location); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	
	public ArrayList<ControldocumentBean> findByApprovedynAsList(String approvedyn )throws Exception{
		
		PreparedStatement preparedStatement = null ;
		
		ResultSet resultSet = null ;
		
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByApprovedyn = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE approvedyn = ? " ;
		try{
			preparedStatement = connection.prepareStatement( sqlSelectByApprovedyn );
			preparedStatement.setString(1,approvedyn); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				
				preparedStatement.close();
				
			} catch (SQLException ioe) {
			}
		}
		return beansList;
	}
	
	
	public ControldocumentBean[] findByApprovedyn(String approvedyn )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByApprovedyn = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE approvedyn = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByApprovedyn );
			preparedStatement.setString(1,approvedyn); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByCreationdatetime(Timestamp creationdatetime )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByCreationdatetime = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE creationdatetime = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByCreationdatetime );
			preparedStatement.setTimestamp(1,creationdatetime); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByCreatedby(String createdby )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByCreatedby = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE createdby = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByCreatedby );
			preparedStatement.setString(1,createdby); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByModifieddatetime(Timestamp modifieddatetime )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByModifieddatetime = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE modifieddatetime = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByModifieddatetime );
			preparedStatement.setTimestamp(1,modifieddatetime); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public ControldocumentBean[] findByModifiedby(Timestamp modifiedby )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		ResultSet resultSet = null ;
		ControldocumentBean[] beans = null ;
		ArrayList<ControldocumentBean> beansList = new ArrayList<ControldocumentBean>();
		String sqlSelectByModifiedby = " SELECT  documentid  , documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby FROM controldocument WHERE modifiedby = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlSelectByModifiedby );
			preparedStatement.setTimestamp(1,modifiedby); 
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				ControldocumentBean bean = new ControldocumentBean();
				bean.setDocumentid( resultSet.getInt("documentid"));
				bean.setDocumentnumber( resultSet.getString("documentnumber"));
				bean.setDocumenttype( resultSet.getString("documenttype"));
				bean.setDocumentname( resultSet.getString("documentname"));
				bean.setDocumentversion( resultSet.getString("documentversion"));
				bean.setDocumenthashkey( resultSet.getString("documenthashkey"));
				bean.setDescription( resultSet.getString("description"));
				bean.setControlfilepath( resultSet.getString("controlfilepath"));
				bean.setControlfilecreationdate( resultSet.getTimestamp("controlfilecreationdate"));
				bean.setControlfilesize( resultSet.getInt("controlfilesize"));
				bean.setSynchgoogledrive( resultSet.getString("synchgoogledrive"));
				bean.setGoogledrivesynchedtime( resultSet.getTimestamp("googledrivesynchedtime"));
				bean.setGooglefolderpath( resultSet.getString("googlefolderpath"));
				bean.setGoogledrivefileid( resultSet.getString("googledrivefileid"));
				bean.setOwnerid( resultSet.getInt("ownerid"));
				bean.setIsblocked( resultSet.getString("isblocked"));
				bean.setIsdeleted( resultSet.getString("isdeleted"));
				bean.setIspasswordprotected( resultSet.getString("ispasswordprotected"));
				bean.setDepartmentcode( resultSet.getString("departmentcode"));
				bean.setLocation( resultSet.getString("location"));
				bean.setApprovedyn( resultSet.getString("approvedyn"));
				bean.setCreationdatetime( resultSet.getTimestamp("creationdatetime"));
				bean.setCreatedby( resultSet.getString("createdby"));
				bean.setModifieddatetime( resultSet.getTimestamp("modifieddatetime"));
				bean.setModifiedby( resultSet.getTimestamp("modifiedby"));
				beansList.add(bean);
			}
			Object[] objectArray = beansList.toArray();
			beans = new ControldocumentBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				beans[jindex] = (ControldocumentBean)objectArray[jindex];
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		return beans ;
	}
	public void insertAllCols( ControldocumentBean bean )throws Exception{
		PreparedStatement preparedStatement = null ;
		String sqlInsertAllStmt = "INSERT INTO controldocument (documentnumber , documenttype , documentname , documentversion , documenthashkey , description , controlfilepath , controlfilecreationdate , controlfilesize , synchgoogledrive , googledrivesynchedtime , googlefolderpath , googledrivefileid , ownerid , isblocked , isdeleted , ispasswordprotected , departmentcode , location , approvedyn , creationdatetime , createdby , modifieddatetime , modifiedby,documentreason,usercode) VALUES (  ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?, ?,? )" ;
		try{
			preparedStatement = connection.prepareStatement(sqlInsertAllStmt);
			
			int rowIndex = 1 ;
			
			if(bean.getDocumentnumber()!= null){
				preparedStatement.setString(rowIndex, bean.getDocumentnumber());
			}else{
				preparedStatement.setNull(rowIndex,Types.VARCHAR) ;
			}
			
			rowIndex++ ;
			
			if(bean.getDocumenttype()!= null){
				preparedStatement.setString(rowIndex, bean.getDocumenttype());
			}else{
				preparedStatement.setNull(rowIndex,Types.VARCHAR) ;
			}

			rowIndex++ ;
			
			if(bean.getDocumentname()!= null){
				preparedStatement.setString(rowIndex, bean.getDocumentname());
			}else{
				preparedStatement.setNull(rowIndex,Types.VARCHAR) ;
			}

			rowIndex++ ;
			
			if(bean.getDocumentversion()!= null){
				preparedStatement.setString(rowIndex, bean.getDocumentversion());
			}else{
				preparedStatement.setNull(rowIndex,Types.VARCHAR) ;
			}

			rowIndex++ ;
			
			if(bean.getDocumenthashkey()!= null){
				preparedStatement.setString(rowIndex, bean.getDocumenthashkey());
			}else{
				preparedStatement.setNull(rowIndex,Types.VARCHAR) ;
			}

			rowIndex++ ;
			
			if(bean.getDescription()!= null){
				preparedStatement.setString(rowIndex, bean.getDescription());
			}else{
				preparedStatement.setNull(rowIndex,Types.VARCHAR) ;
			}

			rowIndex++ ;
			
			if(bean.getControlfilepath()!= null){
				preparedStatement.setString(rowIndex, bean.getControlfilepath());
			}else{
				preparedStatement.setNull(rowIndex,Types.VARCHAR) ;
			}

			rowIndex++ ;
			
			if(bean.getControlfilecreationdate()!= null){
				preparedStatement.setTimestamp(rowIndex, bean.getControlfilecreationdate());
			}else{
				preparedStatement.setNull(rowIndex,Types.DATE) ;
			}

			rowIndex++ ;
			
			if(bean.getControlfilesize()!= null){
				preparedStatement.setInt(rowIndex, bean.getControlfilesize());
			}else{
				preparedStatement.setNull(rowIndex,Types.INTEGER) ;
			}

			rowIndex++ ;
			
			if(bean.getSynchgoogledrive()!= null){
				preparedStatement.setString(rowIndex, bean.getSynchgoogledrive());
			}else{
				preparedStatement.setNull(rowIndex,Types.CHAR) ;
			}

			rowIndex++ ;
			
			if(bean.getGoogledrivesynchedtime()!= null){
				preparedStatement.setTimestamp(rowIndex, bean.getGoogledrivesynchedtime());
			}else{
				preparedStatement.setNull(rowIndex,Types.DATE) ;
			}

			rowIndex++ ;
			
			if(bean.getGooglefolderpath()!= null){
				preparedStatement.setString(rowIndex, bean.getGooglefolderpath());
			}else{
				preparedStatement.setNull(rowIndex,Types.VARCHAR) ;
			}

			rowIndex++ ;
			
			if(bean.getGoogledrivefileid()!= null){
				preparedStatement.setString(rowIndex, bean.getGoogledrivefileid());
			}else{
				preparedStatement.setNull(rowIndex,Types.VARCHAR) ;
			}

			rowIndex++ ;
			
			if(bean.getOwnerid()!= null){
				preparedStatement.setInt(rowIndex, bean.getOwnerid());
			}else{
				preparedStatement.setNull(rowIndex,Types.INTEGER) ;
			}

			rowIndex++ ;
			
			if(bean.getIsblocked()!= null){
				preparedStatement.setString(rowIndex, bean.getIsblocked());
			}else{
				preparedStatement.setNull(rowIndex,Types.CHAR) ;
			}

			rowIndex++ ;
			
			if(bean.getIsdeleted()!= null){
				preparedStatement.setString(rowIndex, bean.getIsdeleted());
			}else{
				preparedStatement.setNull(rowIndex,Types.CHAR) ;
			}

			rowIndex++ ;
			
			if(bean.getIspasswordprotected()!= null){
				preparedStatement.setString(rowIndex, bean.getIspasswordprotected());
			}else{
				preparedStatement.setNull(rowIndex,Types.CHAR) ;
			}

			rowIndex++ ;
			
			if(bean.getDepartmentcode()!= null){
				preparedStatement.setString(rowIndex, bean.getDepartmentcode());
			}else{
				preparedStatement.setNull(rowIndex,Types.VARCHAR) ;
			}

			rowIndex++ ;
			
			if(bean.getLocation()!= null){
				preparedStatement.setString(rowIndex, bean.getLocation());
			}else{
				preparedStatement.setNull(rowIndex,Types.VARCHAR) ;
			}

			rowIndex++ ;
			
			if(bean.getApprovedyn()!= null){
				preparedStatement.setString(rowIndex, bean.getApprovedyn());
			}else{
				preparedStatement.setNull(rowIndex,Types.CHAR) ;
			}

			rowIndex++ ;
			
			if(bean.getCreationdatetime()!= null){
				preparedStatement.setTimestamp(rowIndex, bean.getCreationdatetime());
			}else{
				preparedStatement.setNull(rowIndex,Types.DATE) ;
			}

			rowIndex++ ;
			
			if(bean.getCreatedby()!= null){
				preparedStatement.setString(rowIndex, bean.getCreatedby());
			}else{
				preparedStatement.setNull(rowIndex,Types.VARCHAR) ;
			}

			rowIndex++ ;
			
			if(bean.getModifieddatetime()!= null){
				preparedStatement.setTimestamp(rowIndex, bean.getModifieddatetime());
			}else{
				preparedStatement.setNull(rowIndex,Types.DATE) ;
			}

			rowIndex++ ;
			
			if(bean.getModifiedby()!= null){
				preparedStatement.setTimestamp(rowIndex, bean.getModifiedby());
			}else{
				preparedStatement.setNull(rowIndex,Types.DATE) ;
			}
			
			rowIndex++ ;
			
			if(bean.getDocumentreason()!= null){
				preparedStatement.setString(rowIndex, bean.getDocumentreason());
			}else{
				preparedStatement.setNull(rowIndex,Types.VARCHAR) ;
			}
			
			rowIndex++;
			
			preparedStatement.setString(rowIndex, bean.getUserCode());
			
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
	
	public void updateAllCols(ControldocumentBean bean)throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlUpdateAllStmt = "UPDATE controldocument SET   documentnumber = ?  , documenttype = ?  , documentname = ?  , documentversion = ?  , documenthashkey = ?  , description = ?  , controlfilepath = ?  , controlfilecreationdate = ?  , controlfilesize = ?  , synchgoogledrive = ?  , googledrivesynchedtime = ?  , googlefolderpath = ?  , googledrivefileid = ?  , ownerid = ?  , isblocked = ?  , isdeleted = ?  , ispasswordprotected = ?  , departmentcode = ?  , location = ?  , approvedyn = ?  , creationdatetime = ?  , createdby = ?  , modifieddatetime = ?  , modifiedby = ?   WHERE  documentid = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlUpdateAllStmt );
			if(bean.getDocumentnumber()!= null){
				preparedStatement.setString(1, bean.getDocumentnumber());
			}else{
				preparedStatement.setNull(1,Types.VARCHAR) ;
			}
			if(bean.getDocumenttype()!= null){
				preparedStatement.setString(2, bean.getDocumenttype());
			}else{
				preparedStatement.setNull(2,Types.VARCHAR) ;
			}
			if(bean.getDocumentname()!= null){
				preparedStatement.setString(3, bean.getDocumentname());
			}else{
				preparedStatement.setNull(3,Types.VARCHAR) ;
			}
			if(bean.getDocumentversion()!= null){
				preparedStatement.setString(4, bean.getDocumentversion());
			}else{
				preparedStatement.setNull(4,Types.VARCHAR) ;
			}
			if(bean.getDocumenthashkey()!= null){
				preparedStatement.setString(5, bean.getDocumenthashkey());
			}else{
				preparedStatement.setNull(5,Types.VARCHAR) ;
			}
			if(bean.getDescription()!= null){
				preparedStatement.setString(6, bean.getDescription());
			}else{
				preparedStatement.setNull(6,Types.VARCHAR) ;
			}
			if(bean.getControlfilepath()!= null){
				preparedStatement.setString(7, bean.getControlfilepath());
			}else{
				preparedStatement.setNull(7,Types.VARCHAR) ;
			}
			if(bean.getControlfilecreationdate()!= null){
				preparedStatement.setTimestamp(8, bean.getControlfilecreationdate());
			}else{
				preparedStatement.setNull(8,Types.DATE) ;
			}
			if(bean.getControlfilesize()!= null){
				preparedStatement.setInt(9, bean.getControlfilesize());
			}else{
				preparedStatement.setNull(9,Types.INTEGER) ;
			}
			if(bean.getSynchgoogledrive()!= null){
				preparedStatement.setString(10, bean.getSynchgoogledrive());
			}else{
				preparedStatement.setNull(10,Types.CHAR) ;
			}
			if(bean.getGoogledrivesynchedtime()!= null){
				preparedStatement.setTimestamp(11, bean.getGoogledrivesynchedtime());
			}else{
				preparedStatement.setNull(11,Types.DATE) ;
			}
			if(bean.getGooglefolderpath()!= null){
				preparedStatement.setString(12, bean.getGooglefolderpath());
			}else{
				preparedStatement.setNull(12,Types.VARCHAR) ;
			}
			if(bean.getGoogledrivefileid()!= null){
				preparedStatement.setString(13, bean.getGoogledrivefileid());
			}else{
				preparedStatement.setNull(13,Types.VARCHAR) ;
			}
			if(bean.getOwnerid()!= null){
				preparedStatement.setInt(14, bean.getOwnerid());
			}else{
				preparedStatement.setNull(14,Types.INTEGER) ;
			}
			if(bean.getIsblocked()!= null){
				preparedStatement.setString(15, bean.getIsblocked());
			}else{
				preparedStatement.setNull(15,Types.CHAR) ;
			}
			if(bean.getIsdeleted()!= null){
				preparedStatement.setString(16, bean.getIsdeleted());
			}else{
				preparedStatement.setNull(16,Types.CHAR) ;
			}
			if(bean.getIspasswordprotected()!= null){
				preparedStatement.setString(17, bean.getIspasswordprotected());
			}else{
				preparedStatement.setNull(17,Types.CHAR) ;
			}
			if(bean.getDepartmentcode()!= null){
				preparedStatement.setString(18, bean.getDepartmentcode());
			}else{
				preparedStatement.setNull(18,Types.VARCHAR) ;
			}
			if(bean.getLocation()!= null){
				preparedStatement.setString(19, bean.getLocation());
			}else{
				preparedStatement.setNull(19,Types.VARCHAR) ;
			}
			if(bean.getApprovedyn()!= null){
				preparedStatement.setString(20, bean.getApprovedyn());
			}else{
				preparedStatement.setNull(20,Types.CHAR) ;
			}
			if(bean.getCreationdatetime()!= null){
				preparedStatement.setTimestamp(21, bean.getCreationdatetime());
			}else{
				preparedStatement.setNull(21,Types.DATE) ;
			}
			if(bean.getCreatedby()!= null){
				preparedStatement.setString(22, bean.getCreatedby());
			}else{
				preparedStatement.setNull(22,Types.VARCHAR) ;
			}
			if(bean.getModifieddatetime()!= null){
				preparedStatement.setTimestamp(23, bean.getModifieddatetime());
			}else{
				preparedStatement.setNull(23,Types.DATE) ;
			}
			if(bean.getModifiedby()!= null){
				preparedStatement.setTimestamp(24, bean.getModifiedby());
			}else{
				preparedStatement.setNull(24,Types.DATE) ;
			}
			preparedStatement.setInt(25, bean.getDocumentid());
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
	
	
	
	
	public void updateColumns( ControldocumentBean bean )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlUpdateAllStmt = "UPDATE controldocument SET   documenttype = ?  , documentname = ?  , description = ?  , usercode = ?  , departmentcode = ?  , location = ? , documentreason = ?    WHERE  documentid = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlUpdateAllStmt );
			
			if(bean.getDocumenttype()!= null){
				preparedStatement.setString(1, bean.getDocumenttype());
			}else{
				preparedStatement.setNull(1,Types.VARCHAR) ;
			}
			
			if(bean.getDocumentname()!= null){
				preparedStatement.setString(2, bean.getDocumentname());
			}else{
				preparedStatement.setNull(2,Types.VARCHAR) ;
			}
			
			
			if(bean.getDescription()!= null){
				preparedStatement.setString(3, bean.getDescription());
			}else{
				preparedStatement.setNull(3,Types.VARCHAR) ;
			}
			
			
			if(bean.getUserCode()!= null){
				preparedStatement.setString(4, bean.getUserCode());
			}else{
				preparedStatement.setNull(4,Types.INTEGER) ;
			}
			
			if(bean.getDepartmentcode()!= null){
				preparedStatement.setString(5, bean.getDepartmentcode());
			}else{
				preparedStatement.setNull(5,Types.VARCHAR) ;
			}
			if(bean.getLocation()!= null){
				preparedStatement.setString(6, bean.getLocation());
			}else{
				preparedStatement.setNull(6,Types.VARCHAR) ;
			}
			
			if(bean.getDocumentreason()!= null){
				preparedStatement.setString(7, bean.getDocumentreason());
			}else{
				preparedStatement.setNull(7,Types.VARCHAR) ;
			}
			
			preparedStatement.setInt(8, bean.getDocumentid());
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
	
	
	
	
	
	public void updateDeleteStatusForGoogleFile( String googlefileId, String deleteStatus )throws Exception{
		
		PreparedStatement preparedStatement = null ;
		
		String sqlUpdateAllStmt = "UPDATE controldocument SET isdeleted = ?  WHERE  googledrivefileid = ? " ;
		
		try{
			preparedStatement = connection.prepareStatement( sqlUpdateAllStmt );
						
			if(deleteStatus!= null){
				preparedStatement.setString(1, deleteStatus);
			}else{
				preparedStatement.setNull(1,Types.CHAR) ;
			}
			
			preparedStatement.setString(2, googlefileId);
			
			preparedStatement.executeUpdate();
			
			connection.commit();
		}catch(Exception e){
			connection.rollback();
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
		try{ preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	
	public void updateApproveStatusForDocuments(List<ControldocumentBean> selectedDocuments)throws Exception{
		
		PreparedStatement preparedStatement = null ;
		
		String sqlUpdateAllStmt = "UPDATE controldocument SET approvedyn = ?  WHERE  documentid = ? " ;
		
		try{
			
			preparedStatement = connection.prepareStatement( sqlUpdateAllStmt );
				
			for(ControldocumentBean documentBean : selectedDocuments){
				
				preparedStatement.setString(1, "Y");
				
				preparedStatement.setInt(2, documentBean.documentid);
				
				preparedStatement.addBatch();
				
				preparedStatement.clearParameters();
				
			}			
			
			preparedStatement.executeBatch();
			
			connection.commit();
			
		} catch (Exception e) {
			
			connection.rollback();
			
			e.printStackTrace();
			
			throw new Exception(e.getMessage());
		
		} finally {
			
			try {
			
				preparedStatement.close();
			
			} catch (Exception ioe) {
			
			}
		}
	}		
	
	public void deleteAllByPK( ControldocumentBean bean )throws Exception{
		String sqlDeleteAll = "DELETE FROM controldocument WHERE  documentid = ?  " ;
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
	public void deleteByDocumentnumber(String documentnumber )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByDocumentnumber = " DELETE FROM controldocument WHERE documentnumber = ? " ;
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
	public void deleteByDocumenttype(String documenttype )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByDocumenttype = " DELETE FROM controldocument WHERE documenttype = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByDocumenttype );
			preparedStatement.setString(1,documenttype); 
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
		String sqlDeleteByDocumentname = " DELETE FROM controldocument WHERE documentname = ? " ;
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
	public void deleteByDocumentversion(String documentversion )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByDocumentversion = " DELETE FROM controldocument WHERE documentversion = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByDocumentversion );
			preparedStatement.setString(1,documentversion); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByDocumenthashkey(String documenthashkey )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByDocumenthashkey = " DELETE FROM controldocument WHERE documenthashkey = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByDocumenthashkey );
			preparedStatement.setString(1,documenthashkey); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByDescription(String description )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByDescription = " DELETE FROM controldocument WHERE description = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByDescription );
			preparedStatement.setString(1,description); 
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
		String sqlDeleteByControlfilepath = " DELETE FROM controldocument WHERE controlfilepath = ? " ;
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
	public void deleteByControlfilecreationdate(Timestamp controlfilecreationdate )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByControlfilecreationdate = " DELETE FROM controldocument WHERE controlfilecreationdate = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByControlfilecreationdate );
			preparedStatement.setTimestamp(1,controlfilecreationdate); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByControlfilesize(int controlfilesize )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByControlfilesize = " DELETE FROM controldocument WHERE controlfilesize = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByControlfilesize );
			preparedStatement.setInt(1,controlfilesize); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteBySynchgoogledrive(String synchgoogledrive )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteBySynchgoogledrive = " DELETE FROM controldocument WHERE synchgoogledrive = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteBySynchgoogledrive );
			preparedStatement.setString(1,synchgoogledrive); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByGoogledrivesynchedtime(Timestamp googledrivesynchedtime )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByGoogledrivesynchedtime = " DELETE FROM controldocument WHERE googledrivesynchedtime = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByGoogledrivesynchedtime );
			preparedStatement.setTimestamp(1,googledrivesynchedtime); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByGooglefolderpath(String googlefolderpath )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByGooglefolderpath = " DELETE FROM controldocument WHERE googlefolderpath = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByGooglefolderpath );
			preparedStatement.setString(1,googlefolderpath); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByGoogledrivefileid(String googledrivefileid )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByGoogledrivefileid = " DELETE FROM controldocument WHERE googledrivefileid = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByGoogledrivefileid );
			preparedStatement.setString(1,googledrivefileid); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByOwnerid(int ownerid )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByOwnerid = " DELETE FROM controldocument WHERE ownerid = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByOwnerid );
			preparedStatement.setInt(1,ownerid); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByIsblocked(String isblocked )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByIsblocked = " DELETE FROM controldocument WHERE isblocked = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByIsblocked );
			preparedStatement.setString(1,isblocked); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByIsdeleted(String isdeleted )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByIsdeleted = " DELETE FROM controldocument WHERE isdeleted = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByIsdeleted );
			preparedStatement.setString(1,isdeleted); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByIspasswordprotected(String ispasswordprotected )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByIspasswordprotected = " DELETE FROM controldocument WHERE ispasswordprotected = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByIspasswordprotected );
			preparedStatement.setString(1,ispasswordprotected); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByDepartmentcode(String departmentcode )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByDepartmentcode = " DELETE FROM controldocument WHERE departmentcode = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByDepartmentcode );
			preparedStatement.setString(1,departmentcode); 
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
		String sqlDeleteByLocation = " DELETE FROM controldocument WHERE location = ? " ;
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
	public void deleteByApprovedyn(String approvedyn )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByApprovedyn = " DELETE FROM controldocument WHERE approvedyn = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByApprovedyn );
			preparedStatement.setString(1,approvedyn); 
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
		String sqlDeleteByCreationdatetime = " DELETE FROM controldocument WHERE creationdatetime = ? " ;
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
		String sqlDeleteByCreatedby = " DELETE FROM controldocument WHERE createdby = ? " ;
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
	public void deleteByModifieddatetime(Timestamp modifieddatetime )throws Exception{
		
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByModifieddatetime = " DELETE FROM controldocument WHERE modifieddatetime = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByModifieddatetime );
			preparedStatement.setTimestamp(1,modifieddatetime); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}
	public void deleteByModifiedby(Timestamp modifiedby )throws Exception{
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		String sqlDeleteByModifiedby = " DELETE FROM controldocument WHERE modifiedby = ? " ;
		try{
			preparedStatement = conn.prepareStatement( sqlDeleteByModifiedby );
			preparedStatement.setTimestamp(1,modifiedby); 
			preparedStatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
	}


	public boolean fileApproved(String googleFileId) throws Exception {
		
		Boolean status = false;
		
		DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
		Connection conn = dbDatabaseHandler.getConnection();
		PreparedStatement preparedStatement = null ;
		
		try {
			
			preparedStatement = conn.prepareStatement("update controldocument set approvedyn = 'Y' where googledrivefileid = ?");
			
			preparedStatement.setString(1, googleFileId);
			
			int rowCount = preparedStatement.executeUpdate();
			
			System.out.println("ROW COUNT:: "+rowCount);
			
			if(rowCount > 0){
				
				conn.commit();
				status = true;
				
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
		}
		
		return status;
	}


public boolean fileUnapproved(String googleFileId) throws Exception {
	
	Boolean status = false;
	
	DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
	Connection conn = dbDatabaseHandler.getConnection();
	PreparedStatement preparedStatement = null ;
	
	try {
		
		preparedStatement = conn.prepareStatement("update controldocument set approvedyn = 'N' where googledrivefileid = ?");
		
		preparedStatement.setString(1, googleFileId);
		
		int rowCount = preparedStatement.executeUpdate();
		
		System.out.println("ROW COUNT:: "+rowCount);
		
		if(rowCount > 0){
			
			conn.commit();
			status = true;
			
		}
		
	} catch(Exception e){
		e.printStackTrace();
	}finally{
		try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
	}
	
	return status;
}


public boolean filereject(String googleFileId) throws Exception {
	
	Boolean status = false;
	
	DatabaseHandler dbDatabaseHandler = DatabaseHandler.getNewInstance();
	Connection conn = dbDatabaseHandler.getConnection();
	PreparedStatement preparedStatement = null ;
	
	try {
		
		preparedStatement = conn.prepareStatement("update controldocument set approvedyn = 'R' where googledrivefileid = ?");
		
		preparedStatement.setString(1, googleFileId);
		
		int rowCount = preparedStatement.executeUpdate();
		
		System.out.println("ROW COUNT:: "+rowCount);
		
		if(rowCount > 0){
			
			conn.commit();
			status = true;
			
		}
		
	} catch(Exception e){
		e.printStackTrace();
	}finally{
		try{ dbDatabaseHandler.closeConnection();preparedStatement.close();}catch(SQLException ioe){}
	}
	
	return status;
}


}
