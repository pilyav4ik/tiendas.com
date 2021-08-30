package com.pilyav4ik.driver;

import com.pilyav4ik.manager.DriverManager;
import com.pilyav4ik.manager.DriverManagerFactory;
import com.pilyav4ik.manager.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;

public class BaseUtil {

    public WebDriver driver;
    DriverManager driverManager;

    @BeforeMethod
    @Parameters("browserName")
    public void setUp(@Optional String browserName) throws IOException {
        getLocalDriver(browserName);
        driver.manage().window().maximize();
        driver.navigate().to("https://tiendas.com");
    }

    public WebDriver getLocalDriver(String browserName) throws IOException {
        if (browserName.equalsIgnoreCase("Chrome")) {
            driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
            driver = driverManager.getDriver();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
        } else if (browserName.equalsIgnoreCase("Firefox")) {
                driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
                driver = driverManager.getDriver();
        }

        return driver;
    }

    @AfterMethod
    public void tearDown(){
        driverManager.quitDriver();
    }
}
