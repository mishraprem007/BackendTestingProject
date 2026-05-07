package typesOfParaamters;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class FormParamTest {
/*
 * http://49.249.29.4:8091/project?projectId=NH_PROJ_152
 */
	@Test
	public void sampleTest() {
		given()
		.formParam("projectId", "NH_PROJ_152")
		.log().all()
		.when()
		.post("http://49.249.29.4:8091/project")
		.then()
		.log().all();
	}
}
