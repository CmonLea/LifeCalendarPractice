package 片段;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class 片段 {
	public void snapshot(TakesScreenshot drivername, String filename) {
		
		String currentPath = System.getProperty("user.dir"); 
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		
		try {
			System.out.println("Ϊ:" + currentPath + "\\" + filename);
			FileUtils
					.copyFile(scrFile, new File(currentPath + "\\" + filename));
		} catch (IOException e) {
			System.out.println("");
			e.printStackTrace();
		} finally {
			System.out.println(" " + currentPath + "");
		}
	}

	public static void snapshot1(TakesScreenshot drivername, String filename) {

		String destDir = "screenshots";
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		new File(destDir).mkdirs();
		String destFile = dateFormat.format(new Date()) + filename + ".png";

		try {
			System.out.println("截图位于Ϊ:" + destDir + "\\" + destFile);
			FileUtils.copyFile(scrFile, new File(destDir + "\\" + destFile));
		} catch (IOException e) {
			System.out.println("截图失败");
			e.printStackTrace();
		} 
	}
}

