package com.lookup.service.lookup.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Complaint {

    @Id
    private String uuid;
    private String title;

    private String description;

    private User user;


}
