package com.codegym.finalproject.service;

import com.codegym.finalproject.model.entity.MailObject;

public interface EmailService {
    void sendSimpleMessage(MailObject email);
}
