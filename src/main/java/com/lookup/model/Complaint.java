package com.lookup.model;

import com.lookup.model.enums.ComplaintStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Complaint {

    @Id
    private String uuid;
    private String title;
    private String description;
    private String userUuid;
    private ComplaintStatus complaintStatus;


}
