package practise.postRequestTypes;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import PojoClassUtility.ProjectPojo;
import io.restassured.http.ContentType;

public class PostRequest_Vai_POJOClassTest {
	
	@Test
	public void postDataToServer() {
		//create an object to Pojo class
		Random random = new Random();
		int randomNum = random.nextInt(99999);
		ProjectPojo pObj = new ProjectPojo("JERSEY_"+randomNum, "Created", "Jersey", 0);
		

		given().contentType(ContentType.JSON)
		.body(pObj)
		.when()
		.post("http://49.249.29.4:8091/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
	}
}
