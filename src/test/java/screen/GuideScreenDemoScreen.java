package screen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class GuideScreenDemoScreen extends AbstractScreen{

	
	
	public GuideScreenDemoScreen(AppiumDriver<?> driver) {
		super(driver);
		// TODO 自动生成的构造函数存根
	}
	@FindBy(name ="点击跳过")
	WebElement we;
	BufferedImage actualPicture=null;
	BufferedImage templatePicture=null;
	public boolean test() throws IOException, InterruptedException{
		Thread.sleep(10000);
		actualPicture=getCustomeScreenshots(we);
		templatePicture=ImageIO.read(new File("templatePicture.jpg"));
		return testPictureSimilarity(actualPicture,templatePicture);
	}
	

}
