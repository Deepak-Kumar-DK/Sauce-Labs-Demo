package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;
import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;

public class ConfigFileReader {
    private static final Logger logger = LoggerFactory.getLogger(ConfigFileReader.class);

    private Properties properties;

    public ConfigFileReader() {
        String propertyFilePath = "configs/Configurations.properties";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            properties.load(reader);
        } catch (FileNotFoundException e) {
            logger.error(()->"Properties file not found at path : " + propertyFilePath);
            throw new RuntimeException("Properties file not found at path : " + propertyFilePath);
        } catch (IOException e) {
                e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException ignore) {

            }
        }
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) {
            try {
                return Long.parseLong(implicitlyWait);
            } catch (NumberFormatException e) {
                logger.error(()->"Not able to parse value : " + implicitlyWait + " in to Long");
                throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
            }
        }
        return 30;
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null)
            return url;
        else {
            logger.error(()->"Application Url not specified in the Configuration.properties file for the Key:url");
            throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
        }
    }

    public DriverType getBrowser() {
        String browserName = properties.getProperty("browser");
        if (browserName == null || browserName.equals("chrome"))
            return DriverType.CHROME;
        else if (browserName.equalsIgnoreCase("firefox"))
            return DriverType.FIREFOX;
        else if (browserName.equals("iexplorer"))
            return DriverType.INTERNETEXPLORER;
        else
            throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }

    public EnvironmentType getEnvironment() {
        String environmentName = properties.getProperty("environment");
        if (environmentName == null || environmentName.equalsIgnoreCase("local"))
            return EnvironmentType.LOCAL;
        else if (environmentName.equals("remote"))
            return EnvironmentType.REMOTE;
        else {
            logger.error(()->"Environment Type Key value in Configuration.properties is not matched : " + environmentName);
            throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
        }
    }

    public Boolean getBrowserWindowSize() {
        String windowSize = properties.getProperty("windowMaximize");
        if (windowSize != null)
            return Boolean.valueOf(windowSize);

        return true;
    }

    public String getTestDataResourcePath() {
        String testDataResourcePath = properties.getProperty("testDataResourcePath");
        if (testDataResourcePath != null)
            return testDataResourcePath;
        else {
            logger.error(()->"Test Data Resource Path not specified in the Configuration.properties file for the Key: testDataResourcePath");
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key: testDataResourcePath");
        }
    }

}
