package framework.pages;

import framework.driver.DriverManager;
import framework.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object for Home Page.
 */
public final class HomePage {

    private static final String BASE_URL_KEY = "base.url";

    private final WebDriver driver;

    public HomePage() {

        this.driver = DriverManager.getDriver();

        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized");
        }

        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "A/B Testing")
    private WebElement abTesting;

    @FindBy(linkText = "Add/Remove Elements")
    private WebElement addRemove;

    @FindBy(linkText = "Basic Auth")
    private WebElement basicAuth;

    @FindBy(linkText = "Broken Images")
    private WebElement brokenImages;

    public void open() {

        String url = ConfigReader.get(BASE_URL_KEY);

        if (url == null || url.isBlank()) {
            throw new IllegalStateException("base.url is not configured");
        }

        driver.get(url);
    }

    public void clickAB() {
        abTesting.click();
    }

    public void clickAddRemove() {
        addRemove.click();
    }

    public void clickBasicAuth() {
        basicAuth.click();
    }

    public void clickBrokenImages() {
        brokenImages.click();
    }
}