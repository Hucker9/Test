package com.example.test.model.response;

import com.example.test.model.Priority;
import com.example.test.model.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude
@JsonPropertyOrder({
        "title",
        "priority",
        "status",
        "description",
        "comment"
})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponseDto {
    @JsonIgnore
    private int idtask;
    @JsonProperty("title")
    private String title;
    @JsonProperty("priority")
    private Priority priority;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("description")
    private String description;
    @JsonProperty("comment")
    private String comment;
}
