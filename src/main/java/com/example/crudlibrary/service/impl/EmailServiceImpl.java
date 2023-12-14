package com.example.crudlibrary.service.impl;

import com.example.crudlibrary.exception.DataNotFoundException;
import com.example.crudlibrary.model.BookDTO;
import com.example.crudlibrary.model.Mailing;
import com.example.crudlibrary.repository.BookRepository;
import com.example.crudlibrary.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void sendMail(Mailing mailing) {
        BookDTO book = new  BookDTO(bookRepository.findById(mailing.getId())
                .orElseThrow(() -> new DataNotFoundException(mailing.getId())));

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailing.getEmailTo());
        message.setSubject("Send Email by Id");
        message.setText(book.toString());

        mailSender.send(message);
    }
}
