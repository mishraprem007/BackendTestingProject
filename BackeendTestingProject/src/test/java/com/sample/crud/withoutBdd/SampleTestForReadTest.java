package com.sample.crud.withoutBdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleTestForReadTest {

	@Test
	public void  getDataFromServer() {
	Response resp=	RestAssured.get("http://49.249.29.4:8091/projects");

	//System.out.println(resop.asString());
	
	/*
	 * to get in JSON format
	 */
	//System.out.println(resop.prettyPrint());
	
	resp.then().assertThat().statusCode(200);
	
	/*
	 * to display all response  header & body
	 */
	resp.then().log().all();
	}
}
