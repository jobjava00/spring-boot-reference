package com.github.jobjava00.jpa;


import javax.persistence.*;
import java.util.Date;

/**
 * @author jobjava00
 */
@Entity
public class Person {
	@Id @GeneratedValue
	private Long id;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date joined;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getJoined() {
		return joined;
	}

	public void setJoined(Date joined) {
		this.joined = joined;
	}
}
