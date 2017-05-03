package screen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class NoteScreen extends AbstractScreen {

	public NoteScreen(AppiumDriver<?> driver) {
		super(driver);
		// TODO 自动生成的构造函数存根
	}

	@FindBy(id = "com.updrv.lifecalendar:id/rl_note_to_search")
	WebElement searchButton;

	@FindBy(id = "com.updrv.lifecalendar:id/rl_note_to_add")
	WebElement newButton;

	@FindBy(id = "com.updrv.lifecalendar:id/one_status_name")
	List<WebElement> recordName;

	public void getNoteListDate() {
		Iterator<WebElement> it = recordName.iterator();
		System.out.println(recordName.size());
		FileOutputStream fos = null;
		File fl = new File("date.txt");
		try {
			fos = new FileOutputStream(fl);
		} catch (FileNotFoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
	for(WebElement str : recordName){
		System.out.println(str.getText().split("年")[0]);
		String [] str1=str.getText().split("年");
		for(String str2 : str1){
			System.out.println(str2);
		}
	}

//		for(int i=0;i<recordName.size();i++){
//			String str=recordName.get(0).getText();
//			System.out.println(str);
//		}
//		while(it.hasNext()){
//			System.out.println(it.next().getText());
//			it.next().getText().split("年").toString();
//		}
		//		
//				String str = it.next().getText();
//				System.out.println(it.next().getText());

//				try {
//					System.out.println();
//					fos.write(str.getBytes());
//				} catch (IOException e) {
//					// TODO 自动生成的 catch 块
//					e.printStackTrace();
//				}
//					
					
				

			
//		if (fos != null) {
//			try {
//				fos.close();
//			} catch (IOException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
//	
//	}
		
	}
}

