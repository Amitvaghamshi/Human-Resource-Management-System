package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	
	
	
	

	@Override
	public String addEmployee(Employee emp) throws EmployeeException {
		  String add="No";
		  
		  try(Connection conn=DBUtil.getConnection()){
		PreparedStatement st=	conn.prepareStatement("insert into employee(name ,phone ,email ,username ,password ,dob ,gender ,address ,joindate ) values(?,?,?,?,?,?,?,?,?) ");
			st.setString(1, emp.getName());
			st.setString(2, emp.getPhone());
			st.setString(3, emp.getEmail());
			st.setNString(4, emp.getUsername());
			st.setString(5, emp.getPassword());
			st.setDate(6, emp.getDob());
			st.setString(7, emp.getGender());
			st.setString(8, emp.getAddress());
			st.setDate(9, emp.getJoindate());
			  
			int x=st.executeUpdate();
			if(x>0) {
				add="Yes";
			}
			  
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		  
		  return add;
	}

	
	
}
