package com.pilyav4ik.manager;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.service.DriverService;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class FirefoxDriverManager extends DriverManager{

    private FirefoxDriverService firefoxDriverService;

    void startService() throws IOException {
        if (firefoxDriverService == null) {
            firefoxDriverService = new GeckoDriverService.Builder()
                    .usingDriverExecutable(new File(
                            System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\geckodriver.exe"))
                    .usingAnyFreePort()
                    .build();
            firefoxDriverService.start();
        }
    }

    void stopService() {
        if (firefoxDriverService != null && firefoxDriverService.isRunning()){
            firefoxDriverService.stop();
        }
    }

    void createDriver() {
        driver = new FirefoxDriver(firefoxDriverService);
    }
}
