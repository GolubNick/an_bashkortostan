package an.framework.elements;

import an.helpers.GetTextFromCatpchaImage;
import org.openqa.selenium.By;

public class Link  extends Element{

    private String locator;

    public Link(String locator){
        this.locator = locator;
    }

    public String getText(){
        return new GetTextFromCatpchaImage().exampleImageToText(driver.findElement(By.xpath(locator)).getAttribute("src"));
    }
}
