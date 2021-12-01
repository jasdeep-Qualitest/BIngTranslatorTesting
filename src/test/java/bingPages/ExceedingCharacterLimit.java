package bingPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ExceedingCharacterLimit {
	
	WebDriver driver;
	@FindBy(id = "tta_input_ta")
	WebElement fillInputWebElement;
	
	
	@FindBy(id="tta_longerr")
	WebElement exeedLimitWarning;
	
	public ExceedingCharacterLimit(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	
	
	public void exeedLimitTest() throws InterruptedException {
		fillInputWebElement.click();
		Thread.sleep(3000);
		String exeedLimitWarningString= exeedLimitWarning.getText();
		Assert.assertEquals(exeedLimitWarningString,"That’s too much text to translate at once. Try entering less");
		System.out.println("Test Case Passed "+exeedLimitWarningString);
		
		
	}

}
