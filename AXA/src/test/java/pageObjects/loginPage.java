package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
WebDriver driver;
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="_evidon-banner-acceptbutton")
	WebElement homeCookie;

	@FindBy(xpath="//body/div[3]/nav[1]/ul[1]/li[2]/a[1]")
	WebElement homeLink;				

	@FindBy(xpath="//a[@title='Log in']")
	WebElement loginLink;	
	
	@FindBy(xpath="/html[1]/body[1]/main[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]")
	WebElement loginAccount;	
	
	@FindBy(xpath="//button[@data-click='cookie-close']")
	WebElement loginCookie;	
	
	@FindBy(css="input[id='EmailAddress']")
	WebElement emailAddress;
	
	@FindBy(css="input[name='Password']")
	WebElement password;
	
	@FindBy(css="button[id='logon-submit']")
	WebElement login;
	
	public WebElement getHomeCookie()
	{
		return homeCookie;
	}
	
	public WebElement getHomeLink()
	{
		return homeLink;
	}
	
	public WebElement getLoginLink()
	{
		return loginLink;
	}
	
	public WebElement getLoginAccount()
	{
		return loginAccount;
	}
	
	public WebElement getLoginCookie()
	{
		return loginCookie;
	}
	
	public WebElement getEmailAddress()
	{
		return emailAddress;
	}
	
	public WebElement getPassword()
	{
		return password;
	}
	
	public WebElement getUserLogin()
	{
		return login;
	}


}
