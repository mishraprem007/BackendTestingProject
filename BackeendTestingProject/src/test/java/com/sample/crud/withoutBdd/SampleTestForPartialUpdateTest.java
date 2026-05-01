package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForPartialUpdateTest {

	@Test
	public void putDataServer() {
		/*
		 * JSON body as per swagger
		 */
		JSONObject jsonObj = new JSONObject();	
		jsonObj.put("projectName", "Jersey_69!");

		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		/*
		 * Need to convert this into JSON String before passing this value in body
		 */
		req.body(jsonObj.toJSONString());
		Response resp = req.patch("http://49.249.29.4:8091/project/NH_PROJ_101");
		/*
		 * NH_PROJ_101 - this we gets after project created in web - Ninja also we can
		 * check
		 */
		resp.then().log().all();
		resp.then().assertThat().statusCode(200);

	}
}
