
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

//Calendar_Android-307:�ع�����-��ӳ���
public class TestAddCity {
	AppiumDriver<WebElement> driver;
	List<String> arraylist = null;//�м������Ҫ�������Ƚ�
    int CITY_POSTION=(int)(Math.random()*31+1);//���ų��е�����
 
	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Coolpad8670");
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("appPackage", "com.updrv.lifecalendar");
		capabilities.setCapability("appActivity",
				".activity.weather.WeatherNewActivity");
		capabilities.setCapability("unicodeKeyboard", "ture");
		capabilities.setCapability("resetKeyboard", "ture");
		//caps.setCapability("newCommandTimeout", 120);
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
	}

	@Test
	// ��ӳ���
	public void testAddCity() {
		try {

			Thread.sleep(3000);
		
		} catch (InterruptedException e) {
			e.printStackTrace();
			//logger.error("����δ��Ӧ", TestAddCity.class.getName());
		}
		//logger.info("�Ѿ���������������棬���ڽ�ͼ");
		snapshot(driver, "���������������ͼ");
		//logger.info("��ͼ���");
		driver.findElementById("com.updrv.lifecalendar:id/weather_new_title_iv")
				.click();// �����������������Ӱ�ť

		
		//logger.warn("���ǰ���й�������ͼ...");
		snapshot(driver, "���ǰ���й�������ͼ");
	
		// for(int i=0;i<5;i++){
		if (driver.findElementsByXPath(
				"//android.widget.GridView/android.widget.RelativeLayout")
				.size() >= 9) {
			//System.out.println("��ǰҳ�������������9��������ҳ���Ի�ȡ���������б�");
			//logger.warn("��ǰҳ�������������9��������ҳ���Ի�ȡ���������б�...");
			//logger.info("��ʼ��������������Ϊ��250, 640, 250, 320, 800...");
			driver.swipe(250, 640, 250, 320, 800);
			
			new AddCities().addCities();
		} else {
			//System.out.println("��������С��9��������ִ��...");
			//logger.warn("��������С��9��������ִ��...");
			//logger.info("���ڵ�����ӳ��еķ���");
			new AddCities().addCities();
		}
		// }
	}

	@After
	public void teardown() {
		driver.quit();
	}

	public static void snapshot(TakesScreenshot drivername, String filename) {
		// ����������ڴ�����ͼ ,���������β� ,һ����driver�����ƣ�һ�����ļ�������
		String destDir = "screenshots"; // ��ȡ��ǰ�����ռ�Ŀ¼
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh��mm��ss-a");
		new File(destDir).mkdirs();
		 String destFile = dateFormat.format(new Date()) +filename+ ".png";
		// ��ȡ����ͼ�󣬿��Կ�����ͼ������λ��
		try {
			System.out.println("��ͼ�����·��Ϊ:" + destDir + "\\" +  destFile);
			FileUtils.copyFile(scrFile, new File(destDir + "\\" + destFile));
		} catch (IOException e) {
			System.out.println("�޷������ͼ");
			e.printStackTrace();
		} finally {
			System.out.println("��ͼ���, �ļ�λ�� " + destDir + "�ļ���");
		}
	}
	
	public boolean comparecityrepeation(List<String> citymanagelist,
			String selectedcity) {
		boolean isrepeat = false;//�ȼ���û������ظ��ĳ���
		for (int i = 0; i < arraylist.size(); i++) {
			System.out.println("arraylist�ĳ���Ϊ��" + arraylist.size());
			if (arraylist.get(i).contains(selectedcity)) {
				System.out.println(selectedcity + "�����");
				isrepeat = true;
		}
	
	}
		return isrepeat;
}

}