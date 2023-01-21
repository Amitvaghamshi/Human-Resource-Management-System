package dao;

import java.util.List;

import exception.DepartmentException;
import model.Department;

public interface DepartmentDao {

	  public String addDepartment(Department dept) throws DepartmentException;
	  public int countDepartment();
	  public List<Department> getDeptDetal();
	  public String assignDepartment(int eid,int deptid) throws DepartmentException;
}
