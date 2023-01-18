package model;

public class Department {

	private String dname;
	private int did;
	private  int dmanager;
	private String location;
	
	public Department() {
		
	}
	
	public Department(String dname, int did, int dmanager, String location) {
		super();
		this.dname = dname;
		this.did = did;
		this.dmanager = dmanager;
		this.location = location;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public int getDmanager() {
		return dmanager;
	}

	public void setDmanager(int dmanager) {
		this.dmanager = dmanager;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department [dname=" + dname + ", did=" + did + ", dmanager=" + dmanager + ", location=" + location
				+ "]";
	}
	
	
	
}
