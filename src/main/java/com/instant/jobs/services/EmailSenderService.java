package com.instant.jobs.services;

import com.instant.jobs.entity.Emails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public String sendMailWithAttachment(String senderId, String categoryId) throws MessagingException {


        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);

        //get sender email id and details
        getSenderEmailId(senderId);

        //get company details-- for loop ..retrieve mail id corresponding to ctegory.
        //list of email ids



        //read email array loop
//        if(emailConent.categroyid ==  categoryId){
//
//        }
        //after getting conents-- modify the data to email and delete once the count reaches 5



        Emails email = new Emails();
        email.setToEmail("ajasasraloorkavu@gmail.com");
        email.setSubject("This email subject");
        email.setBody("This is email body.");
        email.setAttachment("" + "/home/arjun/Pictures/Wallpapers/wallpaper.jpg");


        mimeMessageHelper.setFrom("ajasabdulazeezofficial@gmail.com");
        mimeMessageHelper.setTo(email.getToEmail());
        mimeMessageHelper.setText(email.getBody());
        mimeMessageHelper.setSubject(email.getSubject());

        FileSystemResource fileSystemResource=
                new FileSystemResource(new File(email.getAttachment()));
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),
                fileSystemResource);
        javaMailSender.send(mimeMessage);
        System.out.printf("Mail with attachment sent successfully..");
        return "Mail with attachment sent successfully..";

    }

    private Object getSenderEmailId(String senderId){

        //repository_get
        return "ajasabdulazeezofficial@gmail.com";
    }
}
