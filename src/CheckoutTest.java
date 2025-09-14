import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();

        try {
            // Open sample e-commerce site
            driver.get("https://example.com");

            // Add item to cart
            WebElement addToCart = driver.findElement(By.id("addToCartBtn"));
            addToCart.click();

            // Go to checkout
            WebElement checkout = driver.findElement(By.id("checkoutBtn"));
            checkout.click();

            // Fill checkout details
            driver.findElement(By.id("address")).sendKeys("123 Main St");
            driver.findElement(By.id("payment")).sendKeys("4111111111111111");

            // Submit order
            driver.findElement(By.id("placeOrderBtn")).click();

            // Verify success
            if (driver.getPageSource().contains("Order Confirmed")) {
                System.out.println("✅ Checkout flow test passed");
            } else {
                System.out.println("❌ Checkout failed");
            }

        } finally {
            driver.quit();
        }
    }
}
