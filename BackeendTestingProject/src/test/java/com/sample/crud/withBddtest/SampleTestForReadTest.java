package com.sample.crud.withBddtest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class SampleTestForReadTest {

	@Test
	public void getDataFromServer() {
		/*
		 * import static io.restassured.RestAssured.*;
		 */
		given()
		.get("http://49.249.29.4:8091/projects")
		.then().assertThat().statusCode(200)
		.log().all();

	}
}
