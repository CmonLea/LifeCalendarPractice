import org.apache.log4j.Logger;
import org.junit.Test;

import util.AppiumListener;

public class LogoutTest extends AbstractTest {
	public static Logger logger = Logger.getLogger(LogoutTest.class);
	@Test
	public void testLogout() {
		//logger.info("点击我的页面");
		app.mainScreen().myPageTag.click();
		if (app.myScreen().isLogin()) {
			app.myScreen().logOut();
			app.personalCenterScreen().logOut();
		} else {
			System.out.println("==================？？？？？？？？？？？？？？？？==============");
			app.myScreen().initUserName.get(0).click();
			app.loginScreen().login("1", "1");
		}
        
		app.myScreen().logOut();
		app.personalCenterScreen().logOut();

	}
}
