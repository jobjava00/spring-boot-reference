package com.github.jobjava00.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author jobjava00
 */
@Component
public class DataPopulator implements ApplicationRunner {
	@Autowired
	MeetingRepository redisMeetingRepository;

	@Autowired StringRedisTemplate redisTemplate;

	@Override public void run(ApplicationArguments args) throws Exception {
		Meeting meeting = new Meeting();
		meeting.setTitle("New Meeting");
		meeting.setStartAt(new Date());
		redisMeetingRepository.save(meeting);

		redisMeetingRepository.findAll().forEach(m -> {
			System.out.println("======================Redis====================");
			System.out.println(m.getTitle() + " " + m.getStartAt());
		});
	}
}
