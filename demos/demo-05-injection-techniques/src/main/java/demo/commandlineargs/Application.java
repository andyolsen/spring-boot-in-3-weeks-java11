package demo.commandlineargs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
		MyBeanWithArgs beanWithArgs = ctx.getBean(MyBeanWithArgs.class);
		System.out.println(beanWithArgs);
	}
}
