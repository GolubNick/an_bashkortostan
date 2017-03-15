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
    private String code = "Send";

    public String startGroSovet(PageObject pageObject){
        webManager.getUrl("http://gorsovet-ufa.ru/newdeputat/os/" + pageObject.getCategory().split("_")[2] + ".php");
        String fatherName = pageObject.getFathername() == null ? "" : pageObject.getFathername();
        deputatModel.setName(pageObject.getName() + " " + pageObject.getSirname() + " " + fatherName);
        deputatModel.setEmail(pageObject.getEmail());
        deputatModel.setMessage(pageObject.getMessage());
        deputatModel.setCaptcha(deputatModel.getCaptchaText());
        deputatModel.clickSubmit();
        if (deputatModel.isErrorTextVisible())
            code = "Error";
        return code;
    }

    public String startBashProk(PageObject pageObject) throws IOException {
        webManager.navigateToUrl("http://bashprok.ru/internet_reception/" );
        prokuraturaModel.setName(pageObject.getName());
        prokuraturaModel.setSirname(pageObject.getSirname());
        if (pageObject.getFathername() != null)
            prokuraturaModel.setFathername(pageObject.getFathername());
        prokuraturaModel.setEmail(pageObject.getEmail());
        String telephone = pageObject.getAddress() == null ? "0000000000" : pageObject.getTelephone();
        prokuraturaModel.setTelnumber(telephone);
        String address = pageObject.getAddress() == null ? "не соответствие федерального закона" : pageObject.getAddress();
        prokuraturaModel.setAddresss(address);
        prokuraturaModel.setMessage(pageObject.getMessage());
        File file = null;
        if (pageObject.getFile() != null){
            file = FileHelper.getImageFile(pageObject);
            prokuraturaModel.setUploadImage(file.getAbsolutePath());
        }
        prokuraturaModel.setCaptcha(prokuraturaModel.getCaptchaText());
        prokuraturaModel.clickSubmit();
        if (webManager.isAlertPresent())
            code = "Error";
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
        String telephone = pageObject.getAddress() == null ? "0000000000" : pageObject.getTelephone();
        gibddModel.setTelnumber(telephone);
        gibddModel.setMessage(pageObject.getMessage());
        gibddModel.clickAddAttach();
        File file = null;
        if (pageObject.getFile() != null) {
             file = FileHelper.getImageFile(pageObject);
            gibddModel.setUploadImage(file.getAbsolutePath());
        }
        gibddModel.setCaptcha(gibddModel.getCaptchaText());
        gibddModel.clickSubmit();
        if (webManager.isAlertPresent() || gibddModel.isIncorrectCaptchaAlertVisible())
            code = "Error";
        if (file != null)
            FileHelper.fileDelete(file);
        return code;
    }

    public void closeDriver(){
        webManager.closeDriver();
    }


}
