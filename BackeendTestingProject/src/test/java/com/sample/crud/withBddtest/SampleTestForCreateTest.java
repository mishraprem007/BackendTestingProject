package com.sample.crud.withBddtest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SampleTestForCreateTest {

	@Test
	public void postDataFromServer() {
		/*
		 * JSON body as per swagger
		 */
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("createdBy", "Jersey");
		jsonObj.put("projectName", "Jersey_54831");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);

		given().contentType(ContentType.JSON).body(jsonObj.toJSONString()).when().post("http://49.249.29.4:8091/addProject").then()
				.assertThat().statusCode(201).log().all();
	}
}
