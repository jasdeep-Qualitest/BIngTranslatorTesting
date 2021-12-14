package bingPages;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class bingTranslatorPage {
	WebDriver driver;
	@FindBy(id = "tta_input_ta")
	WebElement fillInputWebElement;

	@FindBy(id = "tta_output_ta")
	WebElement outputElement;

	@FindBy(xpath = "//select[@id='tta_srcsl']//option[@value='auto-detect']")
	WebElement detactedLanguagWebElement;
	
	@FindBy(id="tta_copyIcon")
	WebElement copyButtonWebElement;
	
	@FindBy(id="tta_longerr")
	WebElement exeedLimitWarning;
	

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

	public bingTranslatorPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void insertInput(String inputString) {
		fillInputWebElement.sendKeys(inputString);
	}

	public void pageLoadGetTitle(String expectedTitleString) {

		String titleString = driver.getTitle();

		Assert.assertEquals(titleString, expectedTitleString);

		System.out.println("Page Loaded Successfully using getTitle     -------PASSED");

	}

	public void loadJavaExecutor() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		Assert.assertEquals(jsExecutor.executeScript("return document.readyState").toString(), "complete");

		System.out.println("Page Loaded Successfully using javaexecutor ");
		System.out.println("Check whether page loads completely    -------------PASSED");
	}

	public void cleartext() {

		fillInputWebElement.clear();
		fillInputWebElement.click();
		String outputClearString = outputElement.getText();

		Assert.assertEquals(outputClearString, "");

		System.out.println("Check whether clear button clears both text areas   ------PASSED");

	}

	public void checkDetactLanguageCorrect(String inputLanguageString) throws InterruptedException {

		String detactedLanguageString = detactedLanguagWebElement.getText();
		Thread.sleep(3000);
		String[] detectedLangArrayStrings = detactedLanguageString.split(" ");

		Assert.assertEquals(detectedLangArrayStrings[0].toLowerCase(), inputLanguageString);

		System.out.println("Check whether auto-detect dropdown automatically detects language         --------PASSED");
	}

	

	public void swapFunctionTest() throws InterruptedException {

		String inputLanguageString = detactedInputLanguagWebElement.getText();
		Thread.sleep(3000);
		String[] detectedLangArrayStrings = inputLanguageString.split(" ");

		String outputLanguageString = detactedOutputLanguagElement.getText();

		System.out.println(" input Lang + " + inputLanguageString + "  output + " + outputLanguageString);

		swapButtonWebElement.click();

		String afterSwapInputLanguageString = afterSwapInputLanguagElement.getText();
		String afterSwapOutputLanguageString = afterSwapOutputLanguagElement.getText();

		Assert.assertEquals(afterSwapInputLanguageString, outputLanguageString);
		Assert.assertEquals(detectedLangArrayStrings[0], afterSwapOutputLanguageString);

		System.out.println("Swap input Lang -> " + afterSwapInputLanguageString + "  Swap output -> "
				+ afterSwapOutputLanguageString);

	}

	public void checkPageEditableOrNot() {
		String readonly = outputWebElement.getAttribute("readonly");
		Assert.assertNotNull(readonly);

	}
	public void checkButtonCopiedText() throws UnsupportedFlavorException, IOException {

		copyButtonWebElement.click();
		Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
		String copyString=(String) clipboard.getData(DataFlavor.stringFlavor);
		
		Assert.assertNotEquals(copyString,"");
		System.out.println("Copied Data  "+copyString);
		
	
		
		}
	
	public void exeedLimitTest() throws InterruptedException {
		fillInputWebElement.click();
		Thread.sleep(3000);
		String exeedLimitWarningString= exeedLimitWarning.getText();
		Assert.assertEquals(exeedLimitWarningString,"That’s too much text to translate at once. Try entering less");
		System.out.println("Test Case Passed "+exeedLimitWarningString);
		
		
	}

}
