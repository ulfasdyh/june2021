package june2021.qaautomation;

import org.testng.annotations.Test;

import june2021.qaautomation.pages.CommonPage;
import june2021.qaautomation.pages.YOPMailHomePage;

public class Assignment3 extends BaseWebTest {

	CommonPage commonPage = new CommonPage(driver, explicitWait);
	YOPMailHomePage homePage = new YOPMailHomePage(driver, explicitWait);

	@Test
	public void assignment3() {
		commonPage.openURL("https://yopmail.com/");
		homePage.searchEmail("automation");
		commonPage.switchToFrame("ifmail");
		System.out.println(homePage.getBodyMail());
	}

}
