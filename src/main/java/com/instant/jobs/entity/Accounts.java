package com.instant.jobs.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Accounts {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;
    private String secretString;

    private String role;
    private String appVersion;

    @Temporal(TemporalType.DATE)
    private Date createdDate = new Date(System.currentTimeMillis());
    private String status;
}
