package io.angelo.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

//In Spring, @Service is used to tell Spring that it's a singleton.

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("1", "Yii2", "Yii2 Description"),
			new Topic("2", "Java", "Java Description"),
			new Topic("3", "Javascript", "Javascript Description")));

	/**
	 * @desc Get all topics.
	 * @return
	 */
	public List<Topic> getAllTopics() {
		return topics;
	}

	/**
	 * @desc Returns one topic. Comparison done using lambda expressions.
	 * @param id
	 * @return topic t
	 */
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	/**
	 * @desc Add new topic
	 * @param topic
	 */
	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	/**
	 * @desc Update an existing topic
	 * @param id
	 * @param topic
	 */
	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	/**
	 * @desc Delete a topic.
	 * @param id
	 */
	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}
