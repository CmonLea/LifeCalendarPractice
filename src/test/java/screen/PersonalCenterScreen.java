package screen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.AppiumDriver;

public class PersonalCenterScreen extends AbstractScreen{

	public PersonalCenterScreen(AppiumDriver<?> driver) {
		super(driver);
		// TODO 自动生成的构造函数存根
	}
	
	//@FindAll(id ="com.updrv.lifecalendar:id/user_center_etit_text")
	//@FindBys({@FindBy(id ="com.updrv.lifecalendar:id/user_center_etit_text"), 
	@FindBy(id="com.updrv.lifecalendar:id/user_center_etit_text")
	//}) 
	WebElement logoutButton1;
	WebElement logoutButton2;
	
	public void logOut(){
		if (isElementDisplayed(logoutButton1)) {
			logoutButton1.click();
			// waitElentAndCapture(logoutButton1, "退出登录控件未找到");
			// if(logoutButton2.isDisplayed()){
			// logoutButton2.click();
			// }else{
			// waitElentAndCapture(logoutButton2, "退出登录控件未找到");
			// }

		} else {
			waitElentAndCapture(logoutButton1, "退出登录控件未找到");
//			if (isElementDisplayed(logoutButton2)) {
//				logoutButton2.click();
//			} else {
//				waitElentAndCapture(logoutButton2, "退出登录控件未找到");
//			}

		}
		driver.findElementByName("确定").click();
	}

	
	}


