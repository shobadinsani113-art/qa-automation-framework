package framework.pages;

import framework.driver.DriverManager;
import framework.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for Basic Auth page.
 */
public final class BasicAuthPage {

    private static final String PROTOCOL = "https://";
    private static final String HOST = "the-internet.herokuapp.com/basic_auth";

    private final WebDriver driver;

    public BasicAuthPage() {

        this.driver = DriverManager.getDriver();

        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized");
        }
    }

    public void openWithAuth() {

        String username = ConfigReader.get("username");
        String password = ConfigReader.get("password");

        if (username == null || password == null) {
            throw new IllegalStateException("Auth credentials not configured");
        }

        String url =
                PROTOCOL +
                        username +
                        ":" +
                        password +
                        "@" +
                        HOST;

        driver.get(url);
    }

    public void openInvalid() {

        String url =
                PROTOCOL +
                        "test:test@" +
                        HOST;

        driver.get(url);
    }
}