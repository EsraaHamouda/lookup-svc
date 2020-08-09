package com.lookup.dao;

import com.lookup.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

    @Query("{  $or: [ { 'nameEn' : { $regex: ?0 }  }, { 'nameAr' : { $regex: ?0 }  }] }")
    List<Category> search(String query);
}