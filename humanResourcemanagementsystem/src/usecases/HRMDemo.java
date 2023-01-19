package usecases;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import consolecolors.ConsoleColor;
import dao.AdminDaoImpl;
import dao.DepartmentDao;
import dao.DepartmentDaoImpl;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import dao.LeaveDao;
import dao.LeaveDaoImpl;
import dao.LoanDao;
import dao.LoanDaoImpl;
import dao.ProjectReportDao;
import dao.ProjectReportImpl;
import dao.SalaryDao;
import dao.SalaryDaoImpl;
import exception.AdminException;
import exception.DepartmentException;
import exception.EmployeeException;
import exception.LeaveException;
import exception.LoanException;
import exception.SalaryException;
import model.Department;
import model.Employee;
import model.Leave;
import model.Loan;
import model.ProjectReport;
import model.Salary;

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
						    	 System.out.println("-------------------------------------------"); 
						    	 System.out.println("|  1 :Show dashboard                       |");
						    	 System.out.println("|  2 :Screening And Approval Process       |");
						    	 System.out.println("|  3 :Get Data Of Employee                 |");
						    	 System.out.println("|  4 :Add new Department                   |");
						    	 System.out.println("|  5 :Assign Department                    |");
						    	 System.out.println("|  6 :Assign Project                       |");
						    	 System.out.println("|  7 :Provide Salary                       |");
						    	 System.out.println("|  8 :Add new Employee                     |");
						    	 System.out.println("|  9 :Remove employee                      |");
						    	 System.out.println("|  0 :Exit                                 |");
						    	 System.out.println("--------------------------------------------"); 
						    	 
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
						   boolean userpanel=true;
						   while(userpanel){
							   // showing all option for user
							   System.out.println(ConsoleColor.YELLOW+"Press Number According to use"+ConsoleColor.RESET);
							   System.out.println("  --------------------------------------");
							   System.out.println("  |  1: for Submit project Report      |");
							   System.out.println("  |  2: Salary Details                 |");
							   System.out.println("  |  3: Apply for Leave                |");
							   System.out.println("  |  4: Leave Request Details          |");
							   System.out.println("  |  5: Apply For Loan                 |");
							   System.out.println("  |  6: Loan Request Details           |");
							   System.out.println("  |  0: Exit                           |");
							   System.out.println("  --------------------------------------");
							   
							   int useroption=sc.nextInt();
							   
							   if(useroption==1) {
								    //For submit project report
								   
								   ProjectReport repo=new ProjectReport();
								   ProjectReportDao repodao=new ProjectReportImpl();
								   
								   System.out.println(ConsoleColor.TEAL+ "Enter No of Task you have completed" +ConsoleColor.RESET);
								   int tc=sc.nextInt();
								   System.out.println(ConsoleColor.TEAL+ "Enter No of Task you have Pending" +ConsoleColor.RESET);
								   int tp=sc.nextInt();
								   System.out.println(ConsoleColor.TEAL+ "Description" +ConsoleColor.RESET);
								   sc.nextLine();
								   String dis=sc.nextLine();
								   
								   repo.setEmpid(userdetails.getEmpid());
								   repo.setTaskcompleted(tc);
								   repo.setTaskpending(tp);
								   repo.setDescription(dis);
								   
								  String add=repodao.addProjectReport(repo);
								  if(add=="Yes") {
									  System.out.println("");
									  System.out.println(ConsoleColor.YELLOW_BACKGROUND+"Project Report Added Successfully"+ConsoleColor.RESET);
								  }else {
									  System.out.println("Something Problem");
								  }
								   
								  
								  
							   }else if(useroption==2) {
								   //salary details
								   SalaryDao saldao=new SalaryDaoImpl();
								   try {
									List<Salary> sl= saldao.getSalaryDetails(userdetails.getEmpid());
								    System.out.println(ConsoleColor.PURPLE+ "Your salary Detais are" +ConsoleColor.RESET);
								    System.out.println();
								    sl.forEach(s->{
								    	   System.out.println( ConsoleColor.LIGHT_BLUE +"Salary Id: "+s.getSalaryid()+"  "+"Amount: "+s.getAmount()+"  "+"Time: " +s.getEntry()+"  "+s.getTime()+ConsoleColor.RESET);
								    });
									System.out.println("=======================================================");
									System.out.println();
									
								} catch (SalaryException e) {
									System.out.println(e.getMessage());
								}
								   
								  
								   
							   }else if(useroption==3) {
								   //apply leave
								   Leave leave=new Leave();
								   LeaveDao leavedao=new LeaveDaoImpl();
								   
								   System.out.println(ConsoleColor.TEAL+ "enter From Date For Leave  Format[ YYYY MM DD ]" +ConsoleColor.RESET);
								   Date fd=Date.valueOf(LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt()));
								   System.out.println(ConsoleColor.TEAL+ "enter To Date For Leave  Format[ YYYY MM DD ]" +ConsoleColor.RESET);
								   Date td=Date.valueOf(LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt()));
								   System.out.println(ConsoleColor.TEAL+ "Reason for Leave" +ConsoleColor.RESET);
								   sc.nextLine();
								   String rsn=sc.nextLine();
								   
								   leave.setEmpid(userdetails.getEmpid());
								   leave.setFromdate(fd);
								   leave.setTodate(td);
								   leave.setReason(rsn);
								   
								   String add;
								try {
									add = leavedao.applyForLeave(leave);
									if(add.equals("Yes")) {
										   System.out.println("");
										   System.out.println(ConsoleColor.YELLOW_BACKGROUND+"Your Leave Request added SuccessFully"+ConsoleColor.RESET);
										   System.out.println("");
										   try {
											   // 1 sec delay
											Thread.sleep(1000);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
											  System.out.println(ConsoleColor.ORANGE_BACKGROUND+"Wait For Approved By Admin"+ConsoleColor.RESET);
											  System.out.println();
									   }
									
								} catch (LeaveException e1) {
									System.out.println(e1.getMessage());
								}
								    
								   
								
							   }else if(useroption==4) {
								   //details of leave request
								   
								   LeaveDao ld=new LeaveDaoImpl();
								   try {
								List<Leave> li=ld.getLeaveDetais(userdetails.getEmpid());
									
									
									li.forEach(s->{
										  String isaproved=s.getIsapproved();
										  System.out.println(ConsoleColor.LIGHT_BLUE +"Leave Id:  "+ConsoleColor.RESET+s.getLeaveid());
										  System.out.println(ConsoleColor.LIGHT_BLUE +"From Date: "+ConsoleColor.RESET+s.getFromdate());
										  System.out.println(ConsoleColor.LIGHT_BLUE +"To Date:   "+ConsoleColor.RESET+s.getTodate());
										  System.out.println(ConsoleColor.LIGHT_BLUE +"Rasaon:    "+ConsoleColor.RESET+s.getReason());
										  if(isaproved.equals("approved")) {
										  System.out.println( ConsoleColor.LIGHT_BLUE+"Status:    "+ConsoleColor.RESET+ConsoleColor.GREEN_BOLD+s.getIsapproved()+ConsoleColor.RESET);
										  }else if(isaproved.equalsIgnoreCase("pending")) {
										  System.out.println(ConsoleColor.LIGHT_BLUE +"Status:    "+ConsoleColor.RESET+ConsoleColor.PURPLE_BOLD+s.getIsapproved()+ConsoleColor.RESET); 
										  }else {
										  System.out.println(ConsoleColor.LIGHT_BLUE +"Status:    "+ConsoleColor.RESET+ConsoleColor.RED_BOLD+s.getIsapproved()+ConsoleColor.RESET);  
										  }
										  System.out.println("***********************************************************");
								    });
									   
									
								} catch (LeaveException e) {
									e.printStackTrace();
								}
								   
								   
							   }else if(useroption==5) {
								   //loan apply
								   
								   Loan loan=new Loan();
								   LoanDao ldao=new LoanDaoImpl();
								   
								   System.out.println(ConsoleColor.TEAL+ "Enter Amount Required" +ConsoleColor.RESET);
								   int amount=sc.nextInt();
								   System.out.println(ConsoleColor.TEAL+ "Enter Loan Duration" +ConsoleColor.RESET);
								   int dur=sc.nextInt();
								   
								   loan.setEmpid(userdetails.getEmpid());
								   loan.setAmount(amount);
								   loan.setDuration(dur);
								   loan.setIsapproved("Pending");
								   
								   try {
									String add=ldao.applyForLoan(loan);
									if(add.equals("Yes")) {
										   System.out.println("");
										   System.out.println(ConsoleColor.YELLOW_BACKGROUND+"Your Loan Request added SuccessFully"+ConsoleColor.RESET);
										   System.out.println("");
										   try {
											   // 1 sec delay
											Thread.sleep(1000);
										} catch (InterruptedException e) {
											e.printStackTrace();
										}
											  System.out.println(ConsoleColor.ORANGE_BACKGROUND+"Wait For Approved By Admin"+ConsoleColor.RESET);
											  System.out.println();
									   }
									
								} catch (LoanException e) {
									System.out.println(e.getMessage());
								}
								   
								   
								   
							   }else if(useroption==6) {
								   //approved loan request
								  LoanDao loandao=new LoanDaoImpl();
								  try {
									List<Loan> li=loandao.getLoanDetais(userdetails.getEmpid());
									li.forEach(s->{
										  String isaproved=s.getIsapproved();
										  System.out.println(ConsoleColor.LIGHT_BLUE +"Loan Amount:    "+ConsoleColor.RESET+s.getAmount());
										  System.out.println(ConsoleColor.LIGHT_BLUE +"Loan Duration:  "+ConsoleColor.RESET+s.getDuration()+" Months");
										  System.out.println(ConsoleColor.LIGHT_BLUE +"Loan Date:      "+ConsoleColor.RESET+s.getApplieddate());
										  if(isaproved.equals("approved")) {
										  System.out.println( ConsoleColor.LIGHT_BLUE+"Status:         "+ConsoleColor.RESET+ConsoleColor.GREEN_BOLD+s.getIsapproved()+ConsoleColor.RESET);
										  }else if(isaproved.equalsIgnoreCase("pending")) {
										  System.out.println(ConsoleColor.LIGHT_BLUE +"Status:         "+ConsoleColor.RESET+ConsoleColor.PURPLE_BOLD+s.getIsapproved()+ConsoleColor.RESET); 
										  }else {
										  System.out.println(ConsoleColor.LIGHT_BLUE +"Status:         "+ConsoleColor.RESET+ConsoleColor.RED_BOLD+s.getIsapproved()+ConsoleColor.RESET);  
										  }
										  System.out.println("***********************************************************");
								    });
									
								} catch (LoanException e) {
									System.out.println(e.getMessage());
								}
								   
								   
								  
							   }else if(useroption==0) {
								   //exit;
								   System.out.println();
								   break;
							   }else {
								   System.out.println( ConsoleColor.RED+ "You select Wrong Option");
							   }
							  
						   }
						   
						   
						   
						   
						   
						   
						   
						   
						   
						   
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
