package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class TestFactory {

    protected WebDriver webdriver;
    protected String platform;

    /**
     * 파라미터를 커맨드라인으로부터 입력받아 초기화합니다.
     * @param platform sort of platform
     */
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

        this.webdriver = new ChromeDriver(this.setupChromeOptions());
    }

    @AfterClass
    protected void tearDownDriver() {
        this.webdriver.quit();
    }

    public ChromeOptions setupChromeOptions() {

        ChromeOptions options  = new ChromeOptions();

        options.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36");
        options.addArguments("--start-fullscreen");
        options.addArguments("--incognito");

        return options;
    }
}
