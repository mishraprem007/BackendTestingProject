package com.ninza.hrm.api.employeetest;

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

import PojoClassUtility.EmployeePOJO;
import PojoClassUtility.ProjectPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EmployeeTest {

	@Test
	public void addEmployeeTest() throws SQLException {
		/*
		 * Create an object of Project pojo class
		 */
		Random random = new Random();
		int randomNum = random.nextInt(99999);
		String projectName = "TestProject_P" + randomNum;
		String userName = "TestUser_" + randomNum;
		ProjectPojo pObj = new ProjectPojo(projectName, "Created", "Prem Mishra", 0);
		given().contentType(ContentType.JSON).body(pObj).when().post("http://49.249.29.4:8091/addProject").then()
				.statusCode(201).log().all();

		/*
		 * Add Employee to same project
		 */

		EmployeePOJO eObj = new EmployeePOJO("SDET", "10/11/2022", "testemai@gmail.com", "TestName", 10.3, "9825610132",
				projectName, "ROLE_ADMIN", userName);
		/*
		 * public EmployeePOJO(String designation, String dob, String email, String
		 * empName, double experience, String mobileNo, String project, String role,
		 * String username)
		 */
		Response resp = given().contentType(ContentType.JSON).body(eObj).when()
				.post("http://49.249.29.4:8091/employees");
		resp.then().statusCode(201).time(Matchers.both(Matchers.lessThan(3000L)).and(Matchers.greaterThan(200L))).log()
				.all();

		boolean flag = false;
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		Connection con = DriverManager.getConnection("jdbc:mysql://49.249.29.4:3307/ninza_hrm", "root@%", "root");
		ResultSet result = con.createStatement().executeQuery("select * from employee");
		while (result.next()) {
			result.getString(5).equals(userName);
			flag = true;
			break;
		}
		con.close();
		Assert.assertTrue(flag, "userName in DB is not verified");
	}

	@Test
	public void addEmployeeWithoutEmailTest() {

		/*
		 * create an object to Pojo class
		 */
		Random random = new Random();
		int randomNum = random.nextInt(99999);
		String projectName = "TestProject_" + randomNum;
		String userName = "user" + randomNum;

		/*
		 * Api-1 - Add a project inside a server
		 */
		ProjectPojo pObj = new ProjectPojo(projectName, "Created", "Prem Mishra", 0);

		given().contentType(ContentType.JSON).body(pObj).when().post("http://49.249.29.4:8091/addProject").then().log()
				.all();
		/*
		 * Api-2 Add employee to same Project
		 */
		EmployeePOJO empObj = new EmployeePOJO("Architect", "01/01/1997", "", userName, 10, "8435902135", projectName,
				"ROLE_ADMIN", userName);

		given().contentType(ContentType.JSON).body(empObj).when().post("http://49.249.29.4:8091/employees").then()
				.assertThat().statusCode(500).log().all();
	}
}
