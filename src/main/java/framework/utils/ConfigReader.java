package framework.utils;

import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * Reads configuration from config.properties located in classpath.
 */
public final class ConfigReader {

    private static final Properties PROP = new Properties();

    static {

        try (InputStream is =
                     ConfigReader.class
                             .getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (is == null) {
                throw new IllegalStateException(
                        "config.properties not found in classpath"
                );
            }

            PROP.load(is);

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to load config.properties",
                    e
            );
        }
    }

    private ConfigReader() {
        throw new UnsupportedOperationException(
                "ConfigReader is a utility class"
        );
    }

    public static String get(String key) {

        Objects.requireNonNull(key, "Config key must not be null");

        String value = PROP.getProperty(key);

        if (value == null) {
            throw new IllegalArgumentException(
                    "Missing config key: " + key
            );
        }

        return value;
    }
}