package web;

import com.yoodahun.web.pages.home.NaverHomePage;
import com.yoodahun.web.pages.searchResult.NaverSearchResultPage;
import factory.TestFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNaver extends TestFactory {

    String searchKeyword;

    @Test
    public void testNaverHome() {
        NaverHomePage naverHomePage = new NaverHomePage(this.webdriver);
        System.out.println("print_for_testcase");
        Assert.assertTrue(naverHomePage.checkShortcutAreaIsVisible());
        searchKeyword = "이것은 셀레니움 테스트 코드 입니다.";
        naverHomePage.searchText(searchKeyword);
    }

    @Test
    public void testNaverSearchResultPage() {
        System.out.println("print_for_testcase");
        NaverSearchResultPage naverSearchResultPage = new NaverSearchResultPage(this.webdriver);
        Assert.assertTrue(naverSearchResultPage.checkQueryArea(searchKeyword));

        usingSleep(1000);

    }

}
