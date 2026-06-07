package testcases;

import org.testng.annotations.Test;

import base.BaseTest;

public class BankingFlowTest extends BaseTest {

    @Test
    public void loginTest() throws Exception {

        login();
    }

    @Test(dependsOnMethods = "loginTest")
    public void addCustomer() {

        System.out.println("Customer Added");
    }

    @Test(dependsOnMethods = "addCustomer")
    public void openAccount() {

        System.out.println("Account Opened");
    }

    @Test(dependsOnMethods = "openAccount")
    public void depositMoney() {

        System.out.println("Money Deposited");
    }

    @Test(dependsOnMethods = "depositMoney")
    public void withdrawMoney() {

        System.out.println("Money Withdrawn");
    }

    @Test(dependsOnMethods = "withdrawMoney")
    public void fundTransfer() {

        System.out.println("Fund Transfer Done");
    }
}