package com.example.test.service;

import com.example.test.model.requestDTO.TaskDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    void create(TaskDTO taskDTO);
    void delete(int id);
    void updateTask(int id, TaskDTO taskDTO);
     List<?> getAllTasks();
}
