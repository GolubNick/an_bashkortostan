package an.controllers;

import an.framework.Test;
import an.framework.jsoup.GetCaptchaValue;
import an.object.PageObject;
import an.object.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class MainController {

    @Autowired
    PageService pageService;

    @RequestMapping(path="/", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void postPage(/*@RequestParam("fileUpload") MultipartFile[] files,*/
                         @RequestBody PageObject pageObject) throws IOException {
        if (pageObject.getCategory().contains("gorsovet_ufa"))
            new Test().startGroSovet(pageService.createService(pageObject));
        else if (pageObject.getCategory().contains("bashprok"))
            new Test().startBashProk(pageService.createService(pageObject));
        else if (pageObject.getCategory().contains("gibdd_rb"))
            new Test().startGIBDDProk(pageService.createService(pageObject));


//        try {
//            new Test().startGorSovet(pageService.createService(pageObject));
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }

//        File newFile = new File("e:\\12345"+files[0].getOriginalFilename());
//        files[0].transferTo(newFile);


        System.out.println("ddd");
    }
}
