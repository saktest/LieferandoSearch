package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
	
	final static String HEADER_BUTTON	= ".button-house";
	final static String HEADER_IMAGE	= ".logo a img";
	final static String SUGGESTION_BOX 	= ".autoCompleteDropDownContent";
	final static String SUGGESTION_NAMES= ".autoCompleteDropDownContent a";
	final static String SEARCH_BAR		= ".deliveryareapanel .inputs";
	final static String SHOW_BUTTON		= ".submitBtn";
	final static String VALIDATION_ERROR = "ideliveryareaerror";

	
	public static String getHeaderButtontext(WebDriver driver)
	{
		String headerButtontext= driver.findElement(By.cssSelector(HEADER_IMAGE)).getAttribute("alt");
		return headerButtontext;
	}
	public static WebElement getHeaderButtonElement(WebDriver driver)
	{
		WebElement element= driver.findElement(By.cssSelector(HEADER_BUTTON));
		return element;
	}
	public static WebElement getSearchElement(WebDriver driver)
	{
		WebElement element= driver.findElement(By.cssSelector(SEARCH_BAR));
		return element;
	}
	public static WebElement getShowButtonElement(WebDriver driver)
	{
		WebElement element= driver.findElement(By.cssSelector(SHOW_BUTTON));
		return element;
	}
	public static WebElement getSuggestionBoxElement(WebDriver driver)
	{
		WebElement element= driver.findElement(By.cssSelector(SUGGESTION_BOX));
		return element;
	}
	public static List<WebElement> getSuggestionNames(WebDriver driver)
	{
		List<WebElement> element= driver.findElements(By.cssSelector(SUGGESTION_NAMES));
		return element;
	}
	public static WebElement getValidationError(WebDriver driver)
	{
		WebElement validationError= driver.findElement(By.id(VALIDATION_ERROR));
		return validationError;
	}
	
	
}