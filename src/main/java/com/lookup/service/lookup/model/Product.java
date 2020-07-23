package com.lookup.service.lookup.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Product {

    @Id
    private String uuid;
    private String nameAr;
    private String nameEn;
    private String photoUrl;
    private double price;
    private double stockAmount;

}
