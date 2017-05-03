package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
 * 引导页第二屏，前提是需要启动第一屏然后向左滑动
 */
@SuppressWarnings("deprecation")
public class SecondGuideScreen extends AbstractScreen {

	GuideScreen gs = new GuideScreen(driver);

	public SecondGuideScreen(AppiumDriver<?> driver) {
		super(driver);

	}

	@FindBy(className = "android.widget.TextView")
	WebElement skipButton;

	@FindBy(xpath = "//android.support.v4.view.ViewPager/android.widget.ImageView")
	MobileElement secondGuideScreen;

	/*
	 * 滑动到引导页第三屏
	 */
	public void switchToThirdGuideScreen() {
		PropertyConfigurator.configure("log4j2.properties");
		// 进入引导页第二屏
		gs.switchToSecondGuideScreen();
		driver.swipe(500, 300, 100, 300, 500);
	
	}

	public void switchToFristGuideScreen() {
		PropertyConfigurator.configure("log4j2.properties");
		// findElementWithTimeout(by, timeOutInSeconds)
		gs.switchToSecondGuideScreen();
		findElementWithTimeout(
				By.xpath("//android.support.v4.view.ViewPager/android.widget.ImageView"),
				10);
		driver.swipe(100, 300, 500, 300, 500);
	}

	/*
	 * 跳转到应用首页
	 */
	public void skipGuideScreen() {
		PropertyConfigurator.configure("log4j2.properties");
		findElementWithTimeout(By.className("android.widget.TextView"), 5);
		skipButton.click();
	}
}