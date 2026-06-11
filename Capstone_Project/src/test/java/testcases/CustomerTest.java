package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.CustomerPage;
import utilities.CustomerData;

public class CustomerTest extends BaseTest {

    @Test(dataProvider = "customerData",
          dataProviderClass = CustomerData.class)

    public void addCustomer(
            String name,
            String dob,
            String address,
            String city,
            String state,
            String pin,
            String mobile,
            String password) throws Exception {

        login();

        CustomerPage cp =new CustomerPage(driver);

        cp.clickNewCustomer();

        cp.enterCustomerName(name);
        cp.selectGender();
        cp.enterDOB(dob);
        cp.enterAddress(address);
        cp.enterCity(city);
        cp.enterState(state);
        cp.enterPin(pin);
        cp.enterMobile(mobile);

        int random =(int)(Math.random() * 10000);

        cp.enterEmail("akash" + random + "@gmail.com");

        cp.enterPassword(password);

        cp.clickSubmit();

        soft.assertTrue(driver.getPageSource().contains("Customer"));

        System.out.println("Customer Added Successfully");
    }
}