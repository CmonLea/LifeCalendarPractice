import static org.testng.Assert.assertTrue;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ApkUninstallTest extends AbstractTest {

	static boolean isAppInstalled = driver.isAppInstalled("com.updrv.lifecalendar");
	// AppiumDriver<WebElement> driver;
	public static Logger logger = Logger.getLogger(ApkUninstallTest.class);

	@Before
	public void setUp() {
		if (isAppInstalled) {
			driver.removeApp("com.updrv.lifecalendar");
		} else {
			driver.installApp(appPath.getAbsolutePath());
			Activity ac =new Activity("io.appium.unlock", ".activity.MainActivity");
			((StartsActivity) driver).startActivity(ac);
		}
	}

	@Ignore
	@Test
	public void uninstallApp() {

		driver.removeApp("com.updrv.lifecalendar");
		if (!isAppInstalled) {
			logger.info("应用已卸载");
			assertTrue(!isAppInstalled);
		}

	}

	@After
	public  void restoreEnv() {
		driver.installApp(appPath.getAbsolutePath());
		if (driver != null) {
			driver.quit();
		}

	}

}
