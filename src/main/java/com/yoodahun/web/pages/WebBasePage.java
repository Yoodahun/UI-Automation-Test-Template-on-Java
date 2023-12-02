package com.yoodahun.web.pages;

import com.yoodahun.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

// page_url = https://www.naver.com/
public class WebBasePage extends BasePage {
    public WebBasePage(WebDriver driver) {
        super(driver);
    }

    public void pressEnter() {
        this.actions.sendKeys(Keys.RETURN).perform();
    }
}