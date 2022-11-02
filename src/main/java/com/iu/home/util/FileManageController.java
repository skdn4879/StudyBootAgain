package com.iu.home.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.qna.QnaFileVO;
import com.iu.home.board.qna.QnaService;

@Controller
@RequestMapping("/resources/*")
public class FileManageController {
	
	@Autowired
	private QnaService qnaService;

	@GetMapping("down/{path}")
	public ModelAndView getFileDown(@PathVariable String path, QnaFileVO qnaFileVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if(path.equals("qna")) {
			qnaFileVO = qnaService.getFileDetail(qnaFileVO);
		}
		
		mv.addObject("fileVO", qnaFileVO);
		mv.addObject("path", path);
		mv.setViewName("fileManager");
		
		return mv;
		
	}
	
}
