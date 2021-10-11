package demo.catalogservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CatalogController {

    private static List<String> catalogItems = new ArrayList<>();
    static {
        catalogItems.add("Bugatti Divo");
        catalogItems.add("Lear Jet");
        catalogItems.add("Socks from M&S");
    }

    @GetMapping(value="/catalog", produces={"application/json", "text/plain"})
    public ResponseEntity<List<String>> getAllItemsInCatalog(){
        return ResponseEntity
                .ok()
                .body(catalogItems);
    }

    @GetMapping(value="/catalog/{index}", produces={"application/json", "text/plain"})
    public ResponseEntity<String> getItemInCatalog(@PathVariable int index){
        return ResponseEntity
                .ok()
                .body(catalogItems.get(index));
    }
}
