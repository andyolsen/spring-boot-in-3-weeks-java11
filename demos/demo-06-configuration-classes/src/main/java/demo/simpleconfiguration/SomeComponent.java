package demo.simpleconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeComponent {

	@Autowired
	MyBean bean;

	public void someOperation() {
		System.out.printf("In SomeComponent.someOperation() with MyBean: %s\n", bean);
	}
}