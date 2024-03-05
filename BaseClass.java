package CommonUtil;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass 
{
	public WebDriver driver;
	PropertyFileUtil putil=new PropertyFileUtil();
	WebdriverUtil wutil=new WebdriverUtil();
	
	
@BeforeSuite
public void BS()
{
	System.out.println("Connect to Data Base");
}
	
@BeforeClass
public void BC() throws IOException
{
// 	
	String URL = putil.getDataFromPropertyFile("Url");
	
	WebDriver driver=new ChromeDriver();
// To maximize the window	
	wutil.Maximize();
// To apply wait for findelement()	
	wutil.implicitwait();
	
// To launch the application
	driver.get(URL);

	
}

@BeforeMethod
public void BM() throws IOException
{
	// @Before Method is used to Login to the Application
	String USERNAME = putil.getDataFromPropertyFile("Username");
	String PASSWORD = putil.getDataFromPropertyFile("Password");
	
	// Login to Application
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();

}

@AfterMethod
public void AM() throws InterruptedException
{
   // @AfterMethod is used to signout from the Application	
	Thread.sleep(2000);
	// Mouse hover on image
			WebElement image = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
			wutil.MouseHover(driver, image);
			
		// click on signout
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			
}

@AfterClass
public void AC()
{
  // @AfterClass is used to close the Browser
	driver.quit();

}


@AfterSuite
public void AS()
{
	System.out.println("Dis-connect Data Base");
	
}


}
