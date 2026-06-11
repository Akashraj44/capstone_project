package utilities;

import org.testng.annotations.DataProvider;

public class CustomerData {

    @DataProvider(name = "customerData")
    public Object[][] getCustomerData() {

        return new Object[][] {

            {"Akashsingh","01052002","Kolkata","Kolkata",
             "West Bengal","700001","9876543210","abc123"}
        };
        
    }
}