import static org.testng.Assert.assertEquals;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;

import org.junit.Before;
import org.junit.Test;

public class GuideScreenTest extends AbstractTest {

	@Before
	public void setUp() {
		Activity activity = new Activity("com.updrv.lifecalendar",
				".activity.GuideActivity");
		((StartsActivity) driver).startActivity(activity);

	}

	
	@Test
	/*
	 * 从引导页第一屏跳到首页
	 */
	public void testFristScreenClickSkipButton() {
		app.guideScreen().skipGuideScreen();

	}


	@Test
	/*
	 * 从引导页第一屏 滑动到第二屏引导页
	 */
	public void testSwipToSecondGuideScreen() {
		app.guideScreen().switchToSecondGuideScreen();
		// 待添加图片比对方法验证

	}

	
	@Test
	public void testSecondScreenClickSkipButton() {
		app.secondGuideScreen().skipGuideScreen();
		assertEquals(((StartsActivity) driver).currentActivity(), ".activity.MainActivity");
	}

	
	@Test
	/*
	 * 从第一屏滑动到第三屏引导页
	 */
	public void testSwipToThridGuideScreen() {
		app.secondGuideScreen().switchToThirdGuideScreen();
		// 待添加图片比对方法验证
	}

	@Test
	public void testClickExperienceButton() {
		app.thirdGuideScreen().enterMainScreen();
	assertEquals(((StartsActivity) driver).currentActivity(), ".activity.MainActivity");
	}

	/*
	 * 从第三屏引导页滑动到第二屏
	 */

	@Test
	public void testSwipFromThridGuideScreenToSecondScreen() {
		app.thirdGuideScreen().switchToSecondGuideScreen();
		// 待添加图片比对方法验证
	}

}
