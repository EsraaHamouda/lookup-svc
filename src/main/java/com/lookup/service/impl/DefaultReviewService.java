package com.lookup.service.impl;

import com.lookup.dao.ReviewRepository;
import com.lookup.model.Review;
import com.lookup.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class DefaultReviewService implements BaseService<Review> {

    @Autowired
    ReviewRepository reviewRepository;


    @Override
    public void create(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void update(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public void deleteById(String uuid) {
        reviewRepository.deleteById(uuid);
    }

    @Override
    public Optional<Review> findById(String uuid) {
        return reviewRepository.findById(uuid);
    }

    @Override
    public Page<Review> findAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }
}
