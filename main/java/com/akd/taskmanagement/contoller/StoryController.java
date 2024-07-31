package com.akd.taskmanagement.contoller;

import com.akd.taskmanagement.dto.StoryDto;
import com.akd.taskmanagement.entity.Story;
import com.akd.taskmanagement.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stories")
public class StoryController {

    @Autowired
    private final StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @PostMapping
    public Story createStory(@RequestBody Story story) {
        return storyService.createStory(story);
    }

    @PutMapping("/{storyId}")
    public Story updateStory(@PathVariable Long storyId, @RequestBody Story story) {
        story.setId(storyId);
        return storyService.updateStory(story);
    }

    @DeleteMapping("/{storyId}")
    public void deleteStory(@PathVariable Long storyId) {
        storyService.deleteStory(storyId);
    }

    @GetMapping
    public List<StoryDto> getAllStories() {
        return storyService.getAllStories();
    }

}
