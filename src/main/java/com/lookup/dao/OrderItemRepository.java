package com.lookup.dao;

import com.lookup.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderItemRepository extends LookupRepository<Order.OrderItem> {

    List<Order.OrderItem> findByOrderUuid(String orderUuid);
}
