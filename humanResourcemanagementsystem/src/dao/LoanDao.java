package dao;

import java.util.List;

import exception.LoanException;
import model.Loan;
import model.LoanEmployeeDTO;

public interface LoanDao {

	public String applyForLoan(Loan loan) throws LoanException;
	public List<Loan> getLoanDetais(int empid) throws LoanException;
	public List<LoanEmployeeDTO> getPendingLoanDetails() throws LoanException;
	public String approveLoan(int empid,int loanid,int res) throws LoanException;
}
