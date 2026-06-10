package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerPage {

	WebDriver driver;

	public CustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	By newCustomer = By.linkText("New Customer");
	By customerName = By.name("name");
	By gender = By.xpath("//input[@value='m']");
	By dob = By.id("dob");
	By address = By.name("addr");
	By city = By.name("city");
	By state = By.name("state");
	By pin = By.name("pinno");
	By mobile = By.name("telephoneno");
	By email = By.name("emailid");
	By password = By.name("password");
	By submit = By.name("sub");

	public void clickNewCustomer() { 
		
		driver.findElement(newCustomer).click(); }

	public void enterCustomerName(String cname) { 
		driver.findElement(customerName).sendKeys(cname); 
		}

	public void selectGender() {
		driver.findElement(gender).click();
		}

	public void enterDOB(String date) {
		driver.findElement(dob).sendKeys(date);
		}

	public void enterAddress(String addr) { 
		driver.findElement(address).sendKeys(addr); }

	public void enterCity(String cityname) {
		driver.findElement(city).sendKeys(cityname); 
		}

	public void enterState(String statename) {
		driver.findElement(state).sendKeys(statename); 
		}

	public void enterPin(String pinno) { 
		driver.findElement(pin).sendKeys(pinno); 
		}

	public void enterMobile(String mob) { 
		driver.findElement(mobile).sendKeys(mob);
		}

	public void enterEmail(String mail) { 
		driver.findElement(email).sendKeys(mail); 
		}

	public void enterPassword(String pass) { 
		driver.findElement(password).sendKeys(pass); 
		}

	public void clickSubmit() {
		driver.findElement(submit).click();
		}

}