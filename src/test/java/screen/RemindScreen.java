package screen;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class RemindScreen extends AbstractScreen {

	public RemindScreen(AppiumDriver<?> driver) {
		super(driver);
	
	}
@FindBy(id="com.updrv.lifecalendar:id/item_view_recover_note")
public WebElement noteItem;

@FindBy(id="com.updrv.lifecalendar:id/item_view_recover_schedule")
public WebElement backlogScheduleItem;

@FindBy(id="com.updrv.lifecalendar:id/item_view_recover_remind")
public WebElement remindItem;

@FindBy(id="com.updrv.lifecalendar:id/item_view_recover_anniversary")
public WebElement birthAnniversaryItem;

}
