package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import pages.LoginPage;
import utilities.ConfigReader;
import utilities.ExcelUtils;

public class BaseTest {

    public static WebDriver driver;
    public SoftAssert soft;

    ConfigReader config;

    @BeforeMethod
    public void setup() throws Exception {
    	 soft = new SoftAssert();

        config = new ConfigReader();

        String browser = config.getBrowser();

        if(browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);

            System.out.println("Chrome browser started");

        } else if(browser.equalsIgnoreCase("edge")) {

            EdgeOptions options = new EdgeOptions();

            options.addArguments("--headless=new");

            driver = new EdgeDriver(options);

            System.out.println("Edge Headless Started");

        } else if(browser.equalsIgnoreCase("firefox")) {

            FirefoxOptions options =new FirefoxOptions();

            options.addArguments("--headless");

            driver = new FirefoxDriver(options);

            System.out.println("Firefox Headless Started");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(config.getUrl());
    }

    public void login() throws Exception {

        String user =ExcelUtils.getData("Sheet1", 1, 0);
        String pass =ExcelUtils.getData("Sheet1", 1, 1);

        LoginPage lp =new LoginPage(driver);

        lp.enterUser(user);
        lp.enterPass(pass);
        lp.clickLogin();
    }

    @AfterMethod
    public void tearDown() {

        if(driver != null) {

            driver.quit();
        }
    }
}