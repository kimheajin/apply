package kr.co.mindall.apply.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.mindall.apply.dao.CommonDao;
import kr.co.mindall.apply.mapper.LoginMapper;
import kr.co.mindall.apply.security.dto.MngAccount;
import kr.co.mindall.apply.service.MngService;


@Service
//@Transactional(rollbackFor = Exception.class)
public class MngServiceImpl implements MngService{

//	@Autowired
//	private LoginMapper loginMapper;
	
	@Autowired
	private CommonDao commonDao;
	
	private final PasswordEncoder pwEncoder = new BCryptPasswordEncoder();
	
	@Override
	public void createUser(MngAccount mngAccount) {
		if(!mngAccount.getMngId().equals("") && mngAccount.getMngPw().equals("")) {
			mngAccount.setMngPw(pwEncoder.encode(mngAccount.getMngPw()));
			commonDao.insert("login.setUser", mngAccount);
		}
	}
	
	public PasswordEncoder passwordEncoder() {
		return this.pwEncoder;
	}
	
	public MngAccount getUser(MngAccount mngAccount) {
		// MngAccount rstl = loginMapper.getUser(mngAccount);
		MngAccount rstl = commonDao.select("login.getUser", mngAccount.getMngId());
		return rstl;
	}
}
