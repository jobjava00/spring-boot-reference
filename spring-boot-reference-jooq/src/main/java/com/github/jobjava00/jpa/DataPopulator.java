package com.github.jobjava00.jpa;

import com.github.jobjava00.jooq.Sequences;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

import static com.github.jobjava00.jooq.tables.Meeting.MEETING;

/**
 * @author jobjava00
 */
@Component
public class DataPopulator implements ApplicationRunner{
	@Autowired
	MeetingRepository meetingRepository;

	@Autowired
	PersonRepository personRepository;

	@Autowired DSLContext dsl;

	@Override public void run(ApplicationArguments args) throws Exception {
		Person person = new Person();
		person.setEmail("jobjava00@gmail.com");
		person.setName("jobjava");
		person.setJoined(new Date());
		personRepository.save(person);

		Optional<Person> personOptional = personRepository.findByEmail("jobjava00@gmail.com");
		personOptional.ifPresent(p -> System.out.println(p.getName()));

		Meeting meeting = new Meeting();
		meeting.setTitle("title");
		meeting.setLocation("Seoul");
		meetingRepository.save(meeting);

		dsl.insertInto(MEETING)
				.set(MEETING.ID, Sequences.HIBERNATE_SEQUENCE.nextval())
				.set(MEETING.TITLE, "JOOQ Study")
				.set(MEETING.LOCATION, "Seoul")
				.execute();
	}
}
