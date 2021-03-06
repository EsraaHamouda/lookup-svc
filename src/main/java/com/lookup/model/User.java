package com.lookup.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {

    @Id
    private String uuid;
    private String name;
    private String phoneNumber;
    private String email;

}
