package dao;

import java.util.List;

import exception.LoanException;
import model.Loan;

public interface LoanDao {

	public String applyForLoan(Loan loan) throws LoanException;
	public List<Loan> getLoanDetais(int empid) throws LoanException;
}
