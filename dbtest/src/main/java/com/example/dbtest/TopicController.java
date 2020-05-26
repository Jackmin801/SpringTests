package com.example.dbtest;

import com.example.dbtest.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping
    public List<Topic> getAllTopic(){
        return topicService.getAllTopics();
    }

    @GetMapping("/{id}")
    public Topic getTopic(@PathVariable("id") String id){
        return topicService.getTopic(id);
    }

    @PostMapping
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @PutMapping
    public  void updateTopic(String id, @RequestBody Topic topic){
        topicService.updateTopic(id,topic);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable("id")String id){
        topicService.deleteTopic(id);
    }
}
