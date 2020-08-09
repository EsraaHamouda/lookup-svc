package com.lookup.service.impl;

import com.lookup.dao.ComplaintRepository;
import com.lookup.dao.ProductRepository;
import com.lookup.model.Complaint ;
import com.lookup.service.ComplaintService;
import com.lookup.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class DefaultComplaintService implements ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;

    @Override
    public void create(Complaint  complaint ) {
        complaintRepository.save(complaint );
    }

    @Override
    public void update(Complaint  complaint ) {
        complaintRepository.save(complaint );
    }

    @Override
    public void deleteById(String uuid) {
        complaintRepository.deleteById(uuid);
    }

    @Override
    public Optional<Complaint > findById(String uuid) {
        return complaintRepository.findById(uuid);
    }

    @Override
    public Page<Complaint > findAll(Pageable pageable) {
        return complaintRepository.findAll(pageable);
    }

    @Override
    public List<Complaint > findAll() {
        return complaintRepository.findAll();
    }
}
