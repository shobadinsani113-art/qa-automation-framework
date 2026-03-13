package framework.utils;

import framework.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Utility for image validation.
 */
public final class ImageUtils {

    private static final String NATURAL_WIDTH_SCRIPT =
            "return arguments[0].naturalWidth";

    private ImageUtils() {
        throw new UnsupportedOperationException(
                "ImageUtils is a utility class"
        );
    }

    public static boolean isBroken(WebElement img) {

        if (img == null) {
            throw new IllegalArgumentException("Image element cannot be null");
        }

        WebDriver driver = DriverManager.getDriver();

        if (!(driver instanceof JavascriptExecutor js)) {
            throw new IllegalStateException(
                    "Driver does not support JavaScript execution"
            );
        }

        Object result = js.executeScript(
                NATURAL_WIDTH_SCRIPT,
                img
        );

        if (result == null) {
            return true;
        }

        // naturalWidth returns number (Long/Double/Integer depending on driver)
        int width = ((Number) result).intValue();

        return width == 0;
    }
}