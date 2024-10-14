package Stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;


public class GoogleSearchSteps {

	private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to your WebDriver
        System.setProperty("webdriver.chrome.driver","C:\\Users\\sehka\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");  // Replace with the correct path
        driver = new ChromeDriver();
    }

    @Given("I am on the Google homepage")
    public void i_am_on_the_google_homepage() {
        driver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void i_search_for(String query) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(query);
        searchBox.sendKeys(Keys.RETURN);
        System.out.println("google opened successfully!!!!");
    }

    @Then("I should see results related to {string}")
    public void i_should_see_results_related_to(String query) {
        // Wait for results and validate that they contain the query
        try {
            Thread.sleep(2000);  // Simplified wait, use WebDriverWait in real scenarios
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
       
        
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}