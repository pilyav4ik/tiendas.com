package com.pilyav4ik.definition;

import com.pilyav4ik.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageDefinition {

    private WebDriver webDriver;
    private BasePage basePage;

    public BasePageDefinition(WebDriver webDriver, BasePage basePage) {
        this.webDriver = webDriver;
        this.basePage = basePage;
        PageFactory.initElements(webDriver, this);
    }

    public void clickToAcceptCookies(){
        basePage.clickToAcceptCookies();
    }

    public void inputSearchText(){
        basePage.inputSearchText();
    }
    public void textVisability(){
        basePage.textVisability();
    }

}
