package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountPage {

	WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
	}

	By newAccount = By.linkText("New Account");
	By customerId = By.name("cusid");
	By accountType = By.name("selaccount");
	By initialDeposit = By.name("inideposit");
	By submit = By.name("button2");

	public void clickNewAccount() {
		driver.findElement(newAccount).click();
	}

	public void enterCustomerId(String cid) {
	driver.findElement(customerId).sendKeys(cid);
	}

	public void selectAccountType(String type) {
		Select s = new Select(driver.findElement(accountType));
		s.selectByVisibleText(type);
	}

	public void enterInitialDeposit(String amount) {
		driver.findElement(initialDeposit).sendKeys(amount);
	}

	public void clickSubmit() {
		driver.findElement(submit).click();
	}
}