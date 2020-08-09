package com.lookup.service;

import com.lookup.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {


    void create(Category t);

    void update(Category t);

    void deleteById(String uuid);

    Optional<Category> findById(String uuid);

    Page<Category> findAll(Pageable pageable);

    List<Category> findAll();

}
