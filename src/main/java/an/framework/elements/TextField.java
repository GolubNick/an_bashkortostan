package an.framework.elements;

import org.openqa.selenium.By;

public class TextField extends Element{

    private String locator;

    public TextField(String locator){
        this.locator = locator;
    }

    public void setText(String text){
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }
}
