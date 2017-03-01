package an.framework.model;

import an.framework.elements.Button;
import an.framework.elements.TextField;
import an.framework.webdriver.DSL;

public class Deputat {

    private static Deputat instance ;
    private Button submit;
    private TextField name;
    private TextField email;
    private TextField message;
    private TextField captcha;

    public static Deputat get(){
        if (instance == null){
            instance = new Deputat().init();
        }
        return instance;
    }

    private Deputat init(){
        name = new TextField("//*[@name='user_name']");
        email = new TextField("//*[@name='user_email']");
        message = new TextField("//*[@name='MESSAGE']");
        captcha = new TextField("//*[@name='captcha_word']");
        submit = new Button("//*[@name='submit']");
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
}
