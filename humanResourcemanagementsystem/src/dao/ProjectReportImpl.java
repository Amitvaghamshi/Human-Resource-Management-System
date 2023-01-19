package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

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

}
