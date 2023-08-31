package kr.co.mindall.apply.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.mindall.apply.dao.CommonDao;
import kr.co.mindall.apply.security.dto.MngAccount;

@Service
public class MngDetailService implements UserDetailsService{

	@Autowired
	private CommonDao commonDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MngAccount mng = commonDao.select("commonDao.getUser", username);
		if(mng != null) {
			return mng; 
		}
		return null;
		
	}

	
}
