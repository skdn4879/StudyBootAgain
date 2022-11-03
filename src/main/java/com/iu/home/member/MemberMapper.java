package com.iu.home.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Mapper
public interface MemberMapper {

	public MemberVO getLogin(String username) throws UsernameNotFoundException;
	
	public int setJoin(MemberVO memberVO) throws Exception;
	
	public int setMemberRoleJoin(MemberVO memberVO) throws Exception;
	
	public int getIdCheck(MemberVO memberVO) throws Exception;
	
}
