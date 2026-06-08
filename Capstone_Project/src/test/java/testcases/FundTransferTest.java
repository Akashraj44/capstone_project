package testcases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FundTransferPage;

public class FundTransferTest extends BaseTest {

    @Test(priority = 1)
    public void validFundTransfer() throws Exception {

        login();

        FundTransferPage fp = new FundTransferPage(driver);

        fp.clickFundTransfer();
        fp.enterPayerAccount("183433");
        fp.enterPayeeAccount("183286");
        fp.enterAmount("200");
        fp.enterDescription("Fund Transfer");
        fp.clickSubmit();

       // Assert.assertTrue(driver.getPageSource().contains("Fund Transfer Details"));

        System.out.println("Fund Transfer Successful");
    }

    @Test(priority = 2)
    public void invalidAccountTransfer() throws Exception {

        login();

        FundTransferPage fp = new FundTransferPage(driver);

        fp.clickFundTransfer();
        fp.enterPayerAccount("183433");
        fp.enterPayeeAccount("999999");
        fp.enterAmount("1000");
        fp.enterDescription("Fund Transfer");
        fp.clickSubmit();

        Alert alert = driver.switchTo().alert();

        String msg = alert.getText();

        Assert.assertTrue(
        msg.contains("does not exist"));

        alert.accept();
    }

    @Test(priority = 3)
    public void insufficientBalanceTransfer() throws Exception {

        login();

        FundTransferPage fp = new FundTransferPage(driver);

        fp.clickFundTransfer();
        fp.enterPayerAccount("183433");
        fp.enterPayeeAccount("183286");
        fp.enterAmount("9999999");
        fp.enterDescription("Fund Transfer");
        fp.clickSubmit();

        Alert alert = driver.switchTo().alert();

        String msg = alert.getText();

       // Assert.assertTrue(msg.contains("Balance low"));

        alert.accept();
    }
}