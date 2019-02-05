package com.company.app.base;

import com.company.app.util.TestUtil;
import com.company.app.util.WebEventListner;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ansari on 01/06/2019.
 */

public class TestBase {

    public static WebDriver driver;
    public static Properties properties;
    public static WebDriverWait wait;

    //To generate descriptive logs  and event firing actions
    public static EventFiringWebDriver eventFiringWebDriver ;
    public static WebEventListner webEventListner ;

    public static Logger logger;

    public static String CONFIG_FILE_PATH = "/src/main/java/com/company/app/config/config.properties";


    public TestBase() {
        /*Read and load the config property file in properties object*/
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+CONFIG_FILE_PATH);
            properties.load(fis);
        }
        catch (FileNotFoundException exception){
            exception.printStackTrace();
        }
        catch(IOException exception){
            exception.printStackTrace();
        }

    }

    public void webDriverInitialization(){
        /*Initialize the log4j*/
         loggerInitializer(this.toString());
        /*initialize driver based on the Browser selection in config file*/
        String browserType = properties.getProperty("browser");

        if(browserType.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            logger.info("Chrome driver initialized");

        }
        else if (browserType.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();

        }
        else if (browserType.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/MicrosoftWebDriver.exe");
            driver = new EdgeDriver();

        }

        /*Create and register the WebeventListner object to WebFiringEventLister*/

        webEventListner = new WebEventListner();
        eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(webEventListner);

        //driver object used throughout the test should have the capability of Web Event Firing
        driver = eventFiringWebDriver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(properties.getProperty("url"));

    }


    public void loggerInitializer(String className){
        logger=Logger.getLogger(className);
        PropertyConfigurator.configure("log4j.properties");

    }
}
