package an.framework.model;

import an.framework.elements.Button;
import an.framework.elements.Link;
import an.framework.elements.TextField;

public class GIBDDModel {

    private static GIBDDModel instance ;
    private Button submit;
    private TextField name;
    private TextField sirname;
    private TextField fathername;
    private TextField email;
    private TextField telnumber;
    private TextField addresss;
    private TextField message;
    private TextField captcha;
    private Link captchaLink;

    public static GIBDDModel get(){
        if (instance == null){
            instance = new GIBDDModel().init();
        }
        return instance;
    }

    private GIBDDModel init(){
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
        return this;
    }
}
