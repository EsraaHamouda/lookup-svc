package com.lookup.service;

import com.lookup.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {


    void create(Order t);

    void update(Order t);

    void deleteById(String uuid);

    Optional<Order> findById(String uuid);

    Page<Order> findAll(Pageable pageable);

    List<Order> findAll();

}
