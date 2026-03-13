package framework.driver;

import framework.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

/**
 * Responsible for driver lifecycle initialization and shutdown.
 */
public final class DriverFactory {

    private DriverFactory() {
        throw new UnsupportedOperationException("DriverFactory is a utility class");
    }

    public static void initDriver() {

        String browser = ConfigReader.get("browser");

        if (browser == null || browser.isBlank()) {
            throw new IllegalStateException("Browser is not defined in config");
        }

        WebDriver driver = BrowserFactory.createDriver(browser);

        if (driver == null) {
            throw new IllegalStateException(
                    "Failed to create WebDriver for browser: " + browser
            );
        }

        DriverManager.setDriver(driver);

        // use local reference to avoid repeated ThreadLocal lookup
        driver.manage().window().maximize();
    }

    public static void quit() {
        DriverManager.quitDriver();
    }
}