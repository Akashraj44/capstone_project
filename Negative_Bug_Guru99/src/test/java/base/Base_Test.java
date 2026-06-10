package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.LoginPage;
import utilities.ConfigReader;
import utilities.ExcelUtils;

public class Base_Test {

    public static WebDriver driver;

    ConfigReader config;

    @BeforeMethod
    public void setup() throws Exception {

        config = new ConfigReader();

        String browser = config.getBrowser();

        if(browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();
            System.out.println("opened chrome successfully ");

        } else if(browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();
            System.out.println("opened edge successfully ");

        } else if(browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();
            System.out.println("opened firefox successfully ");
        }

        driver.manage().window().maximize();

        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(10));

        driver.get(config.getUrl());
    }

   
    public void login() throws Exception {

    	String user = ExcelUtils.getData("Sheet1",1,0);
    	String pass = ExcelUtils.getData("Sheet1",1,1);

        LoginPage lp = new LoginPage(driver);

        lp.enterUser(user);
        lp.enterPass(pass);
        lp.clickLogin();
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}