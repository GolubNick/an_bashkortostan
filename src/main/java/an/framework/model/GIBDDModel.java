package an.framework.model;

import an.framework.elements.*;

public class GIBDDModel {

    private static ThreadLocal<GIBDDModel> instance  = new ThreadLocal<>();

    private TextField name;
    private TextField sirname;
    private TextField fathername;
    private TextField email;
    private TextField telnumber;
    private TextField message;
    private TextField captcha;
    private Link captchaLink;
    private Label alertCaptcha;
    private Button submit;
    private Button fillForm;
    private Button selectRepublicBashkortostan;
    private Button addAttach;
    private RadioButton elForm;

    private ImageLink uploadImage;

    public static GIBDDModel get(){
        if (instance.get() == null){
            instance.set(new GIBDDModel().init());
        }
        return instance.get();
    }

    private GIBDDModel init(){
        name = new TextField("//*[@name='f_name']");
        sirname = new TextField("//*[@name='f_fam']");
        fathername = new TextField("//*[@name='f_coname']");
        email = new TextField("//*[@name='f_email']");
        telnumber = new TextField("//*[@name='f_phone']");
        message = new TextField("//*[@name='f_msg']");
        captcha = new TextField("//*[@name='captcha_word']");
        submit = new Button("//*[@id='sendletter']");
        captchaLink = new Link("//*[@class='captcha_pic']");
        fillForm= new Button("//*[@id='iread']");
        addAttach= new Button("//*[@class='add_attach']");
        selectRepublicBashkortostan= new Button("//*[@id='fancybox-content']//li[2]/a");
        elForm= new RadioButton("//*[@name='f_answer_method' and @value='615']");
        uploadImage = new ImageLink("//input[@type='file']");
        alertCaptcha = new Label("//*[@id='fancybox-close' and @style='display: inline;']");
        return this;
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

    public void setMessage(String value) {
        message.setText(value);
    }

    public void setCaptcha(String value) {
        captcha.setText(value);
    }

    public void clickSubmit(){
        submit.click();
    }

    public void clickFillForm(){
        fillForm.click();
    }

    public void clickSelectRepublicBashkortostan(){
        selectRepublicBashkortostan.click();
    }

    public void clickAddAttach(){
        addAttach.click();
    }

    public void clickElForm(){
        elForm.click();
    }

    public void setUploadImage(String url){
        uploadImage.uploadImageFromUrl(url);
    }

    public String getCaptchaText() {
        return captchaLink.getText();
    }

    public boolean isIncorrectCaptchaAlertVisible(){
        return alertCaptcha.isVisible();
    }
}
