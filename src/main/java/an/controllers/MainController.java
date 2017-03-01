package an.controllers;

import an.framework.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/")
    String home() {
        new Test().start();
        return "Hello World!";
    }
}
