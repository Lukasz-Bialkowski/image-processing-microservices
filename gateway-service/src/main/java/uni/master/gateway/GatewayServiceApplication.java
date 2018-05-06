package uni.master.gateway;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class GatewayServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }
}

@RestController
@RequestMapping("/gateway")
class GatewayController {

    EurekaClient eurekaClient;

    @Autowired
    public GatewayController(EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    @RequestMapping("/benchmark")
    public List<ResourceBenchmark> benchmark(@RequestParam int size) {
        List<InstanceInfo> instances = eurekaClient.getApplications().getRegisteredApplications("worker-service").getInstances();
        List<ResourceBenchmark> result = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        int fsize = size / instances.size();

        for (InstanceInfo ii : instances) {
            System.out.println("Instance: " + ii.getHomePageUrl());
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ii.getHomePageUrl() + "app/benchmark")
                    .queryParam("size", fsize);
            try{
                ResponseEntity<List<ResourceBenchmark>> claimResponse =
                        restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<ResourceBenchmark>>() {});
                result.addAll(claimResponse.getBody());
            } catch (RestClientException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    @RequestMapping("/history")
    public List<ProcessTask> history() {
        List<InstanceInfo> instances = eurekaClient.getApplications().getRegisteredApplications("worker-service").getInstances();
        List<ProcessTask> result = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        for (InstanceInfo ii : instances) {
            System.out.println("Instance: " + ii.getHomePageUrl());
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ii.getHomePageUrl() + "app/history");
            try{
                ResponseEntity<List<ProcessTask>> claimResponse =
                        restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<ProcessTask>>() {});
                result.addAll(claimResponse.getBody());
            } catch (RestClientException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    @RequestMapping("/searchList")
    public List<ProcessTask> searchList(@RequestParam String userInput) {
        List<InstanceInfo> instances = eurekaClient.getApplications().getRegisteredApplications("worker-service").getInstances();
        List<ProcessTask> result = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();

        for (InstanceInfo ii : instances) {
            System.out.println("Instance: " + ii.getHomePageUrl());
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(ii.getHomePageUrl() + "app/searchList")
                    .queryParam("userInput", userInput);
            try{
                ResponseEntity<List<ProcessTask>> claimResponse =
                        restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<ProcessTask>>() {});
                result.addAll(claimResponse.getBody());
            } catch (RestClientException e) {
                e.printStackTrace();
            }
        }

        return result;
    }
}