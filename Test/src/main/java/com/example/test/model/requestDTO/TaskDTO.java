package com.example.test.model.requestDTO;

import com.example.test.model.Priority;
import com.example.test.model.Status;
import lombok.Data;

@Data
public class TaskDTO {
    private String title;
    private String description;
    private String comment;
    private Status status;
    private Priority priority;

}
