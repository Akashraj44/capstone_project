package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WithdrawPage {

    WebDriver driver;

    public WithdrawPage(WebDriver driver) {
        this.driver = driver;
    }

    By withdrawalLink = By.linkText("Withdrawal");
    By accountNo = By.name("accountno");
    By amount = By.name("ammount");
    By description = By.name("desc");
    By submitBtn = By.name("AccSubmit");

    public void clickWithdrawal() {
        driver.findElement(withdrawalLink).click();
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