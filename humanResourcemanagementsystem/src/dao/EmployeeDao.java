package dao;

import java.util.List;

import exception.EmployeeException;
import model.Employee;

public interface EmployeeDao {

	  public Employee loginEmployee(String username,String password);
	  public String addEmployee(Employee emp) throws EmployeeException;
	  public int countOfEmployee();
	  public List<Employee> getAllEmployee() throws EmployeeException;
	  public List<Employee> getEmployeeByName(String name) throws EmployeeException;
	  public String provideSalary(int empid,int amount) throws EmployeeException;
	  public String removeEmployee(int empid) throws EmployeeException;
}
