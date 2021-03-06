package com.lookup.service.impl;

import com.lookup.dao.ProductRepository;
import com.lookup.model.Complaint;
import com.lookup.model.Product;
import com.lookup.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DefaultProductService implements BaseService<Product> {

    @Autowired
    ProductRepository productRepository;


    @Override
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(String uuid) {
        productRepository.deleteById(uuid);
    }

    @Override
    public Optional<Product> findById(String uuid) {
        return productRepository.findById(uuid);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
