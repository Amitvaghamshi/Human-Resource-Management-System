package dao;

import java.util.List;

import exception.ProjectException;
import model.Project;

public interface ProjectDao {

	public int countProject();
	public List<Project> getProjectsDetail();
	public String assignProject(int empid,int proid) throws ProjectException;
}
