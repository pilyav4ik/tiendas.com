package com.pilyav4ik.manager;


import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;

import java.io.File;

public class EdgeDriverManager extends DriverManager {

    private EdgeDriverService edgeDriverService;

    void startService() {
        if (edgeDriverService == null){
            edgeDriverService = new EdgeDriverService.Builder()
                    .usingDriverExecutable(new File(
                            System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\msedgedriver.exe"))
                    .usingAnyFreePort()
                    .build();
        }
    }

    void stopService() {
        if (edgeDriverService != null && edgeDriverService.isRunning()){
            edgeDriverService.stop();
        }
    }

    void createDriver() {
        driver = new EdgeDriver(edgeDriverService);
    }
}
