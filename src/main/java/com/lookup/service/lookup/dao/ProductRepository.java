package com.lookup.service.lookup.dao;

import com.lookup.service.lookup.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {

 }
