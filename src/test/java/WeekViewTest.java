import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;

import org.junit.Test;


public class WeekViewTest extends AbstractTest{
	@Test
	public void testWeekView() {
		Activity ac = new Activity("com.updrv.lifecalendar",
				".activity.MainActivity");

		((StartsActivity) driver).startActivity(ac);
		try {
			app.weekViewScreen().getWeekViewScreenInfo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
