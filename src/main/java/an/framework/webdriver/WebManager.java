package an.framework.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebManager {

    private static ThreadLocal<WebManager> instance = new ThreadLocal<>();
    private WebDriver driver;

    public static WebManager get() {
        if (instance.get() == null) {
            instance.set(new WebManager().init());
        }
        return instance.get();
    }

    private WebManager init() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return this;
    }

    public void navigateToUrl(String url) {
        driver.navigate().to(url);
    }

    public void getUrl(String url) {
        driver.get(url);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void closeDriver(){
        driver.quit();
    }

    public boolean isAlertPresent(){
        try {
            driver.switchTo().alert();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
