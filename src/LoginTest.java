import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) {
        // Set path to chromedriver (adjust if needed)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();

        try {
            // Open sample login page
            driver.get("https://example.com/login");

            // Happy Path: Correct login
            WebElement username = driver.findElement(By.id("username"));
            WebElement password = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("loginBtn"));

            username.sendKeys("validUser");
            password.sendKeys("validPassword");
            loginButton.click();

            // Verify login success
            if (driver.getPageSource().contains("Welcome")) {
                System.out.println("✅ Login successful test passed");
            } else {
                System.out.println("❌ Login failed");
            }

        } finally {
            driver.quit();
        }
    }
}
