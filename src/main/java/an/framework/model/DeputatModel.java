package an.framework.model;

import an.framework.elements.Button;
import an.framework.elements.Link;
import an.framework.elements.TextField;

public class DeputatModel {

    private static DeputatModel instance ;
    private Button submit;
    private TextField name;
    private TextField email;
    private TextField message;
    private TextField captcha;
    private Link captchaLink;
    private final String UFAGORSOVET = "http://gorsovet-ufa.ru";

    public static DeputatModel get(){
        if (instance == null){
            instance = new DeputatModel().init();
        }
        return instance;
    }

    private DeputatModel init(){
        name = new TextField("//*[@name='user_name']");
        email = new TextField("//*[@name='user_email']");
        message = new TextField("//*[@name='MESSAGE']");
        captcha = new TextField("//*[@name='captcha_word']");
        submit = new Button("//*[@name='submit']");
        captchaLink = new Link("//*[@name='captcha_sid']/following-sibling::img");
        return this;
    }

    public void setName(String text){
     name.setText(text);
    }

    public void setEmail(String text){
        email.setText(text);
    }

    public void setMessage(String text){
        message.setText(text);
    }

    public void setCaptcha(String text){
        captcha.setText(text);
    }

    public void clickSubmit(){
        submit.click();
    }

    public String getCaptchaText() {
        return captchaLink.getText();
    }
}
