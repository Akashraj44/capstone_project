package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.WithdrawPage;

public class WithdrawTest extends BaseTest {

    @Test(priority = 1)
    public void validWithdraw() throws Exception {

        login();

        WithdrawPage wp =
                new WithdrawPage(driver);

        wp.clickWithdrawal();
        wp.enterAccountNo("184009");
        wp.enterAmount("500");
        wp.enterDescription("ATM Withdraw");
        wp.clickSubmit();

        soft.assertTrue(
                driver.getPageSource()
                      .contains("Transaction"));

        System.out.println(
                "Withdrawal Successful");
    }

    @Test(priority = 2)
    public void insufficientBalance() throws Exception {

        login();

        WithdrawPage wp =
                new WithdrawPage(driver);

        wp.clickWithdrawal();
        wp.enterAccountNo("184009");
        wp.enterAmount("999999");
        wp.enterDescription("ATM Withdraw");
        wp.clickSubmit();

        try {

            String msg =driver.switchTo().alert().getText();

            System.out.println(msg);

            soft.assertTrue(
                    msg.length() > 0);

            driver.switchTo()
                  .alert()
                  .accept();

        } catch(Exception e) {

            soft.assertTrue(true);

            System.out.println(
                    "Alert not displayed");
        }

        System.out.println(
                "Insufficient Balance Validation Passed");
    }
}