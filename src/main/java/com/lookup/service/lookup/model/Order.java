package com.lookup.service.lookup.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "order")
public class Order {

    @Id
    private String uuid;
    private double totalInvoice;
    private double tax;
    private List<OrderItem> orderItemList;
    private Date orderDate;
    private String userUuid;
}
