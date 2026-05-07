package authtest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class PremtiveAuthTest3 {
	/*
	 * There is some backend configuration issue it seems, website doesn't load
	 */
	@Test
	public void sampleTest() {
	given()
	.auth().preemptive().basic("rmgyantra", "rmgy@9999")
	.log().all()
	.when()
	.get("http://49.249.29.5:8888/login")
	.then()
	.log().all();
	}
}
