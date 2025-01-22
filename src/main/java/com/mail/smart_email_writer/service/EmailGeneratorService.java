package com.mail.smart_email_writer.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.mail.smart_email_writer.entity.EmailRequest;

@Service
public class EmailGeneratorService {

    @Value("${gemini.api.url}")
    private String geminiApiUrl;
    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public String generateReplyEmail(EmailRequest emailRequest){
        String prompt = buildPrompt(emailRequest);
        // Craft the request according to its form
        Map<String, Object> requestBody = Map.of(
            "contents",new Object[]{
                Map.of("parts", new Object[]{
                    Map.of("text",prompt)
                })
            }
        );
        // Send request -> return response
        return "";

    }

    public String buildPrompt(EmailRequest emailRequest){
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a professional email reply for the following email. Please don't write subject lines.");
        if (emailRequest.getTone()!=null && !emailRequest.getTone().isEmpty()) {
            prompt.append("Use a ").append(emailRequest.getTone()).append(" tone.");
        }
        prompt.append("\nOriginal Email Content:\n").append(emailRequest.getEmailContent());
        return prompt.toString();        
    }
    
}
