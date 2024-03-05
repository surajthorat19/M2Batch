package CommonUtil;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebdriverUtil 
{
	
	
	
 public void Maximize()
 {
	 driver.manage().window().maximize();
	 
 }
 
 
 public void implicitwait()
 {
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
 }
	
 public void HandleDropdown(WebElement element,String targetedelement)
 {
	 Select s=new Select(element);
	 s.selectByVisibleText(targetedelement);
 }

 public void MouseHover(WebDriver driver,WebElement element)
 {
	 Actions a=new Actions(driver);
	 a.moveToElement(element);
	 a.perform();
 }
 
  public void SwitchWindow(WebDriver driver,String expectedurl)
  {
	  Set<String> ids = driver.getWindowHandles();
	  
	  for(String e: ids)
		  
	  {
		  String actualurl = driver.switchTo().window(e).getCurrentUrl();
		  
		  if(actualurl.contains(expectedurl))
		  {
			  break;
		  }
	  }
	  
	  
	  public File Screenshot(WebDriver driver,String screenshotName)
	  {
		  TakesScreenshot ts= new (TakesScreenshot)driver;
		  File tempfile = ts.getScreenshotAs(OutputType.FILE);
		  File destinationFile = new File("./screenshot/"+screenshotName+".png");
		  FileUtils.copyToDirectory(tempfile, destinationFile);
		  return destinationFile;
	  }
	  
	  
	  
  }
	

}
