package 片段;

import org.openqa.selenium.Dimension;

import io.appium.java_client.TouchAction;

public class AppiumSwipe {
	public void method1(){
	TouchAction action = new TouchAction(driver);
	
	int startY2 = element1.getLocation().getY() + (element.getSize().getHeight() / 2);
	
	int startX2 = element1.getLocation().getX() + (element.getSize().getWidth() / 2);
	
	int endX2 = element2.getLocation().getX() + (element2.getSize().getWidth() / 2);
	
	int endY2 = element2.getLocation().getY() + (element2.getSize().getHeight()/2) - (element2.getSize().getHeight()/2);
	
	
	action.press(startX2, startY2).waitAction(2000).moveTo(endX2, endY2).release().perform();
	}
	public void method2(){
		Dimension dimension = driver.manage().window().getSize();
		int width = dimension.getWidth();
		int height = dimension.getHeight();
		switch(direction)
		{
		case "right" : driver.swipe((int) (width*(0.20)), (int) (height*(0.50)), (int)(width*(0.80)), (int) (height*(0.50)), 6000);
		break;
		case "left" : driver.swipe((int) (width*(0.80)), (int) (height*(0.50)), (int) (width*(0.20)), (int) (height*(0.50)), 6000);
		break;
		case "up" : driver.swipe((int) (width*(0.50)), (int) (height*(0.70)), (int) (width*(0.50)), (int) (height*(0.30)), 6000);
		break;
		default : driver.swipe((int) (width*(0.50)), (int) (height*(0.30)), (int) (width*(0.50)), (int) (height*(0.70)), 6000);
		break;
		}
	}
	}

