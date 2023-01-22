package model;

import java.sql.Date;

public class LeaveEmployeeDTO {
    private String name;
	private int empid;
	private Date fromdate;
	private Date todate;
	private String reason;
	private String isapproved;
	private int leaveid;
	
	public LeaveEmployeeDTO() {
		   
	}

	public LeaveEmployeeDTO(String name, int empid, Date fromdate, Date todate, String reason, String isapproved,
			int leaveid) {
		super();
		this.name = name;
		this.empid = empid;
		this.fromdate = fromdate;
		this.todate = todate;
		this.reason = reason;
		this.isapproved = isapproved;
		this.leaveid = leaveid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public Date getFromdate() {
		return fromdate;
	}

	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}

	public Date getTodate() {
		return todate;
	}

	public void setTodate(Date todate) {
		this.todate = todate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getIsapproved() {
		return isapproved;
	}

	public void setIsapproved(String isapproved) {
		this.isapproved = isapproved;
	}

	public int getLeaveid() {
		return leaveid;
	}

	public void setLeaveid(int leaveid) {
		this.leaveid = leaveid;
	}

	@Override
	public String toString() {
		return "LeaveEmployeeDTO [name=" + name + ", empid=" + empid + ", fromdate=" + fromdate + ", todate=" + todate
				+ ", reason=" + reason + ", isapproved=" + isapproved + ", leaveid=" + leaveid + "]";
	}
	
	
}
