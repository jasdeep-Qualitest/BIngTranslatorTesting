package bingPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import bingTestcases.testCases;

public class swapPage {
	WebDriver driver;

	@FindBy(xpath = "//textarea[@id='tta_input_ta']")
	WebElement fillInputWebElement;

	@FindBy(xpath = "//textarea[@id='tta_output_ta']")
	WebElement outputWebElement;
	
	@FindBy(xpath = "//select[@id='tta_srcsl']//option[@value='auto-detect']")
	WebElement detactedInputLanguagWebElement;
	
	@FindBy(xpath = "//optgroup[@id='t_tgtRecentLang']//option[@value='hi']")
	WebElement detactedOutputLanguagElement;
	
	@FindBy(xpath = "//optgroup[@id='t_srcRecentLang']//option[@value='hi']")
	WebElement afterSwapInputLanguagElement;
	
	@FindBy(xpath = "//optgroup[@id='t_tgtRecentLang']//option[@value='en']")
	WebElement afterSwapOutputLanguagElement;
	
	
	
	
	


	@FindBy(id = "tta_revIcon")
	WebElement swapButtonWebElement;

	public swapPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
public void insertInput(String inputString) {
	fillInputWebElement.sendKeys(inputString);	
	}

public void swapFunctionTest() throws InterruptedException {
  
	String inputLanguageString=detactedInputLanguagWebElement.getText();
	Thread.sleep(3000);
	String [] detectedLangArrayStrings=inputLanguageString.split(" ");
	
	String outputLanguageString=detactedOutputLanguagElement.getText();
	
	
	System.out.println(" input Lang + "+inputLanguageString+"  output + "+outputLanguageString);
	
	
	swapButtonWebElement.click();
	
	String afterSwapInputLanguageString=afterSwapInputLanguagElement.getText();
	String afterSwapOutputLanguageString=afterSwapOutputLanguagElement.getText();
	
	Assert.assertEquals(afterSwapInputLanguageString,outputLanguageString);
	Assert.assertEquals(detectedLangArrayStrings[0], afterSwapOutputLanguageString);
	
	
	
	System.out.println("Swap input Lang -> "+afterSwapInputLanguageString+"  Swap output -> "+afterSwapOutputLanguageString);
	
	
	
	
	

}





}
