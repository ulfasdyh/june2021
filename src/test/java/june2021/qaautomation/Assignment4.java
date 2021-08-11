package june2021.qaautomation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

import june2021.qaautomation.pages.CommonPage;
import june2021.qaautomation.pages.MakeMyTripPage;
import june2021.qaautomation.utils.TestUtility;

public class Assignment4 extends BaseWebTest {

	CommonPage commonPage = new CommonPage(driver, explicitWait);
	MakeMyTripPage makeMyTripPage = new MakeMyTripPage(driver, explicitWait);
	TestUtility testUtility = new TestUtility();

	@Test
	public void assignment4() {
		// Get active date, format : Sat Jul 24 2021
		LocalDateTime myDateObj = LocalDateTime.now().plusDays(2);
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E MMM dd yyyy");
		String formattedDate = myDateObj.format(myFormatObj);
		System.out.println("After formatting: " + formattedDate);

		commonPage.openURL("https://www.makemytrip.com/");

		// Close login popup if exist
		makeMyTripPage.closeLoginPopUp();

		// Select from city, to city, active date and search
		makeMyTripPage.selectFromCity("Jakarta");
		makeMyTripPage.selectToCity("Delhi");
		makeMyTripPage.selectDate(formattedDate);
		makeMyTripPage.search();
		testUtility.hardWait(5);

		// Get first price from results with numbers only
		System.out.println("First Price : " + makeMyTripPage.getFirstPrice().replaceAll("[^0-9]", ""));
	}

}
