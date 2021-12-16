package com.parkingbooking.parkingbookingv1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.parkingbooking.parkingbookingv1.domain.Role;
import com.parkingbooking.parkingbookingv1.domain.User;
import com.parkingbooking.parkingbookingv1.repository.UserRepository;

@Service
public class UserCreationService {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	public UserCreationService() {
	}

	public void createUsers() {
		User admin = new User("admin", passwordEncoder.encode("admin"), "ROLE_" + Role.ADMIN.toString());
		User user = new User("user", passwordEncoder.encode("user"), "ROLE_" + Role.USER.toString());

		userRepository.save(admin);
		userRepository.save(user);
	}
}
