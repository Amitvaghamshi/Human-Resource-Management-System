package model;

import java.sql.Date;

public class Loan {

	private int empid;
	private int amount;
	private int duration;
	private String isapproved;
	private Date applieddate;
	
	public Loan () {
		
	}
	
	public Loan(int empid, int amount, int duration, String isapproved, Date applieddate) {
		super();
		this.empid = empid;
		this.amount = amount;
		this.duration = duration;
		this.isapproved = isapproved;
		this.applieddate = applieddate;
	}


	public Date getApplieddate() {
		return applieddate;
	}

	public void setApplieddate(Date applieddate) {
		this.applieddate = applieddate;
	}

	public String getIsapproved() {
		return isapproved;
	}
	public void setIsapproved(String isapproved) {
		this.isapproved = isapproved;
	}
	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Loan [empid=" + empid + ", amount=" + amount + ", duration=" + duration + "]";
	}
	
	
	
}
