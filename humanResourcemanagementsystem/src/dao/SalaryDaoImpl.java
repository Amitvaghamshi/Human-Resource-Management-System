package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import exception.SalaryException;
import model.Salary;
import util.DBUtil;

public class SalaryDaoImpl implements SalaryDao{

	@Override
	public List<Salary> getSalaryDetails(int empid) throws SalaryException {
		  List<Salary>  li=new ArrayList<>();
		  
		  try(Connection conn=DBUtil.getConnection()){
			  
		 PreparedStatement st=conn.prepareStatement("select * from salary where empid=?");
		 st.setInt(1, empid);
		 
		 ResultSet set=st.executeQuery();
		 while(set.next()) {
			  Salary tamp=new Salary();
			  tamp.setEmpid(set.getInt("empid"));
			  tamp.setSalaryid(set.getInt("salaryid"));
			  tamp.setAmount(set.getInt("amount"));
			  tamp.setEntry(set.getDate("entry"));
			  tamp.setTime(set.getTime("entry"));
			  li.add(tamp);
		 }
		 
		 if(li.isEmpty()) {
			 throw new SalaryException("No data found");
		 }
			  
		} catch (Exception e) {
			throw new SalaryException(e.getMessage());
		}
		  
		  return li;
	}

}
