package com.parkingbooking.parkingbookingv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parkingbooking.parkingbookingv1.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	
	public User findByUsername(String username);

}
