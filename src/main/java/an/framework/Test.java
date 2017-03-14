package an.framework;

import an.framework.filehelper.FileHelper;
import an.framework.model.DeputatModel;
import an.framework.model.GIBDDModel;
import an.framework.model.ProkuraturaModel;
import an.framework.webdriver.WebManager;
import an.object.PageObject;

import java.io.*;

public class Test {

    private WebManager webManager = WebManager.get();
    private DeputatModel deputatModel = DeputatModel.get();
    private ProkuraturaModel prokuraturaModel = ProkuraturaModel.get();
    private GIBDDModel gibddModel = GIBDDModel.get();
    private String code = "200 Ok";

    public String startGroSovet(PageObject pageObject){
        webManager.getUrl("http://gorsovet-ufa.ru/newdeputat/os/" + pageObject.getCategory().split("_")[2] + ".php");
        deputatModel.setName(pageObject.getName());
        deputatModel.setEmail(pageObject.getEmail());
        deputatModel.setMessage(pageObject.getMessage());
        deputatModel.setCaptcha(deputatModel.getCaptchaText());
//        deputatModel.clickSubmit();
        if (deputatModel.isErrorTextVisible())
            code = "400 Bad request";
        return code;
    }

    public String startBashProk(PageObject pageObject) throws IOException {
        webManager.navigateToUrl("http://bashprok.ru/internet_reception/" );
        prokuraturaModel.setName(pageObject.getName());
        prokuraturaModel.setSirname(pageObject.getSirname());
        if (pageObject.getFathername() != null)
            prokuraturaModel.setFathername(pageObject.getFathername());
        prokuraturaModel.setEmail(pageObject.getEmail());
        if (pageObject.getTelephone() != null)
            prokuraturaModel.setTelnumber(pageObject.getTelephone());
        if (pageObject.getAddress() != null)
            prokuraturaModel.setAddresss(pageObject.getAddress());
        prokuraturaModel.setMessage(pageObject.getMessage());
        File file = null;
        if (pageObject.getFile() != null){
            file = FileHelper.getImageFile(pageObject);
            prokuraturaModel.setUploadImage(file.getAbsolutePath());
        }
        prokuraturaModel.setCaptcha(prokuraturaModel.getCaptchaText());
        prokuraturaModel.clickSubmit();
        if (webManager.isAlertPresent())
            code = "400 Bad Request";
        if (file != null)
            FileHelper.fileDelete(file);
        return code;
    }

    public String startGIBDDProk(PageObject pageObject) throws IOException {
        webManager.navigateToUrl("http://www.gibdd.ru/letter/");
        gibddModel.clickFillForm();
        gibddModel.clickSelectRepublicBashkortostan();
        gibddModel.setSirname(pageObject.getSirname());
        gibddModel.setName(pageObject.getName());
        if (pageObject.getFathername() != null)
            gibddModel.setFathername(pageObject.getFathername());
        gibddModel.clickElForm();
        gibddModel.setEmail(pageObject.getEmail());
        if (pageObject.getTelephone() != null)
            gibddModel.setTelnumber(pageObject.getTelephone());
        gibddModel.setMessage(pageObject.getMessage());
        gibddModel.clickAddAttach();
        File file = null;
        if (pageObject.getFile() != null) {
             file = FileHelper.getImageFile(pageObject);
            gibddModel.setUploadImage(file.getAbsolutePath());
        }
        gibddModel.setCaptcha(gibddModel.getCaptchaText());
//        gibddModel.clickSubmit();
        if (webManager.isAlertPresent() || gibddModel.isIncorrectCaptchaAlertVisible())
            code = "400 Bad Request";
        if (file != null)
            FileHelper.fileDelete(file);
        return code;
    }

    public void closeDriver(){
        webManager.closeDriver();
    }


}
