package test;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class SearchTest {

	public String basUrl="https://social.pagefreezer.com/openrecords/cityofsacramento";
	public WebDriver driver;
	public Logger log;
	
	@BeforeMethod
	public void beforeMethod() {
		   System.out.println("@BeforeMethod");
		   System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		   driver = new ChromeDriver();
		   driver.get(basUrl);
		   log = Logger.getLogger("my.log");
		   log.setLevel(Level.ALL);
		   log.info("Started Test");
		   
	}
	
	@Test
	public void testforSpecialCharactersAsSearchInput() throws Exception {
		    
	           
		    String symbols ="@$#^#%#@^@^";
		    WebElement element = driver.findElement(By.id("Value_1"));
		    element.sendKeys(symbols);
		    
		    element = driver.findElement(By.cssSelector("#aria-search > div.col-xs-10.search-field > div > div:nth-child(3) > button"));
		    element.click();     
		    Assert.assertTrue(isNotAlphanumeric(symbols),"Search string cannot be specialcharacters");
	} 

	public boolean isNotAlphanumeric(String symbols)
	{
		if(StringUtils.isAlphanumeric(symbols))
		{
			return false;
		}
		else
		{
		 return true;
		}
		
	}

}

