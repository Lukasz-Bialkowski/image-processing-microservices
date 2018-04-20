package uni.master.gateway.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/app")
@RefreshScope
public class AppController {

    @Value("${parent-message:zkodu}")
    private String message;

    @RequestMapping(value = "/process", method = RequestMethod.GET)
    public String processImage() {
        return this.message;
    }

}
