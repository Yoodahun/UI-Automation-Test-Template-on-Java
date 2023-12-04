package com.yoodahun.web.pages.searchResult;

import com.yoodahun.web.pages.WebBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class NaverSearchResultPage extends WebBasePage {

    @FindBy(id = "nx_query")
    private WebElement queryInputInSearchResultPage;

    public NaverSearchResultPage(WebDriver driver) {
        super(driver);

    }

    public boolean checkQueryArea(String text) {
        logger.info(queryInputInSearchResultPage.getAttribute("value"));
        return isElementVisible(queryInputInSearchResultPage) && queryInputInSearchResultPage.getAttribute("value").equals(text);
    }

    // 여기에 isElementVisible() 메소드를 구현해야 합니다.
}