package dao;

import exception.DepartmentException;
import model.Department;

public interface DepartmentDao {

	  public String addDepartment(Department dept) throws DepartmentException;
}
