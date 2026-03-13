package framework.driver;

import org.openqa.selenium.WebDriver;

/**
 * Manages WebDriver instances per thread.
 * Designed for parallel execution using ThreadLocal.
 */
public final class DriverManager {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    // Prevent instantiation
    private DriverManager() {
        throw new UnsupportedOperationException("DriverManager is a utility class");
    }

    public static void setDriver(WebDriver drv) {
        if (drv == null) {
            throw new IllegalArgumentException("WebDriver cannot be null");
        }
        DRIVER.set(drv);
    }

    public static WebDriver getDriver() {
        WebDriver drv = DRIVER.get();

        if (drv == null) {
            throw new IllegalStateException(
                    "WebDriver is not initialized for this thread. " +
                            "Did you forget to call setDriver()?"
            );
        }

        return drv;
    }

    public static void quitDriver() {
        WebDriver drv = DRIVER.get();

        if (drv != null) {
            drv.quit();
            DRIVER.remove(); // prevent memory leak in ThreadLocal
        }
    }
}