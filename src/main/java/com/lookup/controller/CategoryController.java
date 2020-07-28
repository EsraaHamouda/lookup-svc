package com.lookup.controller;


import com.lookup.model.Category;
import com.lookup.service.LookupService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/category")
@Api(description = "Category lookup operations", tags = "Category")
public class CategoryController {


    LookupService<Category> lookupService;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        lookupService.create(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("uuid") String uuid) {

        Optional<Category> category = lookupService.findById(uuid);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Category>> listCategories() {
        List<Category> result = lookupService.findAll();
        if (result.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{uuid}")
    public Category updateCategory(@RequestBody Category category, @PathVariable("uuid") String categoryId) {
        category.setUuid(categoryId);
        lookupService.update(category);
        return category;
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> deleteCategory(@PathVariable("uuid") String uuid) {
        lookupService.deleteById(uuid);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }


    // TODO: to be refactored
    /*
    @RequestMapping(value = "/search/{query}", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> searchCategories(@PathVariable("query") String query) {
        List<Category> result = categoryRepository.search(query);
        if (result.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }*/


}
