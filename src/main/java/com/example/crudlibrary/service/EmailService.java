package com.example.crudlibrary.service;

import com.example.crudlibrary.model.Mailing;

public interface EmailService {
    void sendMail(Mailing mailing);
}
