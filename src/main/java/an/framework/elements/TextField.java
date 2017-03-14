package an.framework.elements;

import org.openqa.selenium.By;

public class TextField extends Element{

    public TextField(String locator){
        super.locator = locator;
    }

    public void setText(String text){
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }
}
