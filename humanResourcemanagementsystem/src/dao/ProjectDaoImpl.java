package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import exception.ProjectException;
import model.Project;
import util.DBUtil;

public class ProjectDaoImpl implements ProjectDao{

	@Override
	public int countProject() {
		  int count=0;
		  
		  try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement st=  conn.prepareStatement("select count(*) as total from projects");
			ResultSet set= st.executeQuery();
			if(set.next()) {
				count=set.getInt("total");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		  
		  return count; 
	}

	@Override
	public List<Project> getProjectsDetail() {
		List<Project> li=new ArrayList<>();
		try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement st=conn.prepareStatement("select * from projects");
			ResultSet set= st.executeQuery();
			while(set.next()) {
				  Project tamp=new Project();
				  tamp.setProjectid(set.getInt("projectid"));
				  tamp.setProname(set.getString("proname"));
				  li.add(tamp);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return li;
	}

	@Override
	public String assignProject(int empid, int proid) throws ProjectException{
		String ass="No";
		
		try(Connection conn=DBUtil.getConnection()){
			
		  PreparedStatement st=conn.prepareStatement("update employee set projectid =? where empid =?");
		  st.setInt(1, proid);
		  st.setInt(2, empid);
		  int x= st.executeUpdate();
		  if(x>0) {
			   ass="Yes";
		  }else {
			  throw new ProjectException("Oopps! Something Problem");
		  }
			
		} catch (Exception e) {
			throw new ProjectException(e.getMessage());
		}
		
		return ass;
	}

	
}
