package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import exception.DepartmentException;
import model.Department;
import util.DBUtil;

public class DepartmentDaoImpl implements DepartmentDao{

	@Override
	public String addDepartment(Department dept) throws DepartmentException {
		 String add="No";
		 
		 try(Connection conn=DBUtil.getConnection()){
			
		  PreparedStatement st=conn.prepareStatement("insert into department values(?,?,?,?)");
		  st.setString(1, dept.getDname());
		  st.setInt(2, dept.getDid());
		  st.setInt(3, dept.getDmanager());
		  st.setString(4, dept.getLocation());
		  
		  int x=st.executeUpdate();
		  if(x>0) {
			  add="Yes";
		  }
		} catch (SQLException e) {
			throw new DepartmentException(e.getMessage());
		}
		 
		 return add;
	}
	
	
	
  
	
}
