package com.lookup.dao;

import com.lookup.model.Order;
import com.lookup.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface ReviewRepository extends MongoRepository<Review, String> {


}
