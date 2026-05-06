package practise.resposeValidation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class VerifyResponseHeaderTest {
	@Test
	public void verifyHeader() {
		Response resop = given().get("http://49.249.29.4:8091/projects");
		resop.then().log().all();
		/*
		 * to verify content type
		 */
		resop.then().assertThat().contentType(ContentType.JSON);
		resop.then().assertThat().statusLine("HTTP/1.1 200 ");
		resop.then().assertThat().statusCode(200);
		/*
		 * to verify response key & value
		 */
		resop.then().assertThat().header("Transfer-Encoding", "chunked");

	}
}
