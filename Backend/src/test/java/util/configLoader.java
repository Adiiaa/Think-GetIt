package util;

import java.io.FileInputStream;
import java.util.Properties;

public class configLoader {
    private static Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }
    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }
    public static String getAdminEmail(){
        return properties.getProperty("admin.email");
    }
    public static String getAdminPassword(){
        return properties.getProperty("admin.password");
    }
}
