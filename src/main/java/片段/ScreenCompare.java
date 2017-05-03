package 片段;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ScreenshotState;
import io.appium.java_client.android.AndroidDriver;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import screen.AbstractScreen;

public class ScreenCompare  {

	public ScreenCompare(AppiumDriver<?> driver) {
		super(driver);
		// TODO 自动生成的构造函数存根
	}

	AppiumDriver<WebElement> driver;

	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Coolpad8670");
		capabilities.setCapability("platformVersion", "4.4.2");
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", "ture");
		capabilities.setCapability("appPackage", "com.updrv.lifecalendar");
		capabilities.setCapability("appActivity", ".activity.GuideActivity");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

//	public static void snapshot(TakesScreenshot drivername, String filename) {
//
//		String currentPath = System.getProperty("user.dir");
//		// 用一个文件来接收返回的图片
//		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
//
//		try {
//			System.out.println(":" + currentPath + "\\" + filename);
//			// 复制文件到指定路径
//			FileUtils
//					.copyFile(scrFile, new File(currentPath + "\\" + filename));
//		} catch (IOException e) {
//			System.out.println("");
//			e.printStackTrace();
//		} finally {
//			System.out.println(" " + currentPath + "");
//		}
//	}
//
//	/*
//	 * 此方法用于保存图片，同时返回一个BufferedImage对象
//	 */
//
//	public BufferedImage capturePicture(TakesScreenshot drivername,
//			String filename) throws IOException {
//		// String currentPath = System.getProperty("user.dir");
//
//		byte[] srcImage = ((TakesScreenshot) driver)
//				.getScreenshotAs(OutputType.BYTES);
//		// 将图片写入到文件
//		File file = new File("screenShot.jpg");
//		FileOutputStream fis = new FileOutputStream(file);
//		BufferedOutputStream bos = new BufferedOutputStream(fis);
//		bos.write(srcImage);
//
//		return ImageIO.read(new ByteArrayInputStream(srcImage));
//
//	}

//	/**
//	 * @此方法用于比较2张图片的相似度
//	 * @param templatePicture
//	 *            用于比较的模板图片
//	 * @param actualPicture
//	 *            待比较的图片
//	 * @param sc
//	 *            double类型，表示相似度， 相似度数值范围在 (-1.0, 1.0). 返回1.0表示两张图片为同一张图片
//	 * @return isSimilar表示图片是否匹配
//	 * @throws IOException
//	 */
//	public boolean testPictureSimilarity(BufferedImage actualPicture,
//			BufferedImage templatePicture) throws IOException {
//		boolean isSimilar = false;
//		WebElement element = null;
//		templatePicture = ImageIO.read(new File("templatePicture.jpg"));
//		actualPicture = getCustomeScreenshots(element);
//		double sc = ScreenshotState.getOverlapScore(actualPicture,
//				templatePicture);
//
//		System.out.println("sc=" + sc);
//		if (sc == 1.0) {
//			isSimilar = true;
//		}
//		return isSimilar;
//
//	}

	@Test
	public void VerifyPicture() throws IOException, InterruptedException {
		BufferedImage actualPicture=null;
		BufferedImage templatePicture=null;
		
		Thread.sleep(5000);
		getCustomeScreenshots(driver.findElement(By
				.className("android.widget.TextView")));
		try {
			testPictureSimilarity(actualPicture,templatePicture);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

//	/**
//	 * 此方法用于获取自定义区域截图
//	 * 
//	 * @param element
//	 *            需要截取的元素
//	 * @return BufferedImage类型的截图
//	 * @throws IOException
//	 */
//	public BufferedImage getCustomeScreenshots(WebElement element)
//			throws IOException {
//
//		// 需要截取的元素
//	//	element = driver.findElement(By.className("android.widget.TextView"));
//		final Point elementLocation = element.getLocation();
//		final Dimension elementSize = element.getSize();
//
//		final byte[] srcImage = ((TakesScreenshot) driver)
//				.getScreenshotAs(OutputType.BYTES);
//
//		// 将图片写入到文件
//		File file = new File("screenShotCapture.jpg");
//		File outImageFile = new File("processedScreenshot.jpg");
//		FileOutputStream fis = new FileOutputStream(file);
//		BufferedOutputStream bos = new BufferedOutputStream(fis);
//		try {
//			bos.write(srcImage);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		if(bos !=null){
//			bos.close();
//		}
//
//		// 从读入的文件来截取图片
//		final BufferedImage screenshot = ImageIO.read(file);
//		BufferedImage processedScreenshot = screenshot.getSubimage(
//				elementLocation.x, elementLocation.y, elementSize.width,
//				elementSize.height);
//		// 将截取的图片写入到新文件
//		ImageIO.write(processedScreenshot, "jpg", outImageFile);
//
//		return ImageIO.read(outImageFile);
//
//	}

}
