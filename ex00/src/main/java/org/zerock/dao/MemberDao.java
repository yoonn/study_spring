package org.zerock.dao;

import org.zerock.domain.MemberDto;

public interface MemberDao {
	
	public String getTime();
	
	public void insertMember(MemberDto dto);
	
	public MemberDto readMember(String userid) throws Exception;
	
	public MemberDto readWithPw(String userid, String userpw) throws Exception;

}
