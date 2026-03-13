package framework.pages;

import framework.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Page Object for Add/Remove Elements page.
 */
public final class AddRemoveElementsPage {

    private final WebDriver driver;

    public AddRemoveElementsPage() {

        this.driver = DriverManager.getDriver();

        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized");
        }

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Add Element']")
    private WebElement addBtn;

    @FindBy(xpath = "//button[text()='Delete']")
    private List<WebElement> deleteBtn;

    public void add() {
        addBtn.click();
    }

    public int deleteCount() {
        return deleteBtn.size();
    }

    public void deleteOne() {

        if (deleteBtn.isEmpty()) {
            throw new IllegalStateException("No delete button available");
        }

        deleteBtn.get(0).click();
    }
}