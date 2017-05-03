import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import screen.LifeCalendar;
import util.AppiumDriverBuilder;
import util.AppiumListener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;

public abstract class AbstractTest {

	protected static AppiumDriver<?> driver;
	protected static LifeCalendar app;// 用于管理页面，返回各个测试页面

	// 建立本地连接
	@BeforeClass
	public static void connect() throws MalformedURLException {

		driver = AppiumDriverBuilder.forAndroid()
				.withEndpoint(new URL("http://127.0.0.1:4723/wd/hub"))
				.build();
		driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new AppiumListener(driver)   
			   );  

		app = new LifeCalendar(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PropertyConfigurator.configure("log4j2.properties");
	}

	@AfterClass
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}