package demo.techniques;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		// Lookup 1st bean via its name.
		MyBean ref1 = ctx.getBean("cool-bean", MyBean.class);
		System.out.println(ref1);

		// Lookup 2nd bean via its various aliases.
		MyBean ref2a = ctx.getBean("subsystemA-bean", MyBean.class);
		MyBean ref2b = ctx.getBean("subsystemB-bean", MyBean.class);
		MyBean ref2c = ctx.getBean("subsystemC-bean", MyBean.class);
		System.out.println(ref2a);
		System.out.println(ref2b);
		System.out.println(ref2c);

		// Lookup 3rd bean (lazy), Spring Boot creates bean JIT.
		MyBean ref3 = ctx.getBean("lazy-bean", MyBean.class);
		System.out.println(ref3);

		// Lookup 4th bean (prototype), get a new bean every time.
		MyBean ref4a = ctx.getBean("proto-bean", MyBean.class);
		MyBean ref4b = ctx.getBean("proto-bean", MyBean.class);
		MyBean ref4c = ctx.getBean("proto-bean", MyBean.class);
		System.out.println(ref4a);
		System.out.println(ref4b);
		System.out.println(ref4c);
	}
}
