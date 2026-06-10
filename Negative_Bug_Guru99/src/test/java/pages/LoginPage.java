package pages;

import org.openqa.selenium.*;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By uid =By.name("uid");
	By pass =By.name("password");
	By login =By.name("btnLogin");

	public void enterUser(String user) {
		driver.findElement(uid).sendKeys(user);
	}

	public void enterPass(String password) {
		driver.findElement(pass).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(login).click();
	}
}