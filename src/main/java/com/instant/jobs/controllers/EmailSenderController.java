package com.instant.jobs.controllers;

import com.instant.jobs.constants.ApiRoutes;
import com.instant.jobs.services.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.mail.MessagingException;

@RestController
public class EmailSenderController {

    @Autowired
    private EmailSenderService emailSenderService;

    @GetMapping(ApiRoutes.SEND_MAIL)
    public String triggerMail() throws MessagingException {
        return emailSenderService.sendMailWithAttachment("ajasabdulazeezofficial@gmail.com", "IT");
    }
}
