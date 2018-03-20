package uni.master.notification;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class NotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }
}

@RefreshScope
@RestController
class NotificationRestController {
    @Value("${parent-message:zkodu}")
    private String message;

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }

    @HystrixCommand(defaultFallback = "getDefaultUser")
    @RequestMapping("/user")
    String getUser() {
        return "User taki";
    }

    String getDefaultUser() {
        return "Nie ma usera";
    }
}
