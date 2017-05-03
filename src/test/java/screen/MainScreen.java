package screen;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class MainScreen extends AbstractScreen {

	public MainScreen(AppiumDriver<?> driver) {
		super(driver);

	}

	@FindBy(name = "首页")
	public WebElement homePageTag;

	@FindBy(name = "提醒")
	public WebElement remindPageTag;

	@FindBy(name = "发现")
	public WebElement foundPageTag;

	@FindBy(name = "我的")
	public WebElement myPageTag;

	public void clickHomePageTag() {
		PropertyConfigurator.configure("log4j2.properties");
		if(homePageTag.isDisplayed()){
		homePageTag.click();
		}else{
			logger.error("首页标签控件查找失败");
			waitElentAndCapture(homePageTag, "首页标签控件查找失败");
		}
	}

	public void clickRemindPageTag() {
		//PropertyConfigurator.configure("log4j2.properties");
		if(remindPageTag.isDisplayed()){
			remindPageTag.click();
		}else{
			logger.error("提醒标签控件查找失败");
			waitElentAndCapture(remindPageTag, "提醒标签控件查找失败");
		}
	
	
	}

	public void clickFoundPageTag() {
		//PropertyConfigurator.configure("log4j2.properties");
		if(foundPageTag.isDisplayed()){
			foundPageTag.click();
		}else{
			logger.error("提醒标签控件查找失败");
			waitElentAndCapture(foundPageTag, "发现标签查找失败");
		}
	
	}

	public void clickMyPageTag() {
		// PropertyConfigurator.configure("log4j2.properties");
		if (myPageTag.isDisplayed()) {
			myPageTag.click();
		} else {
			logger.error("我的标签控件查找失败");
			waitElentAndCapture(myPageTag, "我的标签控件查找失败");
		}

	}

}
