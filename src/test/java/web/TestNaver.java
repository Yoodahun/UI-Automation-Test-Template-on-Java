package web;

import factory.TestFactory;
import org.testng.annotations.Test;

public class TestNaver extends TestFactory {

    @Test
    public void testNaver() {
        webdriver.get("https://www.naver.com");
    }

}
