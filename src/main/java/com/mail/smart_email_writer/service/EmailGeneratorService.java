package com.mail.smart_email_writer.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mail.smart_email_writer.entity.EmailRequest;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmailGeneratorService {

    private final WebClient webClient;

    @Value("${gemini.api.url}")
    private String geminiApiUrl;
    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public EmailGeneratorService (WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.build();
    }

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
        String response = webClient.post()
            .uri(geminiApiUrl+geminiApiKey)
            .header("Content-Type","application/json")
            .bodyValue(requestBody)
            .retrieve()
            .bodyToMono(String.class)
            .block();

        return extractResponseContent(response);
        
            }
        
    private String extractResponseContent(String response) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(response);
            return rootNode.path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();
            
        } catch (Exception e) {
            return "Error in processing request: "+e.getMessage();
        }
                
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
