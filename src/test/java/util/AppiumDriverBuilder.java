package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class AppiumDriverBuilder<SELF, DRIVER extends AppiumDriver<?>> {
	
	protected URL endpoint;

	@SuppressWarnings("unchecked")
	public SELF withEndpoint(URL endpoint) {
		this.endpoint = endpoint;

		return (SELF) this;
	}

	// public abstract DRIVER build();

	public static AndroidDriverBuilder forAndroid() {
		return new AndroidDriverBuilder();
	}

	public static class AndroidDriverBuilder extends
			AppiumDriverBuilder<AndroidDriverBuilder, AndroidDriver> {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		// 返回带capability参数的 endpoint
		@SuppressWarnings("rawtypes")
		public AndroidDriver build() {

			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("deviceName", "testDevice");
			capabilities.setCapability("platformVersion", "4.2.2");
			capabilities.setCapability("noReset", false);
			capabilities.setCapability("appPackage", "com.updrv.lifecalendar");
			capabilities.setCapability("appActivity", ".activity.MainActivity");
			capabilities.setCapability("unicodeKeyboard", true);
			capabilities.setCapability("resetKeyboard", true);
			capabilities.setCapability("deviceReadyTimeout",30);

			return new AndroidDriver(endpoint, capabilities);

		}

	}

}
