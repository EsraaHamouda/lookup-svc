package com.lookup.service.lookup.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "category")
public class Category {

    @Id
    private String uuid;
    private String nameAr;
    private String nameEn;

}
