package com.example.test.service.serviceIMPL;

import com.example.test.model.Status;
import com.example.test.model.Task;
import com.example.test.model.requestDTO.TaskDTO;
import com.example.test.model.response.TaskResponseDto;
import com.example.test.repository.TaskRepository;
import com.example.test.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void create(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setComment(taskDTO.getComment());
        task.setStatus(taskDTO.getStatus());
        task.setPriority(taskDTO.getPriority());
        taskRepository.save(task);
    }

    @Override
    public void delete(int id) {
        taskRepository.delete(taskRepository.getById(id));
    }

    @Override
    public void updateTask(int id, TaskDTO taskDTO) {
        Task byId = taskRepository.getById(id);
        byId.setTitle(taskDTO.getTitle());
        byId.setDescription(taskDTO.getDescription());
        byId.setComment(taskDTO.getComment());
        byId.setStatus(taskDTO.getStatus());
        byId.setPriority(taskDTO.getPriority());
        taskRepository.save(byId);
    }

    @Override
    public List<?> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskResponseDto> taskResponseDto = new ArrayList<>();
        for (Task task : tasks) {
            TaskResponseDto taskResponseDto1 = new TaskResponseDto();
            taskResponseDto1.setTitle(task.getTitle());
            taskResponseDto1.setPriority(task.getPriority());
            taskResponseDto1.setStatus(task.getStatus());
            taskResponseDto1.setComment(task.getComment());
            taskResponseDto1.setDescription(task.getDescription());
            taskResponseDto.add(taskResponseDto1);
        }
        return taskResponseDto;
    }
}
