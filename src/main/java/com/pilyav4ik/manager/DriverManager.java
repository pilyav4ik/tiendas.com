package com.pilyav4ik.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public abstract class DriverManager {

    WebDriver driver;

    abstract void startService() throws IOException;
    abstract void stopService();
    abstract void  createDriver();


    public void quitDriver(){
        if (driver != null){
            driver.quit();
        }
    }

    public WebDriver getDriver() throws IOException {
        if (driver == null){
            startService();
            createDriver();
        }
        return driver;
    }
}
