package com.iu.home.board.qna;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class QnaVO {
	
	private Long num;
	@NotBlank
	private String writer;
	@NotBlank
	private String title;
	@NotBlank
	@Size(min = 12)
	private String contents;
	private Long hit;
	private Date regDate;
	private Integer ref;
	private Integer step;
	private Integer depth;
	
	private List<QnaFileVO> qnaFiles;

}
