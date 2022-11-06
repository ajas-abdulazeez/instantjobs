package com.instant.jobs.entity;

import com.instant.jobs.enums.EmailStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class EmailLogs {

    @Id
    private String id;
    private String fromEmailId;
    private String receiverId;
    private String toEmailId;
    private String contentId;
    private Date sendDate;
    private EmailStatus status;
}
