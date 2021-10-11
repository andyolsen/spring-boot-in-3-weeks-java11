package demo.restclients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Application.class, args);

        MyRestClient client = context.getBean(MyRestClient.class);

        client.demoGetOne();
        client.demoInsert();
        client.demoUpdate();
        client.demoDelete();
        client.demoGetAll();
    }

}
