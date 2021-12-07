package bingTestcases;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bingPages.AutodetactLanguage;
import bingPages.ExceedingCharacterLimit;
import bingPages.OutPutEditPage;
import bingPages.PageLoad;
import bingPages.copyText;
import bingPages.pageloadJavaexecutor;
import bingPages.swapPage;

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
	swapPage objSwapPage;
	
	@Test(priority = 5)
	public void checkSwapFunction() throws InterruptedException
	{
		objSwapPage=new swapPage(driver);
		Thread.sleep(3000);
		
		objSwapPage.insertInput("In this tutorial ");
		Thread.sleep(3000);
		
	    objSwapPage.swapFunctionTest();
		
	}
	
	
	OutPutEditPage objOutPutEditPage;
	@Test(priority = 6)
	public void editTestCase() {
		objAutodetactLanguage=new AutodetactLanguage(driver);
		objAutodetactLanguage.insertInput("does not have any common things to readonly ");
		objOutPutEditPage =new OutPutEditPage(driver);
		objOutPutEditPage.checkPageEditableOrNot();
	
	}
	
	copyText objCopyText;
	
	@Test (priority = 7) 
	public void copyTestCase() throws  InterruptedException, UnsupportedFlavorException, IOException {
		objAutodetactLanguage = new AutodetactLanguage(driver);
		objAutodetactLanguage.insertInput("It is strongly recommended to ");
		Thread.sleep(2000);
		objAutodetactLanguage.insertInput("add ");
		
		
		Thread.sleep(5000);
		objCopyText = new copyText(driver);
		objCopyText.checkButtonCopiedText();
		
		
	}
	
	 ExceedingCharacterLimit objCharacterLimit;
	 String largeInputString="Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild Question Marks and devious Semikoli, but the Little Blind Text didn’t listen. She packed her seven versalia, put her initial into the belt and made herself on the way. When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksg ";
		
	@Test(priority = 8)
	public void ExceedingCharacterLimitTestMethod() throws InterruptedException 
	{
		objAutodetactLanguage=new AutodetactLanguage(driver);
		objAutodetactLanguage.insertInput(largeInputString);
		
		objCharacterLimit=new ExceedingCharacterLimit(driver);
		objCharacterLimit.exeedLimitTest();
		
		
	}
	

	
	@AfterTest
	public void quit() {
		driver.quit();
	}


}
