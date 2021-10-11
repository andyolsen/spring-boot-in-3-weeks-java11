package demo.techniques;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.util.UUID;

@Configuration
public class MyConfig {

	@Bean(name="cool-bean")
	public MyBean bean1() {
		return new MyBean(1111, UUID.randomUUID().toString());
	}

	@Bean(name = {"subsystemA-bean", "subsystemB-bean", "subsystemC-bean"})
	public MyBean bean2() {
		return new MyBean(2222, UUID.randomUUID().toString());
	}

	@Bean(name="lazy-bean")
	@Lazy
	public MyBean bean3() {
		return new MyBean(3333, UUID.randomUUID().toString());
	}

	@Bean(name="proto-bean")
	@Scope("prototype")
	public MyBean bean4() {
		return new MyBean(4444, UUID.randomUUID().toString());
	}
}
