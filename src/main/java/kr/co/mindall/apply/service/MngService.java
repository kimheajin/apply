package kr.co.mindall.apply.service;

import java.util.HashMap;
import java.util.List;

import kr.co.mindall.apply.Dao.MngAccount;

public interface MngService {

	public int createUser(MngAccount member);
	
	public List<HashMap<String, Object>> getUser();
}
