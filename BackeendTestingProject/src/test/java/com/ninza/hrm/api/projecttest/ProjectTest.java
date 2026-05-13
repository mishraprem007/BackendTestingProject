package com.ninza.hrm.api.projecttest;

import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import PojoClassUtility.ProjectPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ProjectTest {
	ProjectPojo pObj;
	

	@Test
	public void addSingleProjectWithCreatedTest() throws SQLException {
		/*
		 * create an object to PojoClass
		 */
		Random random = new Random();
		int randomNum = random.nextInt(99999);

		String projectName = "TestProject_MH" + randomNum;
		String expSucMsg = "Successfully Added";

		pObj = new ProjectPojo(projectName, "Created", "Prem Mishra", 0);

		/*
		 * Verify the Project in the API layer
		 */
		Response resp = given().contentType(ContentType.JSON).body(pObj).when()
				.post("http://49.249.29.4:8091/addProject");

		resp.then().statusCode(201).time(Matchers.lessThan(3000L)).log().all();

		String actSucMsg = resp.jsonPath().get("msg");
		String actProjectName = resp.jsonPath().get("projectName");

		Assert.assertEquals(actSucMsg, expSucMsg);
		Assert.assertEquals(actProjectName, projectName);

		/*
		 * Verify the project in DB layer
		 */
		boolean flag = false;

		Driver driver = new Driver();
		Connection con = DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm", "root@%", "root");
		ResultSet result = con.createStatement().executeQuery("select * from project");
		while (result.next()) {
			result.getString(4).equals(projectName);
			flag = true;
			break;
		}
		con.close();
		Assert.assertTrue(flag, "Project not verified in DB");

	}

	@Test
	public void createDuplicateProject() {
		given().contentType(ContentType.JSON).body(pObj).when().post("http://49.249.29.4:8091/addProject").then()
				.statusCode(409).log().all();
	}
}
