package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exception.EmployeeException;
import exception.LoanException;
import model.Loan;
import model.LoanEmployeeDTO;
import util.DBUtil;

public class LoanDaoImpl implements LoanDao{

	@Override
	public String applyForLoan(Loan loan) throws LoanException {
		  String add="No";
		  
		  try(Connection conn=DBUtil.getConnection()){
			  
			 PreparedStatement st=conn.prepareStatement("insert into loan values(?,?,?,?,?,null)");
			 st.setInt(1, loan.getEmpid());
			 st.setInt(2,loan.getAmount());
			 st.setInt(3, loan.getDuration());
			 st.setString(4, loan.getIsapproved());
			 st.setDate(5, Date.valueOf(LocalDate.now()));
			 
			 int x= st.executeUpdate();
			 if(x>0){
				 add="Yes";
			 }else {
				 throw new LoanException("Opps Something Problem");
			 }
			
		} catch (Exception e) {
			throw new LoanException(e.getMessage());
		}
		  return add;
	}

	
	
	
	
	@Override
	public List<Loan> getLoanDetais(int empid) throws LoanException {
		 List<Loan> li=new ArrayList<>();
		 
		 try(Connection conn=DBUtil.getConnection()){
		  PreparedStatement st=	conn.prepareStatement("select * from loan where empid=?");
		  st.setInt(1, empid);
		  ResultSet set= st.executeQuery();
		  while(set.next()) {
			  Loan l=new Loan();
			  l.setEmpid(set.getInt("empid"));
			  l.setAmount(set.getInt("amount"));
			  l.setDuration(set.getInt("duration"));
			  l.setIsapproved(set.getString("isapproved"));
			  l.setApplieddate(set.getDate("applieddate"));
			  
			  li.add(l);
		  }
		  if(li.isEmpty()) {
			  throw new LoanException("No Record Found");
		  }
			 
		} catch (Exception e) {
			throw new LoanException(e.getMessage());
		}
		 return li;
	}





	@Override
	public List<LoanEmployeeDTO> getPendingLoanDetails() throws LoanException{
		List<LoanEmployeeDTO> li=new ArrayList<>();
		
		try(Connection conn=DBUtil.getConnection()){
			
		PreparedStatement st=	conn.prepareStatement("select  e.empid as eid ,name,amount,duration,isapproved ,loanid from loan l join employee e on l.empid=e.empid and isapproved='pending' ");
		ResultSet set=st.executeQuery();
		while(set.next()) {
			LoanEmployeeDTO tamp=new LoanEmployeeDTO();
			tamp.setEmpid(set.getInt("eid"));
			tamp.setAmount(set.getInt("amount"));
			tamp.setName(set.getString("name"));
			tamp.setDuration(set.getInt("duration"));
			tamp.setIsapproved(set.getString("isapproved"));
			tamp.setLoanid(set.getInt("loanid"));
			   
			   li.add(tamp);
		}
		if(li.isEmpty()) {
			throw new LoanException("No pending request found");
		}
		
		} catch (Exception e) {
			throw new LoanException(e.getMessage());
		}
		return li;
	}





	@Override
	public String approveLoan(int empid,int loanid,int res) throws LoanException {
		String app="No";
		
		try(Connection conn=DBUtil.getConnection()){
			String status="reject";
			if(res==1) {
				status="approved";
			}else if(res==0) {
				status="reject";
			}else {
				throw new LoanException("You have select wrong Option");
			}
			PreparedStatement st=conn.prepareStatement("update loan set isapproved =? where empid=? and loanid=?");
			st.setString(1, status);
			st.setInt(2, empid);
			st.setInt(3, loanid);
			
			int x=st.executeUpdate();
			if(x>0) {
				app="Yes";
			}
			
		} catch (Exception e) {
			throw new LoanException(e.getMessage());
		}
		
		return app;
	}

	
}
