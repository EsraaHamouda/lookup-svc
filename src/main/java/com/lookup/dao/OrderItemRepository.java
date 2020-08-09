package com.lookup.dao;

import com.lookup.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderItemRepository extends org.springframework.data.mongodb.repository.MongoRepository<Order.OrderItem, String> {

    List<Order.OrderItem> findByOrderUuid(String orderUuid);
}
