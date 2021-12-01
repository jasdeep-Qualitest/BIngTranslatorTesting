package bingTestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bingPages.AutodetactLanguage;
import bingPages.OutPutEditPage;

public class TranslatetAreaNotEditableTestCase {
 
	WebDriver driver;
	AutodetactLanguage objAutodetactLanguage;
	
	OutPutEditPage objOutPutEditPage;
	@BeforeTest
    public void SetUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\jasdeep.singh\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.bing.com/translator");

	}
	@Test()
	public void editTestCase() {
		objAutodetactLanguage=new AutodetactLanguage(driver);
		objAutodetactLanguage.insertInput("does not have any common things to readonly ");
		objOutPutEditPage =new OutPutEditPage(driver);
		objOutPutEditPage.checkPageEditableOrNot();
		
		
		
		
		
	}

}
