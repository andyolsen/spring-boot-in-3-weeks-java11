package demo.simpleconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

	@Bean
	public MyBean myBean() {
		MyBean b = new MyBean();
		b.setField1(42);
		b.setField2("wibble");
		return b;
	}
}
