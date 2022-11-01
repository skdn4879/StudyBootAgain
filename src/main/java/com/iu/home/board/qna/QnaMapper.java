package com.iu.home.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.iu.home.util.Pager;

@Mapper
public interface QnaMapper {
	
	public int setQnaAdd(QnaVO qnaVO) throws Exception;
	
	public int setQnaFileAdd(QnaFileVO qnaFileVO) throws Exception;
	
	public List<QnaVO> getList(Pager pager) throws Exception;
	
	public Long getCount(Pager pager) throws Exception;

}
