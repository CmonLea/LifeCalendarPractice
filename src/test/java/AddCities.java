

import java.util.ArrayList;
import java.util.List;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class AddCities extends AbstractTest {
  
//	private static final Logger logger = LogManager.getLogger(AddCities.class
//			.getName());

	List<String> arraylist = null;// �м����,���ڴ�Ż�ȡ���ĳ����б������ѡ��ĳ������Ƚ�
	int CITY_POSTION = (int) (Math.random() * 31 + 1);// ���ų��е�����
	String selectedcity = null;// �ֲ�������ʾѡ��ĳ���
	List<String> al = new ArrayList<String>();

	public void addCities() throws NoSuchElementException {
		try {

			logger.warn("ͨ��Xpath://android.widget.LinearLayout[2]/"
					+ "android.widget.TextView[1]���ҽ�����й�������Ѵ��ڵĳ���");
			List<WebElement> excistcitylist = driver
					.findElementsByXPath("//android.widget.LinearLayout[2]/android.widget.TextView[1]");

			// һ���forѭ���������й��������ڵĳ���

			for (int i = 0; i < excistcitylist.size(); i++) {
				// System.out.println("������й�������Ѵ��ڵĳ���Ϊ:"
				// + excistcitylist.get(i).getText());
				logger.info("������й�������Ѵ��ڵĳ���Ϊ:"
						+ excistcitylist.get(i).getText());

				al.add(excistcitylist.get(i).getText());

			}
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error("����ʱ�������й���������ʧ�ܣ�");
		}
		arraylist = al;

		if (arraylist.size() == 12) {
			logger.warn("������ӵĳ����Ѵ����ޣ�");
			// System.out.println("������ӵĳ����Ѵ����ޣ�");

		} else {

			// �����Ӱ�ť
			logger.info("�����Ӱ�ť com.updrv.lifecalendar:id/addcity");
			driver.findElementById("com.updrv.lifecalendar:id/addcity").click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
				// System.out.println("ҳ����ܻ�δ��ת�����ų��н���");
				logger.error("ҳ����ܻ�δ��ת�����ų��н��棡");
			}
			// while(cityList.size()<12){
			try {
				selectedcity = driver
						// ����һ��ѡ�еĳ���
						.findElementsByXPath(
								"//android.widget.GridView/android.widget.LinearLayout/android.widget.TextView")
						.get(CITY_POSTION).getText();
			} catch (Exception e) {

				e.printStackTrace();
				logger.error("ѡ�����ʧ��XPathΪ��//android.widget.GridView/android.widget.LinearLayout/android.widget.TextView");
			}
			// System.out.println("ѡ��ĳ���Ϊ:" + selectedcity);
			logger.info("ѡ��ĳ���Ϊ:" + selectedcity);
			List<WebElement> lt = driver
					.findElementsByXPath("//android.widget.GridView[@index=3]/android.widget.LinearLayout");
			// System.out.println("����ĳ��г�����" + lt.size());
			logger.info("�ж�ѡ��ĳ����Ƿ��ظ�");
			// �жϳ����Ƿ��ظ����
			if (!comparecityrepeation(arraylist, selectedcity)) {
				// System.out.println("����δ�����ִ����Ӳ�������ӵĳ���Ϊ��" +
				// selectedcity);
				logger.info("����δ�����ִ����Ӳ�������ӵĳ���Ϊ��" + selectedcity);
				// System.out.println("CITY_POSTION��ֵΪ��" + CITY_POSTION);
				logger.warn("������е�����Ϊ" + CITY_POSTION);
				lt.get(CITY_POSTION).click();

			}
			// snapshot(driver, "��ӳ��к���й����������ͼ");
		}
		snapshot(driver, "��ӳ��к���й����������ͼ");
	}

	public boolean comparecityrepeation(List<String> citymanagelist,
			String selectedcity) {
		boolean isrepeat = false;// �ȼ���û������ظ��ĳ���
		for (int i = 0; i < arraylist.size(); i++) {
			//System.out.println("arraylist�ĳ���Ϊ��" + arraylist.size());
			   logger.info("arraylist�ĳ���Ϊ��" + arraylist.size());
			if (arraylist.get(i).contains(selectedcity)) {
				// System.out.println(selectedcity + "�����");
				 logger.info(selectedcity + "�����");
				isrepeat = true;
			}

		}
		return isrepeat;
	}
}