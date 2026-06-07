package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage {

    WebDriver driver;

    By logout = By.linkText("Log out");

    public LogoutPage(WebDriver driver) {

        this.driver = driver;
    }

    public void clickLogout() {

        WebDriverWait wait =
                new WebDriverWait(
                driver,
                Duration.ofSeconds(10));

        WebElement ele =
                wait.until(
                ExpectedConditions
                .elementToBeClickable(
                logout));

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();",ele);
    }
}