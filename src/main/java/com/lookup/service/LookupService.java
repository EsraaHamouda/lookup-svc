package com.lookup.service;

import com.lookup.model.Complaint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LookupService<T> {



    void create(T t);
    void update(T t);
    void deleteById(String uuid);
    Optional<T> findById(String uuid);
    Page<T> findAll(Pageable pageable);
    List<T> findAll();

}
