package Runner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features", // Path to the feature files
    glue = "Stepdefinition", // Package containing step definitions
    		 plugin = {"pretty", "html:target/cucumber-reports.html"}, // Generates HTML reports
    		    monochrome = false,
    		    tags="@smoke"// Output is readable
   
)


public class CucumberTestRunner {

}
