package requestChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import PojoClassUtility.ProjectPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenario_1_DeleteProject {

	@Test
	public void postDataToServer() {
		// create an object to Pojo class
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

		String projectId = resp.jsonPath().get("projectId");
		System.out.println(projectId);

		/*
		 * API-2 delete Project
		 */
		given().delete("http://49.249.29.4:8091/project/" + projectId).then().log().all();

	}
}
