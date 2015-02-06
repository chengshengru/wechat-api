package com.qq.weixin.api.model;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("item")
public class PicItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String PicMd5Sum;

	public String getPicMd5Sum() {
		return PicMd5Sum;
	}

	public void setPicMd5Sum(String picMd5Sum) {
		PicMd5Sum = picMd5Sum;
	}
	
}
