package com.pilyav4ik.utils;

import com.pilyav4ik.driver.BaseUtil;
import io.qameta.allure.Attachment;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseUtil implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message){
        return message;
    }
}
