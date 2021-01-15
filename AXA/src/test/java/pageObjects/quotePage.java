package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class quotePage {
	
WebDriver driver;
	
	public quotePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
/*	driver.switchTo().frame("slider-iframe");
	String retrieveQuote = driver.findElement((By.linkText("Retrieve your saved quote"))).getText();
	System.out.println(retrieveQuote);
	driver.findElement((By.linkText("Retrieve your saved quote"))).click();  */

	
	@FindBy(linkText="Retrieve your saved quote")
	WebElement retrieveQuote;
	
	@FindBy(xpath="//li[contains(text(),'4 Ilsley Road, Basingstoke, Hampshire, RG24 9RU')]")
	WebElement quoteAddress;
	
	public WebElement  getRetrieveQuote()
	{
		return retrieveQuote;
	}
	
	public WebElement getQuoteAddress()
	{
		return quoteAddress;
	}
	
/*	String houseAddress = "4 Ilsley Road, Basingstoke, Hampshire, RG24 9RU";
	String quoteAddress = driver.findElement(By.xpath("//li[contains(text(),'4 Ilsley Road, Basingstoke, Hampshire, RG24 9RU')]")).getText();
	System.out.println(quoteAddress);
	Assert.assertEquals(quoteAddress, houseAddress);  */
	
	

}
