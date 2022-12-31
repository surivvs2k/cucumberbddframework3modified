package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage {

public WebDriver ldriver;
	
	public AddcustomerPage(WebDriver rdriver)
	
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//By lnkCustomers_menu=By.xpath("//a[@href='#']//span[contains(text(), 'Customers')]");
	By lnkCustomers_menu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	
	

	//By lnkCustomers_menuitem=By.xpath("//span[@class='menu-item-title'][contains(text(,'Customers')]");
	
	By lnkCustomers_menuitem=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");

	
	By btnAddnew=By.xpath("//a[@class='btn btn-primary']"); //Add new
	
	By txtEmail=By.xpath("//input[@id='Email']");
	By txtPassword=By.xpath("//input[@id='Password']");
	
	By txtcustomerRoles=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	
	By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
	By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
	
	By drpmgrOfVendor=By.xpath("//*[@id='VendorId']");
	By rdMaleGender=By.id("Gender_Male");
	By rdFeMaleGender=By.id("Gender_Female");
	
	By txtFirstName=By.xpath("//input[@id='FirstName']");
	By txtLastName=By.xpath("//input[@id='LastName']");
	
	By txtDob=By.xpath("//input[@id='DateOfBirth']");
	
	By txtCompanyName=By.xpath("//input[@id='Company']");
	
	By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");
	
	By btnSave=By.xpath("//button[@name='save']");
	
	
	//Action Methods
	
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	public void clickOnCustomersMenu() {
		ldriver.findElement(lnkCustomers_menu).click();
	}
	
	public void clickOnCustomersMenuItem() {
		ldriver.findElement(lnkCustomers_menuitem).click();
	}
	
	public void clickOnAddnew() {
		ldriver.findElement(btnAddnew).click();
	}
	
	public void setEmail(String email) 
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	
	public void setCustomerRoles(String role) throws InterruptedException
	{
		
		ldriver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[1]")).click();

		
		ldriver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_listbox']/li[3]")).click();

		ldriver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li[1]/span[2]")).click();

		
		/*
		if(!role.equals("Vendors")) 
			
		{
		//ldriver.findElement(By.xpath("//li[contains(text(),'Vendors')]"));
		ldriver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[1]")).click();;;
		}
		
		ldriver.findElement(txtcustomerRoles).click();
		
		WebElement listitem;
		
		Thread.sleep(3000);
		
		if(role.equals("Administrators"))
		{
			
			listitem=ldriver.findElement(lstitemAdministrators);
		}
		else if(role.equals("Guests"))
		{
			listitem=ldriver.findElement(lstitemGuests);
		}
		else if (role.equals("Registered"))
		{
			
			listitem=ldriver.findElement(lstitemRegistered);
		}
		else if (role.equals("Vendors"))
		{
			
			listitem=ldriver.findElement(lstitemVendors);
		}
		
		else
		{
			
			listitem=ldriver.findElement(lstitemGuests);
		}
		
		listitem.click();
		//Thread.sleep(3000);
		
		
		
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listitem);
			
		*/
		}
	
	public void setManagerVendor(String value)
	{
		Select drp=new Select(ldriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
		
	}
	
	public void setGender(String gender)
	{
		
		if(gender.equals("Male"))
		{
			
			ldriver.findElement(rdMaleGender).click();
		}
		else if(gender.equals("Female"))
		{
			
			ldriver.findElement(rdFeMaleGender).click();
		}
		else
		{
			ldriver.findElement(rdMaleGender).click();
		}
	}
	
	public void setFirstName(String fname) 
	{
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	
	public void setLastName(String lname) 
	{
		ldriver.findElement(txtLastName).sendKeys(lname);
	}
	public void setDob(String dob) 
	{
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	
	public void setcompanytName(String comname) 
	{
		ldriver.findElement(txtCompanyName).sendKeys(comname);
	}
	
	public void setAdminContent(String content) 
	{
		ldriver.findElement(txtAdminContent).sendKeys(content);
	}
	public void clickOnsave() 
	{
		ldriver.findElement(btnSave).click();
	}



}