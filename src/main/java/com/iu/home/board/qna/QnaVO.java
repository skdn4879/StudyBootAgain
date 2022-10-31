package com.iu.home.board.qna;

import java.sql.Date;

import lombok.Data;

@Data
public class QnaVO {
	
	private Long num;
	private String writer;
	private String title;
	private String contents;
	private Long hit;
	private Date regDate;
	private Integer ref;
	private Integer step;
	private Integer depth;

}
