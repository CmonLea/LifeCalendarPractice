package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;

public class LoginScreen extends AbstractScreen {
	
	public LoginScreen(AppiumDriver<?> driver) {
		super(driver);

	}
    
	@AndroidFindBy(className = "android.widget.EditText") 
	List<WebElement> accountEditText;

	@AndroidFindBy(className = "android.widget.EditText")
	List<WebElement> passwordEditText;
	@AndroidFindBy(className = "android.widget.Button")
	WebElement loginButton;
	
	public void login(String userName, String passWord) throws NoSuchElementException {
		// PropertyConfigurator.configure("log4j2.properties");
		if (accountEditText.get(0).isDisplayed()) {
			accountEditText.get(0).sendKeys(userName);
		} else {
			logger.error("进行异常截图...");
			waitElentAndCapture(accountEditText.get(0), "用户输入框未找到");

		}
		if (passwordEditText.get(1).isDisplayed()) {
			passwordEditText.get(1).sendKeys(passWord);
		} else {
			logger.error("进行异常截图...");
			waitElentAndCapture(passwordEditText.get(1), "密码输入框未找到");

			// takeScreenShot("密码输入框未找到异常");

		}
		if (loginButton.isDisplayed()) {
			findElementWithTimeout(loginButton, 10).click();
		} else {
			logger.error("进行异常截图...");
			waitElentAndCapture(passwordEditText.get(1), "登录按钮未找到");

			// takeScreenShot("登录按钮未找到异常");

		}

	}

}
