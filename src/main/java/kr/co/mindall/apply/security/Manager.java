package kr.co.mindall.apply.security;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import kr.co.mindall.apply.Dao.MngAccount;

public class Manager implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MngAccount mngAccount;
	private Collection<? extends GrantedAuthority> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}


	@Override
	public String getPassword() {
		return mngAccount.getMngPw();
	}

	@Override
	public String getUsername() {
		return mngAccount.getMngNm();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
