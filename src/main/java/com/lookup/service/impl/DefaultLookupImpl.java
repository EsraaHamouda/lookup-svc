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

    LookupRepository<T> lookupRepository;

    @Override
    public LookupRepository<T> getRepository() {
        return null;
    }

    @Override
    public void create(T t) {
        lookupRepository.save(t);
    }

    @Override
    public void update(T t) {
        lookupRepository.save(t);
    }

    @Override
    public void deleteById(String uuid) {
        lookupRepository.deleteById(uuid);
    }

    @Override
    public Optional<T> findById(String uuid) {
        return lookupRepository.findById(uuid);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return lookupRepository.findAll(pageable);
    }

    @Override
    public List<T> findAll() {
        return lookupRepository.findAll();
    }
}
