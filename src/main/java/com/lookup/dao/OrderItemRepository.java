package com.lookup.dao;
import com.lookup.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderItemRepository extends MongoRepository<Order.OrderItem, String> {

    List<Order.OrderItem> findByOrderUuid(String orderUuid);
}
