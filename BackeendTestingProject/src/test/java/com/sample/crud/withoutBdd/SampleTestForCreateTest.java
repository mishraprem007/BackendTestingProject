package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForCreateTest {

	@Test
	public void postDataFromServer() {
		/*
		 * JSON body as per swagger
		 */
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("createdBy", "Jersey");
		jsonObj.put("projectName", "Jersey_45899");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);

		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		/*
		 * Need to convert this into JSON String before passing this value in body
		 */
		req.body(jsonObj.toJSONString());
		Response resp = req.post("http://49.249.29.4:8091/addProject");
		resp.then().log().all();
		resp.then().assertThat().statusCode(201);

	}
}
