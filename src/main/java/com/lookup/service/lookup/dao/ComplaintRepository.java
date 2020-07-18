package com.lookup.service.lookup.dao;

import com.lookup.service.lookup.model.Complaint;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ComplaintRepository extends MongoRepository<Complaint, String> {
}
