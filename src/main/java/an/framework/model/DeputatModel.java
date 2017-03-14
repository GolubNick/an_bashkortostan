package an.framework.model;

import an.framework.elements.Button;
import an.framework.elements.Label;
import an.framework.elements.Link;
import an.framework.elements.TextField;

public class DeputatModel {

    private static ThreadLocal<DeputatModel> instance = new ThreadLocal<>();
    private Button submit;
    private TextField name;
    private TextField email;
    private TextField message;
    private TextField captcha;
    private Label errorText;
    private Link captchaLink;

    public static DeputatModel get(){
        if (instance.get() == null){
            instance.set(new DeputatModel().init());
        }
        return instance.get();
    }

    private DeputatModel init(){
        name = new TextField("//*[@name='user_name']");
        email = new TextField("//*[@name='user_email']");
        message = new TextField("//*[@name='MESSAGE']");
        captcha = new TextField("//*[@name='captcha_word']");
        errorText = new Label("//*[@class='errortext']");
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

    public boolean isErrorTextVisible(){
        return errorText.isVisible(errorText.toString());
    }
}
