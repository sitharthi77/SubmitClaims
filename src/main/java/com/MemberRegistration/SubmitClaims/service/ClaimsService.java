package com.MemberRegistration.SubmitClaims.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MemberRegistration.SubmitClaims.model.UserDetails;
import com.MemberRegistration.SubmitClaims.repository.UserRepository;

@Service
public class ClaimsService {
	@Autowired
	private UserRepository userRepository;
	
     public UserDetails fetchUserByMemberId(String memberId) {
		
		
		return userRepository.findByMemberId(memberId);
		
	}

	public UserDetails saveUser(UserDetails userobj) {
	 
		return userRepository.save(userobj);
	}

}
