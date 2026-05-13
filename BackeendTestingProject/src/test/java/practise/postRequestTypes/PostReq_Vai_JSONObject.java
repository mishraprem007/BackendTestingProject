package practise.postRequestTypes;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

/*
 * import static io.restassured.RestAssured.*;
 */
public class PostReq_Vai_JSONObject {
	@Test
	public void postDataToServer() {

		JSONObject jsonObj = new JSONObject();

		jsonObj.put("createdBy", "Jersey");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		jsonObj.put("projectName", "Jersey_9121");

		given().contentType(ContentType.JSON).body(jsonObj.toJSONString()).when()
				.post("http://49.249.29.4:8091/addProject").then().assertThat().statusCode(201).log().all();

	}
}
