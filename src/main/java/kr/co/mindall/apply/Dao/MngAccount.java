package kr.co.mindall.apply.Dao;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MngAccount {

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
	
	MngAccount(String mngSn, String mngId, String prntMngSn, String mngNm, String mngPw)
	
}
