package cc.xfl12345.web.initializer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private final static Logger log = LoggerFactory.getLogger(MyBeanFactoryPostProcessor.class);

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        ConfigurableEnvironment configurableEnvironment = configurableListableBeanFactory.getBean(ConfigurableEnvironment.class);

        log.info(
            "configurableListableBeanFactory.getBeanDefinitionNames(): [\n    " +
            Arrays.asList(configurableListableBeanFactory.getBeanDefinitionNames())
                .parallelStream()
                .collect(Collectors.joining(",\n    "))
            + "\n]"
        );

        // 优先初始化一些 Bean
        // Something else
    }
}
