package kr.co.mindall.apply.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.mindall.apply.service.MngService;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	private final MngService mngService;
	
	public UserDetailServiceImpl(MngService mng) {
		this.mngService = mng;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}

	
}
