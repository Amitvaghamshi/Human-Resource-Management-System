package dao;

import java.util.List;

import exception.ProjectException;
import exception.ProjectReportException;
import model.ProjectReport;

public interface ProjectReportDao {
     public String addProjectReport(ProjectReport report);
     public List<ProjectReport> getProjectDetaisByEmpId(int empid) throws ProjectReportException;
}
