package com.pilyav4ik.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private int limit = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count < limit){
            count++;
            return true;
        }
        return false;
    }
}
