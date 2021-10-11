package demo.simpleconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		MyBean bean = ctx.getBean("myBean", MyBean.class);
        System.out.println(bean);

        SomeComponent comp = ctx.getBean("someComponent", SomeComponent.class);
        comp.someOperation();
	}
}
