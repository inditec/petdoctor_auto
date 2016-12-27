package km.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by KrishnaMohan on 27/12/2016.
 */
public class PropertiesReader {
    private static final Map<String, String> propertiesMap = new HashMap<String, String>();

    static{
        loadProperties("default.properties");
        String environmentFilePath = "environment/" + propertiesMap.get("environment") + ".properties";
        loadProperties(environmentFilePath);
    }

    private static void loadProperties(String filePath) {
        Properties properties = new Properties();
        try {
            properties.load(PropertiesReader.class.getClassLoader().getResourceAsStream(filePath));
        } catch (Exception exception) {
            //println("Could not read properties from property file: ${filePath}")
            throw new RuntimeException(exception.getMessage());
        }
        Enumeration enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String propertyKey = (String) enumeration.nextElement();
            String propertyValue = properties.getProperty(propertyKey);
            System.out.println(String.format("Adding property, %s = %s", propertyKey, propertyValue));
            propertiesMap.put(propertyKey, propertyValue);
        }
    }

    public static String findProperty(String propertyName) {
        return propertiesMap.get(propertyName);
    }
}
