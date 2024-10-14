package Googlesample.Googlesample;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegressionTest {

	private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // WebDriverManager automatically handles the browser driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch Chrome browser
        driver.manage().window().maximize(); // Maximize the browser window
    }

    @Test
    public void googleSearchTest() {
        // Step 1: Open Google
        driver.get("https://www.google.com");

        // Step 2: Find the search box using its name attribute
        WebElement searchBox = driver.findElement(By.name("q"));

        // Step 3: Type the search query "Selenium WebDriver"
        searchBox.sendKeys("Selenium WebDriver");

        // Step 4: Submit the search form
        searchBox.submit();

        // Wait for the results to load (a simple implicit wait could also be used)
        try {
            Thread.sleep(2000); // Use proper WebDriverWait in production code
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 5: Verify that results page is displayed by checking the title
        String title = driver.getTitle();
        assertTrue(title.contains("Selenium WebDriver"), "The page title should contain 'Selenium WebDriver'");

        // Optional: Print the title of the page
        System.out.println("Page title is: " + title);
    }

    @AfterEach
    public void tearDown() {
        // Close the browser after the test
        if (driver != null) {
            driver.quit();
        }
    }
}

