import static org.testng.Assert.assertEquals;

import org.junit.Test;

//实现登录操作并判断是否登录成功
public class LoginTest extends AbstractTest {
	// @Ignore
	@Test
	public void testLogin() {

		app.mainScreen().myPageTag.click();
		if (app.myScreen().isLogin()) {
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
//@Ignore
	@Test
	public void testQQLogin() {

		app.mainScreen().myPageTag.click();
		if (app.myScreen().isLogin()) {
			app.myScreen().resetAPP();
			try {
				app.mainScreen().myPageTag.click();
				app.myScreen().enterLoginPage();

				app.loginScreen().qqLogin("1415506275", "1285322614@qq.com");
//				if(app.myScreen().isRemindWindowDisplay()){
//					app.myScreen().remindLaterButton.click();
//				}
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} else {
			app.myScreen().enterLoginPage();
			try {
				app.loginScreen().qqLogin("1415506275", "1285322614@qq.com");
//				if(app.myScreen().isRemindWindowDisplay()){
//					app.myScreen().remindLaterButton.click();
//				}
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

		}
		assertEquals(app.myScreen().initUserName.get(0).getText(), "玻利", "登录失败");

	}

	@Test
	public void testWeboLogin() {

		app.mainScreen().myPageTag.click();
		if (app.myScreen().isLogin()) {
			app.myScreen().resetAPP();
			try {
			app.mainScreen().myPageTag.click();
			app.myScreen().enterLoginPage();
			
				app.loginScreen().weiboLogin("burcelea@163.com", "Test20161024");
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		} else {
			app.myScreen().enterLoginPage();
			try {
				app.loginScreen().weiboLogin("burcelea@163.com", "Test20161024");
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

		}
		assertEquals(app.myScreen().initUserName.get(0).getText(), "RelicRun",
				"登录成功");

	}
}