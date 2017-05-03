package screen;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class BacklogScheduleScreen extends AbstractScreen {

	public BacklogScheduleScreen(AppiumDriver<?> driver) {
		super(driver);
		// TODO 自动生成的构造函数存根
	}

	@FindBy(id = "com.updrv.lifecalendar:id/tv_title_name")
	WebElement titleName;

	@FindBy(id = "com.updrv.lifecalendar:id/layout_left")
	WebElement backlog;

	@FindBy(id = "com.updrv.lifecalendar:id/layout_right")
	WebElement schedule;

	//用来获取当前页面显示的待办记事条数
	@FindBy(id = "com.updrv.lifecalendar:id/swipe")
	List<WebElement> backlogList;
	//已经完成列表，页面至少包含一条已完成的待办记事后可用
	@FindBy(id = "com.updrv.lifecalendar:id/one_status_name")
	WebElement finishStatus;
	
	@FindBy(xpath= "//android.widget.ExpandableListView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView")
	List<WebElement> noteTitle;
	
	/**
	 * 点击待办标签
	 * 
	 * @return 页面标题
	 */
	public String switchToBacklog() {
		String switchStatus = null;
		try {
			backlog.click();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			switchStatus=titleName.getText();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return switchStatus;

	}

	/**
	 * 点击日程标签
	 * 
	 * @return 页面标题
	 */
	public String switchToSchedule() {
		String switchStatus = null;
		try {
			schedule.click();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			switchStatus=titleName.getText();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return switchStatus;

	}

	/**
	 * 点击单条未完成的待办记事
	 * 
	 * @return
	 */
	public boolean clickBacklogItem() {
		boolean isClickOK = false;
		int backlogListSize = 0;
		String fristNoteTitleName;
		try {
			backlogListSize = backlogList.size();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		// 判断待办列表中有未完成的待办记事
		if (backlogListSize > 0) {
			// 获取要点击待办记事的记事标题
			fristNoteTitleName = noteTitle.get(0).getText();

			// 点击待办列表中第一条未完成的记事
			backlogList.get(0).click();
		}
		try {
			isClickOK = finishStatus.isDisplayed();
			//展开完成的记事查找已完成的待办记事
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return isClickOK;

	}

}
