package com.xingxing.privateRecord.domain;

import java.io.Serializable;
import java.util.Date;

public class WishingDo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer wishId;
	private Date wishDate;
	private String wishContent;
	private String wishStatus;
	public Integer getWishId() {
		return wishId;
	}
	public void setWishId(Integer wishId) {
		this.wishId = wishId;
	}
	public Date getWishDate() {
		return wishDate;
	}
	public void setWishDate(Date wishDate) {
		this.wishDate = wishDate;
	}
	public String getWishContent() {
		return wishContent;
	}
	public void setWishContent(String wishContent) {
		this.wishContent = wishContent;
	}
	public String getWishStatus() {
		return wishStatus;
	}
	public void setWishStatus(String wishStatus) {
		this.wishStatus = wishStatus;
	}
	@Override
	public String toString() {
		return "WishingDo [wishId=" + wishId + ", wishDate=" + wishDate + ", wishContent=" + wishContent
				+ ", wishStatus=" + wishStatus + "]";
	}
	
	

	
}
