package com.instant.jobs.entity;

import lombok.Data;

@Data
public class Emails {

    private String toEmail;
    private String subject;
    private String body;
    private String attachment;

}
