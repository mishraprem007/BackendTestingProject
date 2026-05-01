package com.sample.crud.withBddtest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class SampleTestForCompleteUpdateTest {

	@Test
	public void putDataServer() {
		/*
		 * JSON body as per swagger
		 */
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("createdBy", "Jersey");
		jsonObj.put("projectName", "Jersey_12345");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);

		given()
		.contentType(ContentType.JSON)
		.body(jsonObj.toJSONString())
		.when().put("http://49.249.29.4:8091/project/NH_PROJ_098")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}
}
