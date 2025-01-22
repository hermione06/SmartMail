package com.mail.smart_email_writer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mail.smart_email_writer.entity.EmailRequest;

@RestController
@RequestMapping("/api/email")
public class EmailGeneratorController {
    
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest){
        //
        return ResponseEntity.ok(""); // TODO: returns generated email
        
    }
}
