package com.pilyav4ik.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait webDriverWait;
    @FindBy(className = "swiper-slide")
    private List<WebElement> carouselOnHomePage;
    @FindBy(xpath = "//h1[contains(text(),'myPhone HAMMER')]")
    private WebElement titleOnProductPage;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }




    public void popUpIsVisible() {

        System.out.println("Text -> "+ carouselOnHomePage.get(1).getText());
        String tag = carouselOnHomePage.get(1).getTagName();
        System.out.println(tag);
        carouselOnHomePage.get(1).click();

        String title = titleOnProductPage.getText();
        System.out.println("Title -> "+title);
    }
}
