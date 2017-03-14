package an.framework.elements;

import org.openqa.selenium.By;

public class RadioButton extends Element{

    public RadioButton(String locator){
        super.locator = locator;
    }

    public void click(){
        driver.findElement(By.xpath(locator)).click();
    }
}
