package dao;

import java.sql.Connection;

import util.DBUtil;

public class AdminDaoImpl implements AdminsDao{

	@Override
	public boolean loginAdmin(String username,String passworld) {
		boolean get=false;
		
		try(Connection conn=DBUtil.getConnection()){
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return get;
	}

}
