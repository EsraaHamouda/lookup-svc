package com.lookup.dao;

import com.lookup.model.Complaint;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface ComplaintRepository extends MongoRepository<Complaint, String> {

    List<Complaint> findByUserUuid(String uuid);
}
