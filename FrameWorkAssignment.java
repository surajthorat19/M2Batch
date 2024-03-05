package VtigerCRM_DDT;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import CommonUtil.PropertyFileUtil;
import CommonUtil.WebdriverUtil;
                                                    // Assignment
public class FrameWorkAssignment                    // Launch http://localhost:8888
                                                   // Enter username---admin > Enter password ---admin > click on Login button
                                                  //  click on organizations > click on create organizations..(+) > Enter organization name(company name)
                                                 //   In AssignedTo > click on group > Select supportGroup
{

	PropertyFileUtil putil=new PropertyFileUtil();
	WebdriverUtil wutil=new WebdriverUtil();
	
	@Test
	
   public void OrganizationTest() throws IOException
   {
	
	WebDriver driver=new ChromeDriver();
// To maximize the window	
	
//	wutil.Maximize();
	
// To apply wait for Findelement	
//	wutil.implicitwait();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
// To read data from property file	
	String URL = putil.getDataFromPropertyFile("Url");
	String USERNAME = putil.getDataFromPropertyFile("Username");
	String PASSWORD = putil.getDataFromPropertyFile("Password");
// To launch the application	
	driver.get(URL);
// Login to application	
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys("Wipro");
	driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	driver.findElement(By.xpath("//option[text()='Support Group']")).click();
   }
}
