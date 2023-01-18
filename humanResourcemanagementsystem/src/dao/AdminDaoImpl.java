package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DBUtil;

public class AdminDaoImpl implements AdminsDao{

	@Override
	public boolean loginAdmin(String username,String passworld) {
		boolean get=false;
		
		try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement st=conn.prepareStatement("");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return get;
	}

}
