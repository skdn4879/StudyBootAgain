package com.iu.home.util;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Pager {

	private Long page;
	private Long startNum;
	private Long lastNum;
	private Long perPage = 5L;
	private Long totalPage;
	private Long startRow;
	private Long perBlock = 5L;
	private Long totalBlock;
	private Long curBlock;
	
	private boolean pre;
	private boolean next;
	
	private String kind;
	private String search;
	
	public void getRow() {
		this.startRow = (this.getPage() - 1) * this.getPerPage();
	}
	
	public void getNum(Long totalCount) {
		this.totalPage = totalCount / this.getPerPage();
		
		if(totalCount % this.getPerPage() > 0) {
			this.totalPage++;
		}
		
		this.totalBlock = this.getTotalPage() / this.getPerBlock();
		
		if(this.getTotalPage() % this.getPerBlock() > 0) {
			this.totalBlock++;
		}
		
		this.curBlock = this.getPage() / this.getPerBlock();
		
		if(this.getPage() % this.getPerBlock() > 0) {
			this.curBlock++;
		}
		
		this.startNum = ((this.getCurBlock() - 1) * this.getPerBlock() + 1);
		this.lastNum = this.getCurBlock() * this.getPerBlock();
		
		if(this.lastNum > this.getTotalPage()) {
			this.lastNum = this.totalPage;
		}
		
		if(this.getCurBlock() > 1) {
			this.pre = true;
		} else {
			this.pre = false;
		}
		
		if(this.getCurBlock() < this.getTotalBlock()) {
			this.next = true;
		} else {
			this.next = false;
		}
		
	}
	
	public Long getPage() {
		if(this.page == null || this.page <= 0) {
			this.page = 1L;
		}
		return this.page;
	}
	
	public String getKind() {
		if(this.kind == null) {
			this.kind = "";
		}
		return this.kind;
	}
	
	public String getSearch() {
		if(this.search == null) {
			this.search = "";
		}
		return this.search;
	}
	
}
