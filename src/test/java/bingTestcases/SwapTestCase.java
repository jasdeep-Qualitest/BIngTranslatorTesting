package bingTestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import bingPages.swapPage;

public class SwapTestCase {
	WebDriver driver;

	swapPage objSwapPage;
	
	@BeforeTest
    public void SetUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\jasdeep.singh\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.bing.com/translator");

	}
	
	
	@Test(priority = 1)
	public void checkSwapFunction() throws InterruptedException
	{
		objSwapPage=new swapPage(driver);
		Thread.sleep(3000);
		
		objSwapPage.insertInput("In this tutorial ");
		Thread.sleep(3000);
		
	    objSwapPage.swapFunctionTest();
		
	}

}
