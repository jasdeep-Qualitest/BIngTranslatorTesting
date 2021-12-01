package bingPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AutodetactLanguage {
WebDriver driver;
@FindBy(id = "tta_input_ta")
WebElement fillInputWebElement;

@FindBy(id="tta_output_ta")
WebElement outputElement;

@FindBy(xpath = "//select[@id='tta_srcsl']//option[@value='auto-detect']")
WebElement detactedLanguagWebElement;



public AutodetactLanguage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}

public void insertInput(String inputString) {
	fillInputWebElement.sendKeys(inputString);	
}

public void checkDetactLanguageCorrect(String inputLanguageString) throws InterruptedException {
	
	
	String detactedLanguageString=detactedLanguagWebElement.getText();
	Thread.sleep(3000);
	String [] detectedLangArrayStrings=detactedLanguageString.split(" ");
	
	Assert.assertEquals(detectedLangArrayStrings[0].toLowerCase(),inputLanguageString);
	

	System.out.println("Check whether auto-detect dropdown automatically detects language         --------PASSED");
}
public void cleartext() {
	

	fillInputWebElement.clear();
	fillInputWebElement.click();
	String outputClearString=outputElement.getText();
	
	Assert.assertEquals(outputClearString,"");
	
	System.out.println("Check whether clear button clears both text areas   ------PASSED");
	

}
}
