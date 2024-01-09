package com.moveone.app.util;

public class Pager {
	private Long startRow;
	private Long lastRow;
	private Long perPage=10l;
	private Long page;
	
	private Long totalPage;
	private Long startNum;
	private Long lastNum;
	
	private Boolean start;
	private Boolean last;
	
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getPerPage() {
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getPage() {
		return (this.page == null || this.page < 1)?  1L :page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	
	public Boolean getStart() {
		return start;
	}
	public void setStart(Boolean start) {
		this.start = start;
	}
	public Boolean getLast() {
		return last;
	}
	public void setLast(Boolean last) {
		this.last = last;
	}
	
	public void makeRow() {
		this.startRow = 1 + (getPage()-1)*getPerPage();
		this.lastRow = getPage()*getPerPage();
	}
	
	public void makeNum(Long totalCount) {
		this.totalPage = (long)Math.ceil((double)totalCount/getPerPage());
		
		Long perBlock = 5L;
		Long totalBlock = (long)Math.ceil((double)totalPage/perBlock);
		Long currentBlock = (long)Math.floor((double)(getPage()-1)/perBlock) + 1;
		
		this.startNum = 1 + (currentBlock - 1)*perBlock;
		this.lastNum = perBlock*currentBlock;
		
		this.start = (currentBlock == 1);
		
		if(currentBlock == totalBlock) {
			this.last=true;
			this.lastNum=totalPage;
		}
	}
}
