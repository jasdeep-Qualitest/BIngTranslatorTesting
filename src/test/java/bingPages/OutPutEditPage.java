package bingPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OutPutEditPage {
	WebDriver driver;
	
	@FindBy(id = "tta_output_ta")
	WebElement outputTextAreaWebElement;

	public OutPutEditPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void checkPageEditableOrNot() {
		String readonly = outputTextAreaWebElement.getAttribute("readonly");
	    Assert.assertNotNull(readonly);
	
		
	}

}
