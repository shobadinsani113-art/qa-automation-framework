package tests.abtesting;

import framework.driver.DriverFactory;
import framework.pages.ABTestingPage;
import framework.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

public final class ABTestingTest {

    private HomePage home;
    private ABTestingPage page;

    @BeforeMethod
    public void setup() {

        DriverFactory.initDriver();

        home = new HomePage();
        page = new ABTestingPage();

        home.open();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quit();
    }

    @Test
    public void AB_TC_001() {

        home.clickAB();

        Assert.assertTrue(
                page.getTitle().contains("A/B")
        );
    }

    @Test
    public void AB_TC_002() {

        home.clickAB();

        String t1 = page.getTitle();

        page.refresh();

        String t2 = page.getTitle();

        Assert.assertNotEquals(t1, t2);
    }
}