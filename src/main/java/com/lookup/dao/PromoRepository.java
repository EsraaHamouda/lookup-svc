package com.lookup.dao;

import com.lookup.model.Promo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoRepository extends MongoRepository<Promo, String> {
}
