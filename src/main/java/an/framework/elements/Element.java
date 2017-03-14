package an.framework.elements;

import an.framework.webdriver.DSL;
import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class Element extends DSL implements IElement{
    String locator;

    public boolean isVisible(){
        try{
        return driver.findElement(By.xpath(locator)).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public void waitForElement() {
         Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(locator));
            }
        });
    }
}
