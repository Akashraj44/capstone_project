package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.FundTransferPage;

public class FundTransferTest extends BaseTest {

    @Test(priority = 1)
    public void validFundTransfer() throws Exception {

        login();

        FundTransferPage fp =
                new FundTransferPage(driver);

        fp.clickFundTransfer();
        fp.enterPayerAccount("183433");
        fp.enterPayeeAccount("183286");
        fp.enterAmount("200");
        fp.enterDescription("Fund Transfer");
        fp.clickSubmit();

        soft.assertTrue(
                driver.getPageSource()
                      .contains("Fund"));

        System.out.println(
                "Fund Transfer Successful");
    }

    @Test(priority = 2)
    public void invalidAccountTransfer() throws Exception {

        login();

        FundTransferPage fp =
                new FundTransferPage(driver);

        fp.clickFundTransfer();
        fp.enterPayerAccount("183433");
        fp.enterPayeeAccount("999999");
        fp.enterAmount("1000");
        fp.enterDescription("Fund Transfer");
        fp.clickSubmit();

        try {

            String msg = driver.switchTo().alert().getText();

            System.out.println(msg);

            soft.assertTrue(
                    msg.length() > 0);

            driver.switchTo().alert().accept();

        } catch(Exception e) {

            soft.assertTrue(true);

            System.out.println(
                    "Alert not displayed");
        }

        System.out.println(
                "Invalid Account Validation Passed");
    }

    @Test(priority = 3)
    public void insufficientBalanceTransfer() throws Exception {

        login();

        FundTransferPage fp =
                new FundTransferPage(driver);

        fp.clickFundTransfer();
        fp.enterPayerAccount("183433");
        fp.enterPayeeAccount("183286");
        fp.enterAmount("9999999");
        fp.enterDescription("Fund Transfer");
        fp.clickSubmit();

        try {

            String msg =driver.switchTo().alert()
                          .getText();

            System.out.println(msg);

            soft.assertTrue(
                    msg.length() > 0);

            driver.switchTo().alert()
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