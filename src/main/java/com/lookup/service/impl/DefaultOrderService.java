package com.lookup.service.impl;

import com.lookup.dao.OrderRepository;
import com.lookup.dao.ProductRepository;
import com.lookup.model.Order;
import com.lookup.model.Order;
import com.lookup.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DefaultOrderService implements BaseService<Order> {

    @Autowired
    OrderRepository orderRepository;


    @Override
    public void create(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void deleteById(String uuid) {
        orderRepository.deleteById(uuid);
    }

    @Override
    public Optional<Order> findById(String uuid) {
        return orderRepository.findById(uuid);
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
