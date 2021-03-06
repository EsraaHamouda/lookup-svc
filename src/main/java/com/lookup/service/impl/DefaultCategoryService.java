package com.lookup.service.impl;

import com.lookup.dao.CategoryRepository;
import com.lookup.model.Category;
import com.lookup.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DefaultCategoryService implements BaseService<Category> {

    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public void create(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteById(String uuid) {
        categoryRepository.deleteById(uuid);
    }

    @Override
    public Optional<Category> findById(String uuid) {
        return categoryRepository.findById(uuid);
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
