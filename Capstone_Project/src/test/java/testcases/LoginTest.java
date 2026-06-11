package testcases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(priority = 3)
    public void validLogin() throws Exception {

        login();

        Assert.assertTrue(driver.getTitle().contains("Guru99"));

        System.out.println("Valid Login Passed");
    }

    @Test(priority = 2)
    public void invalidLogin() {

        LoginPage lp = new LoginPage(driver);

        lp.enterUser("ahldhlld");
        lp.enterPass("1389890");
        lp.clickLogin();

        String alertText = driver.switchTo().alert().getText();

        Assert.assertEquals(alertText, "User or Password is not valid");

        driver.switchTo().alert().accept();

        System.out.println("Invalid Login Passed");
    }

    @Test(priority = 1)
    public void blankLogin() {

        LoginPage lp = new LoginPage(driver);

        lp.clickLogin();

//        Alert alert = driver.switchTo().alert();
//
//        String msg = alert.getText();
//
//         Assert.assertEquals(msg,"User or Password is not valid");

//        alert.accept();
        System.out.println("Blank Login Passed");
    }
}