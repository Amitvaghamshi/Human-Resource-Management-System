package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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






	@Override
	public int countOfEmployee() {
		 int count=0;
		 
		 try(Connection conn=DBUtil.getConnection()){
			 
			 PreparedStatement st=conn.prepareStatement("select count(*) as total from employee");
			 ResultSet set= st.executeQuery();
			 if(set.next()){
				   count=set.getInt("total");
			 }
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		 
		 return count;
	}






	@Override
	public List<Employee> getAllEmployee() throws EmployeeException {
		List<Employee> li=new ArrayList<>();
		
		try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement st=conn.prepareStatement("select * from employee");
			ResultSet set=st.executeQuery();
			while(set.next()) {
				Employee tamp=new Employee();
				tamp.setName(set.getString("name"));
				tamp.setEmpid(set.getInt("empid"));
				tamp.setDepartmentid(set.getInt("deptid"));
				tamp.setProjectid(set.getInt("projectid"));
				tamp.setPhone(set.getString("phone"));
				tamp.setEmail(set.getString("email"));
				tamp.setUsername(set.getString("username"));
				tamp.setPassword(set.getString("password"));
				tamp.setDob(set.getDate("dob"));
				tamp.setGender(set.getString("gender"));
				tamp.setAddress(set.getString("address"));
				tamp.setJoindate(set.getDate("joindate"));
				tamp.setSalary(set.getInt("salary"));
				
				li.add(tamp);
			}
			if(li.isEmpty()) {
				throw new EmployeeException("No record Found");
			}
		} catch (Exception e) {
			throw new EmployeeException(e.getMessage());
		}
		return li;
	}






	@Override
	public List<Employee> getEmployeeByName(String name) throws EmployeeException {
		List<Employee> li=new ArrayList<>();
		
           try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement st=conn.prepareStatement("select * from employee where name like ?");
			st.setString(1, name+'%');
			
			ResultSet set=st.executeQuery();
			while(set.next()){
				Employee tamp=new Employee();
				tamp.setName(set.getString("name"));
				tamp.setEmpid(set.getInt("empid"));
				tamp.setDepartmentid(set.getInt("deptid"));
				tamp.setProjectid(set.getInt("projectid"));
				li.add(tamp);
				
			}
			
			if(li.isEmpty()) {
				throw new EmployeeException("No record Found");
			}
		} catch (Exception e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return li;
	}

	
	
}
