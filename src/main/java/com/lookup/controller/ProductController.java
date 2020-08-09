package com.lookup.controller;

import com.lookup.model.Product;
import com.lookup.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@Api(tags = "Product CRUD endpoints")
public class ProductController {

    @Autowired
    ProductService productLookupService;


    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        productLookupService.create(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> listProducts() {
        List<Product> result = productLookupService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Product> findProductById(@PathVariable("uuid") String uuid) {
        Optional<Product> result = productLookupService.findById(uuid);
        return result.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("uuid") String uuid){
        product.setUuid(uuid);
        productLookupService.update(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/uuid")
    public ResponseEntity<String> deleteProduct(@PathVariable("uuid") String uuid){
        productLookupService.deleteById(uuid);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }


}
