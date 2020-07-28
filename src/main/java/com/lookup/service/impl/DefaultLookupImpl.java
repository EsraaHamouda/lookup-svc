package com.lookup.service.impl;

import com.lookup.dao.LookupRepository;
import com.lookup.service.LookupService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultLookupImpl<T> implements LookupService<T> {



    LookupRepository<T> lookupService;


    @Override
    public void create(T t) {
        lookupService.save(t);
    }

    @Override
    public void update(T t) {
        lookupService.save(t);
    }

    @Override
    public void deleteById(String uuid) {
        lookupService.deleteById(uuid);
    }

    @Override
    public Optional<T> findById(String uuid) {
        return lookupService.findById(uuid);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return lookupService.findAll(pageable);
    }

    @Override
    public List<T> findAll() {
        return lookupService.findAll();
    }
}
