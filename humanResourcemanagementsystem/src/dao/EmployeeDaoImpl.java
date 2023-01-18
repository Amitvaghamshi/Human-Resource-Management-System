package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import exception.EmployeeException;
import model.Employee;
import util.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public Employee loginEmployee(String username, String password) {
        Employee emp=null;
		
		try(Connection conn=DBUtil.getConnection()){
			PreparedStatement st=conn.prepareStatement("select * from employee where username =? and password = ?");
			st.setString(1, username);
			st.setString(2, password);
			
			ResultSet set=st.executeQuery();
			if(set.next()){
				int empid=set.getInt("empid");
				String name=set.getString("name");
				int did=set.getInt("deptid");
				int pid=set.getInt("projectid");
				
				emp=new Employee();
				emp.setEmpid(empid);
				emp.setName(username);
				emp.setDepartmentid(did);
				emp.setProjectid(pid);
			}
		}catch (Exception e) {
			new EmployeeException(e.getMessage());
		}
		return emp;
	}

	
	
}
