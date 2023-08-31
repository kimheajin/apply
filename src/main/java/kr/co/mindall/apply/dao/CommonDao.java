package kr.co.mindall.apply.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("commonDao")
public class CommonDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public <T> T select(String queryId, Object paramObject) {
		return sqlSession.selectOne(queryId, paramObject);
	}
	
	public int insert(String queryId, Object paramObject) {
		return sqlSession.insert(queryId, paramObject);
	}
}
