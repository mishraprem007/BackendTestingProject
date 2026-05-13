package practise.resposeValidation;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

class VerifyData_ComplexJSONXpathBasedOnCondition {

	@Test
	public void sampleTest() {
		Response resp = given().get("http://49.249.29.4:8091/projects-paginated");
		resp.then().log().all();

		/*
		 * here we can display all information and do assertion as well as we added
		 * jsonpath dependency
		 */
		List<String> list = JsonPath.read(resp.asString(), "content[*].projectName");

		for (String data : list) {
			System.out.println(data);
		}

		List<String> list1 = JsonPath.read(resp.asString(), "content[*].[?(@.projectName=='NinzaCRM_03')].projectId");
		String actProjectID = list1.get(0);
		/*
		 * After extracting the data, we can't do Rest Assured assertion but we can do
		 * testNG assertion, DB validation,request changing as per our requirement
		 */
		Assert.assertEquals(actProjectID, "NH_PROJ_131");

	}

}
