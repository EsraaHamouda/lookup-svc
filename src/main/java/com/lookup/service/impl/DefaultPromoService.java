package com.lookup.service.impl;

import com.lookup.dao.PromoRepository;
import com.lookup.model.Complaint;
import com.lookup.model.Promo;
import com.lookup.model.Promo;
import com.lookup.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class DefaultPromoService implements BaseService<Promo> {

    @Autowired
    PromoRepository promoRepository;


    @Override
    public void create(Promo promo) {
        promoRepository.save(promo);
    }

    @Override
    public void update(Promo promo) {
        promoRepository.save(promo);
    }

    @Override
    public void deleteById(String uuid) {
        promoRepository.deleteById(uuid);
    }

    @Override
    public Optional<Promo> findById(String uuid) {
        return promoRepository.findById(uuid);
    }

    @Override
    public Page<Promo> findAll(Pageable pageable) {
        return promoRepository.findAll(pageable);
    }

    @Override
    public List<Promo> findAll() {
        return promoRepository.findAll();
    }
}
