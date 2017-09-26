package com.bigdata2017.mysite.vo;

public class GalleryVo {
	private Long no;
	private String comments;
	private String imageUrl;
	
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
	@Override
	public String toString() {
		return "GalleryVo [no=" + no + ", comments=" + comments + ", imageUrl=" + imageUrl + "]";
	}
	
	

}
