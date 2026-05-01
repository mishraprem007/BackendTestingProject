package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCompleteUpdateTest {

	@Test
	public void putDataServer() {
		/*
		 * JSON body as per swagger
		 */
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("createdBy", "Jersey");
		jsonObj.put("projectName", "Jersey_00777");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);

		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		/*
		 * Need to convert this into JSON String before passing this value in body
		 */
		req.body(jsonObj.toJSONString());
		Response resp = req.put("http://49.249.29.4:8091/project/NH_PROJ_101");
		/*
		 * NH_PROJ_101 - this we gets after project created in web - Ninja also we can
		 * check
		 */
		resp.then().log().all();
		resp.then().assertThat().statusCode(200);

	}
}
