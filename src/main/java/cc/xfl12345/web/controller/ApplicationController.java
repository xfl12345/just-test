package cc.xfl12345.web.controller;


import cc.xfl12345.web.Main;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("app")
public class ApplicationController {
    @GetMapping("shutdown")
    @ResponseBody
    public boolean shutdown(HttpServletRequest request, boolean confirm) {
        WebApplicationContext context = RequestContextUtils.findWebApplicationContext(request);
        if (confirm && context != null) {
            // 三秒后执行任务
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
                // 整个 JVM 系统级 关机
                System.exit(0);
            });
            thread.setName("web-api-app-shutdown");
            thread.start();
            return true;
        }

        return false;
    }

    @GetMapping("context/reboot")
    @ResponseBody
    public boolean reboot(boolean confirm) {
        if (confirm) {
            // 三秒后执行任务
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
                Main.restart();
            });
            thread.setName("web-api-spring-reboot");
            thread.start();
        }

        return true;
    }
}
