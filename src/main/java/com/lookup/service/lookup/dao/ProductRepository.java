package com.lookup.service.lookup.dao;

import com.lookup.service.lookup.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
