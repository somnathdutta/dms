package org.sap.birlatyres.core.gen.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import org.sap.birlatyres.core.db.DatabaseHandler;
import org.sap.birlatyres.core.gen.bean.ControldocumentBean;
import org.sap.birlatyres.core.gen.bean.GuestMasterBean;
import org.sap.birlatyres.core.gen.bean.GuestUserMastBean;

public class GuestUserMasterDao {
	
	int updatecount = 0;
	
	private Connection connection ; 
	public GuestUserMasterDao(){
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
	
	
	
	public GuestUserMastBean getGuest(String username,String password) throws Exception{
	
		PreparedStatement preparestmt = null;
		
		String sql = "select * from guestusermaster where guestusername = ? and guestpassword = ?";
		
		GuestUserMastBean guestbean = null;
		
		
		try {
			
			preparestmt = connection.prepareStatement(sql);
			
			preparestmt.setString(1, username);
			preparestmt.setString(2, password);
			
			ResultSet guestRS = preparestmt.executeQuery();
			
			while(guestRS.next()){
				
				guestbean= new GuestUserMastBean();
				
				guestbean.setGuestusername(guestRS.getString("guestusername"));
				guestbean.setGuestpassword(guestRS.getString("guestpassword"));
				guestbean.setGuestusercode(guestRS.getString("guestusercode"));
				guestbean.setPhoneno(guestRS.getString("phoneno"));
				guestbean.setIsactive(guestRS.getString("isactive"));
				guestbean.setStartdate(guestRS.getString("startdate"));
				guestbean.setEnddate(guestRS.getString("enddate"));
				guestbean.setAllowview(guestRS.getString("allowview"));
				guestbean.setAllowdownload(guestRS.getString("allowdownload"));
				guestbean.setAllowprint(guestRS.getString("allowprint"));
				guestbean.setAllowupload(guestRS.getString("allowupload"));
			
			}
	
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			throw new Exception(e.getMessage());
		}finally{
			
			if(preparestmt != null) { 
				
				preparestmt.close() ;
			}
			
			
		}
		
		return guestbean;
		
	}
	
	
	
	public int newGuestregister(GuestMasterBean bean) throws Exception{
	
		PreparedStatement preparedStatement = null ;
		
		String sqlInsertAllStmt = "INSERT INTO guestusermaster(guestusername  , guestpassword , guestusercode , phoneno , startdate , enddate , isactive , allowview , allowdownload , allowprint , allowupload) VALUES (?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ?  , ? )" ;
		try{
			preparedStatement = connection.prepareStatement( sqlInsertAllStmt );
			preparedStatement.setString(1, bean.getGuestusername());
			preparedStatement.setString(2, bean.getGuestpassword());
			preparedStatement.setString(3, bean.getGuestcode());
			if(bean.getGuestponeno()!= null || bean.getGuestponeno() != ""){
				preparedStatement.setString(4, bean.getGuestponeno());
			}else{
				preparedStatement.setNull(4,Types.VARCHAR) ;
			}
			if(bean.getStartdate()!= null ){
				
				java.sql.Date sqlstartDate = new java.sql.Date(bean.getEnddate().getTime());
				
				preparedStatement.setDate(5, sqlstartDate);
				
			}else{
				preparedStatement.setNull(5,java.sql.Types.DATE) ;
			}
			if(bean.getEnddate()!= null ){
			
			    java.sql.Date sqlendDate = new java.sql.Date(bean.getEnddate().getTime());
				
				preparedStatement.setDate(6, sqlendDate);
				
			}else{
				
				preparedStatement.setNull(6,java.sql.Types.DATE) ;
			}
			
			preparedStatement.setString(7, bean.getIsactive());
			preparedStatement.setString(8, bean.getAllowview());
			preparedStatement.setString(9, bean.getAllowdownload());
			preparedStatement.setString(10, bean.getAllowprint());
			preparedStatement.setString(11, bean.getAllowupload());
			
			updatecount = preparedStatement.executeUpdate();
			
		
		}catch(Exception e){
			
			connection.rollback();
			
			e.printStackTrace();
			
			throw new Exception(e.getMessage());
		
		}finally{
			
			if(preparedStatement != null) { 
				
				preparedStatement.close() ;
			}
			
			connection.commit();
		}
	
		return updatecount;
		
	}
	
	String guestusername = null;
	public String getGusetusername(String guestusercode) throws Exception{
		
		PreparedStatement preparestmt = null;
		
		String sql = "select guestusername from guestusermaster where guestusercode = ?";
		
		try {
			
			preparestmt = connection.prepareStatement(sql);
			preparestmt.setString(1, guestusercode);
			
			ResultSet rs = preparestmt.executeQuery();
			
			if(rs.next()){
				
				guestusername = rs.getString("guestusername");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new Exception(e.getMessage());
		}finally{
			
			if(preparestmt != null) { 
				
				preparestmt.close() ;
			}
		}
		
		return guestusername;
		
	}
	
	int guestdocumentmatrixcount = 0;
	public int insertGuestDocumentMatrix(String guestUsercode, int documentId, String isActive) throws Exception{
		
		PreparedStatement prepatestatement = null;
		
		String sql = "INSERT INTO guestdocumentmatrix(guestusercode , documentid, isactive) VALUES (?,?,?)";
		
		try {
			
			prepatestatement = connection.prepareStatement(sql);
			
			prepatestatement.setString(1, guestUsercode);
			
			prepatestatement.setInt(2, documentId);
			
			prepatestatement.setString(3, isActive);
			
			
			guestdocumentmatrixcount = prepatestatement.executeUpdate();
			
		} catch (Exception e) {
			
			connection.rollback();
			
			e.printStackTrace();
			
			throw new Exception(e.getMessage());
		}finally{
			
			if(prepatestatement != null) { 
				
				prepatestatement.close() ;
			}
			
			connection.commit();
		}
	
		return guestdocumentmatrixcount;
	
	}
	
	
	
	
	public GuestUserMastBean[] getGuestuserforapprove() throws Exception{
		
		PreparedStatement preparestmt = null;
		
		String sql = "select * from guestusermaster where isactive = 'N'";
		
		GuestUserMastBean[] guestbeanarray = null;
		
		ArrayList<GuestUserMastBean> guestusermastbeanlist = new ArrayList<GuestUserMastBean>();
		
		try {
			
			preparestmt = connection.prepareStatement(sql);
			
			ResultSet guestRS = preparestmt.executeQuery();
			
			while(guestRS.next()){
				
				GuestUserMastBean guestbean= new GuestUserMastBean();
				
				guestbean.setGuestusername(guestRS.getString("guestusername"));
				guestbean.setGuestpassword(guestRS.getString("guestpassword"));
				guestbean.setGuestusercode(guestRS.getString("guestusercode"));
				guestbean.setPhoneno(guestRS.getString("phoneno"));
				guestbean.setIsactive(guestRS.getString("isactive"));
				guestbean.setStartdate(guestRS.getString("startdate"));
				guestbean.setEnddate(guestRS.getString("enddate"));
				guestbean.setAllowview(guestRS.getString("allowview"));
				guestbean.setAllowdownload(guestRS.getString("allowdownload"));
				guestbean.setAllowprint(guestRS.getString("allowprint"));
				guestbean.setAllowupload(guestRS.getString("allowupload"));
				
				guestusermastbeanlist.add(guestbean);
				
			}
			
			Object[] objectArray = guestusermastbeanlist.toArray();
			
			guestbeanarray = new GuestUserMastBean[objectArray.length];
			for(int jindex = 0 ; jindex < objectArray.length ; jindex++){
				guestbeanarray[jindex] = (GuestUserMastBean)objectArray[jindex];
			}

			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			throw new Exception(e.getMessage());
		}finally{
			
			if(preparestmt != null) { 
				
				preparestmt.close() ;
			}
			
			//connection.commit();
		}
		
		return guestbeanarray;
		
	}
	
	int result = 0;
	public int updateGuestiaActiveStatus(String guestUsercode,String guestUsername) throws Exception{
		
		PreparedStatement preparestmt = null;
		
		String sql = "update guestusermaster set isactive = 'Y' where guestusercode = ? and guestusername = ?";
		
		try {
			
			preparestmt = connection.prepareStatement(sql);
			
			preparestmt.setString(1, guestUsercode);
			
			preparestmt.setString(2, guestUsername);
			
			
			result = preparestmt.executeUpdate();
			
		} catch (Exception e) {

			connection.rollback();
			
			e.printStackTrace();
			
			throw new Exception(e.getMessage());
		}finally{
			
			if(preparestmt != null) { 
				
				preparestmt.close() ;
			}
			
			connection.commit();
			
			
		}
		
		return result;
		
	}
	

}











