package practise.resposeValidation;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class VerifyResponseTimeTest {
	@Test
	public void verifyHeader() {
		Response resp = given().get("http://49.249.29.4:8091/projects");
		resp.then().log().all();
		/*
		 * response time will be available in response header only
		 */
		long timeTaken = resp.time();
		long timeTakenSec = resp.timeIn(TimeUnit.SECONDS);
		System.out.println(timeTaken);
		/*
		 * it will show 0 sec if response time in less than 1000ms
		 */
		System.out.println(timeTakenSec);

		/*
		 * Matchers is a class we use it for the validation of response time
		 */

		/*
		 * 1. To check less then condition
		 */
		resp.then().assertThat().time(Matchers.lessThan(900L));
		/*
		 * 2. To check greater then condition
		 */

		resp.then().assertThat().time(Matchers.greaterThan(300L));

		/*
		 * 3. To check both less then and greater than condition
		 */
		resp.then().assertThat().time(Matchers.both(Matchers.lessThan(900L)).and(Matchers.greaterThan(300L)));

	}
}
