package an.framework.model;

import an.framework.elements.*;

public class ProkuraturaModel {

    private static ProkuraturaModel instance ;
    private Button submit;
    private TextField name;
    private TextField sirname;
    private TextField fathername;
    private TextField email;
    private TextField telnumber;
    private TextField addresss;
    private TextField message;
    private TextField captcha;
    private Button addFile;
    private Link captchaLink;
    private ImageLink uploadImage;

    public static ProkuraturaModel get(){
        if (instance == null){
            instance = new ProkuraturaModel().init();
        }
        return instance;
    }

    private ProkuraturaModel init(){
        name = new TextField("//*[@name='name']");
        sirname = new TextField("//*[@name='lastname']");
        fathername = new TextField("//*[@name='secondname']");
        email = new TextField("//*[@name='email']");
        telnumber = new TextField("//*[@name='phone']");
        addresss = new TextField("//*[@name='addr']");
        message = new TextField("//*[@name='message']");
        captcha = new TextField("//*[@name='captcha_word']");
        submit = new Button("//*[@class='btn btn-primary btn-block' and @type='button']");
        captchaLink = new Link("//*[@id='captcha_pic']");
        addFile = new Button("//*[@class='add_file']");
        uploadImage = new ImageLink("//input[@type='file']");
        return this;
    }

    public String getCaptchaText() {
        return captchaLink.getText();
    }

    public void setName(String value) {
        name.setText(value);
    }

    public void setSirname(String value) {
        sirname.setText(value);
    }

    public void setFathername(String value) {
        fathername.setText(value);
    }

    public void setEmail(String value) {
        email.setText(value);
    }

    public void setTelnumber(String value) {
        telnumber.setText(value);
    }

    public void setAddresss(String value) {
        addresss.setText(value);
    }

    public void setMessage(String value) {
        message.setText(value);
    }

    public void setCaptcha(String value) {
        captcha.setText(value);
    }

    public void setUploadImage(String url){
        uploadImage.uploadImageFromUrl(url);
    }

    public void clickAddFile(){
        addFile.click();
    }

    public void clickSubmit(){
        submit.click();
    }
}
