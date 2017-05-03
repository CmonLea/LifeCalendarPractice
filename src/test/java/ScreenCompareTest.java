

import java.io.IOException;
import org.junit.Test;

public class ScreenCompareTest extends AbstractTest {
	@Test
	public void VerifyPicture() throws IOException, InterruptedException {

		if (app.guideScreenDemoScreen().test()) {
			System.out.println("图片对比成功");
		} else {
			System.out.println("图片对比失败");
		}

	}

}
