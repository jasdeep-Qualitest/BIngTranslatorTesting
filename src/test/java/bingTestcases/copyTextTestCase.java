package bingTestcases;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bingPages.AutodetactLanguage;
import bingPages.copyText;

public class copyTextTestCase {
	copyText objCopyText;
	AutodetactLanguage objAutodetactLanguage;
	WebDriver driver;

	

	@BeforeTest
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\jasdeep.singh\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://www.bing.com/translator");

	}

	@Test  
	public void copyTestCase() throws  InterruptedException, UnsupportedFlavorException, IOException {
		objAutodetactLanguage = new AutodetactLanguage(driver);
		objAutodetactLanguage.insertInput("It is strongly recommended to ");
		Thread.sleep(2000);
		objAutodetactLanguage.insertInput("add ");
		
		
		Thread.sleep(5000);
		objCopyText = new copyText(driver);
		objCopyText.checkButtonCopiedText();
		
		
	}
	@AfterTest
	public void quit() {
		driver.quit();
	}
	
}
