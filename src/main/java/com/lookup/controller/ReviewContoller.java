package com.lookup.controller;

import com.lookup.dao.LookupRepository;
import com.lookup.model.Review;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
@Api(tags = "Review endpoints")
public class ReviewContoller {

    @Autowired
    LookupRepository<Review> reviewRepository;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        reviewRepository.save(review);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Review> updateReview(@RequestBody Review review, @PathVariable("uuid") String uuid) {
        review.setUuid(uuid);
        reviewRepository.save(review);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> deleteReview(@PathVariable("uuid") String uuid) {
        reviewRepository.deleteById(uuid);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Review> getReview(@PathVariable("uuid") String uuid) {
        Optional<Review> result = reviewRepository.findById(uuid);
        return result.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Review>> listReview(@RequestParam("pageNumber") int pageNumber,
                                                   @RequestParam("size") int size) {
        Pageable pageable = PageRequest.of(pageNumber, size);
         Page<Review> result = reviewRepository.findAll(pageable);
        if (result.isEmpty()) new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(result.getContent(), HttpStatus.OK);
    }


}
