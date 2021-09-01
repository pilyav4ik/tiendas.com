package com.pilyav4ik.manager;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;
import java.io.IOException;

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

    void startServiceInHeadless() {
        if (firefoxDriverService == null){
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            firefoxDriverService = new GeckoDriverService.Builder()
                    .usingDriverExecutable(new File(
                            System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\geckodriver.exe"))
                    .usingAnyFreePort()
                    .build();
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
