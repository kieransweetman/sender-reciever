package com.example.reciever.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reciever.service.TaskExecutionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskExecutionController {

    private final TaskExecutionService taskExecutionService;

    @Autowired
    public TaskExecutionController(TaskExecutionService taskExecutionService) {
        this.taskExecutionService = taskExecutionService;
    }

    @GetMapping("/test-hello")
    public String hello() {
        return "Hello from reciever";
    }

    @PostMapping("/start")
    public String startTask() {
        taskExecutionService.executeTask();
        return "Task started";
    }
}