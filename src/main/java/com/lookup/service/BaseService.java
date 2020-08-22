package com.lookup.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface BaseService<T> {

    void create(T t);

    void update(T t);

    void deleteById(String uuid);

    <T> Optional<T> findById(String uuid);

    <T> Page<T> findAll(Pageable pageable);

    <T> List<T> findAll();

}
