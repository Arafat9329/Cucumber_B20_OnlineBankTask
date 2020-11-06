package com.zerobank.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/*
public class Driver {
    private static WebDriver driver;

    private Driver() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("No such a browser yet!");
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

 */

public class Driver {

    private  static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private Driver(){}

    public  static WebDriver getDriver(){
        if (driverThreadLocal.get()==null){
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverThreadLocal.set( new ChromeDriver() );
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverThreadLocal .set( new FirefoxDriver());
                    break;
            }
        }
        //driverThreadLocal.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driverThreadLocal.get();
    }

    public  static void closeDriver(){

        if (driverThreadLocal.get()!=null){
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }

}
