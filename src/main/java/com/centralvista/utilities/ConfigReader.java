/**
 * @author surendragangwar
 * @since 13-Aug-2026
 * @version 1.0
 * 
 * Description: [Enter class purpose here]
 */
package com.centralvista.utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public static void loadProperties() {

        properties = new Properties();

        try {
            FileInputStream fis =
                    new FileInputStream("src/main/java/com/centralvista/resources/config.properties");

            properties.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to load config.properties");
        }
    }

    public static String getProperty(String key) {

        if (properties == null) {
            loadProperties();
        }

        return properties.getProperty(key);
    }
}