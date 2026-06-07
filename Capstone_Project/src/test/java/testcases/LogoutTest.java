package testcases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LogoutPage;

public class LogoutTest extends BaseTest {

    @Test

    public void validLogout() throws Exception {

        login();

        LogoutPage lp = new LogoutPage(driver);

        lp.clickLogout();

        Alert alert = driver.switchTo().alert();

        String msg = alert.getText();

        Assert.assertEquals(msg,"You Have Succesfully Logged Out!!");

        alert.accept();

        System.out.println("Logout Successful");
    }
}