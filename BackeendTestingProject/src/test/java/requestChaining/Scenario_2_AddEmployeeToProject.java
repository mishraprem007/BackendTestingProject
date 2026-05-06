package requestChaining;
import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import PojoClassUtility.EmployeePOJO;
import PojoClassUtility.ProjectPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenario_2_AddEmployeeToProject {

	@Test
	public void sampleTest() {
		/*
		 * create an object to Pojo class
		 */
		Random random = new Random();
		int randomNum = random.nextInt(99999);
		/*
		 * Api-1 - Add a project inside a server
		 */
		ProjectPojo pObj = new ProjectPojo("JERSEY_" + randomNum, "Created", "Jersey", 0);

		Response resp = given().contentType(ContentType.JSON).body(pObj).when()
				.post("http://49.249.29.4:8091/addProject");

		resp.then().assertThat().statusCode(201).log().all();

		/*
		 * capture project name from the response
		 */

		String projectName = resp.jsonPath().get("projectName");
		System.out.println(projectName);
		
		/*
		 * Api-2 Add employee to same Project        
		 */
		
		
		EmployeePOJO empObj = new EmployeePOJO("Architect", "01/01/1997", "jersey@gmail.com", "JERSEY"+randomNum, 10, "8435902135", projectName, "ROLE_ADMIN","JERSEY"+randomNum);
	
		given().contentType(ContentType.JSON).body(empObj).when()
		.post("http://49.249.29.4:8091/employees")
		.then()
		.assertThat().statusCode(201)
		.log().all();
	
	}

}
