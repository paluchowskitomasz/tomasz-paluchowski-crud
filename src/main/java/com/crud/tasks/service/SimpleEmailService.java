package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class SimpleEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleEmailService.class);
    @Autowired
    private JavaMailSender javaMailSender;


    public void send(Mail mail) {

        LOGGER.info("Starting email preparation...");

        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            javaMailSender.send(createMailMessage(mail));

            LOGGER.info("Email has been sent.");
        } catch (MailException e) {
            LOGGER.error("Fail to process email sending: ", e.getMessage(), e);
        }
    }

    private SimpleMailMessage createMailMessage(final Mail mail) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        if (mail.getToCC() != null) {
            mailMessage.setCc(mail.getToCC());
        }

        return mailMessage;
    }
}
