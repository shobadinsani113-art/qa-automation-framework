package framework.pages;

import framework.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object for A/B Testing page.
 */
public final class ABTestingPage {

    private final WebDriver driver;

    public ABTestingPage() {

        this.driver = DriverManager.getDriver();

        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized");
        }

        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h3")
    private WebElement title;

    public String getTitle() {
        return title.getText();
    }

    public void refresh() {
        driver.navigate().refresh();
    }
}