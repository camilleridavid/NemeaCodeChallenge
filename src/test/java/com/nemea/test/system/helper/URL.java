package com.nemea.test.system.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The <code>URL</code> class is a properties placeholder for site URLs.
 */
public class URL {
    /**
     * The <code>Properties</code> instance that will hold the URLs loaded from the properties file.
     */
    private static Properties properties;

    /**
     * Loads a set of properties from the URL.xml file.
     */
    public static void loadURLs() {
        File file = new File("src/test/resources/url.xml");
        try {
            FileInputStream fileInput = new FileInputStream(file);
            properties = new Properties();
            properties.loadFromXML(fileInput);
            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the URL related to the name of the URL that's passed as an argument.
     *
     * @param urlName The name of the URL needed.
     * @return String with the URL requested.
     */
    public static String getURL(String urlName) {
        return properties.getProperty(urlName);
    }
}
