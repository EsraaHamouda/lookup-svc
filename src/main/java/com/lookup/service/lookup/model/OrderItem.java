package com.lookup.service.lookup.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "order_item")
public class OrderItem {

    @Id
    private String uuid;
    private Product product;
    private int numOfUnits;
    private double amountByKg;
}
