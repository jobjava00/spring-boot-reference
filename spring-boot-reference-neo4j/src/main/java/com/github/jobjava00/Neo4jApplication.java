package com.github.jobjava00;

import com.github.jobjava00.neo4j.Meeting;
import com.github.jobjava00.neo4j.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Neo4jApplication {

	@Autowired MeetingRepository meetingRepository;

	/**
	 *
	 -- unix shell 입력
	 docker run \
	 --publish=7474:7474 --publish=7687:7687 \
	 --volume=$HOME/neo4j/data:/data \
	 neo4j

	 -- windows cmd shell 입력
	 docker run ^
	 --publish=7474:7474 --publish=7687:7687 ^
	 --volume=\$HOME/neo4j/data:/data ^
	 neo4j
	 * @param args
	 */
	// docker 로 띄우면 http://localhost:7474/browser/ 접속 가능
	public static void main(String[] args) {
		SpringApplication.run(Neo4jApplication.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner() {
		return args -> {
			Meeting meeting = new Meeting();
			meeting.setName("New Meeting");
			meeting.setTitle("Neo4j Study");
			meetingRepository.save(meeting);
		};
	}
}

