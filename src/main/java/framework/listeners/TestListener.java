package framework.listeners;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import framework.driver.DriverManager;
import io.qameta.allure.Allure;

/**
 * TestNG listener for attaching screenshots on test failure.
 */
public final class TestListener implements ITestListener {

    private static final String SCREENSHOT_NAME = "screenshot";

    @Override
    public void onTestFailure(ITestResult result) {

        try {

            if (result == null) {
                return;
            }

            WebDriver driver = DriverManager.getDriver();

            if (!(driver instanceof TakesScreenshot ts)) {
                return;
            }

            byte[] screenshot =
                    ts.getScreenshotAs(OutputType.BYTES);

            if (screenshot == null || screenshot.length == 0) {
                return;
            }

            Allure.addAttachment(
                    SCREENSHOT_NAME,
                    new ByteArrayInputStream(screenshot)
            );

        } catch (Exception ignored) {
            // Listener must never break test execution
        }
    }
}