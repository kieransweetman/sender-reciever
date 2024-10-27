package com.example.sender.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sender.service.TaskRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/task")
public class TaskExecutionController {

    private final TaskRequestService taskRequestService;

    @Autowired
    public TaskExecutionController(TaskRequestService taskExecutionService) {
        this.taskRequestService = taskExecutionService;
    }

    @GetMapping("/test-hello")
    public String hello() {
        return "Hello from sender";
    }

    @PostMapping("/send")
    public String startTask() {
        taskRequestService.sendTask();
        return "Sending task.";
    }

    @PostMapping("/completed")
    public String completedTask(@RequestBody String entity) {
        System.out.println("Task completed: " + entity);
        return entity;
    }

}