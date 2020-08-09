package com.lookup.service;

import com.lookup.model.Promo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PromoService {


    void create(Promo t);

    void update(Promo t);

    void deleteById(String uuid);

    Optional<Promo> findById(String uuid);

    Page<Promo> findAll(Pageable pageable);

    List<Promo> findAll();

}
