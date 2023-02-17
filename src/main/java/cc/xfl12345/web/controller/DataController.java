package cc.xfl12345.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teasoft.bee.osql.service.ObjSQLRichService;

import javax.annotation.PostConstruct;

@RestController
public class DataController {

    private static Logger log = LoggerFactory.getLogger(DataController.class);

    protected ObjSQLRichService objSQLRichService;

    @Autowired
    public void setObjSQLRichService(ObjSQLRichService objSQLRichService) {
        this.objSQLRichService = objSQLRichService;
    }

    @PostConstruct
    public void init() {
    }

    @GetMapping("data")
    public String justGet() {
        return "2333";
    }

}
