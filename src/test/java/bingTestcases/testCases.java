package bingTestcases;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import bingPages.bingTranslatorPage;


public class testCases {
	WebDriver driver;
	bingTranslatorPage objectTranslatorPage;
	
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
		objectTranslatorPage = new bingTranslatorPage(driver);
		objectTranslatorPage.pageLoadGetTitle("Bing Microsoft Translator");
		

	}
	
	/*
	 * a)   Check whether page loads completely
	 */
	
	
	@Test(priority = 2)
	public void pageLoadJavaExecutorTest() {
		objectTranslatorPage = new bingTranslatorPage(driver);
		objectTranslatorPage.loadJavaExecutor();
		
	}
	
	/*
	 *  c)	Check whether clear button clears both text areas
	 */
		
		@Test(priority = 3)
		public void clearTextCase() throws InterruptedException {
			objectTranslatorPage=new bingTranslatorPage(driver);
			objectTranslatorPage.insertInput("Page Loaded Successfully using getTitle ");
			Thread.sleep(3000);
			objectTranslatorPage.cleartext();
			
			
			
		}
/*
 *  b)  Check whether auto-detect dropdown automatically detects language
 */
	
	
	
	@Test(priority = 4)
	public void detactInputLangaugeIsCorrect() throws InterruptedException {
		
		objectTranslatorPage=new bingTranslatorPage(driver);
		objectTranslatorPage.insertInput("Page Loaded Successfully using getTitle  ");
		Thread.sleep(3000);
		objectTranslatorPage.checkDetactLanguageCorrect("english");
		
	
	}
	
	
	@Test(priority = 5)
	public void checkSwapFunction() throws InterruptedException
	{
		objectTranslatorPage=new bingTranslatorPage(driver);
		Thread.sleep(3000);
		
		objectTranslatorPage.insertInput("In this tutorial ");
		Thread.sleep(3000);
		
	    objectTranslatorPage.swapFunctionTest();
		
	}
	
	
	
	@Test(priority = 6)
	public void editTestCase() {
		objectTranslatorPage=new bingTranslatorPage(driver);
		objectTranslatorPage.insertInput("does not have any common things to readonly ");
		
		objectTranslatorPage.checkPageEditableOrNot();
	
	}
	

	
	@Test (priority = 7) 
	public void copyTestCase() throws  InterruptedException, UnsupportedFlavorException, IOException {
		objectTranslatorPage= new bingTranslatorPage(driver);
		objectTranslatorPage.insertInput("It is strongly recommended to ");
		Thread.sleep(2000);
		objectTranslatorPage.insertInput("add ");
		
		
		Thread.sleep(5000);
		objectTranslatorPage.checkButtonCopiedText();
		
		
	}
	
	
	 String largeInputString="Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth. Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar. The Big Oxmox advised her not to do so, because there were thousands of bad Commas, wild Question Marks and devious Semikoli, but the Little Blind Text didn’t listen. She packed her seven versalia, put her initial into the belt and made herself on the way. When she reached the first hills of the Italic Mountains, she had a last view back on the skyline of her hometown Bookmarksg ";
		
	@Test(priority = 8)
	public void ExceedingCharacterLimitTestMethod() throws InterruptedException 
	{
		objectTranslatorPage=new bingTranslatorPage(driver);
		objectTranslatorPage.insertInput(largeInputString);
		
		
		objectTranslatorPage.exeedLimitTest();
		
		
	}
	

	
	@AfterTest
	public void quit() {
		driver.quit();
	}


}
