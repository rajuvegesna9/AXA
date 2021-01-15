package stepDefinations;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.loginPage;
import pageObjects.quotePage;
import resources.base;
import org.testng.Assert;
public class retrieveQuoteDefination extends base {
	
		@Given("User navigates to the AXA Home Page")
		public void user_navigates_to_the_axa_home_page() throws IOException {
			driver = initializeDriver();
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			driver.get("https://www.axa.co.uk/");
			driver.manage().window().maximize();
		} 

		@Given("User logs in with EmailAddress and Password")
		public void user_logs_in_with_email_address_and_password() throws IOException {
	    	loginPage login = new loginPage(driver);
	    	login.getHomeCookie().click();
			login.getHomeLink().click();
			login.getLoginLink().click();
			login.getLoginAccount().click();
			login.getLoginCookie().click();
	    	login.getEmailAddress().sendKeys("rajuvegesna@hotmail.com");
	    	login.getPassword().sendKeys("Password1!");
	    	login.getUserLogin().click();
	    	System.out.println("User logged in successfully");
		}
		@When("User retrieves the saved quote")
		public void user_retrieves_the_saved_quote() {
			quotePage quote = new quotePage(driver);
			driver.switchTo().frame("slider-iframe");
			String retrieveQuote = quote.getRetrieveQuote().getText();
			System.out.println(retrieveQuote);
			quote.getRetrieveQuote().click();
		}
		@Then("the saved quote details are displayed correctly")
		public void the_saved_quote_details_are_displayed_correctly() {
			quotePage quote = new quotePage(driver);
			String houseAddress = "4 Ilsley Road, Basingstoke, Hampshire, RG24 9RU";
			String quoteAddress = quote.getQuoteAddress().getText();
			System.out.println(quoteAddress);
			Assert.assertEquals(quoteAddress, houseAddress);   
			driver.close();
		}
		
