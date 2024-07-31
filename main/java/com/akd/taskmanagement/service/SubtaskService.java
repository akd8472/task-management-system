package com.akd.taskmanagement.service;

import com.akd.taskmanagement.entity.Subtask;
import com.akd.taskmanagement.repository.SubtaskRepository;
import com.akd.taskmanagement.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubtaskService {

    private final SubtaskRepository subtaskRepository;

    public SubtaskService(SubtaskRepository subtaskRepository, TaskRepository taskRepository) {
        this.subtaskRepository = subtaskRepository;
    }

    public Subtask createSubtask(Subtask subtask) {
        return subtaskRepository.save(subtask);
    }

    public Subtask updateSubtask(Subtask subtask) {
        return subtaskRepository.save(subtask);
    }

    public void deleteSubtask(Long subtaskId) {
        subtaskRepository.deleteById(subtaskId);
    }

    public List<Subtask> getSubtasksByTaskId(Long taskId) {
        return subtaskRepository.findByParentTaskId(taskId);
    }

}
