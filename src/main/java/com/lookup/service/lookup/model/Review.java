package com.lookup.service.lookup.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Review {
    @Id
    private String uuid;
    private String title;
    private int rating;
    private String description;
    private String userUuid;


}
