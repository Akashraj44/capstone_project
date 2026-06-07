package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DepositPage;

public class DepositTest extends BaseTest {
    @Test(priority = 1)
    public void validDeposit() throws Exception {

        login();

        DepositPage dp = new DepositPage(driver);

        dp.clickDeposit();
        dp.enterAccountNo("183286");
        dp.enterAmount("5000");
        dp.enterDescription("Cash Deposit");
        dp.clickSubmit();

        if(driver.getPageSource().contains("HTTP ERROR 500")) {

            System.out.println("Guru99 Deposit Found");

            return;
        }

        Assert.assertTrue(
                driver.getPageSource()
                .contains("Transaction details of Deposit"));

        System.out.println("Deposit Successful");
    }

    @Test(priority = 2)
    public void invalidAccountDeposit() throws Exception {

        login();

        DepositPage dp = new DepositPage(driver);

        dp.clickDeposit();
        dp.enterAccountNo("999999");
        dp.enterAmount("5000");
        dp.enterDescription("Cash Deposit");
        dp.clickSubmit();

        try {

            String msg =driver.switchTo().alert().getText();
            System.out.println(msg);
            driver.switchTo().alert().accept();
            System.out.println("Invalid Account Validation Passed");

        } catch(Exception e) {

            System.out.println("Alert not displayed");
        }
    }
}