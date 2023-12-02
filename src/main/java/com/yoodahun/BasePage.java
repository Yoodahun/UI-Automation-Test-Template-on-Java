package com.yoodahun;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// page_url = about:blank
public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    private WebElement usingWait(WebElement element) {
        return this.wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected boolean isElementVisible(WebElement element) {
        try {
            return this.usingWait(element).isDisplayed();
        } catch (TimeoutException exception) {
            return false;
        }

    }
}