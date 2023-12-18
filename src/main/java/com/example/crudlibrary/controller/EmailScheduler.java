package com.example.crudlibrary.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class EmailScheduler {
    @Autowired
    private JavaMailSender emailSender;
    private static final Logger log = LoggerFactory.getLogger(EmailScheduler.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Scheduled(zone ="Asia/Jakarta", cron = "0 52 11 * * *") //s m h date month day
    public void reportCurrentTime() throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

//        helper.setFrom("noreply@baeldung.com");
        helper.setTo("alifa.anwar@asyst.co.id");
        helper.setSubject("Scheduler");
        getLastModified("src/main/resources");
        FileSystemResource file
//                = new FileSystemResource("src/main/resources/6-14Dec_2023_bags.xlsx");
                = new FileSystemResource(getLastModified("src/main/resources"));
        if(file.exists()) {
            helper.setText(file.getPath() + ", file readable" + file.isReadable());
            helper.addAttachment(file.getFilename(), file);
            emailSender.send(message);
        } else {
            log.info("The time is now {}", dateFormat.format(new Date()));
        }
    }

    public static File getLastModified(String directoryFilePath)
    {
        File directory = new File(directoryFilePath);
        File[] files = directory.listFiles(File::isFile);
        long lastModifiedTime = Long.MIN_VALUE;
        File chosenFile = null;

        if (files != null)
        {
            for (File file : files)
            {
                if (file.lastModified() > lastModifiedTime)
                {
                    chosenFile = file;
                    lastModifiedTime = file.lastModified();
                }
            }
        }

        return chosenFile;
    }
}