package model;

import java.sql.Date;

public class LoanEmployeeDTO {

	private int empid;
	private String name;
	private int amount;
	private int duration;
	private String isapproved;
	private Date applieddate;
	private int Loanid;
	
	public LoanEmployeeDTO() {
		
	}
	
	public LoanEmployeeDTO(int empid, String name, int amount, int duration, String isapproved, Date applieddate,
			int loanid) {
		super();
		this.empid = empid;
		this.name = name;
		this.amount = amount;
		this.duration = duration;
		this.isapproved = isapproved;
		this.applieddate = applieddate;
		Loanid = loanid;
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

	public String getIsapproved() {
		return isapproved;
	}

	public void setIsapproved(String isapproved) {
		this.isapproved = isapproved;
	}

	public Date getApplieddate() {
		return applieddate;
	}

	public void setApplieddate(Date applieddate) {
		this.applieddate = applieddate;
	}
		public int getLoanid() {
		return Loanid;
	}
	public void setLoanid(int loanid) {
		Loanid = loanid;
	}

	@Override
	public String toString() {
		return "LoanEmployeeDTO [empid=" + empid + ", name=" + name + ", amount=" + amount + ", duration=" + duration
				+ ", isapproved=" + isapproved + ", applieddate=" + applieddate + ", Loanid=" + Loanid + "]";
	}


	
}
