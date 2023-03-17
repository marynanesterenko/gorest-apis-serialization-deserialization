package utils;
// this Class includes methods to initialise the configuration properties of this project,
// by invoking the FileReader Class load method, and a method to get the property values

import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;
    public static void initializeProperties() {
        // .load() method throws an exception, therefore we are wrapping it in the try-catch statement
        try {
            FileReader fileReader = new FileReader("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fileReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getConfigProperty(String key){
        return properties.getProperty(key);
    }



}
