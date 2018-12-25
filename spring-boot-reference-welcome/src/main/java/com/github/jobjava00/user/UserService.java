package com.github.jobjava00.user;

import org.springframework.stereotype.Service;

/**
 * @author jobjava00
 */
@Service
public class UserService {
	private final UserRepository userRepository;

	//@Autowired 가 없어도 암묵적으로 생성자가 한개면 빈 등록 해준다. -> 그러나 명시적으로 @Autowired 써주는게 좋다.
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}
}
