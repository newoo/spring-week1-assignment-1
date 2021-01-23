package com.codesoom.assignment.helper;

import com.codesoom.assignment.model.Task;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Objects;

/**
 * Return task by arguments.
 */
public class TaskManager {
    public static Task toTask(String content, Long id) throws JsonProcessingException {
        Task task = new ObjectMapper().readValue(content, Task.class);
        task.setId(id);
        return task;
    }

    public static Task getTask(List<Task> tasks, Long taskId) {
        return tasks.stream()
                .filter(element -> Objects.equals(taskId, element.getId()))
                .findFirst()
                .orElse(new Task());
    }
}