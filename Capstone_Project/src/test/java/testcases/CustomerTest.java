package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CustomerPage;

public class CustomerTest extends BaseTest {

    @Test
    public void addCustomer() throws Exception {

        login();

        CustomerPage cp = new CustomerPage(driver);

        cp.clickNewCustomer();
        cp.enterCustomerName("Akashsingh");
        cp.selectGender();
        cp.enterDOB("01052002");
        cp.enterAddress("Kolkata");
        cp.enterCity("Kolkata");
        cp.enterState("West Bengal");
        cp.enterPin("700001");
        cp.enterMobile("9876543210");
        int random = (int)(Math.random() * 10000);
        cp.enterEmail("akash" + random + "@gmail.com");
        cp.enterPassword("abc123");
        cp.clickSubmit();
        Thread.sleep(3000);

        Assert.assertTrue(driver.getPageSource()
                .contains("Customer Registered Successfully"));

        System.out.println("Customer Added Successfully");
    }
}