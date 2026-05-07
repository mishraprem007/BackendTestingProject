package typesOfParaamters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParamTest {

	@Test
	public void sampleTest() {
		given()
		.when()
		.get("http://49.249.29.4:8091/project?projectId=NH_PROJ_152")
		.then()
		.log().all();
	}
}
