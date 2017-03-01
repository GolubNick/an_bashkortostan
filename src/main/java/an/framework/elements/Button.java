package an.framework.elements;

import org.openqa.selenium.By;

public class Button extends Element{

    private String locator;

    public Button(String locator){
        this.locator = locator;
    }

    public void click(){
        driver.findElement(By.xpath(locator)).click();
    }
}
