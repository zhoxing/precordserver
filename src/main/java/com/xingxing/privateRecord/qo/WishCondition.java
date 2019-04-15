package com.xingxing.privateRecord.qo;

import java.io.Serializable;

public class WishCondition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4667267648321353158L;

	private String wishId;
	private String wishDate;
	private String wishContent;
	private String wishStatus;
	
	
	public String getWishId() {
		return wishId;
	}
	public void setWishId(String wishId) {
		this.wishId = wishId;
	}
	public String getWishDate() {
		return wishDate;
	}
	public void setWishDate(String wishDate) {
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
		return "WishCondition [wishId=" + wishId + ", wishDate=" + wishDate + ", wishContent=" + wishContent
				+ ", wishStatus=" + wishStatus + "]";
	}
	
	
	
	
}
