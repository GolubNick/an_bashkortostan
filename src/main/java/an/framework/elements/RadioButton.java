package an.framework.elements;

import org.openqa.selenium.By;

public class RadioButton extends Element{

    private String locator;

    public RadioButton(String locator){
        this.locator = locator;
    }

    public void click(){
        driver.findElement(By.xpath(locator)).click();
    }
}
