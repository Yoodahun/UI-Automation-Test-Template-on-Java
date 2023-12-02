package com.yoodahun.mobileWeb.pages.home;

import com.yoodahun.mobileWeb.MobileWebBasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


// page_url = https://m.naver.com/
public class NaverHomePage extends MobileWebBasePage {
    @FindBy(xpath = "//div[@id='HOME_SHORTCUT']")
    WebElement shortcutArea;

    @FindBy(xpath = "//input[@id='query']")
    WebElement queryInputAfterClick;

    @FindBy(xpath = "//input[@id='MM_SEARCH_FAKE']")
    WebElement queryInputBeforeClick;

    public NaverHomePage(AppiumDriver driver) {
        super(driver);
    }

    public boolean checkShortcutAreaIsVisible() {


        return shortcutArea.isDisplayed();
    }

    public void searchText(String text) {
        queryInputBeforeClick.click();
        queryInputAfterClick.sendKeys(text);

        this.pressEnter();
    }
}