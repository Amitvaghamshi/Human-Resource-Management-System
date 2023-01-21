package model;

public class Project {

	 private int  projectid;
	 private String proname;
	 private int duration;
	 private int deptid;
	 
	public Project(int projectid, String proname, int duration, int deptid) {
		super();
		this.projectid = projectid;
		this.proname = proname;
		this.duration = duration;
		this.deptid = deptid;
	}
	
	public Project() {
		
	}
	
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	
	
	
	@Override
	public String toString() {
		return "Project [projectid=" + projectid + ", proname=" + proname + ", duration=" + duration + ", deptid="
				+ deptid + "]";
	}
	 
	
	
}
