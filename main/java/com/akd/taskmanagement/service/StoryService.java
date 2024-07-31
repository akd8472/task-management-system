package com.akd.taskmanagement.service;

import com.akd.taskmanagement.dto.StoryDto;
import com.akd.taskmanagement.entity.Story;
import com.akd.taskmanagement.repository.StoryRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoryService {

    private final StoryRepository storyRepository;
    private final ObjectMapper objectMapper;

    public StoryService(StoryRepository storyRepository, ObjectMapper objectMapper) {
        this.storyRepository = storyRepository;
        this.objectMapper = objectMapper;
    }

    public Story createStory(Story story) {
        return storyRepository.save(story);
    }

    public Story updateStory(Story story) {
        return storyRepository.save(story);
    }

    public void deleteStory(Long storyId) {
        storyRepository.deleteById(storyId);
    }

    public List<StoryDto> getAllStories() {
        return storyRepository.findAll()
                .stream().map(story -> objectMapper.convertValue(story, StoryDto.class))
                .toList();
    }
}
