package mobileWeb;

import com.yoodahun.mobileWeb.pages.home.NaverHomePage;
import com.yoodahun.mobileWeb.pages.searchResult.NaverSearchResultPage;
import factory.TestFactory;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNaverMobile extends TestFactory {

    String searchKeyword;

    @Test
    public void testNaverHomeMobile() {
        NaverHomePage naverHomePage = new NaverHomePage((AppiumDriver) this.driver);
        System.out.println("print_for_testcase");
        Assert.assertTrue(naverHomePage.checkShortcutAreaIsVisible());
        searchKeyword = "이것은 셀레니움 테스트 코드 입니다.";
        naverHomePage.searchText(searchKeyword);
    }

    @Test
    public void testNaverSearchResultPage() {
        System.out.println("print_for_testcase");
        NaverSearchResultPage naverSearchResultPage = new NaverSearchResultPage((AppiumDriver) this.driver);
        Assert.assertTrue(naverSearchResultPage.checkQueryArea(searchKeyword));

        usingSleep(1000);

    }
}