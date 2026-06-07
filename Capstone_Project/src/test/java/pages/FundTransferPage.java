package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FundTransferPage {

    WebDriver driver;

    public FundTransferPage(WebDriver driver) {
        this.driver = driver;
    }

    By fundTransfer = By.linkText("Fund Transfer");
    By payerAccount = By.name("payersaccount");
    By payeeAccount = By.name("payeeaccount");
    By amount = By.name("ammount");
    By description = By.name("desc");
    By submitBtn = By.name("AccSubmit");

    public void clickFundTransfer() {
    	System.out.println(
    			driver.findElement(fundTransfer).isDisplayed());
        WebElement element =
                driver.findElement(fundTransfer);

        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        js.executeScript("arguments[0].click();",element);
    }
    
    public void enterPayerAccount(String payer) {
        driver.findElement(payerAccount).sendKeys(payer);
    }

    public void enterPayeeAccount(String payee) {
        driver.findElement(payeeAccount).sendKeys(payee);
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