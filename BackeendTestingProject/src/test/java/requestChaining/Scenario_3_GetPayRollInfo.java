package requestChaining;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Scenario_3_GetPayRollInfo {

	@Test
	public void sampleTest() {
		/*
		 * API-1 Get Auth API-1
		 */
		Response resp = given().formParam("client_id", "ninza-client")
				.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
				.formParam("grant_type", "client_credentials")
				.when()
				.post("http://49.249.29.4:8180/auth/realms/ninza/protocol/openid-connect/token");
		resp.then().log().all();

		/*
		 * capture the token from response
		 */

		String token = resp.jsonPath().get("access_token");
		System.out.println(token);

		/*
		 * API-2 Get payroll info
		 */

		given().auth().oauth2(token).get("http://49.249.29.4:8091/admin/payrolls").then().log().all();

	}
}
