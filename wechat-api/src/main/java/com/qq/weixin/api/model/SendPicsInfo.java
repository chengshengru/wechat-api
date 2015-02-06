package com.qq.weixin.api.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("SendPicsInfo")
public class SendPicsInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int Count;
	
	private ArrayList<PicItem> PicList;

	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}

	public ArrayList<PicItem> getPicList() {
		return PicList;
	}

	public void setPicList(ArrayList<PicItem> picList) {
		PicList = picList;
	}
	
	
	
}
