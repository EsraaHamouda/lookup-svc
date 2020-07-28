package com.lookup.dao;

import com.lookup.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ReviewRepository extends MongoRepository<Review, String> {
    @Override
    Page<Review> findAll(Pageable pageable);
}
