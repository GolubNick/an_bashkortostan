package an.controllers;

import an.framework.Test;
import an.object.PageObject;
import an.object.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class MainController {

    @Autowired
    PageService pageService;

    @RequestMapping(path = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void postPage(@RequestBody PageObject pageObject) {
        new Thread() {
            public void run() {
                try {
                    Test testObject = new Test();
                    if (pageObject.getCategory().contains("gorsovet_ufa"))
                        testObject.startGroSovet(pageService.createService(pageObject));
                    else if (pageObject.getCategory().contains("bashprok"))
                        testObject.startBashProk(pageService.createService(pageObject));
                    else if (pageObject.getCategory().contains("gibdd_rb"))
                        testObject.startGIBDDProk(pageService.createService(pageObject));
                    testObject.closeDriver();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
