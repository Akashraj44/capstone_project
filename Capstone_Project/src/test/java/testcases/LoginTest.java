package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(priority = 3)
    public void validLogin() throws Exception {

        login();

        soft.assertTrue(
                driver.getTitle()
                      .contains("Guru99"));

        System.out.println(
                "Valid Login Passed");
    }

    @Test(priority = 2)
    public void invalidLogin() {

        LoginPage lp =new LoginPage(driver);

        lp.enterUser("ahldhlld");
        lp.enterPass("1389890");
        lp.clickLogin();

        try {

            String alertText =driver.switchTo().alert()
                          .getText();

            System.out.println(alertText);

            soft.assertTrue(
                    alertText.length() > 0);

            driver.switchTo().alert()
                  .accept();

        } catch(Exception e) {

            soft.assertTrue(true);

            System.out.println(
                    "Alert not displayed");
        }

        System.out.println(
                "Invalid Login Passed");
    }

    @Test(priority = 1)
    public void blankLogin() {

        LoginPage lp =
                new LoginPage(driver);

        lp.clickLogin();

        try {

            String msg =driver.switchTo().alert()
                          .getText();

            System.out.println(msg);

            soft.assertTrue(msg.length() > 0);

            driver.switchTo().alert()
                  .accept();

        } catch(Exception e) {

            soft.assertTrue(true);

            System.out.println("No Alert Displayed");
        }

        System.out.println("Blank Login Passed");
    }
}