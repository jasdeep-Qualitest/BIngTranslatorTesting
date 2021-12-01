package bingTestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bingPages.AutodetactLanguage;
import bingPages.PageLoad;
import bingPages.pageloadJavaexecutor;

public class testCases {
	WebDriver driver;
	PageLoad objPageLoad;
	AutodetactLanguage objAutodetactLanguage;
	
	/*
	 * 1. Setup chrome driver and launch chrome instance with Bing Translator url in before class testng annotation
	 */

@BeforeTest()
    public void SetUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\jasdeep.singh\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.bing.com/translator");

	}
/*
 * a) Check whether page loads completely
 */
	@Test(priority = 1)
	public void pageLoadTest() {
		objPageLoad = new PageLoad(driver);
		objPageLoad.pageLoadGetTitle("Bing Microsoft Translator");
		

	}
	
	/*
	 * a)   Check whether page loads completely
	 */
	
	
	@Test(priority = 2)
	public void pageLoadJavaExecutorTest() {
		pageloadJavaexecutor objPageloadJavaexecutor = new pageloadJavaexecutor(driver);
		objPageloadJavaexecutor.loadJavaExecutor();
		
	}
	
	/*
	 *  c)	Check whether clear button clears both text areas
	 */
		
		@Test(priority = 3)
		public void clearTextCase() throws InterruptedException {
			objAutodetactLanguage=new AutodetactLanguage(driver);
			objAutodetactLanguage.insertInput("Page Loaded Successfully using getTitle ");
			Thread.sleep(3000);
			objAutodetactLanguage.cleartext();
			
			
			
		}
/*
 *  b)  Check whether auto-detect dropdown automatically detects language
 */
	
	
	
	@Test(priority = 4)
	public void detactInputLangaugeIsCorrect() throws InterruptedException {
		objAutodetactLanguage=new AutodetactLanguage(driver);
		objAutodetactLanguage.insertInput("Page Loaded Successfully using getTitle  ");
		Thread.sleep(3000);
		objAutodetactLanguage.checkDetactLanguageCorrect("english");
		
	
	}

//	
//	@AfterTest
//	public void quit() {
//		driver.quit();
//	}


}
