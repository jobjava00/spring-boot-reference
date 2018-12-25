package com.github.jobjava00.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * @author jobjava00
 */
@Repository
public interface MeetingRepository extends ReactiveMongoRepository<Meeting, String> {
	Flux<Meeting> findByAddress(String address);
}
