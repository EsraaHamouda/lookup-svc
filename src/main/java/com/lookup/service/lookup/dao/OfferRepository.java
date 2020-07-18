package com.lookup.service.lookup.dao;

import com.lookup.service.lookup.model.Offer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OfferRepository extends MongoRepository<Offer, String> {
}
