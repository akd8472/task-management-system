package com.akd.taskmanagement.repository;

import com.akd.taskmanagement.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long> {}
