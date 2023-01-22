package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import exception.LeaveException;
import exception.LoanException;
import model.Leave;
import model.LeaveEmployeeDTO;
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
			
			  PreparedStatement st=conn.prepareStatement("select * from leaves where empid=?");
			  st.setInt(1, empid);
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



	@Override
	public String approveLeave(int empid, int leaveid, int res) throws LeaveException {
		 
		 String app="No";
			
			try(Connection conn=DBUtil.getConnection()){
				String status="reject";
				if(res==1) {
					status="approved";
				}else if(res==0) {
					status="reject";
				}else {
					throw new LeaveException("You have select wrong Option");
				}
				PreparedStatement st=conn.prepareStatement("update leaves set isapproved =? where empid=? and leaveid=?");
				st.setString(1, status);
				st.setInt(2, empid);
				st.setInt(3, leaveid);
				
				int x=st.executeUpdate();
				if(x>0) {
					app="Yes";
				}
				
			} catch (Exception e) {
				throw new LeaveException(e.getMessage());
			}
			return app;
	}



	@Override
	public List<LeaveEmployeeDTO> getPendingLeaveDetails() throws LeaveException {
		List<LeaveEmployeeDTO> li=new ArrayList<>();
		
		try(Connection conn=DBUtil.getConnection()){
			
			PreparedStatement st= conn.prepareStatement(" select e.empid as eid, name,fromdate ,todate ,reason,isapproved,leaveid from leaves l join employee e on e.empid=l.empid and isapproved='pending' ");
			ResultSet set=st.executeQuery();
			while(set.next()) {
				   LeaveEmployeeDTO tamp=new LeaveEmployeeDTO();
				   tamp.setEmpid(set.getInt("eid"));
				   tamp.setName(set.getString("name"));
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
