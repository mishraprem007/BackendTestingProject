package practice;
/*
 * static import
 */
import org.testng.annotations.Test;

/*
 * import com.backend.testing.A;
 */
import static com.backend.testing.A.*;

public class Run1 {

	@Test
	public void sampleTest() {
		/*
		 * import com.backend.testing.A; 
		 * import static com.backend.testing.A.*; 
		 * ==>since we
		 * added static and .* in import, we don't have to use className to call methods
		 * from A class
		 */
		given();
		when();
		then();

	}
}