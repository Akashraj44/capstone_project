package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepositPage {

    WebDriver driver;

    public DepositPage(WebDriver driver) {
        this.driver = driver;
    }

    By depositLink = By.linkText("Deposit");
    By accountNo = By.name("accountno");
    By amount = By.name("ammount");
    By description = By.name("desc");
    By submitBtn = By.name("AccSubmit");

    public void clickDeposit() {
    	
        driver.findElement(depositLink).click();
    }

    public void enterAccountNo(String accNo) {
        driver.findElement(accountNo).sendKeys(accNo);
    }

    public void enterAmount(String amt) {
        driver.findElement(amount).sendKeys(amt);
    }

    public void enterDescription(String desc) {
        driver.findElement(description).sendKeys(desc);
    }

    public void clickSubmit() {
        driver.findElement(submitBtn).click();
    }
}