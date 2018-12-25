package com.github.jobjava00.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author jobjava00
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
	Optional<Person> findByEmail(String email);
}
