package ddt;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class AddMultipleProjectTest {

	@Test(dataProvider = "getData")
	public void sampleTest(String pName, String status) {
		String reqBody = "{\r\n" + "  \"createdBy\": \"JERSEY\",\r\n" + "  \"projectName\": \"" + pName + "\",\r\n"
				+ "  \"status\": \"" + status + "\",\r\n" + "  \"teamSize\": 0\r\n" + "}";

		given().contentType(ContentType.JSON).body(reqBody).when().post("http://49.249.29.4:8091/addProject").then()
				.log().all();
	}

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		ExcelUtility eLib = new ExcelUtility();
		int count = eLib.getRowCount("project");
		Object[][] objarr = new Object[count][2];
		for (int i = 0; i < count; i++) {
			objarr[i][0] = eLib.getDataFromExcel("project", i + 1, 0);
			objarr[i][1] = eLib.getDataFromExcel("project", i + 1, 1);
		}

		return objarr;
	}
}
