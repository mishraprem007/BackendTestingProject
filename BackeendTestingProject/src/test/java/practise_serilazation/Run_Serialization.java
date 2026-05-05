package practise_serilazation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSGame implements Serializable {
	String name;
	int level;
	long score;
	int life;

	public NFSGame(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
}

public class Run_Serialization {

	public static void main(String[] args) throws IOException {

		NFSGame user1obj = new NFSGame("deepak", 10, 50000, 2);
		FileOutputStream fileout = new FileOutputStream("./f.txt");
		ObjectOutputStream object = new ObjectOutputStream(fileout);
		object.writeObject(user1obj);
		System.out.println("=====End=====");

	}

}
