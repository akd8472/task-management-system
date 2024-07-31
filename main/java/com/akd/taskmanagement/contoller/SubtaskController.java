package com.akd.taskmanagement.contoller;

import com.akd.taskmanagement.entity.Subtask;
import com.akd.taskmanagement.service.SubtaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subtasks")
public class SubtaskController {

    @Autowired
    private final SubtaskService subtaskService;


    public SubtaskController(SubtaskService subtaskService) {
        this.subtaskService = subtaskService;
    }

    @PostMapping
    public Subtask createSubtask(@RequestBody Subtask subtask) {
        return subtaskService.createSubtask(subtask);
    }

    @PutMapping("/{subtaskId}")
    public Subtask updateSubtask(@PathVariable Long subtaskId, @RequestBody Subtask subtask) {
        subtask.setId(subtaskId);
        return subtaskService.updateSubtask(subtask);
    }

    @DeleteMapping("/{subtaskId}")
    public void deleteSubtask(@PathVariable Long subtaskId) {
        subtaskService.deleteSubtask(subtaskId);
    }

    @GetMapping("/task/{taskId}")
    public List<Subtask> getSubtasksByTaskId(@PathVariable Long taskId) {
        return subtaskService.getSubtasksByTaskId(taskId);
    }
}
