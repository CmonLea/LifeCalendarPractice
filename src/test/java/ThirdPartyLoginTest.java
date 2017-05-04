
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

@SuppressWarnings("deprecation")
public class ThirdPartyLoginTest {

	static AndroidDriver<AndroidElement> driver;

	@Before
	public void setUp() throws Exception {
		File classpathRoot = new File(System.getProperty("user.dir"));
		 File appDir = new File(classpathRoot, "apps");
		 File app = new File(appDir, "LifeCalendar.apk");
	
		
		
		
		 
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "huawei");
		capabilities.setCapability("platformVersion", "4.4");
		// �������Գ��������activity
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.updrv.lifecalendar");
		capabilities.setCapability("appActivity",
				".activity.user.LoginExtActivity");
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		capabilities.setCapability("noReset", false);
		driver = new AndroidDriver<AndroidElement>(new URL(
				"http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	/*
	 * ���������������QQ��¼
	 */
	
	@Test
	public void testQQLogin() throws InterruptedException{
		boolean isqqinstalled = driver.isAppInstalled("com.tencent.mobileqq");
		// driver.startActivity("com.tencent.mobileqq",
		// "com.tencent.qqconnect.wtlogin.Login");
		if (isqqinstalled) {
			driver.removeApp("com.tencent.mobileqq");
		}
		driver.findElement(By.id("com.updrv.lifecalendar:id/qq_login")).click();

		Set<String> contexts = driver.getContextHandles();// ����һ��string���͵�set����������APP����
		// �����������
		for (String context : contexts) {
			System.out.println(context); // it will print NATIVE_APP \n
											// WEBVIEW_com.example.testapp
		}
		takeScreenShot("QQ��¼ǰ");
		driver.context("WEBVIEW_com.updrv.lifecalendar");
		// driver.context("NATIVE_APP");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementByClassName("input_id").sendKeys("1415506275");

		driver.findElementByClassName("input_pwd")
				.sendKeys("1285322614@qq.com");
		driver.findElementById("go").click();
		Thread.sleep(5000);
		driver.context("NATIVE_APP");
		
		//
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			if(driver.findElementById(
					"com.updrv.lifecalendar:id/tv_personal_account_user_name")!=null){
				takeScreenShot("QQ��¼��");
			}
			Assert.assertEquals(
					"����",
					driver.findElementById(
							"com.updrv.lifecalendar:id/tv_personal_account_user_name")
							.getText());

	}
	
	
	
	/*
	 * ���������������΢����¼
	 */
	//@Ignore
	@Test
	public void testWeiboLogin() throws Exception {
		// driver.startActivity("com.updrv.lifecalendar", "");
		WebElement wbbutton = driver.findElement(By
				.id("com.updrv.lifecalendar:id/web_login"));
		wbbutton.click();
		Thread.sleep(3000);

		// ��ȡAPP����
		Set<String> contexts = driver.getContextHandles();
		for (String context : contexts) {
			System.out.println(context); // it will print NATIVE_APP \n
											// WEBVIEW_com.example.testapp
		}
		
		takeScreenShot("΢����¼ǰ");
		driver.context("WEBVIEW_com.updrv.lifecalendar");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement editText = driver.findElement(By.name("userId"));
		editText.sendKeys("burcelea@163.com");
		WebElement editText1 = driver.findElement(By.name("passwd"));
		editText1.sendKeys("Test20151102");

		WebElement editText3 = driver.findElement(By.className("btnP"));
		editText3.click();
		Thread.sleep(15000);
		// Assert.assertEquals("RelicRun",
		// driver.findElementById("").getText());
		
		driver.context("NATIVE_APP");
		
	//
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(driver.findElementById(
				"com.updrv.lifecalendar:id/tv_personal_account_user_name")!=null){
			takeScreenShot("΢����¼��");
		}
		Assert.assertEquals(
				"RelicRun",
				driver.findElementById(
						"com.updrv.lifecalendar:id/tv_personal_account_user_name")
						.getText());
	}

	@After
	public void tearDown() {
		driver.quit();
	}
	public void takeScreenShot(String filename) {
		  // �½�һ���ļ������洢��ͼ
		 String destDir = "screenshots";
		  // ��ͼ
		  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  // ��ʱ���ʽ�����ļ�����
		  DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		  // ����Ŀ�ļ����´���һ�� "daylifescreenshots" �ṩ�� destDir.
		  new File(destDir).mkdirs();
		  // ���ļ�����������Ϊ��ǰ��ϵͳʱ��
		  String destFile = dateFormat.format(new Date()) +filename+ ".png";

		  try {
		   // ���ļ�������ָ�����ļ�Ŀ¼
		   FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		 }

}