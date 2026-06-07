package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountPage;

public class AccountTest extends BaseTest {

    @Test
    public void openAccount() throws Exception {

        login();

        AccountPage ap = new AccountPage(driver);

        ap.clickNewAccount();
        ap.enterCustomerId("8467");
        ap.selectAccountType("Savings");
        ap.enterInitialDeposit("5000");
        ap.clickSubmit();

        Assert.assertTrue(driver.getPageSource()
                .contains("Account Generated Successfully"));

        System.out.println("Account Created Successfully");
    }
}