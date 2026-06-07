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

        Assert.assertTrue(
                driver.getPageSource()
                .contains("Account does not exist"));

        System.out.println("Invalid Account Validation Passed");
    }
}