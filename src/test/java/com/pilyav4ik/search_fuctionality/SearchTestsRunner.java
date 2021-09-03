package com.pilyav4ik.search_fuctionality;

import com.pilyav4ik.driver.BaseUtil;
import com.pilyav4ik.pages.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchTestsRunner extends BaseUtil {

    @Test
    public void searchOnHomePage() throws InterruptedException {

        BasePage basePage = new BasePage(driver);
        basePage.clickToAcceptCookies();
        basePage.inputSearchText("iphone xr");

        String text = basePage.getProductNameAfterSearch();

        Assert.assertTrue(text.contains("Apple iPhone XR"));

    }
}
