package june2021.qaautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YOPMailHomePage extends BasePage {

	By SEARCHEMAIL = By.id("login");
	By BODYMAIL = By.xpath("//body/main[@class='yscrollbar']/div[@id='mailctn']/div[@id='mail']/div/div/div/div[1]");

	public YOPMailHomePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}

	public void searchEmail(String emailName) {
		setText(SEARCHEMAIL, emailName);
		setKeys(SEARCHEMAIL, Keys.ENTER);
	}

	public String getBodyMail() {
		return getText(BODYMAIL);
	}

}
