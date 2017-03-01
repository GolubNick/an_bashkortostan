package an.framework.webdriver;

import org.openqa.selenium.WebDriver;

public abstract class DSL {

    protected WebDriver driver = WebManager.get().getDriver();


}
