package an.framework.elements;

import org.openqa.selenium.By;

public class Button extends Element{

    public Button(String locator){
        super.locator = locator;
    }

    public void click(){
        driver.findElement(By.xpath(locator)).click();
    }
}
