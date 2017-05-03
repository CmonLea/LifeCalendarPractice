package screen;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyScreen extends AbstractScreen {

	public MyScreen(AppiumDriver<?> driver) {
		super(driver);

	}

	@FindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout")
	public WebElement notLogin;
	
	@FindBy(className="android.widget.TextView")
	public List<WebElement> initUserName;

	@AndroidFindBy(className = "android.widget.ImageView")
	public List<WebElement> loginButton;

	// 判断是否登录，返回获取的用户名
	public boolean isLogin() {
		String userName;
		boolean loginStatus;
		//PropertyConfigurator.configure("log4j2.properties");
		userName = initUserName.get(0).getText();
		loginStatus = userName.equals("未登录");
		if (loginStatus) {
			// System.out.println("用户未登录");
			logger.info("用户未登录");
			loginStatus = false;
		} else {
			// System.out.println("用户已登录");
			logger.info("用户已登录");

			loginStatus = true;

		}
		return loginStatus;

	}

	public void resetAPP() {
		//System.out.println("重置APP...");
		logger.info("重置App...");
		driver.resetApp();
		Activity ac = new Activity("com.updrv.lifecalendar",
				".activity.MainActivity");
		((StartsActivity) driver).startActivity(ac);
	}

	public void logOut() {
		logger.info("退出登录...");
		notLogin.click();
		//driver.findElementByName("确定").click();
	}

	// 进入登录页面
	public void enterLoginPage() {
		logger.info("进入登录页面");
		loginButton.get(0).click();
	}

}
