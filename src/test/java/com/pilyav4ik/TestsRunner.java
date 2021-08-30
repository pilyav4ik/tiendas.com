package com.pilyav4ik;

import com.pilyav4ik.driver.BaseUtil;
import com.pilyav4ik.pages.BasePage;
import org.testng.annotations.Test;



public class TestsRunner extends BaseUtil {

    @Test
    public void test1(){
        BasePage basePage = new BasePage(driver);
        basePage.clickToAcceptCookies();
    }

}
