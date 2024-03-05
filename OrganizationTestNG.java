package VtigerCRM_DDT;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import CommonUtil.BaseClass;
import CommonUtil.ExcelUtil;
import CommonUtil.JavaUtil;
import CommonUtil.PropertyFileUtil;
import CommonUtil.WebdriverUtil;

public class OrganizationTestNG extends BaseClass
{

	public WebDriver driver;
		
		PropertyFileUtil putil=new PropertyFileUtil();
		WebdriverUtil wutil=new WebdriverUtil();
		ExcelUtil eutil=new ExcelUtil();
		JavaUtil jutil=new JavaUtil();
		
		@Test
		
	   public void OrganizationTest() throws IOException, InterruptedException
	   {
		
	/*	WebDriver driver=new ChromeDriver();
  //		wutil.Maximize();
  //		wutil.implicitwait();  */
		// OR
	//	driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	// To read data from property file	
	/*	String URL = putil.getDataFromPropertyFile("Url");              
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");       */
		
	// To read the data from Excel file
		String ORGNAME = eutil.getDataFromExcel("Organizations", 0, 1);
		String GROUP = eutil.getDataFromExcel("Organizations", 1, 1);
		
/*	// Launch the application
		driver.get(URL);
	// 	
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();                        */
		
	// click on organization	
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	// click on create organization	(+)
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
	// Enter organization name	
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME+jutil.getRandomNumber());
		
	// In AssignedTo click on group
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();

	// In the dropdown 	select support group
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		wutil.HandleDropdown(dropdown, GROUP);
		// OR
//		Select s=new Select(dropdown);  // this two lines we written in webdriver
//		s.selectByVisibleText(GROUP);
		
	// click on save button
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		Thread.sleep(3000);
/*	// Mouse hover on image
		WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.MouseHover(driver, image);
		
	// click on signout
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();        */
		
	}

}
