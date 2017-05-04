package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginScreen extends AbstractScreen {
	
	public LoginScreen(AppiumDriver<?> driver) {
		super(driver);

	}
    //160
	@AndroidFindBy(className = "android.widget.EditText") 
	List<WebElement> accountEditText;

	@AndroidFindBy(className = "android.widget.EditText")
	List<WebElement> passwordEditText;
	@AndroidFindBy(className = "android.widget.Button")
	WebElement loginButton;
	
	
	
	
	

   //QQ
	@FindBy(id="com.updrv.lifecalendar:id/qq_login")
	WebElement qqLoginButton;
	
	
	@FindBy(className="input_id")
	WebElement input_id;
	
	
	@FindBy(className="input_pwd")
	WebElement input_pwd;
	

	@FindBy(id="go")
	WebElement go;
	
	//微博
	@FindBy(id="com.updrv.lifecalendar:id/web_login")
	WebElement wbButton ;
	
	@FindBy(name="userId")
	WebElement uEditText;
	
	@FindBy(name="passwd")
	WebElement pEditText;
	
	
	@FindBy(className="btnP")
	WebElement btnP;


	
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

	public void qqLogin(String userName, String passWord) throws InterruptedException
			 {
		boolean isqqinstalled = driver.isAppInstalled("com.tencent.mobileqq");

		if (isqqinstalled) {
			driver.removeApp("com.tencent.mobileqq");
		}

		try {
			qqLoginButton.click();

			Set<String> contexts = driver.getContextHandles();

			for (String context : contexts) {
				//System.out.println(context); // it will print NATIVE_APP \n
					logger.info(context);							// WEBVIEW_com.example.testapp
			}
			// takeScreenShot("QQ��¼ǰ");

			driver.context("WEBVIEW_com.updrv.lifecalendar");

			// driver.context("NATIVE_APP");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			input_id.sendKeys(userName);

			input_pwd.sendKeys(passWord);
			go.click();
			Thread.sleep(5000);
			driver.context("NATIVE_APP");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		//
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// if (driver
		// .findElementById("com.updrv.lifecalendar:id/tv_personal_account_user_name")
		// != null) {
		// //takeScreenShot("QQ��¼��");
		// }
		// Assert.assertEquals(
		// "����",
		// driver.findElementById(
		// "com.updrv.lifecalendar:id/tv_personal_account_user_name")
		// .getText());

	}

	public void weiboLogin(String userName, String passWord) throws Exception {
		boolean isWeiBoInstalled = driver.isAppInstalled("com.sina.weibo");

		if (isWeiBoInstalled) {
			driver.removeApp("com.sina.weibo");
		}
		
		
		try {
			wbButton.click();
			Thread.sleep(3000);


			Set<String> contexts = driver.getContextHandles();
			for (String context : contexts) {
				logger.info(context);	 
			}
			
			//takeScreenShot("΢����¼ǰ");
			driver.context("WEBVIEW_com.updrv.lifecalendar");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			uEditText.sendKeys(userName);
			pEditText.sendKeys(passWord);

			btnP.click();
			Thread.sleep(15000);
			// Assert.assertEquals("RelicRun",
			// driver.findElementById("").getText());
			
			driver.context("NATIVE_APP");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	//
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// if(driver.findElementById(
		// "com.updrv.lifecalendar:id/tv_personal_account_user_name")!=null){
		// takeScreenShot("΢����¼��");
		// }
		// Assert.assertEquals(
		// "RelicRun",
		// driver.findElementById(
		// "com.updrv.lifecalendar:id/tv_personal_account_user_name")
		// .getText());
	}


}
