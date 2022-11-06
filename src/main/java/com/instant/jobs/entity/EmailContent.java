package com.instant.jobs.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class EmailContent {

    @Id
    private String id;

    private String subject;
    private String body;
    private String attachmentId;
    private String Category;
    private Date modifiedOn;

}
