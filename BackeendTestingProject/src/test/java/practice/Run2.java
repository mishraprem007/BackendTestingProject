package practice;

import org.testng.annotations.Test;

import com.backend.testing.A1;

/*
 * Method chaining
 */
public class Run2 {

	@Test
	public void sampleTest() {
		A1 a1 = new A1();
		a1.a().b().c().d();

	}

}
