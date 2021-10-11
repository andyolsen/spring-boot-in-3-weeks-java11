package demo.clientservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.LocalTime;

@RestController
public class ClientController {

    @GetMapping("/client/{index}")
    public String getItem(@PathVariable int index){

        URI catalogUrl = URI.create("http://localhost:8081/catalog/" + index);
        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(catalogUrl, String.class);
        return String.format("[%s] Item %d %s", LocalTime.now(), index, result);
    }
}
