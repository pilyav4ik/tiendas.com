package com.pilyav4ik.driver;

import com.pilyav4ik.manager.DriverManager;
import com.pilyav4ik.manager.DriverManagerFactory;
import com.pilyav4ik.manager.DriverType;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class BaseUtil {

    public WebDriver driver;
    DriverManager driverManager;

    @BeforeMethod
    @Parameters({"browserName", "url"})
    public void setUp(@Optional String browserName, String url) throws IOException {
        getLocalDriver(browserName);
        driver.manage().window().maximize();
        driver.navigate().to(url);
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
    public void tearDown(ITestResult result){
        if(ITestResult.FAILURE==result.getStatus())
        {
            try
            {
                TakesScreenshot ts=(TakesScreenshot)driver;
                File source=ts.getScreenshotAs(OutputType.FILE);
                try{
                    FileHandler.copy(source, new File("./Screenshots/"+result.getName()+".png"));
                    System.out.println("Screenshot taken");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            catch (Exception e)
            {
                System.out.println("Exception while taking screenshot "+e.getMessage());
            }
        }
        driverManager.quitDriver();
    }

}
