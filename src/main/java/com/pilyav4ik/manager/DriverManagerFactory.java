package com.pilyav4ik.manager;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type){

        DriverManager driverManager;
        switch (type){
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            case EDGE:
                driverManager = new EdgeDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
}
