package kr.co.mindall.apply.security;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;


public class MngAuthenticationProvider implements AuthenticationProvider{

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
	}

	@Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
	
}