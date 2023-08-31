package kr.co.mindall.apply.security.dto;

import java.sql.Date;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MngAccount implements UserDetails {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	private String mngSn;
	
	private String mngId;
	
	private String prntMngSn;
	
	private String mngNm;
	
	private String mngPw;
	
	private String useYn;
	
	private int loginFailCnt;
	
	private Date loginFailDt;
	
	private Date lastLoginDt;
	
	private Date chngPwDt;
	
	private String regUser;
	
	private Date regDt;
	
	private String udpUser;
	
	private Date udpDt;
	
	private String role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return this.mngPw;
	}

	@Override
	public String getUsername() {
		return this.mngId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}