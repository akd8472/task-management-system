package com.akd.taskmanagement.contoller;

import com.akd.taskmanagement.dto.TaskDto;
import com.akd.taskmanagement.entity.Task;
import com.akd.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/user/{userId}")
    public List<Task> getTasksByUserId(@PathVariable Long userId) {
        return taskService.getTasksByUserId(userId);
    }

    @PutMapping("/{taskId}")
    public TaskDto updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        task.setId(taskId);
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }

    @PutMapping("/move/{taskId}/{newParentId}")
    public void moveTask(@PathVariable Long taskId, @PathVariable Long newParentId) {
        taskService.moveTask(taskId, newParentId);
    }

    @GetMapping("/user/{userId}/workload")
    public int getUserWorkload(@PathVariable Long userId) {
        return taskService.getUserWorkload(userId);
    }

//    @GetMapping("/user/{userId}/status/{status}")
//    public int getTasksByStatus(@PathVariable Long userId, @PathVariable String status) {
//        return taskService.getTasksByStatus(userId, status);
//    }

}
