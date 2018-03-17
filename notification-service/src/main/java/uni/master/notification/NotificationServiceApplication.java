package uni.master.notification;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
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
}
