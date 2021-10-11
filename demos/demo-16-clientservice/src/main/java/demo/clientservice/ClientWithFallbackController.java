package demo.clientservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.LocalTime;

@RestController
public class ClientWithFallbackController {

    @Autowired
    private CircuitBreakerFactory factory;

    @GetMapping("/clientWithFallback/{index}")
    public String getItem(@PathVariable int index){

        URI catalogUrl = URI.create("http://localhost:8081/catalog/" + index);
        RestTemplate restTemplate = new RestTemplate();

        CircuitBreaker circuitBreaker = factory.create("circuitbreaker");
        String result = circuitBreaker.run(
                ()  -> restTemplate.getForObject(catalogUrl, String.class),
                err -> getFallback(index));
        return String.format("[%s] Item %d %s", LocalTime.now(), index, result);
    }

    public String getFallback(int i) {
        return "FALLBACK-ITEM-" + i;
    }
}
