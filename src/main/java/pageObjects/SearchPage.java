package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	
	final static String SEARCH_DROPDOWN	= ".dropdown-location";
	final static String RESTAURANT_LIST = ".restaurantlist";
	
	public static WebElement getSearchDropdown(WebDriver driver)
	{
		WebElement searchDropdown= driver.findElement(By.cssSelector(SEARCH_DROPDOWN));
		return searchDropdown;
	}
	public static WebElement getRestaurantList(WebDriver driver)
	{
		WebElement restaurantList= driver.findElement(By.cssSelector(RESTAURANT_LIST));
		return restaurantList;
	}

}
