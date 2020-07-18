package com.lookup.service.lookup.controller;


import com.lookup.service.lookup.dao.CategoryRepository;
import com.lookup.service.lookup.model.Category;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/category")
@Api(description = "Category lookup operations", tags = "Category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        categoryRepository.save(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/search/{query}", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> searchCategories(@PathVariable("query") String query) {
        List<Category> result = categoryRepository.search(query);
        if (result.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Category>> listCategories() {
        List<Category> result = categoryRepository.findAll();
        if (result.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/{uuid}")
    public Category updateCategory(@RequestBody Category category, @PathVariable("uuid") String categoryId) {
        category.setUuid(categoryId);
        categoryRepository.save(category);
        return category;
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> deleteCategory(@PathVariable("uuid") String uuid) {
        categoryRepository.deleteById(uuid);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("uuid") String uuid) {

        Optional<Category> category = categoryRepository.findById(uuid);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }
}
