package com.lookup.service.lookup.dao;

import com.lookup.service.lookup.model.OrderItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderItemRepository extends MongoRepository<OrderItem, String> {

    List<OrderItem> findByOrderUuid(String orderUuid);
}
