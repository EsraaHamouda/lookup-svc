package com.lookup.service;

import com.lookup.model.Complaint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ComplaintService {


    void create(Complaint t);

    void update(Complaint t);

    void deleteById(String uuid);

    Optional<Complaint> findById(String uuid);

    Page<Complaint> findAll(Pageable pageable);

    List<Complaint> findAll();

}
