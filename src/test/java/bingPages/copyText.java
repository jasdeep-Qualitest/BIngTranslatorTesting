package bingPages;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class copyText {
	
	
	WebDriver driver;
	@FindBy(id="tta_copyIcon")
	WebElement copyButtonWebElement;
	
	
	
	@FindBy(id = "tta_input_ta")
	WebElement fillInputWebElement;
	
	public copyText(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void checkButtonCopiedText() throws UnsupportedFlavorException, IOException {

	copyButtonWebElement.click();
	Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
	String copyString=(String) clipboard.getData(DataFlavor.stringFlavor);
	
	Assert.assertNotEquals(copyString,"");
	System.out.println("Copied Data  "+copyString);
	
	
	
	

	
	
	
	}

}
