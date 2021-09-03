package com.pilyav4ik;

import com.pilyav4ik.driver.BaseUtil;
import com.pilyav4ik.pages.BasePage;
import com.pilyav4ik.utils.RetryAnalyzer;
import org.testng.annotations.Test;



public class TestsRunner extends BaseUtil {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void AcceptCookies(){
        BasePage basePage = new BasePage(driver);
        basePage.clickToAcceptCookies();
    }
}
