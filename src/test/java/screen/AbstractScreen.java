package screen;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.imageio.ImageIO;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ScreenshotState;
import io.appium.java_client.ScreenshotState.ResizeMode;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractScreen {
	public static Logger logger = Logger.getLogger(AbstractScreen.class);
	protected final AppiumDriver<?> driver;
	File file = new File("screenShotCapture.jpg");// 未处理的截图
	File outImageFile = new File("processedScreenshot.jpg");// 处理过的截图

	// static Logger logger = Logger.getLogger(AbstractScreen.class.getName());

	// 初始化Page Object对象
	public AbstractScreen(AppiumDriver<?> driver) {
		this.driver = driver;

		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	/**
	 * 公用方法查找元素并等待
	 * 
	 * @param by
	 * @param timeOutInSeconds
	 * @return
	 */
	public MobileElement findElementWithTimeout(By by, int timeOutInSeconds) {
		return (MobileElement) (new WebDriverWait(driver, timeOutInSeconds))
				.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public MobileElement findElementWithTimeout(WebElement we, int timeOutInSeconds) {
		return (MobileElement) (new WebDriverWait(driver, timeOutInSeconds))
				.until(ExpectedConditions.elementToBeClickable(we));
	}
	@SuppressWarnings("unchecked")
	public List<WebElement> findElementsWithTimeout(By by, int timeOutInSeconds) {
		return (List<WebElement>) (new WebDriverWait(driver, timeOutInSeconds))
				.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	public void resetAPP() {
		System.out.println("重置APP...");
		driver.resetApp();
		Activity ac=new Activity("com.updrv.lifecalendar", ".activity.MainActivity");
		((StartsActivity) driver).startActivity(ac);
	}
	
	
	/**
	 * @此方法用于截图
	 * 
	 * @param drivername
	 *            Appium Driver 实例
	 * @param filename
	 *            截图文件名称
	 */
	// 截图操作
	public void takeScreenShot(String filename) {
		//PropertyConfigurator.configure("log4j.properties");
		
		// 存取截图文件的目录
		String destDir = "screenshots";
		// 截图文件
		File scrFile = driver.getScreenshotAs(OutputType.FILE);
		// 日期格式
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		// 创建截图目录
		new File(destDir).mkdirs();
		// 存取的截图文件命名
		String fileFormat = dateFormat.format(new Date()) + filename + ".png";
		// 截图存放的路径
		File destFile = new File(destDir + "\\" + fileFormat);

		try {
			System.out.println("截图位于Ϊ:" + destDir + "\\" + fileFormat);
			FileUtils.copyFile(scrFile, destFile);
		} catch (IOException e) {
			System.out.println("截图失败");
			e.printStackTrace();
		}
	}

	/**
	 * @此方法用于比较2张图片的相似度
	 * @param templatePicture
	 *            用于比较的模板图片
	 * @param actualPicture
	 *            待比较的图片
	 * @param sc
	 *            double类型，表示相似度， 相似度数值范围在 (-1.0, 1.0). 返回1.0表示两张图片为同一张图片
	 * @return isSimilar表示图片是否匹配
	 * @throws IOException
	 */
	public boolean testPictureSimilarity(BufferedImage actualPicture,
			BufferedImage templatePicture) throws IOException {
		PropertyConfigurator.configure("log4j2.properties");
		boolean isSimilar = false;
		// WebElement element = null;
		templatePicture = ImageIO.read(file);
		// actualPicture = getCustomeScreenshots(element);
		actualPicture = ImageIO.read(outImageFile);
		double sc = ScreenshotState.getOverlapScore(actualPicture,
				templatePicture, ResizeMode.TEMPLATE_TO_REFERENCE_RESOLUTION);

		System.out.println("sc=" + sc);
		if (sc == 1.0) {
			isSimilar = true;
		}
		return isSimilar;

	}

	/**
	 * 此方法用于获取自定义区域截图
	 * 
	 * @param element
	 *            需要截取的元素
	 * @return BufferedImage类型的截图
	 * @throws IOException
	 */
	public BufferedImage getCustomeScreenshots(WebElement element)
			throws IOException {
		PropertyConfigurator.configure("log4j2.properties");
		// 将图片写入到文件
		// File file = new File("screenShotCapture.jpg");//未处理的截图
		// File outImageFile = new File("processedScreenshot.jpg");//处理过的截图

		// 实现截图功能
		final byte[] srcImage = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.BYTES);
		// 创建输出流将截图写到文件里
		FileOutputStream fis = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fis);
		try {
			bos.write(srcImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (bos != null) {
			bos.close();
		}

		// 需要截取的元素
		// element =
		// driver.findElement(By.className("android.widget.TextView"));

		// 获取需要截图图片的坐标和尺寸
		final Point elementLocation = element.getLocation();
		System.out.println("elementLocation.x=" + elementLocation.x);
		System.out.println("elementLocation.y=" + elementLocation.y);
		final Dimension elementSize = element.getSize();
		System.out.println("elementSize.x=" + elementSize.getHeight());
		System.out.println("elementSize.y=" + elementSize.getWidth());

		// 从读入的文件来截取图片
		final BufferedImage screenshot = ImageIO.read(file);
		// 执行二次截图操作
		BufferedImage processedScreenshot = screenshot.getSubimage(
				elementLocation.x, elementLocation.y, elementSize.width,
				elementSize.height);
		// 将截取的图片写入到新文件
		ImageIO.write(processedScreenshot, "jpg", outImageFile);

		return ImageIO.read(outImageFile);

	}

	/**
	 * 循环等待定位控件出现，如果5次还没出现就截图并返回false
	 * 
	 * @param we
	 *            需要查找的控件
	 * @param fileName
	 * @return false 控件未查找到时返回
	 */
	protected void waitElentAndCapture(WebElement we, String fileName) {
		//PropertyConfigurator.configure("log4j2.properties");
		// WebElement we = null;
		// 判断该控件是否存在
		int i = 0;
		//boolean isElementDisplayed = true;
		while (!we.isDisplayed() && i < 5) {

			// SolveProblems();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			if (i == 4) {
				logger.warn("已达到最大查找次数，正在获取查找页面...");
				takeScreenShot(fileName);// (getUiDevice(), str+"-not-find");
			//	return isElementDisplayed = false;
			}

			i++;
		}
		//return isElementDisplayed;
	}

	protected boolean isElementDisplayed(WebElement we) {
		boolean isElementDisplayed = false;
		System.out.println("假设控件默认显示===========================isElementDisplayed="+isElementDisplayed);
	
		if (we.isDisplayed()) {
			isElementDisplayed = true;
			System.out.println("如果控件未显示则将控件置为false===========================isElementDisplayed="+isElementDisplayed);
		}else{
			waitElentAndCapture(we, "控件未显示");
		}
		System.out.println("返回最后的值===========================isElementDisplayed="+isElementDisplayed);
		return isElementDisplayed;
		
	}
	/**
	 * 当进不下去的时候，使用该方法，例如可能是出现了一些对话框遮挡，该方法会把对话框干掉
	 */
	protected void SolveProblems() {
		// ....
	}

}