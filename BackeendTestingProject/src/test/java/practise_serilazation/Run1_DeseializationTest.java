package practise_serilazation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Run1_DeseializationTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		/*
		 * Already we serialization and this f.txt file is present on project level
		 */
		FileInputStream input = new FileInputStream("./f.txt");

		ObjectInputStream objIn = new ObjectInputStream(input);
		/*
		 * Doing down casting
		 */
		NFSGame user1obj = (NFSGame) objIn.readObject();
		System.out.println(user1obj.name);
		System.out.println(user1obj.level);
		System.out.println(user1obj.score);
		System.out.println(user1obj.life);

	}

}
