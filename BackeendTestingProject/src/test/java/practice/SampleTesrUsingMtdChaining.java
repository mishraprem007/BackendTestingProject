package practice;

import org.testng.annotations.Test;
/*
 * import static io.restassured.RestAssured.*;
 */
import static io.restassured.RestAssured.*;

public class SampleTesrUsingMtdChaining {
	@Test
	public void getRequestTest() {
		/* Ex-1* - using method chaining printing */
	//	get("https://automationexercise.com/api/getUserDetailByEmail").prettyPrint();

		
		/*
		 * Ex-2 - using method chaining===> log().all() will give all information of
		 * response
		 */
		get("https://automationexercise.com/api/getUserDetailByEmail").then().log().all();

		
		/*
		 * without method chaining Response
		 * resop=get("https://automationexercise.com/api/getUserDetailByEmail");
		 * resop.prettyPeek();
		 */

	}
}
