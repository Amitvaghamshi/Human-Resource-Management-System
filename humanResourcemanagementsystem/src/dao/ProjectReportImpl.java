package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exception.ProjectReportException;
import model.Project;
import model.ProjectReport;
import util.DBUtil;

public class ProjectReportImpl implements ProjectReportDao{

	@Override
	public String addProjectReport(ProjectReport repo) {
		    String add="No";
		    
		    try(Connection conn=DBUtil.getConnection()){
				
		    PreparedStatement st=conn.prepareStatement("insert into projectreport values(?,?,?,?,sysdate()) ");
		    st.setInt(1, repo.getEmpid());
		    st.setInt(2, repo.getTaskcompleted());
		    st.setInt(3, repo.getTaskpending());
		    st.setString(4, repo.getDescription());
//		    Date dt=new Date(System.currentTimeMillis());
//		    st.setDate(5,dt);
		     int x=st.executeUpdate();
		     if(x>0) {
		    	 add="Yes";
		     }
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		    return add;
	}

	
	@Override
	public List<ProjectReport> getProjectDetaisByEmpId(int empid) throws ProjectReportException{
		List<ProjectReport> li=new ArrayList<>();
		
		try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement st= conn.prepareStatement("select * from projectreport where empid=?");
			st.setInt(1, empid);
			ResultSet set= st.executeQuery();
			
			while(set.next()) {
				ProjectReport tamp=new ProjectReport();
				
				tamp.setEmpid(set.getInt("empid"));
				tamp.setTaskcompleted(set.getInt("taskcompleted"));
				tamp.setTaskpending(set.getInt("taskpending"));
				tamp.setDescription(set.getString("description"));
				tamp.setSubtime(set.getDate("subtime"));
				
				li.add(tamp);
			}
			if(li.isEmpty()) {
				throw new  ProjectReportException("No Record Found");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return li;
	}
	

}
