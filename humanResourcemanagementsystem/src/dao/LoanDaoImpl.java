package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exception.LoanException;
import model.Loan;
import util.DBUtil;

public class LoanDaoImpl implements LoanDao{

	@Override
	public String applyForLoan(Loan loan) throws LoanException {
		  String add="No";
		  
		  try(Connection conn=DBUtil.getConnection()){
			  
			 PreparedStatement st=conn.prepareStatement("insert into loan values(?,?,?,?,?)");
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

	
}
