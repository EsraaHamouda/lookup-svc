package com.lookup.service.lookup.dao;

import com.lookup.service.lookup.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category, String> {

    @Query("{  $or: [ { 'nameEn' : { $regex: ?0 }  }, { 'nameAr' : { $regex: ?0 }  }] }")
    List<Category> search(String query);
}