package com.akd.taskmanagement.service;

import com.akd.taskmanagement.dto.TaskDto;
import com.akd.taskmanagement.entity.Task;
import com.akd.taskmanagement.repository.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ObjectMapper objectMapper;

    public TaskService(TaskRepository taskRepository, ObjectMapper objectMapper) {
        this.taskRepository = taskRepository;
        this.objectMapper = objectMapper;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByAssignedUserId(userId);
    }

    public TaskDto updateTask(Task task) {
        Task savedTask = taskRepository.save(task);
        return objectMapper.convertValue(savedTask, TaskDto.class);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public void moveTask(Long taskId, Long newParentId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalArgumentException("Task not found"));
        Task newParentTask = taskRepository.findById(newParentId).orElseThrow(() -> new IllegalArgumentException("New parent task not found"));

        task.setStory(newParentTask.getStory());
        taskRepository.save(task);
    }

    public int getUserWorkload(Long userId) {
        return taskRepository.findByAssignedUserId(userId).size();
    }

    public int getTasksByStatus(Long userId, String status) {
        return (int) taskRepository.findByAssignedUserId(userId).stream()
                .filter(task -> task.getStatus().equalsIgnoreCase(status))
                .count();
    }
}
