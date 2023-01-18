package usecases;
import java.sql.Date;
import java.util.Scanner;

import consolecolors.ConsoleColor;
import dao.AdminDaoImpl;
import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import exception.AdminException;
import exception.DepartmentException;
import exception.EmployeeException;
import model.Department;
import model.Employee;

public class HRMDemo {

	public static void main(String[] args) {
		    Scanner sc=new Scanner(System.in);
		    
		    boolean work=true;
		    //  for admin/user panel
		    while(work){
		    	   System.out.println(ConsoleColor.YELLOW+"Press Number According to use"+ConsoleColor.RESET);
		    	   System.out.println(ConsoleColor.CYAN+ "1 :for admin login");
		    	   System.out.println("2 :for user login");
		    	   System.out.println("0 :for Exit"+ ConsoleColor.RESET);
		    	   
		    	   int loginNumber=sc.nextInt();
		    	   if(loginNumber==1){
		    		   // code for admin login
		    		   
		    		   AdminDaoImpl admin=new AdminDaoImpl();
		    		   System.out.println(ConsoleColor.TEAL+ "Enter your username" +ConsoleColor.RESET);
		    		   String uname=sc.next();
		    		   System.out.println(ConsoleColor.TEAL+"Enter your Password"+ConsoleColor.RESET);
		    		   String pass= sc.next();
		    		   try {
						boolean islogin=admin.loginAdmin(uname, pass);
						if(islogin){
							// code for admin functionality
							
						    System.out.println(ConsoleColor.GREEN_BACKGROUND+ "Login Succesful");
						    System.out.println();
						    //sleep main thread for a 1 sec
						    try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								System.out.println(e.getMessage());
							}

						    boolean adminpanel=true;
						    while(adminpanel){
						    	//Admin panel details
						    	
						    	System.out.println(ConsoleColor.YELLOW+"Press Number According to use"+ConsoleColor.RESET);
						    	 System.out.println("1 :Show dashboard");
						    	 System.out.println("2 :Screening And Approval Process");
						    	 System.out.println("3 :Get Data Of Employee");
						    	 System.out.println("4 :Add new Department");
						    	 System.out.println("5 :Assign Department");
						    	 System.out.println("6 :Assign Project");
						    	 System.out.println("7 :Provide Salary");
						    	 System.out.println("8 :Add new Employee");
						    	 System.out.println("9 :Remove employee");
						    	 System.out.println("0 :Exit");
						    	 
						    	 
						    	 int choosepanel=sc.nextInt();
						    	 if(choosepanel==1) {
						    		 // code for dashboard
						    	 }else if(choosepanel==2) {
						    		 //code for screening
						    	 }else if(choosepanel==3) {
						    		 //geting employee
						    		 
						    	 }else if(choosepanel==4) {
						    		 //Add department
						    		 
						    		 System.out.println();
						    		 Department dept=new Department();
						    		 
						    		 System.out.println(ConsoleColor.TEAL+ "Enter department Name"+ConsoleColor.RESET);
						    		 String dname=sc.next();
						    		 System.out.println(ConsoleColor.TEAL+"Enter department Id"+ConsoleColor.RESET);
						    		 int did=sc.nextInt();
						    		 System.out.println(ConsoleColor.TEAL+"Enter department Manager"+ConsoleColor.RESET);
						    		 int dm=sc.nextInt();
						    		 System.out.println(ConsoleColor.TEAL+"Enter department Location"+ConsoleColor.RESET);
						    		 String location=sc.next();
						    		 
						    		 dept.setDname(dname);
						    		 dept.setDid(did);
						    		 dept.setDmanager(dm);
						    		 dept.setLocation(location);
						    		 
						    		 DepartmentDao deptdao=new DepartmentDaoImpl();
						    		 try {
									 String res=deptdao.addDepartment(dept);
									 if(res.equals("Yes")){
										 System.out.println();
										 System.out.println(ConsoleColor.YELLOW_BACKGROUND+"Department Added Successfully"+ConsoleColor.RESET);
									 }
									 
									} catch (DepartmentException e) {
										System.out.println(e.getMessage());
									}
						    		 
						    	 }else if(choosepanel==5) {
						    		 //assign department
						    		 
						    	 }else if(choosepanel==6) {
						    		 //provide project
						    		 
						    	 }else if(choosepanel==7) {
						    		 //provide salary
						    		 
						    	 }else if(choosepanel==8) {
						    		 //add new  employee
						    		 
						    		 EmployeeDao emdao=new EmployeeDaoImpl();
						    		 
						    		 System.out.println(ConsoleColor.TEAL+ "Enter Employee Name"+ConsoleColor.RESET);
						    		 String name=sc.next();
						    		 System.out.println(ConsoleColor.TEAL+ "Enter Mobile Number"+ConsoleColor.RESET);
						    		 String mobile=sc.next();
						    		 System.out.println(ConsoleColor.TEAL+ "Enter Email id"+ConsoleColor.RESET);
						    		 String email=sc.next();
						    		 System.out.println(ConsoleColor.TEAL+ "Enter Username"+ConsoleColor.RESET);
						    		 String euname=sc.next();
						    		 System.out.println(ConsoleColor.TEAL+ "Enter Password"+ConsoleColor.RESET);
						    		 String epass=sc.next();
						    		 System.out.println(ConsoleColor.TEAL+ "Enter DOB Format[ yyyy mm dd ] "+ConsoleColor.RESET);
						    		 Date dob=new Date(sc.nextInt(), sc.nextInt(), sc.nextInt());
						    		 System.out.println(ConsoleColor.TEAL+ "Enter Your gender"+ConsoleColor.RESET);
						    		 String egender=sc.next();
						    		 System.out.println(ConsoleColor.TEAL+ "Enter Address"+ConsoleColor.RESET);
						    		 String eadd=sc.next();
						    		 System.out.println(ConsoleColor.TEAL+ "Enter Join Date Format[ yyyy mm dd ] "+ConsoleColor.RESET);
						    		 Date ejoin=new Date(sc.nextInt(), sc.nextInt(), sc.nextInt());
						    		 
						    		 Employee emp=new Employee();
						    		 emp.setName(name);
						    		 emp.setPhone(mobile);
						    		 emp.setEmail(email);
						    		 emp.setUsername(euname);
						    		 emp.setPassword(epass);
						    		 emp.setDob(dob);
						    		 emp.setGender(egender);
						    		 emp.setAddress(eadd);
						    		 emp.setJoindate(ejoin);

						    		 try {
										String res=emdao.addEmployee(emp);
										if(res.equals("Yes")) {
											System.out.println();
											System.out.println(ConsoleColor.YELLOW_BACKGROUND+"Employee Added Successfully"+ConsoleColor.RESET);
										}
									} catch (EmployeeException e) {
										System.out.println(e.getMessage());
									}
						    		 
						    	 }else if(choosepanel==9) {
						    		 //Remove employee
						    		 
						    	 }else if(choosepanel==0) {
						    		 
						    	 }else {
						    		 System.out.println( ConsoleColor.RED+ "You select Wrong Option");
						    	 }
						    	 break;
						    }
						    
						    
						    
						    
						    
						    
						    
						    
						    
						    
						    
						    
						    
						    
						    
						    
						}else {
							//if admin not found
							System.out.println(ConsoleColor.RED_BACKGROUND+"User not found"+ConsoleColor.RESET);
							System.out.println("Try again");
						}
					} catch (AdminException e) {
						//admin error
						System.out.println(e.getMessage());
					}
		    		   
		    	   }else if(loginNumber==2) {
		    		   //code for user login
		    		   
		    		   EmployeeDao user=new EmployeeDaoImpl();
		    		   System.out.println(ConsoleColor.TEAL+ "Enter your username" +ConsoleColor.RESET);
		    		   String uname=sc.next();
		    		   System.out.println(ConsoleColor.TEAL+"Enter your Password"+ConsoleColor.RESET);
		    		   String pass= sc.next();
		    		   Employee userdetails=user.loginEmployee(uname, pass);
		    		   if(userdetails!=null){                          //  <== for if database send the data
		    			   // code for user functionality
		    			   
		    			   System.out.println(ConsoleColor.GREEN_BACKGROUND+ "Login Succesful"+ConsoleColor.RESET);
						   System.out.println();
						   //sleep main thread for a 1 sec
						    try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								System.out.println(e.getMessage());
							}
						   
						   System.out.println(userdetails.getName());
						   System.out.println(userdetails.getEmpid());
						   
						   
						   
						   
						   
						   
						   
						   
						   
						   
						   
		    		   }else {
		    			   //user not able to login
		    			   System.out.println(ConsoleColor.RED_BACKGROUND+"User not found"+ConsoleColor.RESET);
						   System.out.println("Try again");
		    		   }
		    		   
		    		   
		    		   
		    	   }else if(loginNumber==0) {
		    		   //exit
		    		   System.out.println();
		    		   System.out.println(ConsoleColor.GREEN_BOLD_BRIGHT+ "Thanks visit again");
		    		   break;
		    		  
		    	   }else {
		    		   System.out.println( ConsoleColor.RED+ "You select Wrong Option");
		    	   }
		    	   
		    }
		    
	}
}
