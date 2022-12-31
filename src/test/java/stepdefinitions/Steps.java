package stepdefinitions;

import java.util.concurrent.TimeUnit;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass 

{
			
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		lp=new LoginPage(driver);
			    
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
		
		driver.get(url);

	}
	
	@When("User enters Email as {string} and password as {string}")
	public void user_enters_Email_as_and_password_as(String email, String password) {
		
		lp.setUserName(email);
		lp.setPassword(password);
	    
	}

	
	@When("Click on Login")
	public void click_on_Login() {
		
		lp.clickLogin();
	    
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) {
		
		
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
			
		} else {
			
			Assert.assertEquals(title, driver.getTitle());
					
		}
			   
	}

	@When("User click on Logout link")
	public void user_click_on_Logout_link() throws InterruptedException {
		
		lp.clickLogout();
		Thread.sleep(3000);
	   
	}


	@Then("close browser")
	public void close_browser() {
		
		driver.quit();
	    
	}
	
	// Customer feature step definitions
	
	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() throws InterruptedException {
	    
		addCust=new AddcustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
		Thread.sleep(3000);
	}

	@When("User click on customers menu")
	public void user_click_on_customers_menu() throws InterruptedException {

		//Thread.sleep(3000);
		addCust.clickOnCustomersMenu();
		Thread.sleep(3000);

	}

	@When("click on customers Menu Item")
	public void click_on_customers_Menu_Item() throws InterruptedException {
		addCust.clickOnCustomersMenuItem();
		Thread.sleep(2000);

	}

	@When("click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException {
		addCust.clickOnAddnew();
		Thread.sleep(2000);

	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() throws InterruptedException {
		
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
		Thread.sleep(2000);


	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		
		
		String email=randomestring()+"@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test321");
		Thread.sleep(3000);

		addCust.setCustomerRoles("Guest");
		Thread.sleep(3000);
		
		addCust.setManagerVendor("Vendor 2");
		addCust.setGender("Male");
		addCust.setFirstName("Suri");
		addCust.setLastName("Venkat");
		addCust.setDob("01/01/2003");
		addCust.setcompanytName("SuriVV");
		addCust.setAdminContent("This is for testing........");
					
				
		

				

	}

	@When("click on Save button")
	public void click_on_Save_button() throws InterruptedException {
		addCust.clickOnsave();
		Thread.sleep(2000);


	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully."));
		


	}
	
	//steps for searching a customer using EMail ID..............

	@When("Enter customer EMail")
	public void enter_customer_EMail()  {
		searchCust=new SearchCustomerPage(driver);
		searchCust.setEmail("victoria_victoria@nopCommerce.com");

	   
	}

	@When("click on serach button")
	public void click_on_serach_button() throws InterruptedException {
		searchCust.clickSearch();
		Thread.sleep(3000);
		
	   
	}

	@Then("User should found EMail in the Seach table")
	public void user_should_found_EMail_in_the_Seach_table() {
		
		boolean status=searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
	     Assert.assertEquals(true, status);
	     
	     //WebElement mailid=driver.findElement(By.xpath("//*[@id='customers-grid']/tbody/tr[5]/td[2]"));
	     //mailid.getText();
	     //Assert.assertTrue(mailid.equals("victoria_victoria@nopCommerce.com"));
	    // WebElement mailid=driver.findElement(By.xpath("//td[contains(text(),'victoria_victoria@nopCommerce.com')]"));
	     //mailid.getText();
	    // Assert.assertTrue(mailid.equals("victoria_victoria@nopCommerce.com"));
	     
	     
	}
	
	//Steps for searching a customer by First Name & Last Name
	
	@When("Enter customer FirstName")
	public void enter_customer_FirstName() {
		searchCust=new SearchCustomerPage(driver);
		searchCust.setFirstName("victoria");
  
	}

	@When("Enter customer LastName")
	public void enter_customer_LastName() {
		searchCust.setLastName("Terces");

	    
	}

	@Then("User should found Name in the Seach table")
	public void user_should_found_Name_in_the_Seach_table() {
		boolean status=searchCust.searchCustomerByName("Victoria Terces");
	     Assert.assertEquals(true, status);
		
		
	}
	
	
	



}
