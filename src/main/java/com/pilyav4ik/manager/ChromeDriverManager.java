package com.pilyav4ik.manager;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class ChromeDriverManager  extends DriverManager{

    private ChromeDriverService chromeDriverService;
    ChromeOptions options = new ChromeOptions();
    void startService() {
        if (chromeDriverService == null){
            options.setHeadless(true);
            chromeDriverService = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(
                            System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe"))

                    .usingAnyFreePort()
                    .build();
        }
    }

    void stopService() {
        if (chromeDriverService != null && chromeDriverService.isRunning()){
            chromeDriverService.stop();
        }
    }

    void createDriver() {
        driver = new ChromeDriver(chromeDriverService);
    }
}
