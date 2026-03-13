package tests.brokenimages;

import framework.driver.DriverFactory;
import framework.pages.BrokenImagesPage;
import framework.pages.HomePage;
import framework.utils.ImageUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public final class BrokenImagesTest {

    private HomePage home;
    private BrokenImagesPage page;

    @BeforeMethod
    public void setup() {

        DriverFactory.initDriver();

        home = new HomePage();
        page = new BrokenImagesPage();

        home.open();
        home.clickBrokenImages();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quit();
    }

    @Test
    public void BI_TC_001() {

        List<WebElement> images = page.getImages();

        Assert.assertTrue(
                images.size() > 0
        );
    }

    @Test
    public void BI_TC_002() {

        List<WebElement> images = page.getImages();

        boolean foundBroken = false;

        for (WebElement img : images) {

            if (ImageUtils.isBroken(img)) {
                foundBroken = true;
                break;
            }
        }

        Assert.assertTrue(foundBroken);
    }

    @Test
    public void BI_TC_003() {

        List<WebElement> images = page.getImages();

        boolean allHaveAlt = true;

        for (WebElement img : images) {

            String alt = img.getAttribute("alt");

            if (alt == null || alt.isEmpty()) {
                allHaveAlt = false;
                break;
            }
        }

        Assert.assertTrue(allHaveAlt);
    }
}