package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.WithdrawPage;

public class WithdrawTest extends BaseTest {

    @Test(priority = 1)
    public void validWithdraw() throws Exception {

        login();

        WithdrawPage wp = new WithdrawPage(driver);

        wp.clickWithdrawal();
        wp.enterAccountNo("183286");
        wp.enterAmount("1000");
        wp.enterDescription("ATM Withdraw");
        wp.clickSubmit();

        Assert.assertTrue(
                driver.getPageSource()
                .contains("Transaction details of Withdrawal"));

        System.out.println("Withdrawal Successful");
    }

    @Test(priority = 2)
    public void insufficientBalance() throws Exception {

        login();

        WithdrawPage wp = new WithdrawPage(driver);

        wp.clickWithdrawal();
        wp.enterAccountNo("183286");
        wp.enterAmount("999999");
        wp.enterDescription("ATM Withdraw");
        wp.clickSubmit();

        Assert.assertTrue(
                driver.getPageSource()
                .contains("Insufficient Balance"));

        System.out.println("Insufficient Balance Validation Passed");
    }
}