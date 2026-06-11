package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountPage;

public class AccountTest extends BaseTest {

    @Test
    public void openAccount() throws Exception {

        login();

        AccountPage ap =
                new AccountPage(driver);

        ap.clickNewAccount();
        ap.enterCustomerId("80841");
        ap.selectAccountType("Savings");
        ap.enterInitialDeposit("5000");
        ap.clickSubmit();

        try {

            if(driver.getPageSource()
                     .contains("Account")) {

                System.out.println(
                        "Account Created Successfully");
            }

        } catch(Exception e) {

            System.out.println("Account Validation Failed");
        }
    }
}