package com.lookup.dao;

import com.lookup.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findByUserUuid(String userUuid);

    @Query("{'orderDate':{$gt:?0,$lt:?1}}")
    List<Order> getOrderCountInDateRange(Date startDate, Date endDate);
}
