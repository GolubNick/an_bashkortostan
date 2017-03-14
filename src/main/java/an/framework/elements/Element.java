package an.framework.elements;

import an.framework.webdriver.DSL;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public abstract class Element extends DSL implements IElement{
    String locator;

    public boolean isVisible(){
        try{
        return driver.findElement(By.xpath(locator)).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }


    public void waitForElement(){
        try {
            driver.findElement(By.xpath(locator)).wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
