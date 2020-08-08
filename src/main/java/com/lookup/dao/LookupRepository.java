package com.lookup.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface LookupRepository<T> extends MongoRepository<T, String> {


}
