package com.github.jobjava00.mongo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jobjava00
 */
@RunWith(SpringRunner.class)
@DataMongoTest
public class MeetingRepositoryTests {
	@Autowired MeetingRepository meetingRepository;

	@Test
	public void findByAddress(){
		//Given
		Meeting meeting = new Meeting();
		meeting.setTitle("new meeting test");
		meeting.setAddress("seoul");
		meetingRepository.save(meeting).block();

		Meeting mongoMeeting = new Meeting();
		mongoMeeting.setTitle("new meeting test2");
		mongoMeeting.setAddress("busan");
		meetingRepository.save(mongoMeeting).block();

		//When
		List<Meeting> result = meetingRepository.findByAddress("busan").collectList().block();

		//Then
		assertThat(result.size()).isEqualTo(1);
		assertThat(result).contains(mongoMeeting);

		meetingRepository.delete(meeting).block();
		meetingRepository.delete(mongoMeeting).block();
	}
}
