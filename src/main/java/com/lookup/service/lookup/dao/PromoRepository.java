package com.lookup.service.lookup.dao;

import com.lookup.service.lookup.model.Promo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PromoRepository extends MongoRepository<Promo, String> {
}
