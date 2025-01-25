package com.mail.smart_email_writer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mail.smart_email_writer.entity.EmailRequest;
import com.mail.smart_email_writer.service.EmailGeneratorService;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "*") // Allow requests from any domain
public class EmailGeneratorController {

    private final EmailGeneratorService emailGeneratorService;

    public EmailGeneratorController(EmailGeneratorService emailGeneratorService) {
        this.emailGeneratorService = emailGeneratorService;
    }
    
    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest){
        String response = emailGeneratorService.generateReplyEmail(emailRequest);
        return ResponseEntity.ok(response); 
        
    }
}
