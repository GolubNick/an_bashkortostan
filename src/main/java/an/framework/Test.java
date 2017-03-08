package an.framework;

import an.framework.model.DeputatModel;
import an.framework.model.GIBDDModel;
import an.framework.model.ProkuraturaModel;
import an.framework.webdriver.WebManager;
import an.object.PageObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.util.Date;

public class Test {

    private WebManager webManager = WebManager.get();
    private DeputatModel deputatModel = DeputatModel.get();
    private ProkuraturaModel prokuraturaModel = ProkuraturaModel.get();
    private GIBDDModel gibddModel = GIBDDModel.get();

    public void startGroSovet(PageObject pageObject){
//        webManager.navigateToUrl("http://gorsovet-ufa.ru/newdeputat/os/" + pageObject.getCategory().split("_")[2] + ".php");
        webManager.getUrl("http://gorsovet-ufa.ru/newdeputat/os/" + pageObject.getCategory().split("_")[2] + ".php");
        deputatModel.setName(pageObject.getName());
        deputatModel.setEmail(pageObject.getEmail());
        deputatModel.setMessage(pageObject.getMessage());
        deputatModel.setCaptcha(deputatModel.getCaptchaText());
    }

    public void startBashProk(PageObject pageObject) throws IOException {
        webManager.navigateToUrl("http://bashprok.ru/internet_reception/" );
        prokuraturaModel.setName(pageObject.getName());
        prokuraturaModel.setSirname(pageObject.getSirname());
        if (pageObject.getFathername() != null)
            prokuraturaModel.setFathername(pageObject.getFathername());
        prokuraturaModel.setEmail(pageObject.getEmail());
        prokuraturaModel.setTelnumber(pageObject.getTelephone());
        prokuraturaModel.setAddresss(pageObject.getAddress());
        prokuraturaModel.setMessage(pageObject.getMessage());
        File file = getImageFile(pageObject);
        prokuraturaModel.setUploadImage(file.getAbsolutePath());
        prokuraturaModel.setCaptcha(prokuraturaModel.getCaptchaText());
        file.delete();
    }

    public void startGIBDDProk(PageObject pageObject) throws IOException {
        webManager.navigateToUrl("http://www.gibdd.ru/letter/" );
        gibddModel.clickFillForm();
        gibddModel.clickSelectRepublicBashkortostan();
        gibddModel.setSirname(pageObject.getSirname());
        gibddModel.setName(pageObject.getName());
        if (pageObject.getFathername() != null)
            gibddModel.setFathername(pageObject.getFathername());
        gibddModel.clickElForm();
        gibddModel.setEmail(pageObject.getEmail());
        gibddModel.setTelnumber(pageObject.getTelephone());
        gibddModel.setMessage(pageObject.getMessage());
        gibddModel.clickAddAttach();
        File file = getImageFile(pageObject);
        gibddModel.setUploadImage(file.getAbsolutePath());
        gibddModel.setCaptcha(gibddModel.getCaptchaText());
        file.delete();
    }


    private File getImageFile(PageObject pageObject) throws IOException {
        URL url = new URL(pageObject.getFile());
        BufferedImage img = ImageIO.read(url);
        String fileName = new Date().getTime() + ".jpg";
        File file = new File(fileName);
        ImageIO.write(img, "jpg", file);
        return file;
    }
}