		@When("User generates Home Insurance Quote")
		public void user_generates_home_insurance_quote() {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			loginPage login = new loginPage(driver);
	    	login.getHomeCookie().click();
			login.getHomeLink().click();
			
			//Click on GetA Quote
			driver.findElement(By.xpath("/html[1]/body[1]/main[1]/section[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/a[1]")).click();
			
			//Your Address and choice of cover
			driver.findElement(By.id("HouseNumberOrName")).sendKeys("4");  
			driver.findElement(By.id("Postcode")).sendKeys("RG24 9RU"); 
			driver.findElement(By.xpath("//*[@id=\"find-address-button\"]/a")).click();
			driver.findElement(By.id("PropertyDetailsViewModel_HomePolicyholderIsHomeownerId_1")).click();
			driver.findElement(By.id("PropertyDetailsViewModel_SelectedPackage_9")).click();
			driver.findElement(By.id("CoverStartDateDay")).click();
			driver.findElement(By.id("CoverStartDateDay")).sendKeys("27");
			driver.findElement(By.id("CoverStartDateMonth")).click();
			driver.findElement(By.id("CoverStartDateMonth")).sendKeys("01");
			driver.findElement(By.id("CoverStartDateYear")).click();
			driver.findElement(By.id("CoverStartDateYear")).sendKeys("2021");
			
			//About your home
			Select PropertyType = new Select(driver.findElement(By.id("PropertyDetailsViewModel_PropertyTypeId"))); //Detached house
			PropertyType.selectByVisibleText("Detached house");
			driver.findElement(By.name("PropertyDetailsViewModel_PropertyNumberOfBedroomsId")).click();
			Select BuildDate = new Select(driver.findElement(By.xpath("//select[@id='PropertyDetailsViewModel_PropertyConstructionYearId']"))); 
			BuildDate.selectByIndex(10);
			driver.findElement(By.id("PropertyDetailsViewModel_PropertyBuildingMaterialId_1")).click();
			driver.findElement(By.id("PropertyDetailsViewModel_PropertyRoofMaterialId_1")).click();
			Select RoofFlat = new Select(driver.findElement(By.id("PropertyDetailsViewModel_PropertyFlatRoofPercentageId"))); 
			RoofFlat.selectByVisibleText("None");
			driver.findElement(By.id("PropertyDetailsViewModel_NumberOfAdultsId_2")).click();
			driver.findElement(By.id("PropertyDetailsViewModel_NumberOfDependantsId_2")).click();
			Select Home = new Select(driver.findElement(By.id("PropertyDetailsViewModel_PropertyUsageFrequencyId"))); 
			Home.selectByVisibleText("Most days for at least a few hours");
			Select Business = new Select(driver.findElement(By.id("PropertyDetailsViewModel_PropertyBusinessUseId"))); 
			Business.selectByVisibleText("No business use");
			WebElement Flood = driver.findElement(By.xpath("//button[@id='PropertyDetailsViewModel_PropertyHasBeenFloodedId_0']"));
			js.executeScript("arguments[0].scrollIntoView();", Flood);
			driver.findElement(By.xpath("//button[@id='PropertyDetailsViewModel_PropertyHasBeenFloodedId_0']")).click();
			driver.findElement(By.cssSelector("#PropertyDetailsViewModel_PropertyHasHadSubsidenceId_0")).click();
			driver.findElement(By.cssSelector("#PropertyDetailsViewModel_IsListedBuilding_0")).click();
			
			//About You
			driver.findElement(By.id("PolicyholderDetailsViewModel_PolicyholderTitle_1")).click();
			driver.findElement(By.id("PolicyholderDetailsViewModel_PolicyholderFirstName")).click();
			driver.findElement(By.id("PolicyholderDetailsViewModel_PolicyholderFirstName")).sendKeys("Test");
			driver.findElement(By.id("PolicyholderDetailsViewModel_PolicyholderSurname")).click();
			driver.findElement(By.id("PolicyholderDetailsViewModel_PolicyholderSurname")).sendKeys("pass");
			WebElement DateOfBirth = driver.findElement(By.id("PolicyholderDateOfBirthDay"));
			js.executeScript("arguments[0].scrollIntoView();", DateOfBirth);
			driver.findElement(By.id("PolicyholderDateOfBirthDay")).click();
			driver.findElement(By.id("PolicyholderDateOfBirthDay")).sendKeys("24");
			driver.findElement(By.id("PolicyholderDateOfBirthMonth")).click();
			driver.findElement(By.id("PolicyholderDateOfBirthMonth")).sendKeys("07");
			driver.findElement(By.id("PolicyholderDateOfBirthYear")).click();
			driver.findElement(By.id("PolicyholderDateOfBirthYear")).sendKeys("1970");
			WebElement PolicyholderId = driver.findElement(By.id("JointPolicyholderViewModel_IsAddJointPolicyholderId_0"));
			js.executeScript("arguments[0].scrollIntoView();", PolicyholderId);
			driver.findElement(By.id("JointPolicyholderViewModel_IsAddJointPolicyholderId_0")).click();
			driver.findElement(By.id("InterestedPartyViewModel_IsThirdPartyInterestNoted_0")).click();
			driver.findElement(By.id("ClaimsViewModel_HasClaims_0")).click();
			Select NoBuildingInsurance = new Select(driver.findElement(By.xpath("//select[@id='PolicyholderDetailsViewModel_NumberOfYearsBuildingInsuranceId']"))); 
			NoBuildingInsurance.selectByIndex(2);
			Select NoContentsInsurance = new Select(driver.findElement(By.xpath("//select[@id='PolicyholderDetailsViewModel_NumberOfYearsContentsInsuranceId']"))); 
			NoContentsInsurance.selectByIndex(2);
			driver.findElement(By.id("PolicyholderDetailsViewModel_IsDDMonthlyPaymentPreferred_1")).click();
			driver.findElement(By.name("PolicyholderDetailsViewModel.PolicyholderEmail")).sendKeys("rajuvegesna@hotmail.com");
			
			//Get Quote Now
			WebElement Submit = driver.findElement(By.id("submit-your-details"));
			js.executeScript("arguments[0].scrollIntoView();", Submit);
			driver.findElement(By.id("submit-your-details")).click();
			
			//Your Quote
			String houseAddress = "4 Ilsley Road, Basingstoke, Hampshire, RG24 9RU";
			String quoteAddress = driver.findElement(By.xpath("//li[contains(text(),'4 Ilsley Road, Basingstoke, Hampshire, RG24 9RU')]")).getText();
			System.out.println(quoteAddress);
			Assert.assertEquals(quoteAddress, houseAddress);
		}

		@Then("Home Insurance Quote details are successfully displayed")
		public void home_insurance_quote_details_are_successfully_displayed() {
		    driver.close();
		}

		




	
}
