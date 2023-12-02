package factory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.options.BaseOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class TestFactory {

    protected WebDriver driver;
    protected String platform;

    /**
     * 파라미터를 커맨드라인으로부터 입력받아 초기화합니다.
     * @param platform sort of platform
     */
    @Parameters({"platform"})
    @BeforeSuite
    protected void setupParameter(String platform) {

        this.platform = platform.toLowerCase();
        System.out.println(this.platform);

        if ("pc_chrome".equals(this.platform)) {
            WebDriverManager.chromedriver().setup();
        }
    }


    @BeforeClass
    protected void setupDriver(){
        if ("pc_chrome".equals(this.platform)) {
            this.driver = new ChromeDriver(this.setupChromeOptions());

        } else {
            try {
                this.driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), this.setupMobileOptions());
            } catch (MalformedURLException exception) {
                exception.printStackTrace();
            }
        }

        this.driver.get("https://www.naver.com");

    }

    @AfterClass
    protected void tearDownDriver() {
        this.driver.quit();
        this.driver = null;
    }

    public ChromeOptions setupChromeOptions() {

        ChromeOptions options  = new ChromeOptions();

        options.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36");
        options.addArguments("--start-fullscreen");
        options.addArguments("--incognito");

        return options;
    }

    public BaseOptions setupMobileOptions() {
        BaseOptions options;

        if ("android".equals(this.platform) || "aos_chrome".equals(this.platform)) {
            options = new UiAutomator2Options();
            options.setCapability("browserName","Chrome");

        } else { //ios
            options = new XCUITestOptions();
        }

        return options;
    }

    protected void usingSleep(long time) {
        try {
            Thread.sleep(time);
        }catch (InterruptedException e)  {
            e.printStackTrace();
        }
    }

    protected Properties getProperties(String fileName) {
        String filePath = "src/test/resources/" + fileName + ".properties";

        try {
            FileReader resource = new FileReader(filePath);
            Properties props = new Properties();

            props.load(resource);
            return props;
        } catch (IOException exception) {
            exception.printStackTrace();
            return null;
        }

    }
}
