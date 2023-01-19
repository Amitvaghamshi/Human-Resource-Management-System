package model;

import java.sql.Date;
import java.sql.Time;

public class Salary {

	private int empid;
	private int salaryid;
	private int amount;
	private Date entry;
	private Time time;
	
	public Salary() {
		
	}
	
	

	public Salary(int empid, int salaryid, int amount, Date entry, Time time) {
		super();
		this.empid = empid;
		this.salaryid = salaryid;
		this.amount = amount;
		this.entry = entry;
		this.time = time;
	}



	public Time getTime() {
		return time;
	}



	public void setTime(Time time) {
		this.time = time;
	}



	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public int getSalaryid() {
		return salaryid;
	}

	public void setSalaryid(int salaryid) {
		this.salaryid = salaryid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getEntry() {
		return entry;
	}

	public void setEntry(Date entry) {
		this.entry = entry;
	}



	@Override
	public String toString() {
		return "Salary [empid=" + empid + ", salaryid=" + salaryid + ", amount=" + amount + ", entry=" + entry
				+ ", time=" + time + "]";
	}

	
	
	 
}
