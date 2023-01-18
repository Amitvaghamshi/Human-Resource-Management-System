package model;

import java.sql.Date;

public class Admin {

	 private int admid; 
	 private String name;
	 private String phone;
	 private String email;
	 private String username;
	 private String password;
	 private Date dob;
	 private String gender;
	 private String address;
	 private Date joindate;
	 
	 public Admin(){
		 
	 }
	 
	public Admin(int admid, String name, String phone, String email, String username, String password, Date dob,
			String gender, String address, Date joindate) {
		super();
		this.admid = admid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.joindate = joindate;
	}

	public int getAdmid() {
		return admid;
	}

	public void setAdmid(int admid) {
		this.admid = admid;
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

	@Override
	public String toString() {
		return "Admin [admid=" + admid + ", name=" + name + ", phone=" + phone + ", email=" + email + ", username="
				+ username + ", password=" + password + ", dob=" + dob + ", gender=" + gender + ", address=" + address
				+ ", joindate=" + joindate + "]";
	}
	 
	
	 
	
}
