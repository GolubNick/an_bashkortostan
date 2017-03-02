package an.controllers;

import an.framework.Test;
import an.object.DeputatObject;
import an.object.DeputatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
//
//    @RequestMapping("/")
//    String home() {
//        new Test().start();
//        return "Hello World!";
//    }

    @Autowired
    DeputatService deputatService;

    @RequestMapping(path="/ufa_gorsovet", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void postDeputat(@RequestBody DeputatObject deputatObject){
        new Test().start(deputatService.createService(deputatObject));
    }
}
