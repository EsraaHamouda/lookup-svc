package com.lookup.service;

import com.lookup.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService{


    void create(Product t);

    void update(Product t);

    void deleteById(String uuid);

    Optional<Product> findById(String uuid);

    Page<Product> findAll(Pageable pageable);

    List<Product> findAll();

}
