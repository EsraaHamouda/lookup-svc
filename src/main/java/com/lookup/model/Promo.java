package com.lookup.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Promo {

    @Id
    private String uuid;
    private String name;
    private String description;
    private double amount;
    private Date startDate;
    private Date endDate;
}
