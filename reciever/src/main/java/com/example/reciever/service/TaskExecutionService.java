package com.example.reciever.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TaskExecutionService {

    private final ResponseSender responseSender;

    @Autowired
    public TaskExecutionService(ResponseSender responseSender) {
        this.responseSender = responseSender;
    }

    @Async
    public void executeTask() {
        for (int i = 0; i <= 250; i++) {
            try {
                System.out.println("Count: " + i);
                Thread.sleep(1000); // 1-second delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Task interrupted", e);
            }
        }
        responseSender.sendResponse("Task completed successfully");
    }
}
