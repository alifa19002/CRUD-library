package com.example.crudlibrary.controller;

import com.example.crudlibrary.model.Book;
import com.example.crudlibrary.model.Mailing;
import com.example.crudlibrary.model.Response;
import com.example.crudlibrary.repository.BookRepository;
import com.example.crudlibrary.service.BookService;
import com.example.crudlibrary.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/send-mail")
public class MailingController {
//    @Autowired
//    private BookRepository bookRepository;
    @Autowired
    private EmailService emailService;
    @PostMapping
    ResponseEntity<Response> sendMail (@RequestBody @Validated Mailing mailing) /*Mengambil Request data dari Body dan melakukan Proses Validasi*/
    {
        Response response = new Response();
        response.setMessage("Berhasil Mengirim E-mail");
        emailService.sendMail(mailing);
        response.setData(mailing);

        return  ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
