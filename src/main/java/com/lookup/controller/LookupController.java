package com.lookup.controller;


import com.lookup.model.Category;
import com.lookup.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LookupController {


    @Autowired
    ProductService<Category> categoryLookupService;

//    @Autowired
//    LookupService<Complaint> complaintLookupService;

  /*  @Autowired
    public void setComplaintLookupService(LookupService<Category> categoryLookupService) {
        this.categoryLookupService = categoryLookupService;
    }
    @Autowired
    public void setCategoryLookupService(LookupService<Complaint> complaintLookupService) {
        this.complaintLookupService = complaintLookupService;
    }*/


    @PostMapping("/category")
    public ResponseEntity<Category> create(@RequestBody Category category) {
        categoryLookupService.create(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PutMapping("/category/{uuid}")
    public Category update(@RequestBody Category category, @PathVariable("uuid") String categoryId) {
        category.setUuid(categoryId);
        categoryLookupService.update(category);
        return category;
    }

    @DeleteMapping("/category/category{uuid}")
    public ResponseEntity<String> deleteCategory(@PathVariable("uuid") String uuid) {
        categoryLookupService.deleteById(uuid);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }


    @GetMapping("/category/{uuid}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("uuid") String uuid) {

        Optional<Category> category = categoryLookupService.findById(uuid);
        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("category/list")
    public ResponseEntity<List<Category>> listCategories() {
        List<Category> result = categoryLookupService.findAll();
        if (result.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    ///////////////////////////// Complaints endpoints /////////////////////////////


 /*   @PostMapping("/complaint")
    public ResponseEntity<Complaint> createComplaint(@RequestBody Complaint complaint) {
        complaintLookupService.create(complaint);
        return new ResponseEntity<>(complaint, HttpStatus.OK);
    }

    @GetMapping("/complaint/{uuid}")
    public ResponseEntity<Complaint> getComplaintById(@PathVariable("uuid") String uuid) {
        Optional<Complaint> complaint = complaintLookupService.findById(uuid);
        return complaint.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
    // TODO: to be refactored
   *//* @GetMapping("/user/{uuid}")
    public ResponseEntity<List<Complaint>> getComplaintsByUserId(@PathVariable("uuid") String userUuid) {
        List<Complaint> result = complaintLookupService.findByUserUuid(userUuid);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }*//*

    @GetMapping("/complaint/list")
    public ResponseEntity<List<Complaint>> listComplaints() {
        List<Complaint> result = complaintLookupService.findAll();
        if (result.isEmpty())
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/complaint/{uuid}")
    public ResponseEntity<Complaint> updateComplaint(@RequestBody Complaint complaint, @PathVariable("uuid") String uuid) {
        complaint.setUuid(uuid);
        complaintLookupService.update(complaint);
        return new ResponseEntity<>(complaint, HttpStatus.OK);
    }

    @DeleteMapping("/complaint/{uuid}")
    public ResponseEntity<String> deleteComplaintById(@PathVariable("uuid") String uuid) {
        complaintLookupService.deleteById(uuid);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

  */
}
