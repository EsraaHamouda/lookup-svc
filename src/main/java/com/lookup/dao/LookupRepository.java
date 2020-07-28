package com.lookup.dao;

import com.lookup.model.Complaint;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LookupRepository<T> extends MongoRepository<T, String> {


}
