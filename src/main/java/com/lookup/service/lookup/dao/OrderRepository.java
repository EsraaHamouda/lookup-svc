package com.lookup.service.lookup.dao;

import com.lookup.service.lookup.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findByUserUuid(String userUuid);

    @Query("{'orderDate':{$gt:?0,$lt:?1}}")
    List<Order> getOrderCountInDateRange(Date startDate, Date endDate);
}
