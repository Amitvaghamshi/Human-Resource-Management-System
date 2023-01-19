package model;

import java.sql.Date;

public class ProjectReport {
	
	private int empid;
	private int taskcompleted;
	private int taskpending;
	private String description;
	private Date subtime;

	public ProjectReport(){
		
	}

	public ProjectReport(int empid, int taskcompleted, int taskpending, String description, Date subtime) {
		super();
		this.empid = empid;
		this.taskcompleted = taskcompleted;
		this.taskpending = taskpending;
		this.description = description;
		this.subtime = subtime;
	}
	
	

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public int getTaskcompleted() {
		return taskcompleted;
	}

	public void setTaskcompleted(int taskcompleted) {
		this.taskcompleted = taskcompleted;
	}

	public int getTaskpending() {
		return taskpending;
	}

	public void setTaskpending(int taskpending) {
		this.taskpending = taskpending;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getSubtime() {
		return subtime;
	}

	public void setSubtime(Date subtime) {
		this.subtime = subtime;
	}

	@Override
	public String toString() {
		return "ProjectReport [empid=" + empid + ", taskcompleted=" + taskcompleted + ", taskpending=" + taskpending
				+ ", description=" + description + ", subtime=" + subtime + "]";
	}
	
	
}
