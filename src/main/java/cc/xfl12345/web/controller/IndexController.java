package cc.xfl12345.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping(path = {"", "/", "hello-world"})
    public String helloWorld() {
        return "Hello world!";
    }

}
