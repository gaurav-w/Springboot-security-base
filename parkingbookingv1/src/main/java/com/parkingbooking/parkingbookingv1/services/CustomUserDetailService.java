package com.parkingbooking.parkingbookingv1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.parkingbooking.parkingbookingv1.domain.CustomUserDetails;
import com.parkingbooking.parkingbookingv1.domain.User;
import com.parkingbooking.parkingbookingv1.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findByUsername(username);
		if(user==null)
				throw new UsernameNotFoundException("No Such User");
		return new CustomUserDetails(user);
	}

}
