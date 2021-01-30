package com.registration.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class WebDriverBase {
    public  static WebDriver driver;
    public  static Properties prop;

    public WebDriverBase()  {
        prop=new Properties();
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
            prop.load(fis);
        }catch (Exception e){
            e.getMessage();
        }

    }
    public static void initialBrowser(){
        String browser= prop.getProperty("browser");
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
            driver=new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")) {
            driver=new FirefoxDriver();
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }



public static void close(){

        driver.quit();
}

}
