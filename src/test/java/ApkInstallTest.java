
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

public class ApkInstallTest extends AbstractTest {
	// AppiumDriver<WebElement> driver;
	public static Logger logger = Logger
			.getLogger(ApkInstallTest.class);
//	File classpathRoot = new File(System.getProperty("user.dir"));
//	File appDir = new File(classpathRoot.getParentFile(), "app");
//	File app = new File(appDir, "LifeCalendar.apk");

	// @Ignore
//	 @Before
//	 public void setUp() {
//	
//		 Activity ac =new Activity("io.appium.unlock", ".Unlock");
//			((StartsActivity) driver).startActivity(ac);
//	
//	 }
	

	
	
//	@Override
//	@BeforeClass
//	public void connect(){
//		io.appium.unlock/.Unlock
//	}
	@Ignore
	@Test
	public void installApk() {
		boolean isAppInstalled = driver
				.isAppInstalled("com.updrv.lifecalendar");

		if (isAppInstalled) {
			driver.removeApp("com.updrv.lifecalendar");
			if (!isAppInstalled) {
				logger.info("应用未安装");
			}
			logger.info("安装应用...");
			driver.installApp(appPath.getAbsolutePath());
			if (isAppInstalled) {
				logger.info("应用安装成功");

				assertTrue(isAppInstalled);
			}
		} else {
			logger.info("应用安装失败");

			assertFalse(!isAppInstalled, "应用安装失败");
		}
	}
	
	

}
