package com.iu.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/*public MemberVO getLogin(MemberVO memberVO) throws Exception {
		memberVO = memberMapper.getLogin(memberVO);
		
		return memberVO;
	}*/
	
	@Transactional(rollbackFor = Exception.class)
	public int setJoin(MemberVO memberVO) throws Exception {
		memberVO.setPw(passwordEncoder.encode(memberVO.getPw()));
		int memberResult = memberMapper.setJoin(memberVO);
		int roleResult = memberMapper.setMemberRoleJoin(memberVO);
		
		return memberResult;
		
	}
	
	public boolean memberErrorCheck(MemberVO memberVO, BindingResult bindingResult) throws Exception {
		boolean check = false;
		
		check = bindingResult.hasErrors();
		
		if(!memberVO.getPw().equals(memberVO.getPwcheck())) {
			check = true;
			bindingResult.rejectValue("pwcheck", "member.password.notEqual");
		}
		
		if(memberMapper.getIdCheck(memberVO) > 0) {
			check = true;
			bindingResult.rejectValue("id", "member.id.overlap");
		}
		
		return check;
		
	}

}
