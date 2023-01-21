package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	
	
	@Override
	public int countDepartment() {
		int count=0;
		try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement st=conn.prepareStatement("select count(*) as total from department");
			ResultSet set=st.executeQuery();
			while(set.next()) {
				  count=set.getInt("total");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return count;
	}



	@Override
	public List<Department> getDeptDetal() {
		List<Department> li=new ArrayList<>();
		
            try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement st=conn.prepareStatement("select * from department");
			ResultSet set=st.executeQuery();
			while(set.next()) {
				 Department tamp=new Department();
				 tamp.setDid(set.getInt("did"));
				 tamp.setDname(set.getString("dname"));
				 li.add(tamp);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
            
            return li;
	}



	@Override
	public String assignDepartment(int eid,int deptid) throws DepartmentException{
		  String ass="No";
		  
		  try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement st= conn.prepareStatement("update employee set deptid  =? where empid=?");
			st.setInt(1, deptid);
			st.setInt(2, eid);
			
			int x=st.executeUpdate();
			if(x>0) {
				ass="Yes";
			}else {
				throw new DepartmentException("Opps you Enter something wrongdata");
			}
		} catch (Exception e) {
			throw new DepartmentException(e.getMessage());
		}
		  return ass;
	}
	
	
	
  
	
}
