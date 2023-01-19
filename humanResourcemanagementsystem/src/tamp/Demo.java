package tamp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Scanner;

import util.DBUtil;

public class Demo {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		try(Connection conn=DBUtil.getConnection()){
			System.out.println("Enter date");
			String d=sc.next();
		 PreparedStatement st=conn.prepareStatement("insert into dummy values('jao',sysdate(),?)");
		 Date dt=Date.valueOf(LocalDate.now());
		 
		 // Date dt=new Date(System.currentTimeMillis());
		 st.setDate(1, dt);
		 int x=st.executeUpdate();
		 if(x>0) {
			 System.out.println("Done");
		 }else {
			 System.out.println("Not done");
		 }
		 
		 PreparedStatement st2=conn.prepareStatement("select entry from salary");
		 ResultSet set2= st2.executeQuery();
		 while(set2.next()) {
			 System.out.println(set2.getTime("entry"));
		 }
		 
		 
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
}
