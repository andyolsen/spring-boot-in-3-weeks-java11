package demo.restservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/full")
@CrossOrigin
public class FullController {

	@Autowired
	private ProductRepository repository;

	// New endpoint for the exercise:
	@PutMapping(value="/products/{id}/increasePriceBy/{amount}")
	public ResponseEntity<Void> increasePriceBy(@PathVariable long id, @PathVariable double amount) {
		Product p = repository.getById(id);
		if (p == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			p.setPrice(p.getPrice() + amount);
			repository.update(p);
			return ResponseEntity.ok().build();
		}
	}

	@GetMapping(value="/products/{id}", produces={"application/json","application/xml"})
	public ResponseEntity<Product> getProductById(@PathVariable long id) {
		Product p = repository.getById(id);
		if (p == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok().body(p);
	}
	
	@GetMapping(value="/products", produces={"application/json","application/xml"})
	public ResponseEntity<Collection<Product>> getProductsMoreThan(@RequestParam(value="min", required=false, defaultValue="0.0") double min) {
		Collection<Product> products = repository.getAll()
				                                 .stream()
											     .filter(p -> p.getPrice() > min)
											     .collect(Collectors.toList());
		return ResponseEntity.ok().body(products);
	}

	@PostMapping(
			value="/products",
			consumes={"application/json","application/xml"},
			produces={"application/json","application/xml"})
	public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
		repository.insert(product);
		URI uri = URI.create("/full/products/" + product.getId());
		return ResponseEntity.created(uri).body(product);
	}

	@PutMapping(value="/products/{id}", consumes={"application/json","application/xml"})
	public ResponseEntity<Void> updateProduct(@PathVariable long id, @RequestBody Product product) {
		if (!repository.update(product))
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok().build();
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
		if (!repository.delete(id))
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok().build();
	}
}
