package com.github.jobjava00.neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

/**
 * @author jobjava00
 */
public interface MeetingRepository extends Neo4jRepository<Meeting, Long> {
	List<Meeting> findByTitleContains(String title);
}
