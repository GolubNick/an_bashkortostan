package an.framework.elements;

import an.framework.webdriver.DSL;
import org.openqa.selenium.By;

public abstract class Element extends DSL implements IElement{

    public boolean isVisible(String locator){
        return driver.findElement(By.xpath(locator)).isDisplayed();
    }
}
