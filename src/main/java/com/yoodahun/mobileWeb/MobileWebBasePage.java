package com.yoodahun.mobileWeb;

import com.yoodahun.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Keys;

// page_url = about:blank
public class MobileWebBasePage extends BasePage {
    public MobileWebBasePage(AppiumDriver driver) {
        super(driver);
    }

    public void pressEnter() {
        this.actions.sendKeys(Keys.ENTER).perform();
    }
}