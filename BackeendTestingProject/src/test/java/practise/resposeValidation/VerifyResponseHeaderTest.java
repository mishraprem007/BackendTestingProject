package practise.resposeValidation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class VerifyResponseHeaderTest {
	@Test
	public void verifyHeader() {
		Response resp = given().get("http://49.249.29.4:8091/projects");
		resp.then().log().all();
		/*
		 * to verify content type
		 */
		resp.then().assertThat().contentType(ContentType.JSON);
		resp.then().assertThat().statusLine("HTTP/1.1 200 ");
		resp.then().assertThat().statusCode(200);
		/*
		 * to verify response key & value
		 */
		resp.then().assertThat().header("Transfer-Encoding", "chunked");

	}
}
