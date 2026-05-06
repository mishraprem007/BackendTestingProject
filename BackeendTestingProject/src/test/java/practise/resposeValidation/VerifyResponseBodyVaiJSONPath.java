package practise.resposeValidation;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class VerifyResponseBodyVaiJSONPath {

	@Test
	public void sampleTest1() {
		Response resop = given().get("http://49.249.29.4:8091/projects-paginated");

		resop.then().log().all();

		/*
		 * whenever we use JSON path available in rest assured we don't use .(dot) it
		 * automatically use internally as
		 */

		/*
		 * here for below we required inbuilt assertion
		 */
		
		
		/*
		 * int data = resop.jsonPath().get("numberOfElements");
		 * System.out.println(data);
		 * 
		 * boolean data1 = resop.jsonPath().get("pageable.sort.unsorted");
		 * System.out.println(data1);
		 * 
		 * String data3 = resop.jsonPath().get("content[0].projectId");
		 * System.out.println(data3);
		 */
		 

		/*
		 * below we are using inbuilt Rest Assured assertion not testnG, we are checking with response
		 */

		resop.then().assertThat().body("numberOfElements", Matchers.greaterThanOrEqualTo(20));
		resop.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
		resop.then().assertThat().body("content[0].projectId", Matchers.equalTo("NH_PROJ_121"));
		
		/*
		 * to get multiple match regex[*} not allowed
		 */
	/*
	 * 	ArrayList<String> lst = resop.jsonPath().get("content[*].projectName");
	 */
		
		
		/*
		 * we can get multiple projectName but we can’t do assertion here
		 */
		ArrayList<String> lst = resop.jsonPath().get("content.projectName");
		
		System.out.println(lst);

	}
}
