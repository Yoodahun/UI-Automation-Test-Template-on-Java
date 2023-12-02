package com.yoodahun.mobileWeb.pages.searchResult;

import com.yoodahun.mobileWeb.MobileWebBasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NaverSearchResultPage extends MobileWebBasePage {

    @FindBy(xpath = "//input[@id='nx_query']")
    WebElement queryInputInSearchResultPage;
    public NaverSearchResultPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean checkQueryArea(String text) {

        return queryInputInSearchResultPage.isDisplayed() &&
                queryInputInSearchResultPage.getAttribute("value").equals(text);
    }
}
