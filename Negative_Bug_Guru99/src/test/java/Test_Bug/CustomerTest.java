package Test_Bug;

import org.testng.Assert;

import org.testng.annotations.Test;
import base.Base_Test;
import pages.CustomerPage;

public class CustomerTest extends Base_Test {

    @Test(priority = 1)
    public void addCustomer_invalid_date() throws Exception {

        login();

        CustomerPage cp = new CustomerPage(driver);

        cp.clickNewCustomer();
        cp.enterCustomerName("Akashsingh");
        cp.selectGender();
        cp.enterDOB("01052028");
        cp.enterAddress("Kolkata");
        cp.enterCity("Kolkata");
        cp.enterState("West Bengal");
        cp.enterPin("700001");
        cp.enterMobile("9876543210");
        int random = (int)(Math.random() * 10000);
        cp.enterEmail("akash" + random + "@gmail.com");
        cp.enterPassword("12345");
        cp.clickSubmit();
        Thread.sleep(3000);
     

        System.out.println("Customer Added Successfully but with invalid date of birth and weak password");
    }
    @Test(priority = 2)
    public void addCustomer_invalid_city() throws Exception {

        login();

        CustomerPage cp = new CustomerPage(driver);

        cp.clickNewCustomer();
        cp.enterCustomerName("Akashsingh");
        cp.selectGender();
        cp.enterDOB("01052028");
        cp.enterAddress("Kolkata");
        cp.enterCity("London");
        cp.enterState("West Bengal");
        cp.enterPin("700001");
        cp.enterMobile("9876543210");
        int random = (int)(Math.random() * 10000);
        cp.enterEmail("akash" + random + "@gmail.com");
        cp.enterPassword("abc123");
        cp.clickSubmit();
        Thread.sleep(3000);
        System.out.println("Customer Added Successfully but invalid city ");
    }
    
}