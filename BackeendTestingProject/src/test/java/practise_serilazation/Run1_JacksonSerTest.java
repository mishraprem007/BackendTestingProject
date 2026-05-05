package practise_serilazation;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import tools.jackson.databind.ObjectMapper;

/*
 * This annotation is to provide the order in JSON
 */
@JsonPropertyOrder(value = { "createdBy", "projectName", "teamSize", "status"

})

/*
 * This is to ignore few values to be exposed in JSON from source code
 */
@JsonIgnoreProperties(value = { "teamSize" }, allowSetters = true)
class Project {
	/*
	 * POJO class ==> Plain old Java Object (The business class which we create
	 * during serialization in java called POJO class)
	 */

	private String projectName;
	/*
	 * this annotation is to provide the space
	 */
	@JsonProperty(value = "created By")
	private int teamSize;
	private String status;

	public Project(String projectName, String createdBy, int teamSize, String status) {
		super();
		this.projectName = projectName;
		//this.createdBy = createdBy;
		this.teamSize = teamSize;
		this.status = status;
	}

	/*
	 * creating one empty constructor which is required for deseralization
	 */
	private Project() {

	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

public class Run1_JacksonSerTest {
	public static void main(String[] args) {
		Project pObj = new Project("Jersey_6801q", "Jersey", 10, "Created");

		/*
		 * import from jackson library
		 */
		ObjectMapper objM = new ObjectMapper();
		/*
		 * Jackson serialization
		 */
		objM.writeValue(new File("./project.json"), pObj);
		System.out.println("=========End===========");

	}
}
