package demo.techniques;

public class MyBean {

	private int field1;
	private String field2;

	public MyBean(int field1, String field2) {
		this.field1 = field1;
		this.field2 = field2;
		System.out.printf("Creating MyBean, fields %d %s\n", field1, field2);
	}

	@Override
	public String toString() {
		return String.format("Hi! from MyBean, fields %d %s", field1, field2);
	}
}