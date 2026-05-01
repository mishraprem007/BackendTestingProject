package com.sample.crud.withBddtest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


public class SampleTestForDeleteTest {

	@Test
	public void deleteDataFromServer() {
		given()
		.delete("http://49.249.29.4:8091/project/NH_PROJ_097")
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
		
	}
}
