package tests.addremove;

import framework.driver.DriverFactory;
import framework.pages.AddRemoveElementsPage;
import framework.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public final class AddRemoveTest {

    private HomePage home;
    private AddRemoveElementsPage page;

    @BeforeMethod
    public void setup() {

        DriverFactory.initDriver();

        home = new HomePage();
        page = new AddRemoveElementsPage();

        home.open();
        home.clickAddRemove();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quit();
    }

    @Test
    public void AR_TC_001() {

        Assert.assertEquals(
                page.deleteCount(),
                0
        );
    }

    @Test
    public void AR_TC_002() {

        page.add();

        Assert.assertEquals(
                page.deleteCount(),
                1
        );
    }

    @Test
    public void AR_TC_003() {

        page.add();

        page.deleteOne();

        Assert.assertEquals(
                page.deleteCount(),
                0
        );
    }
}