package com.lookup.dao;

import com.lookup.model.Complaint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LookupRepository<T> extends MongoRepository<T, String> {


}
