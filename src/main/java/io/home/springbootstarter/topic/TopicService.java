package io.home.springbootstarter.topic;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics=new ArrayList<>(Arrays.asList(
			new Topic("Spring","Spring framework","Spring framework Discription"),
			new Topic("Hibernate","Hibernate Object Relational Mapping ","Hibernate Annotaitons"),
			new Topic("Collections","Collections framework","Collection types and Discription")
			));
	
	public List<Topic> getAllTopics()
	{
		return topics;
	}

	public Topic getTopicByIndex(String topicId) {
		return topics.stream().filter(t ->t.getId().equals(topicId)).findFirst().get();
	}
	
	public List<Topic> CreateNewTopic(Topic topic)
	{
		
		topics.add(topic);
		return topics;
	}

	public void UpdateTopic(String id, Topic topic) {
		
		for(int i=0;i<topics.size();i++)
		{
			Topic t=topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
				return;
			}
		}
		
	}

	public void DeleteThisTopics(String topicId) {
		topics.removeIf(t -> t.getId().equals(topicId));
		
		
	}
	

}
