package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("deprecation")
/*
 * 引导页第一屏
 */
public class GuideScreen extends AbstractScreen {

	public GuideScreen(AppiumDriver<?> driver) {
		super(driver);

	}

	@FindBy(className = "android.widget.TextView")
	WebElement skipButton;

	@FindBy(xpath = "//android.support.v4.view.ViewPager/android.widget.ImageView")
	MobileElement fristGuideScreen;

	/*
	 * 滑动到引导页第二屏
	 */

	public void switchToSecondGuideScreen() {
		// PropertyConfigurator.configure("log4j2.properties");
		// if(findElementWithTimeout(
		// By.xpath("//android.support.v4.view.ViewPager/android.widget.ImageView"),
		// 10).isDisplayed()){
		if (fristGuideScreen.isDisplayed()) {
			logger.info("滑到第二屏引导页");
			driver.swipe(500, 300, 100, 300, 500);
		}else{
			
			waitElentAndCapture(fristGuideScreen, "第一屏引导页未显示");
		}

	}

	/*
	 * 跳转到应用首页
	 */
	public void skipGuideScreen() {
		// PropertyConfigurator.configure("log4j2.properties");
		// if(findElementWithTimeout(By.className("android.widget.TextView"),
		// 5).isDisplayed()){
		if (skipButton.isDisplayed()) {
			logger.info("跳过引导页");
			skipButton.click();
		}

	}

}

