package com.MemberRegistration.SubmitClaims.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MemberRegistration.SubmitClaims.model.Claim;
import com.MemberRegistration.SubmitClaims.model.UserDetails;
import com.MemberRegistration.SubmitClaims.service.ClaimsService;


@RestController
public class ClaimsController {
	@Autowired
    private ClaimsService claimsservice ;
	
	@PostMapping("/submitClaims")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<UserDetails> SubmitClaims(@RequestBody UserDetails userdetails) throws Exception {
		String memberId = userdetails.getMemberId();
		UserDetails userobj=null;
		if(memberId!=null) {
			userobj=claimsservice.fetchUserByMemberId(memberId);
		}
		if(userobj==null) {

			throw new Exception("MemberId is not present");
			
		}
		
	    List<Claim> appendclaims=userobj.getClaims();
	    appendclaims.addAll(userdetails.getClaims());
	    userobj.setClaims(appendclaims);
		userobj=claimsservice.saveUser(userobj);
		
		
		return new ResponseEntity<>(userobj, HttpStatus.OK);
	}
}
