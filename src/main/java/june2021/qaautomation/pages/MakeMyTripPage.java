package june2021.qaautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import june2021.qaautomation.utils.TestUtility;

public class MakeMyTripPage extends BasePage {

	By FROMCITY = By.xpath("//label[@for='fromCity']");
	By FROMSEARCH = By.xpath("//input[@placeholder='From']");
	By FROMRESULT = By.xpath("//p[normalize-space()='Jakarta, Indonesia']");
	By TOCITY = By.xpath("//label[@for='toCity']");
	By TOSEARCH = By.xpath("//input[@placeholder='To']");
	By TORESULT = By.xpath("//p[normalize-space()='Delhi, India']");
	By DEPARTURE = By.xpath("//label[@for='departure']");
	By SEARCH = By.xpath("//a[normalize-space()='Search']");
	By LOGIN = By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut']");
	By LOGINPOPUP = By.xpath("//p[contains(text(),'Login/Signup for Best Prices')]");
	By PRICE = By.xpath(
			"/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[3]/div/div/div/div[1]/div[1]/div[2]/div[2]/div/div/p");

	TestUtility testUtility = new TestUtility();

	public MakeMyTripPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	public void closeLoginPopUp() {
		if (isElementPresent(LOGINPOPUP) == true) {
			System.out.println("Login popup displayed");
			clickAndWaitByXpath(LOGIN);
		} else {
			System.out.println("Login popup not displayed");
		}

	}

	public void selectFromCity(String fromCity) {
		clickAndWaitByXpath(FROMCITY);
		setText(FROMSEARCH, fromCity);
		testUtility.hardWait(2);
		clickAndWaitByXpath(FROMRESULT);
	}

	public void selectToCity(String toCity) {
		setText(TOSEARCH, toCity);
		testUtility.hardWait(2);
		clickAndWaitByXpath(TORESULT);
	}

	public void selectDate(String formattedDate) {
		String selector = "//div[@aria-label='" + formattedDate + "']//div[@class='dateInnerCell']";
		clickAndWaitByXpath(By.xpath(selector));
	}

	public void search() {
		clickAndWaitByXpath(SEARCH);
	}

	public String getFirstPrice() {
		return getText(PRICE);
	}

}
