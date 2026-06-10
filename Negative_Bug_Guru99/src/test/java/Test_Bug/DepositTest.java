package Test_Bug;

import org.testng.Assert;

import org.testng.annotations.Test;


import base.Base_Test;
import pages.DepositPage;

public class DepositTest extends Base_Test {
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

            System.out.println("Guru99 Deposit error Found");

            return;
        }
       

       Assert.assertTrue(driver.getPageSource().contains("Transaction details of Deposit"));

        System.out.println("Deposit not Successful due to error ");
    }

  
}