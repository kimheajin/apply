package kr.co.mindall.apply.service;

import org.springframework.security.crypto.password.PasswordEncoder;

import kr.co.mindall.apply.security.dto.MngAccount;

public interface MngService {

	public void createUser(MngAccount mngAccount);
	
	public PasswordEncoder passwordEncoder();
	
	public MngAccount getUser(MngAccount mngAccount);
}
