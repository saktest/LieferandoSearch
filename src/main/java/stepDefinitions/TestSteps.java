package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import org.junit.Assert;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class TestSteps {
	
	WebDriver driver;
	
	@Given("^User opens the Lieferando website$")
	public void user_opens_the_Lieferando_website() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "/Users/sakshi.rawal/Downloads/geckodriver");
		System.setProperty("webdriver.chrome.driver", "/Users/sakshi.rawal/Downloads/chromedrivers");
		driver= new ChromeDriver();
        driver.get("https://www.lieferando.de/");
		driver.manage().window().maximize();
	}

	@Then("^he should see HomePage with Lieferando button text \"([^\"]*)\"$")
	public void he_should_see_HomePage_with_Lieferando_button_text(String arg1) throws Throwable {
		String headerButtontext = HomePage.getHeaderButtontext(driver);
		boolean headerButtonelement = HomePage.getSearchElement(driver).isDisplayed();
		Assert.assertTrue(headerButtonelement);
		Assert.assertEquals(headerButtontext, arg1);
	}

	@Then("^he should see Search bar$")
	public void he_should_see_Search_bar() throws Throwable {
	   boolean searchElement=HomePage.getSearchElement(driver).isDisplayed();
	   Assert.assertTrue(searchElement);
	   
	}

	@Then("^he should see Show button$")
	public void he_should_see_Show_button() throws Throwable {
		boolean showButtonElement=HomePage.getShowButtonElement(driver).isDisplayed();
		Assert.assertTrue(showButtonElement);
	}

	@Then("^the driver is closed$")
	public void the_driver_is_closed() throws Throwable {
	    driver.quit();
	}

	@When("^he enters the address \"([^\"]*)\" in the search bar$")
	public void he_enters_the_address_in_the_search_bar(String arg1) throws Throwable {
	    WebElement element=HomePage.getSearchElement(driver);
	    Actions actions = new Actions(driver);
	    actions.moveToElement(element);
	    actions.click();
	    actions.sendKeys(arg1);
	    actions.build().perform();
	}

	@Then("^he should see a suggestion box$")
	public void he_should_see_a_suggestion_box() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(HomePage.getSuggestionBoxElement(driver)));
		boolean suggestionDisplayed = element.isDisplayed();
	    Assert.assertTrue(suggestionDisplayed); 
	}
	
	@Then("^box should contain suggestions related to \"([^\"]*)\"$")
	public void box_should_contain_suggestions_related_to(String arg1) throws Throwable {
		List<WebElement> listSuggestions= HomePage.getSuggestionNames(driver);
		for ( WebElement list: listSuggestions) 
			{
				String suggestionName = list.getAttribute("data-route");
				Assert.assertTrue(suggestionName.contains(arg1));
			}
	}

	@Then("^the box should contains suggestions between (\\d+) and (\\d+)$")
	public void the_box_should_contains_suggestions_between_and(int arg1, int arg2) throws Throwable {
		List<WebElement> listSuggestions= HomePage.getSuggestionNames(driver);
		int susggestionCount = listSuggestions.size();
		Assert.assertTrue(susggestionCount >= arg1);
		Assert.assertTrue(susggestionCount <= arg2);
	}

	@When("^he selects a value from the suggestion box$")
	public void he_selects_a_value_from_the_suggestion_box() throws Throwable {
		List<WebElement> element=HomePage.getSuggestionNames(driver);
		int listSize= element.size();
		element.get(listSize-1).click();
	}
	@Then("^he should be redirected to search results page$")
	public void he_should_be_redirected_to_search_results_page() throws Throwable {
	WebDriverWait wait = new WebDriverWait(driver, 300);
	WebElement restaurantList = wait.until(ExpectedConditions.visibilityOf(SearchPage.getRestaurantList(driver)));
	WebElement searchDropdown = wait.until(ExpectedConditions.visibilityOf(SearchPage.getSearchDropdown(driver)));
	    Assert.assertTrue(searchDropdown.isDisplayed());
	    Assert.assertTrue(restaurantList.isDisplayed());
	}
	
	@Given("^he clicks the Show button$")
	public void he_clicks_the_Show_button() throws Throwable {
	    WebElement element = HomePage.getShowButtonElement(driver);
	    element.click();
	}
	@Then("^he should see a validation message$")
	public void he_should_see_a_validation_message() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 600);
		WebElement validationMessage = wait.until(ExpectedConditions.visibilityOf(HomePage.getValidationError(driver)));
	    Assert.assertTrue(validationMessage.isDisplayed());
	}

	@Given("^he enters post code \"([^\"]*)\"$")
	public void he_enters_post_code(String arg1) throws Throwable {
		WebElement element=HomePage.getSearchElement(driver);
	    Actions actions = new Actions(driver);
	    actions.moveToElement(element);
	    actions.click();
	    actions.sendKeys(arg1);
	    actions.build().perform();
	}

}
