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
    public String postPage(@RequestBody PageObject pageObject) {
        String responce = "";
        Test testObject = null;
                try {
                    testObject = new Test();
                    if (pageObject.getCategory().contains("gorsovet_ufa"))
                        responce = testObject.startGroSovet(pageService.createService(pageObject));
                    else if (pageObject.getCategory().contains("bashprok"))
                        responce = testObject.startBashProk(pageService.createService(pageObject));
                    else if (pageObject.getCategory().contains("gibdd_rb"))
                        responce = testObject.startGIBDDProk(pageService.createService(pageObject));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    testObject.closeDriver();
                }
        System.out.println(responce.contains("200") ? "Task success" : "Task failed");
        return responce;
    }
}
