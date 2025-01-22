package com.mail.smart_email_writer.entity;

import lombok.Data;

@Data
public class EmailRequest {
        private String emailContent;
        private String tone;
}
