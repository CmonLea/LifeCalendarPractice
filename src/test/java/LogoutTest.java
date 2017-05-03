import static org.testng.Assert.assertEquals;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class LogoutTest extends AbstractTest {
	public static Logger logger = Logger.getLogger(LogoutTest.class);

	@Before
	public void setUp() {
		driver.resetApp();
		Activity ac = new Activity("com.updrv.lifecalendar",
				".activity.MainActivity");
		((StartsActivity) driver).startActivity(ac);

		app.mainScreen().myPageTag.click();
		app.myScreen().notLogin.click();
		app.loginScreen().login("1", "1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	
	@Test
	public void testLogout() {

		app.myScreen().enterLogOutPage();
		app.personalCenterScreen().logOut();
		assertEquals(app.myScreen().isLogin(), false);

	}
			

}
