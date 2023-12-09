package com.example.test.controller;

import com.example.test.model.requestDTO.TaskDTO;
import com.example.test.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody TaskDTO taskDTO){
        taskService.create(taskDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?>search(){
        return ResponseEntity.ok(taskService.getAllTasks());
    }

}

