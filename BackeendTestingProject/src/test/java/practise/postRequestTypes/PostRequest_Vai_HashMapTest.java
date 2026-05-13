package practise.postRequestTypes;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostRequest_Vai_HashMapTest {
	
	@Test
	public void postDataToServer() {
		HashMap <String, Object> map = new HashMap<>();
		map.put("createdBy", "Jersey");
		map.put("status", "Created");
		map.put("teamSize", 0);
		map.put("projectName", "Jersey_9969");
		
		given().contentType(ContentType.JSON)
		.body(map)
		.when()
		.post("http://49.249.29.4:8091/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
	}
}
