package com.lookup.dao;

import com.lookup.model.Complaint;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ComplaintRepository extends LookupRepository<Complaint> {

    List<Complaint> findByUserUuid(String uuid);
}
