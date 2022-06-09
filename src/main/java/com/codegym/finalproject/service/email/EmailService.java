package com.codegym.finalproject.service.email;

import com.codegym.finalproject.model.entity.MailObject;

public interface EmailService {
    void sendSimpleMessage(MailObject email);
}
