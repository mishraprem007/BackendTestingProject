package typesOfParaamters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PathParamTest {
	/*
	 * http://49.249.29.4:8091/project/{projectId} instead of passing params in URI
	 * we are passing in PathParam
	 */
	@Test
	public void sampleTest() {
		given()
		.pathParam("projectId", "NH_PROJ_152")
		.when()
		.get("http://49.249.29.4:8091/project/{projectId}")
		.then()
		.log().all();
	}
}
