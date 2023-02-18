package cc.xfl12345.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Configuration;
import org.teasoft.beex.config.ManageConfig;
import org.teasoft.spring.boot.config.BeeAutoConfiguration;
import org.teasoft.spring.boot.config.BeeXmlConfiguration;

@Configuration
@AutoConfigureAfter({BeeXmlConfiguration.class})
@AutoConfigureBefore(value = {BeeAutoConfiguration.class})
public class Config {

    @Autowired
    public void setManageConfig(ManageConfig manageConfig) {
    }

}
