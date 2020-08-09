package com.lookup.service;

import com.lookup.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReviewService {


    void create(Review t);

    void update(Review t);

    void deleteById(String uuid);

    Optional<Review> findById(String uuid);

    Page<Review> findAll(Pageable pageable);

    List<Review> findAll();

}
