package com.akd.taskmanagement.repository;

import com.akd.taskmanagement.entity.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubtaskRepository extends JpaRepository<Subtask, Long> {

    List<Subtask> findByParentTaskId(Long taskId);

}
