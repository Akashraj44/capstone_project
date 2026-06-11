package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    	 WebDriverWait wait =
    	            new WebDriverWait(
    	            driver,
    	            Duration.ofSeconds(10));

    	    WebElement ele =
    	            wait.until(
    	            ExpectedConditions
    	            .presenceOfElementLocated(
    	            By.linkText("Withdrawal")));

    	    JavascriptExecutor js =
    	            (JavascriptExecutor) driver;

    	    js.executeScript(
    	            "arguments[0].click();",
    	            ele);
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