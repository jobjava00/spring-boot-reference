package com.github.jobjava00.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * @author jobjava00
 */
@Component
public class DbPopulator implements ApplicationRunner {
	@Autowired MongoDbFactory mongoDbFactory;

	@Autowired MongoTemplate mongoTemplate;

	@Autowired
	MeetingRepository meetingRepository;

	@Override public void run(ApplicationArguments args) throws Exception {
		//MongDatabase 사용법
		/*MongoDatabase db = mongoDbFactory.getDb();
		db.createCollection("meetings");
		db.getCollection("meetings").insertOne(
				new Document()
						.append("title", "new meeting")
						.append("location", "seoul"));*/

		//MongoTemplate 사용법
		Meeting meeting = new Meeting();
		meeting.setAddress("Seoul");
		meeting.setTitle("MongoDB Study");
		mongoTemplate.insert(meeting, "meetings");

		//MeetingRepository 사용법
		meetingRepository.findByAddress("Seoul").collectList().block().forEach(m -> {
			System.out.println("======================MongoDB==================");
			System.out.println(m);
		});
	}
}
