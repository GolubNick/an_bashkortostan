package an.framework;

import an.framework.model.DeputatModel;
import an.framework.webdriver.WebManager;
import an.object.PageObject;

public class Test {

    private WebManager webManager = WebManager.get();
    private DeputatModel deputatModel = DeputatModel.get();

    public void startGroSovet(PageObject pageObject){
        webManager.navigateToUrl("http://gorsovet-ufa.ru/newdeputat/os/" + pageObject.getDeputy());
        deputatModel.setName(pageObject.getFio());
        deputatModel.setEmail(pageObject.getEmail());
        deputatModel.setMessage(pageObject.getMessage());
        deputatModel.setCaptcha(deputatModel.getCaptchaText());
    }
}
