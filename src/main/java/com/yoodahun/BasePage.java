package com.yoodahun;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    protected final Logger logger;

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;



    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        this.logger = LogManager.getLogger(this.getClass());
    }

    /**
     * wait를 사용하여 element가 보이는지를 식별합니다.
     * @param element WebElement
     * @return WebElement
     */
    private WebElement usingWait(WebElement element) {
        return this.wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected boolean isElementVisible(WebElement element) {
        logger.info("isElementVisible is execute");
        try {
            return this.usingWait(element).isDisplayed();
        } catch (TimeoutException exception) {
            return false;
        }

    }
}