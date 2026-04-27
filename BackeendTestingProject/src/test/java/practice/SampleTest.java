package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTest {

	@Test
	public void sampleGetRequestTest() {
		/*
		 * Base URL with end point We can't store the response in String so to get
		 * response using Response
		 */
		Response resop = RestAssured.get("https://automationexercise.com/api/getUserDetailByEmail");
		/*
		 * To Print response
		 */
		System.out.println(resop.prettyPrint());

	}
}
