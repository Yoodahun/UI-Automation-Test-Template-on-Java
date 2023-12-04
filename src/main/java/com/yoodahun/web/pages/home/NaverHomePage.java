package com.yoodahun.web.pages.home;

import com.yoodahun.web.pages.WebBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


// page_url = https://www.naver.com
public class NaverHomePage extends WebBasePage {


    @FindBy(id = "shortcutArea")
    WebElement shortcutArea;
    @FindBy(id="query")
    WebElement queryInput;
    public NaverHomePage(WebDriver driver) {
        super(driver);
    }

    public boolean checkShortcutAreaIsVisible() {
        logger.info(shortcutArea);

        return shortcutArea.isDisplayed();
    }

    public void searchText(String text) {
        logger.info("searchText");
        queryInput.click();
        queryInput.sendKeys(text);

        this.pressEnter();
    }





}