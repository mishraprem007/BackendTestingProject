package practise_serilazation;

import java.io.File;

import tools.jackson.databind.ObjectMapper;

public class Run2_Jackson_deserializationTest {

	public static void main(String[] args) {

		/*
		 * import jackson
		 */
		ObjectMapper objM = new ObjectMapper();

		Project pObj = objM.readValue(new File("./project.json"), Project.class);

		System.out.println(pObj.getProjectName());
	//	System.out.println(pObj.getCreatedBy());
		System.out.println(pObj.getTeamSize());
	//	System.out.println(pObj.getCreatedBy());

	}
}
