package com.lookup.service.lookup.controller;

import com.lookup.service.lookup.dao.ProductRepository;
import com.lookup.service.lookup.model.Product;
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
    ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        productRepository.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> listProducts() {
        List<Product> result = productRepository.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Product> findProductById(@PathVariable("uuid") String uuid) {
        Optional<Product> result = productRepository.findById(uuid);
        return result.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("uuid") String uuid){
        product.setUuid(uuid);
        productRepository.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/uuid")
    public ResponseEntity<String> deleteProduct(@PathVariable("uuid") String uuid){
        productRepository.deleteById(uuid);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }


}
