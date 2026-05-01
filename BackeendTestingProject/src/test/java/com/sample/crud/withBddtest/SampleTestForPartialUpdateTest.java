package com.sample.crud.withBddtest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class SampleTestForPartialUpdateTest {

	@Test
	public void putDataServer() {
		/*
		 * JSON body as per swagger
		 */
		JSONObject jsonObj = new JSONObject();	
		jsonObj.put("projectName", "Jersey_123456789!");

		given().contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.when()
		.patch("http://49.249.29.4:8091/project/NH_PROJ_104")
		.then()
		.log().all();
		
		
		
		
		

	}
}
