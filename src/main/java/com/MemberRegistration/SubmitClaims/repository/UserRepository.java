package com.MemberRegistration.SubmitClaims.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.MemberRegistration.SubmitClaims.model.UserDetails;

public interface UserRepository extends MongoRepository<UserDetails,String>{
	public UserDetails findByMemberId(String memberId);

}




