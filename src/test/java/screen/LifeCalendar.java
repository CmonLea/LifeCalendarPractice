package screen;

import io.appium.java_client.AppiumDriver;

//LifeCalendar类用于管理页面，返回不同的测试页面以便操作
public class LifeCalendar {

	private final AppiumDriver<?> driver;

	public LifeCalendar(AppiumDriver<?> driver) {
		this.driver = driver;
	}

	public MainScreen mainScreen() {
		return new MainScreen(driver);
	}

	public MyScreen myScreen() {
		return new MyScreen(driver);
	}

	public LoginScreen loginScreen() {
		return new LoginScreen(driver);
	}

	public GuideScreen guideScreen() {
		return new GuideScreen(driver);
	}

	// SecondGuideScreen
	public SecondGuideScreen secondGuideScreen() {
		return new SecondGuideScreen(driver);

	}

	// ThirdGuideScreen
	public ThirdGuideScreen thirdGuideScreen() {
		return new ThirdGuideScreen(driver);

	}

	public GuideScreenDemoScreen guideScreenDemoScreen() {
		return new GuideScreenDemoScreen(driver);

	}

	public WeekViewScreen weekViewScreen() {
		return new WeekViewScreen(driver);

	}

	public PersonalCenterScreen personalCenterScreen() {
		return new PersonalCenterScreen(driver);
	}

	public RemindScreen remindScreen() {
		return new RemindScreen(driver);
	}

	public NoteScreen noteScreen() {
		return new NoteScreen(driver);
	}
	public BacklogScheduleScreen backlogScheduleScreen() {
		return new BacklogScheduleScreen(driver);
	}

	public BirthDayAnniversary birthDayAnniversary() {
		return new BirthDayAnniversary(driver);
	}

	public RemindNoteScreen remindNoteScreen() {
		return new RemindNoteScreen(driver);
	}

}