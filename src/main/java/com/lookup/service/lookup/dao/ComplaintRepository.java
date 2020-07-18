package com.lookup.service.lookup.dao;

import com.lookup.service.lookup.model.Complaint;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ComplaintRepository extends MongoRepository<Complaint, String> {

    List<Complaint> findByUserUuid(String uuid);
}
