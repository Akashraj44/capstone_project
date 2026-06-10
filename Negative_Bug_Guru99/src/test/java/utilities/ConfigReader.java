package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    Properties prop;

    public ConfigReader() throws Exception {

        FileInputStream fis =
                new FileInputStream(
                "src/test/resources/config.properties");

        prop = new Properties();

        prop.load(fis);
    }

    public String getBrowser() {

        return prop.getProperty("browser");
    }

    public String getUrl() {

        return prop.getProperty("url");
    }
}