package org.zerock.dao;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "org.zerock.mapper.MemberMapper";

	@Override
	public String getTime() {
		return sqlSession.selectOne(namespace+".getTime");
	}

	@Override
	public void insertMember(MemberDto dto) {
		sqlSession.insert(namespace+".insertMember", dto);
	}
	
	@Override
	public MemberDto readMember(String userid) throws Exception {
		return (MemberDto)sqlSession.selectOne(namespace+".selectMember", userid);
	}
	
	@Override
	public MemberDto readWithPw(String userid, String userpw) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		
		return (MemberDto)sqlSession.selectOne(namespace+".readWithPw", paramMap);
	}

}
