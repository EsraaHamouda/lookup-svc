package com.lookup.service.lookup.dao;

import com.lookup.service.lookup.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
