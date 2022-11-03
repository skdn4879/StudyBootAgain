package com.iu.home.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	/*@PostMapping("login")
	public String getLogin(MemberVO memberVO, HttpSession session) throws Exception {
		memberVO = memberService.getLogin(memberVO);
		
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
		}
		
		return "redirect:/";
	}*/
	
	@GetMapping("login")
	public String getLogin() throws Exception {
		return "member/login";
	}
	
	@PostMapping("join")
	public ModelAndView setJoin(@Valid MemberVO memberVO, BindingResult bindingResult, ModelAndView mv) throws Exception {
		boolean errorCheck = memberService.memberErrorCheck(memberVO, bindingResult);
		if(errorCheck) {
			mv.setViewName("member/join");
			return mv;
		}
		memberService.setJoin(memberVO);
		mv.setViewName("redirect:/member/login");
		return mv;
		
	}

	@GetMapping("join")
	public String getJoin(@ModelAttribute MemberVO memberVO) throws Exception {
		return "member/join";
	}
	
}
