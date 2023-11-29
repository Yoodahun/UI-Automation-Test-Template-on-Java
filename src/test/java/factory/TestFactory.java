package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class TestFactory {

    protected WebDriver webdriver;
    protected String platform;


    @Parameters({"platform"})
    @BeforeSuite
    protected void setupParameter(String platform) {
        this.platform = platform.toLowerCase();

        if ("pc_chrome".equals(this.platform)) {
            WebDriverManager.chromedriver().setup();
        }
    }


    @BeforeClass
    protected void setupDriver(){
        this.webdriver = new ChromeDriver();
    }

    @AfterClass
    protected void tearDownDriver() {
        this.webdriver.quit();
    }
}
