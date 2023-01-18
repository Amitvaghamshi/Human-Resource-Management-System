package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import exception.AdminException;
import util.DBUtil;

public class AdminDaoImpl implements AdminsDao{

	@Override
	public boolean loginAdmin(String username,String passworld) throws AdminException{
		boolean get=false;
		
		try(Connection conn=DBUtil.getConnection()){
			PreparedStatement st=conn.prepareStatement("select * from admins where username =? and password = ?");
			st.setString(1, username);
			st.setString(2, passworld);
			
			ResultSet set=st.executeQuery();
			if(set.next()) {
				return true;
			}else {
				throw new AdminException("User Not Found!");
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return get;
	}

}
