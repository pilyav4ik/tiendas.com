package com.pilyav4ik.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//span[contains(text(),'Aceptar')]")
    WebElement acceptCookies;

    @FindBy(xpath = "//span[contains(text(),'Cookies')]")
    WebElement textVisible;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;

    @FindBy(xpath = "//*[@id=\"hits\"]/div/div/ol/li")
    List<WebElement> productName;

    public void clickToAcceptCookies(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(acceptCookies));
        acceptCookies.click();
    }

    public void inputSearchText(String searchText){
        searchField.sendKeys("iPhone XR");
        searchField.sendKeys(Keys.ENTER);
    }

    public boolean textVisability(){
        webDriverWait.until(ExpectedConditions.visibilityOf(textVisible));
        if (!textVisible.isDisplayed()){
            return true;
        }
        return false;
    }

    public String getProductNameAfterSearch() throws InterruptedException {
        Thread.sleep(2000);
        return productName.iterator().next().getText();
    }
}
