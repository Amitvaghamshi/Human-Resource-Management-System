package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import exception.LeaveException;
import model.Leave;
import util.DBUtil;

public class LeaveDaoImpl implements LeaveDao{

	@Override
	public String applyForLeave(Leave leave) throws LeaveException{
		  String app="No";
		  
		  try(Connection conn=DBUtil.getConnection()){
			 
			 PreparedStatement st=conn.prepareStatement("insert into leaves values(?,?,?,?,?,?)");
			 st.setInt(1, leave.getEmpid());
			 st.setDate(2,leave.getFromdate());
			 st.setDate(3, leave.getTodate());
			 st.setString(4, leave.getReason());
			 st.setString(5, "Pending");
			 st.setNull(6, 0);
			 
			 int x= st.executeUpdate();
			 if(x>0){
				 app="Yes";
			 }
		} catch (Exception e) {
			throw new LeaveException(e.getMessage());
		}
		  return app;
	}

	
	
	@Override
	public List<Leave> getLeaveDetais(int empid) throws LeaveException {
		  List<Leave> li=new ArrayList<>();
		  
		  try(Connection conn=DBUtil.getConnection()){
			
			  PreparedStatement st=conn.prepareStatement("select * from leaves");
			  ResultSet set=st.executeQuery();
			  while(set.next()) {
				  Leave tamp=new Leave();
				  tamp.setEmpid(set.getInt("empid"));
				  tamp.setFromdate(set.getDate("fromdate"));
				  tamp.setTodate(set.getDate("todate"));
				  tamp.setReason(set.getString("reason"));
				  tamp.setIsapproved(set.getString("isapproved"));
				  tamp.setLeaveid(set.getInt("leaveid"));
				  
				  li.add(tamp);
			  }
			  
			  if(li.isEmpty()) {
				  throw new LeaveException("No Record Found");
			  }
			  
		} catch (Exception e) {
			throw new LeaveException(e.getMessage());
		}
		  
		  return li;
	}

}
