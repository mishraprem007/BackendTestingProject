package com.sample.crud.withoutBdd;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SampleTestForPATCHTest {
	@Test
	public void patchPartialUpdate() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("status", "OnGoing");

		given().contentType(ContentType.JSON).body(jsonObj.toJSONString()).when()
				.patch("http://49.249.29.4:8091/project/NH_PROJ_285").then().contentType(ContentType.JSON)
				.statusCode(200).log().all();
	}
}
