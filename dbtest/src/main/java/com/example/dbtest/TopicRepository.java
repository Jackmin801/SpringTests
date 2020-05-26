package com.example.dbtest;

import com.example.dbtest.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
    //getAllTopics()
    //getTopics(String id)
    //updateTopic(Topic t)
    //deleteTopic(String id)

}
