package practise_serilazation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import tools.jackson.databind.ObjectMapper;

class Project1 {
	public Project1(String projectName, String projectstatus, int teamSize, List<String> teamMember,
			ProjectManager projectManager) {
		super();
		this.projectName = projectName;
		this.projectstatus = projectstatus;
		this.teamSize = teamSize;
		this.teamMember = teamMember;
		this.projectManager = projectManager;
	}

	/*
	 * #1. in one file if we have multiple classes then only one class can have
	 * public keyword
	 * 
	 * 
	 */

	String projectName;

	String projectstatus;

	int teamSize;

	List<String> teamMember;

	ProjectManager projectManager;

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectstatus(String projectstatus) {
		this.projectstatus = projectstatus;
	}

	public String getProjectstatus() {
		return projectstatus;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamMember(List<String> teamMember) {
		this.teamMember = teamMember;
	}

	public List<String> getTeamMember() {
		return teamMember;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}

	public ProjectManager getProjectManager() {
		return projectManager;
	}

}

class ProjectManager {

	String name;

	String empID;

	public ProjectManager(String name, String empID) {
		super();
		this.name = name;
		this.empID = empID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpID() {
		return empID;
	}

}

public class Run3_POJO {

	public static void main(String[] args) {

		List<String> lst = new ArrayList<String>();
		
		lst.add("JERSEY");
		lst.add("david");
		lst.add("steve");
		
		ProjectManager pm = new ProjectManager("sagar", "tp01");
		Project1 projectObj = new Project1("Jersey","Created",10, lst, pm);
	
		
		ObjectMapper objM = new ObjectMapper();
		objM.writeValue(new File("./Project1.json"), projectObj);
		
		
		
		
	}

}
