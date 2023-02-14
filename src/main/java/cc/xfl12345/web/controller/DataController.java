package cc.xfl12345.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teasoft.bee.osql.SuidRich;
import org.teasoft.honey.osql.core.BeeFactoryHelper;

import javax.annotation.PostConstruct;

@RestController
public class DataController {

    @PostConstruct
    public void init() {
        SuidRich suidRich = BeeFactoryHelper.getSuidRich();
    }

    @GetMapping("data")
    public String justGet() {
        return "2333";
    }

}
