package cc.xfl12345.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teasoft.honey.osql.core.BeeFactory;
import org.teasoft.honey.osql.core.SessionFactory;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class DataController {

    private static Logger log = LoggerFactory.getLogger(DataController.class);

    protected SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    public void init() throws SQLException {
        DataSource dataSource = BeeFactory.getInstance().getDataSource();
        Connection connection = dataSource.getConnection();
        try (connection) {
            connection.createStatement().execute("select 1");
            log.info("OK");
        }
    }

    @GetMapping("data")
    public String justGet() {
        return "2333";
    }

}
