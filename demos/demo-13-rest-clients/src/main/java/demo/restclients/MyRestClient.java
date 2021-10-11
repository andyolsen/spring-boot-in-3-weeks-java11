package demo.restclients;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class MyRestClient {

	private String baseAddress = "http://localhost:8080/full";

	RestTemplate template = new RestTemplate();

	public void demoGetOne() {
		ResponseEntity<Product> response = template.getForEntity(baseAddress + "/products/1", Product.class);
		System.out.printf("\nGot product 1, response details:");
		System.out.printf("  Status code: %d\n", response.getStatusCodeValue());
		System.out.printf("  Response body: %s\n", response.getBody());
	}

	public void demoInsert() {
		ResponseEntity<Product> response = template.postForEntity(
				baseAddress + "/products",
				new Product("Lear jet", 15_000_000),
				Product.class
		);
		System.out.println("\nInserted product, response details:");
		System.out.printf("  Status code: %d\n", response.getStatusCodeValue());
		System.out.printf("  Location header: %s\n", response.getHeaders().getLocation());
		System.out.printf("  Response body: %s\n", response.getBody());
	}

	public void demoUpdate() {
		Product product1 = template.getForObject(baseAddress + "/products/1", Product.class);
		product1.setPrice(product1.getPrice() * 2);

		try {
			template.put(baseAddress + "/products/1", product1);
			System.out.println("\nUpdated product 1");
		}
		catch (RestClientException ex) {
			System.out.println("\nException occurred during update: " + ex);
		}
	}

	public void demoDelete() {
		try {
			template.delete(baseAddress + "/products/2");
			System.out.println("\nDeleted product 2");
		}
		catch (RestClientException ex) {
			System.out.println("\nException occurred during delete: " + ex);
		}
	}

	public void demoGetAll() {

		ParameterizedTypeReference<List<Product>> responseType = new ParameterizedTypeReference<List<Product>>() {};

		ResponseEntity<List<Product>> response = template.exchange(
				baseAddress + "/products",
				HttpMethod.GET,
				null,
				responseType);

		System.out.println("\nAll products: ");
		for (Product p : response.getBody()) {
			System.out.printf("  %s\n", p);
		}
	}
}
