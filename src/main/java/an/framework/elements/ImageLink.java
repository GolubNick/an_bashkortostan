package an.framework.elements;

import org.openqa.selenium.By;

public class ImageLink extends Element {

    private String locator;

    public ImageLink(String locator){
        this.locator = locator;
    }

    public void uploadImageFromUrl(String url){
        driver.findElement(By.xpath(locator)).sendKeys(url);
    }
}
