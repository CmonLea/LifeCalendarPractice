package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WeekViewScreen extends AbstractScreen{

	public WeekViewScreen(AppiumDriver<?> driver) {
		super(driver);
	}

	@FindBy(className = "android.widget.TextView")
    List<WebElement> textViewInfo;
	
	@FindBy(className ="android.view.View")
	WebElement lifeCalendarView;

	public void getWeekViewScreenInfo() throws InterruptedException {
		PropertyConfigurator.configure("log4j2.properties");

		Thread.sleep(50000);

		TouchAction action = new TouchAction(driver);
		// A point, containing the location of the top left-hand corner of the
		// element
		int viewX = lifeCalendarView.getLocation().getX();// 获取左上角的x坐标
		int viewY = lifeCalendarView.getLocation().getY();// 获取左上角的y坐标
		int height = lifeCalendarView.getSize().height;// 获取查找空间的高度
		int width = lifeCalendarView.getSize().width;// 获取查找空间的宽度
		int x = lifeCalendarView.getLocation().x;// 获取左上角的x坐标
		int y = lifeCalendarView.getLocation().y;// 获取左上角的y坐标

		int x1 = lifeCalendarView.getLocation().x;
		int y1 = lifeCalendarView.getLocation().y;
		Point p1 = new Point(x1, y1);
		int x2 = lifeCalendarView.getSize().width;
		int y2 = y1 + lifeCalendarView.getSize().height;
		Point p2 = new Point(x2, y2);

		System.out.println("viewX=" + viewX);
		System.out.println("viewY=" + viewY);
		System.out.println("height=" + height);
		System.out.println("width=" + width);
		System.out.println("x=" + x);
		System.out.println("y=" + y);
		System.out.println("x1="+x1);
		System.out.println("y1="+y1);
		System.out.println("x2="+x2);
		System.out.println("y2="+y2);
		//执行下拉日视图操作
		action.press(x1, y1).waitAction(Duration.ofMillis(500)).moveTo(x1,
		 y2).release().perform();
		
		findElementWithTimeout(By.className("android.view.View"), 5).swipe(SwipeElementDirection.UP, 500);
		//执行上拉日视图操作
//		action.press(x1, y2).waitAction(Duration.ofMillis(500)).moveTo(x1,
//				 y1).release().perform();


	}

}
