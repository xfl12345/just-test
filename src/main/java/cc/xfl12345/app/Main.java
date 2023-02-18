package cc.xfl12345.app;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@EnableConfigurationProperties
@SpringBootApplication
@ComponentScan("cc.xfl12345.web")
@ComponentScan("cc.xfl12345.config")
public class Main {
    private static ConfigurableApplicationContext context;

    public static int restartCount = 0;

    public static void main(String[] args) {
        context = SpringApplication.run(Main.class, args);
    }

    public static void restart() {
        ApplicationArguments args = context.getBean(ApplicationArguments.class);

        Thread thread = new Thread(() -> {
            context.close();
            context = SpringApplication.run(Main.class, args.getSourceArgs());
        });

        restartCount += 1;
        thread.setDaemon(false);
        thread.setName("restart-" + restartCount);
        thread.start();
    }
}
