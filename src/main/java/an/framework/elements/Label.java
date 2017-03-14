package an.framework.elements;

import org.openqa.selenium.By;

public class Label extends Element{

    public Label(String locator){
        super.locator = locator;
    }

    public String getText(){
        return driver.findElement(By.xpath(locator)).getText();
    }
}
