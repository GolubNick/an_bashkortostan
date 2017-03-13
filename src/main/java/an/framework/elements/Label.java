package an.framework.elements;

import org.openqa.selenium.By;

public class Label extends Element{

    private String locator;

    public Label(String locator){
        this.locator = locator;
    }

    public String getText(){
        return driver.findElement(By.xpath(locator)).getText();
    }
}
