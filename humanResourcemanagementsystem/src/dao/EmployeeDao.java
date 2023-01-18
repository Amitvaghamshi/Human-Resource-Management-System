package dao;

import exception.EmployeeException;
import model.Employee;

public interface EmployeeDao {

	  public Employee loginEmployee(String username,String password);
	  public String addEmployee(Employee emp) throws EmployeeException;
}
