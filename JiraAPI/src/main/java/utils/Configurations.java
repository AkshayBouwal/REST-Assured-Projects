package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configurations {

    public static String getProperties(String keyValue) {

        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        return prop.getProperty(keyValue);

    }


}
