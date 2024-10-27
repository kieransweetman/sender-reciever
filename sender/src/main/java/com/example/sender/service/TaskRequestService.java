package com.example.sender.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TaskRequestService {

    private final RestTemplate restTemplate;

    @Value("${reciever.service.url}")
    private String recieverServiceUrl;

    public TaskRequestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // overloading
    public void sendTask() {
        String url = recieverServiceUrl + "/task/start";
        restTemplate.postForObject(url, null, String.class);
    }

}
