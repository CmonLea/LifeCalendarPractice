import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import screen.LifeCalendar;
import util.AppiumDriverBuilder;
import util.AppiumListener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;

public abstract class AbstractTest {

	protected static AppiumDriver<?> driver;
	protected static LifeCalendar app;// 用于管理页面，返回各个测试页面
	static File classpathRoot = new File(System.getProperty("user.dir"));
	static File appDir = new File(classpathRoot.getParentFile(), "app");
	static File appPath = new File(appDir, "LifeCalendar.apk");

	// 建立本地连接
	@Before
	public  void connect() throws MalformedURLException {

		driver = AppiumDriverBuilder.forAndroid()
				.withEndpoint(new URL("http://127.0.0.1:4723/wd/hub"))
				.build("com.updrv.lifecalendar", ".activity.MainActivity");

		driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver,
				new AppiumListener(driver));

		app = new LifeCalendar(driver);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PropertyConfigurator.configure("log4j2.properties");
	}

	@After
	public  void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}