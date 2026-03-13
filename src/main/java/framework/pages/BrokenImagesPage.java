package framework.pages;

import framework.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Page Object for Broken Images page.
 */
public final class BrokenImagesPage {

    private final WebDriver driver;

    public BrokenImagesPage() {

        this.driver = DriverManager.getDriver();

        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized");
        }

        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "img")
    private List<WebElement> images;

    public List<WebElement> getImages() {
        return images;
    }
}