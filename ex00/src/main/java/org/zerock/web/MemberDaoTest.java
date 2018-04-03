package org.zerock.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.dao.MemberDao;
import org.zerock.domain.MemberDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDaoTest {
	
	@Inject
	private MemberDao dao;
	
	@Test
	public void testTime()throws Exception{
		System.out.println(dao.getTime());
	}
	
	@Test
	public void testInsertMember()throws Exception{
		
		MemberDto dto = new MemberDto();
		dto.setUserid("user05");
		dto.setUserpw("userpw");
		dto.setUsername("USER00");
		dto.setEmail("user00@aaa.com");
		
		dao.insertMember(dto);
		
		dao.readMember("user05");
		dao.readWithPw("user05", "userpw");
		
	}

}
