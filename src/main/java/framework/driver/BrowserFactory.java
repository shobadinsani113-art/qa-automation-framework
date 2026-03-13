package framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static WebDriver createDriver(String browser) {

        if (browser == null || browser.isBlank()) {
            throw new IllegalArgumentException("Browser must not be null or empty");
        }

        String normalizedBrowser = browser.toLowerCase();

        boolean headless = System.getenv()
                .getOrDefault("HEADLESS", "false")
                .equalsIgnoreCase("true");

        return switch (normalizedBrowser) {

            case "chrome" -> {

                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();

                if (headless) {
                    options.addArguments("--headless=new");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                }

                yield new ChromeDriver(options);
            }

            case "firefox" -> {

                WebDriverManager.firefoxdriver().setup();

                yield new FirefoxDriver();
            }

            default -> throw new IllegalArgumentException(
                    "Browser not supported: " + browser
            );
        };
    }
}