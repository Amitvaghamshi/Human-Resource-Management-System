package dao;

import java.util.List;

import exception.LeaveException;
import model.Leave;
import model.LeaveEmployeeDTO;

public interface LeaveDao {

	public String applyForLeave(Leave leave) throws LeaveException;
	public List<Leave> getLeaveDetais(int empid) throws LeaveException;
	public String approveLeave(int empid,int leaveid,int res) throws LeaveException;
	public List<LeaveEmployeeDTO> getPendingLeaveDetails() throws LeaveException;
}
