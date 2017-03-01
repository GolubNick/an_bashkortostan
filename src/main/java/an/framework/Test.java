package an.framework;

import an.framework.model.Deputat;
import an.framework.webdriver.WebManager;

public class Test {

    private Deputat deputat = Deputat.get();
    private WebManager webManager = WebManager.get();

    public void start(){
        webManager.navigateToUrl("http://gorsovet-ufa.ru/newdeputat/os/zubairov.php");
        deputat.setName("test");
        deputat.setEmail("test");
        deputat.setMessage("test");
        deputat.setCaptcha("test");
    }
}
