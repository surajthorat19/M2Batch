package VtigerCRM_DDT;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonUtil.ExcelUtil;
import CommonUtil.JavaUtil;
import CommonUtil.PropertyFileUtil;
import CommonUtil.WebdriverUtil;

public class OrganizationContactsTestNG 

{
	
		PropertyFileUtil putil=new PropertyFileUtil();
		WebdriverUtil wutil=new WebdriverUtil();
		ExcelUtil eutil=new ExcelUtil();
		JavaUtil jutil=new JavaUtil();
		
		WebDriver driver;
		
		@Test
		public void ContactTest() throws IOException, InterruptedException 
		{
			
		WebDriver driver=new ChromeDriver();
/*		
	// To maximize the browser window	
//		wutil.Maximize();
		
	// To apply implicit wait for findelement()	
//		wutil.implicitwait();
		//OR
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));     */
		
	// To read data from property file	
	/*	String URL =      putil.getDataFromPropertyFile("Url");
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");      */
		
	// To read the data from Excel file
		String CONTACTNAME = eutil.getDataFromExcel("Contacts", 0, 1);
		String LASTNAME = eutil.getDataFromExcel("Contacts", 1, 1);
		String AssnTo = eutil.getDataFromExcel("Contacts", 2, 1);
		String ORGNAME = eutil.getDataFromExcel("Contacts", 3, 1);
/*		
	// Launch the application
		driver.get(URL);
//	 	Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();                        */
		
	// Click on Contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
	// Click on create Contact..(+)
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		
	// Enter first name & Last name
		driver.findElement(By.name("firstname")).sendKeys(CONTACTNAME);
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
	// To fail the TestScript
		String actualurl = driver.getCurrentUrl();
		String expectedurl = "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
		Assert.assertEquals(actualurl, expectedurl);
		
		
	// In AssignedTo click on group	
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
	// In the dropdown 	select Team Selling
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		wutil.HandleDropdown(dropdown, AssnTo);
		
		
		// Click on select(+) in organization name text field
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
		// Transfer the driver control from parent to child window
		wutil.SwitchWindow(driver, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
		
		// To enter organization name in searchtf
		driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
		
		// To click on search now button
		driver.findElement(By.name("search")).click();
		
		// Click on organization name
		driver.findElement(By.xpath("")).click();
		
		// To transfer control from child window to parent window
		wutil.SwitchWindow(driver, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		
		// click on save button
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		Thread.sleep(2000);
	// To take screenshot of contact
		wutil
		
		
		
/*		Thread.sleep(2000);
	// Mouse Hover on image
		WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.MouseHover(driver, image);
		
	// click on signhout
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();      */
		
		
		
	}

}
