package tests.basicauth;

import framework.driver.DriverFactory;
import framework.driver.DriverManager;
import framework.pages.BasicAuthPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public final class BasicAuthTest {

    private BasicAuthPage page;

    @BeforeMethod
    public void setup() {

        DriverFactory.initDriver();

        page = new BasicAuthPage();
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quit();
    }

    @Test
    public void BA_TC_001() {

        page.openInvalid();

        String url = DriverManager
                .getDriver()
                .getCurrentUrl();

        Assert.assertTrue(
                url.contains("basic_auth")
        );
    }

    @Test
    public void BA_TC_002() {

        page.openWithAuth();

        String source = DriverManager
                .getDriver()
                .getPageSource();

        Assert.assertTrue(
                source.contains("Congratulations")
        );
    }
}