
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//实现登录操作并判断是否登录成功
public class LoginTest extends AbstractTest {
	// @Before
	// public void setUp() {
	// //driver.resetApp();
	// Activity activity = new Activity("com.updrv.lifecalendar",
	// ".activity.MainActivity");
	// // activity.setWaitAppPackage("app wait package goes here");
	// // activity.setWaitAppActivity("app wait activity goes here");
	// ((StartsActivity) driver).startActivity(activity);
	//
	// // ((AndroidDriver)
	// //
	// driver).StartsActivity("com.updrv.lifecalendar",".activity.MainActivity");
	// }

	@Test
	public void testLogin() {

		app.mainScreen().myPageTag.click();
		if (!app.myScreen().isLogin()) {
			app.myScreen().resetAPP();
			app.mainScreen().myPageTag.click();
			app.myScreen().enterLoginPage();
			app.loginScreen().login("apple00", "123456");
		} else {
			app.myScreen().enterLoginPage();
			app.loginScreen().login("apple00", "123456");

		}
		assertEquals(app.myScreen().initUserName.get(0).getText(), "apple00",
				"登录成功");

	}

}