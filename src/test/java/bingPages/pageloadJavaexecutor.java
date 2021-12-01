package bingPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class pageloadJavaexecutor {
	WebDriver driver;
		
	
	public pageloadJavaexecutor(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver=driver;
	PageFactory.initElements(driver,this);
	
	}
	
	public void loadJavaExecutor() {
		JavascriptExecutor jsExecutor= (JavascriptExecutor)driver;
	
		Assert.assertEquals(jsExecutor.executeScript("return document.readyState").toString(),"complete");
		
		System.out.println("Page Loaded Successfully using javaexecutor ");
		System.out.println("Check whether page loads completely    -------------PASSED");
	}
	
	
	
	

}
