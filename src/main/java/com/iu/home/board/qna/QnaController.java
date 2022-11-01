package com.iu.home.board.qna;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/qna/*")
@Slf4j
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@PostMapping("add")
	public ModelAndView setAdd(@Valid QnaVO qnaVO, BindingResult bindingResult, ModelAndView mv, MultipartFile[] files) throws Exception {
		
		if(bindingResult.hasErrors()) {
			mv.setViewName("board/add");
			return mv;
		}
		
		qnaService.setQnaAdd(qnaVO, files);
		
		mv.setViewName("redirect:/qna/list");
		return mv;
	}
	
	@GetMapping("add")
	public String setAdd(@ModelAttribute QnaVO qnaVO) throws Exception {
		return "board/add";
	}

	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception {
		List<QnaVO> qnaList = qnaService.getList(pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("qnaList", qnaList);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		
		return mv;
	}
	
}
