package bingPages;





import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class PageLoad {
	WebDriver driver;
	public PageLoad(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	public void pageLoadGetTitle(String expectedTitleString) {
		
		String titleString= driver.getTitle();
	
	
		Assert.assertEquals(titleString, expectedTitleString);
		
		System.out.println("Page Loaded Successfully using getTitle     -------PASSED");
		
		
	}
	
	
	
	
	
	
	

	
	

}
