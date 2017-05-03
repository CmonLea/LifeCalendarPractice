package util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import screen.AbstractScreen;

public class AppiumListener extends AbstractScreen implements AppiumWebDriverEventListener {

	public AppiumListener(AppiumDriver<?> driver) {
		super(driver);
		// TODO 自动生成的构造函数存根
	}

	public static Logger logger = Logger.getLogger(AppiumListener.class);

	@Override
	public void beforeAlertAccept(WebDriver driver) {
		logger.info("WebDriverEventListener: 尝试接收弹窗");
		// logger.("WebDriverEventListener: Attempt to accept alert");

	}

	@Override
	public void afterAlertAccept(WebDriver driver) {
		logger.info("弹窗已处理");
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		logger.info("尝试取消弹框");
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		logger.info("弹框已取消");
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		logger.info("准备导航到 " + url);
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		logger.info("导航到 " + url + "成功");
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		logger.info("准备回退导航");
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
		logger.info("回退导航成功");
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		logger.info("准备向前导航");
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		logger.info("向前导航成功");
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		logger.info("准备刷新");
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		logger.info(" 刷新成功");
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		logger.info(" 正在查找 " + by.toString());
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		logger.info("查找控件 " + by.toString() + " 完成.");
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		logger.info("准备点击控件" + splitElement(element));
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		logger.info(" 控件点击成功" + splitElement(element));
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver,
			CharSequence[] keysToSend) {
		logger.info("准备改变控件数值" + String.valueOf(element));
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		logger.info("改变控件数值成功" + splitElement(element));
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		logger.info("控件值已改变" + splitElement(element));
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver,
			CharSequence[] keysToSend) {
		logger.info("控件已被点击" + splitElement(element));
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		logger.info("准备执行java script: " + script);
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		logger.info("Java script " + script + " 执行成功");
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {

		logger.info("异常已抛出: " + throwable.getClass());
		takeScreenShot("异常退出截图");

	}

//	public void takeScreenShot(String filename) {
//		//PropertyConfigurator.configure("log4j.properties");
//		
//		// 存取截图文件的目录
//		String destDir = "screenshots";
//		// 截图文件
//		File scrFile = driver.getScreenshotAs(OutputType.FILE);
//		// 日期格式
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		// 创建截图目录
//		new File(destDir).mkdirs();
//		// 存取的截图文件命名
//		String fileFormat = dateFormat.format(new Date()) + filename + ".png";
//		// 截图存放的路径
//		File destFile = new File(destDir + "\\" + fileFormat);
//
//		try {
//			System.out.println("截图位于Ϊ:" + destDir + "\\" + fileFormat);
//			FileUtils.copyFile(scrFile, destFile);
//		} catch (IOException e) {
//			System.out.println("截图失败");
//			e.printStackTrace();
//		}
//	}

	// 获取操作的控件字符串
	private String splitElement(WebElement element) {
		String str = element.toString().split("-> ")[1];
		return str.substring(0, str.length() - 1);
	}

}
