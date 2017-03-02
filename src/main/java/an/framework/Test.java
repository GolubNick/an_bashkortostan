package an.framework;

import an.framework.model.DeputatModel;
import an.framework.webdriver.WebManager;
import an.object.DeputatObject;

public class Test {

    private WebManager webManager = WebManager.get();
    private DeputatModel deputatModel = DeputatModel.get();

    public void start(DeputatObject deputatObject){
        webManager.navigateToUrl("http://gorsovet-ufa.ru/newdeputat/os/" + deputatObject.getCategory());
        deputatModel.setName(deputatObject.getFio());
        deputatModel.setEmail(deputatObject.getEmail());
        deputatModel.setMessage(deputatObject.getMessage());
        deputatModel.setCaptcha("test");
    }
}
