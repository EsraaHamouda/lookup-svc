package com.lookup.service.lookup.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Offer {

    @Id
    private String uuid;
    private String name;
    private String description;
    private double percentage;
    private Date startDate;
    private Date endDate;


}
