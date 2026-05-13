package practise.resposeValidation;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

class VerifyData_ComplexJSONXpath {

	@Test
	public void sampleTest() {
		Response resp = given().get("http://49.249.29.4:8091/projects-paginated");
		resp.then().log().all();

		/*
		 * We don't need 3rd args in read() here as filter
		 */

		/*
		 * here we can display all information and do assertion as well as we added
		 * jsonpath dependency
		 */
		List<String> list = JsonPath.read(resp.asString(), "content[*].projectName");

		for (String data : list) {
			System.out.println(data);
		}

	}

}
