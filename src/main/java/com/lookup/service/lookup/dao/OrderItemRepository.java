package com.lookup.service.lookup.dao;

import com.lookup.service.lookup.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderItemRepository extends MongoRepository<Order, String> {
}
