package com.lookup.service.lookup.controller;

import com.lookup.service.lookup.dao.ReviewRepository;
import com.lookup.service.lookup.model.Review;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/review")
@Api(tags = "Review endpoints")
public class ReviewContoller {

    @Autowired
    ReviewRepository reviewRepository;

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
    public ResponseEntity<Review> listReview(@PathVariable("uuid") String uuid) {
        Optional<Review> result = reviewRepository.findById(uuid);
        return result.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }


}
