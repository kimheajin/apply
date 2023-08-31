package kr.co.mindall.apply.mapper;

import org.apache.ibatis.annotations.Mapper;

import kr.co.mindall.apply.security.dto.MngAccount;

//@Mapper
public interface LoginMapper {

	public MngAccount getUser(MngAccount mngAccount); 
}
