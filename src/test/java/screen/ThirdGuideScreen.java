package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*
 * 引导页第三屏
 */
@SuppressWarnings("deprecation")
public class ThirdGuideScreen extends AbstractScreen {

	public ThirdGuideScreen(AppiumDriver<?> driver) {
		super(driver);

	}

	SecondGuideScreen ss = new SecondGuideScreen(driver);
	
	@FindBy(xpath = "//android.support.v4.view.ViewPager/android.widget.ImageView")
	MobileElement thirdGuideScreen;

	//@FindBy(name = "立即体验")
	@FindBy(className="android.widget.TextView")
	WebElement joinButton;
	public void switchToSecondGuideScreen() {
		PropertyConfigurator.configure("log4j2.properties");
		ss.switchToThirdGuideScreen();
		//向右滑动进入第二屏
		findElementWithTimeout(
				By.xpath("//android.support.v4.view.ViewPager/android.widget.ImageView"),
				10);
		driver.swipe(100, 300, 600, 300, 500);
		
	}
	
	/*
	 * 跳转到应用首页
	 */
	public void enterMainScreen() {
		PropertyConfigurator.configure("log4j2.properties");
		ss.switchToThirdGuideScreen();
//		findElementWithTimeout(
//				By.className("android.widget.TextView"),
//				10);
		joinButton.click();

	}
}
