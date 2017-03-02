package an.framework.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

public class WebManager {

    private static WebManager instance;
    private WebDriver driver;
//    private HtmlUnitDriver driver;

    public static WebManager get() {
        if (instance == null) {
            instance = new WebManager().init();
        }
        return instance;
    }

    private WebManager init() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
//        driver = new HtmlUnitDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return this;
    }

    public void navigateToUrl(String url) {
        driver.navigate().to(url);
    }

    public WebDriver getDriver(){
        return driver;
    }
}
