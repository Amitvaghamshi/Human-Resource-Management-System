package model;

import java.sql.Date;

public class Employee {

	 private int empid; 
	 private String name;
	 private String phone;
	 private String email;
	 private String username;
	 private String password;
	 private int departmentid;
	 private Date dob;
	 private String gender;
	 private String address;
	 private Date joindate;
	 private int salary;
	 private int projectid;
	 
	public Employee(){
		 
	 }

	public Employee(int empid, String name, String phone, String email, String username, String password,
			int departmentid, Date dob, String gender, String address, Date joindate, int salary, int projectid) {
		super();
		this.empid = empid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
		this.departmentid = departmentid;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.joindate = joindate;
		this.salary = salary;
		this.projectid = projectid;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", phone=" + phone + ", email=" + email + ", username="
				+ username + ", password=" + password + ", departmentid=" + departmentid + ", dob=" + dob + ", gender="
				+ gender + ", address=" + address + ", joindate=" + joindate + ", salary=" + salary + ", projectid="
				+ projectid + "]";
	}
	 
	 
}
