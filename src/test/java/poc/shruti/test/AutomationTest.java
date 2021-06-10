package poc.shruti.test;
import org.testng.annotations.Test;
import poc.shruti.main.Controller;

public class AutomationTest {
	@Test
	public void testLogin() throws Exception {
		Controller controller = new Controller();
		controller.processData();
	}
}
