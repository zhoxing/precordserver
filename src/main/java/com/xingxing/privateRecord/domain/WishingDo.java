package com.xingxing.privateRecord.domain;

import java.io.Serializable;
import java.util.Date;

public class WishingDo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Date wishDate;
	private String wishCont;
	private String wishSta;
	public Date getWishDate() {
		return wishDate;
	}
	public void setWishDate(Date wishDate) {
		this.wishDate = wishDate;
	}
	public String getWishCont() {
		return wishCont;
	}
	public void setWishCont(String wishCont) {
		this.wishCont = wishCont;
	}
	public String getWishSta() {
		return wishSta;
	}
	public void setWishSta(String wishSta) {
		this.wishSta = wishSta;
	}
	@Override
	public String toString() {
		return "WishingDo [wishDate=" + wishDate + ", wishCont=" + wishCont
				+ ", wishSta=" + wishSta + "]";
	}

	
}
