package typesOfParaamters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParamTest2 {
/*
 * http://49.249.29.4:8091/project?projectId=NH_PROJ_152 
 * instead of pssing query params in URI we are passing as Param
 */
	@Test
	public void sampleTest() {
		given()
		.queryParam("projectId", "NH_PROJ_152")
		.log().all()
		.when()
		.post("http://49.249.29.4:8091/project")
		.then()
		.log().all();
	}
}
