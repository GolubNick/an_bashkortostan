package an.framework.elements;

import org.openqa.selenium.By;

public class ImageLink extends Element {

    public ImageLink(String locator){
        super.locator = locator;
    }

    public void uploadImageFromUrl(String url){
        driver.findElement(By.xpath(locator)).sendKeys(url);
    }
}
