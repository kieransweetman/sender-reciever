package com.example.reciever.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ResponseSender {

    private final RestTemplate restTemplate;

    @Value("${sender.service.url}")
    private String senderServiceUrl;

    public ResponseSender(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendResponse(String message) {
        String url = senderServiceUrl + "/task/completed";
        restTemplate.postForObject(url, message, String.class);
    }
}