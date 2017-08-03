package searchTest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature/HomePage_Search.feature:69"
		,glue= "stepDefinitions"
		)

public class TestRunner {

}
