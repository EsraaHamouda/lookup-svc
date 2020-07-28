package com.lookup.model;

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
    private final Date orderDate;
    private String userUuid;

    @Data
    @Document(collection = "order_item")
    public class OrderItem {

        @Id
        private String uuid;
        private String productUuid;
        private String orderUuid;
        private int numOfUnits;
        private double amountByKg;
    }

}
