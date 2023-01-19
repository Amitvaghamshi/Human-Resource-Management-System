package dao;

import java.util.List;

import exception.LeaveException;
import model.Leave;

public interface LeaveDao {

	public String applyForLeave(Leave leave) throws LeaveException;
	public List<Leave> getLeaveDetais(int empid) throws LeaveException;
}
