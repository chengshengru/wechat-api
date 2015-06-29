package com.qq.weixin.api.model;

import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;


/**
 * 反馈消息
 * 
 * @author chengshengru
 *
 */
public class WechatResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 消息id
	 */
	private Integer resId;

	/**
	 * 消息类型（text/image/video/news）
	 */
	private String resType;
	/**
	 * 消息的回复内容
	 */
	private String resContent;
	/**
	 * 消息保存格式
	 */
	private String resSaveType;
	/**
	 * 消息创建时间
	 */
	private Date resCreateTime;
	/**
	 * 消息的状态
	 */
	private Integer resStatus;

	/**
	 * 消息的key
	 */
	private String resKey;

	/**
	 * 反馈消息别称
	 */
	private String resName;

	private List<Article> resNews;

	private HashMap<String, String> mAttrs = new HashMap<String, String>();

	public Integer getResId() {
		return resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public String getResType() {
		return resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}

	public String getResContent() {
		return resContent;
	}

	public void setResContent(String resContent) {
		this.resContent = resContent;
	}

	public String getResSaveType() {
		return resSaveType;
	}

	public void setResSaveType(String resSaveType) {
		this.resSaveType = resSaveType;
	}

	public Date getResCreateTime() {
		return resCreateTime;
	}

	public void setResCreateTime(Date resCreateTime) {
		this.resCreateTime = resCreateTime;
	}

	public Integer getResStatus() {
		return resStatus;
	}

	public void setResStatus(Integer resStatus) {
		this.resStatus = resStatus;
	}

	public String getResKey() {
		return resKey;
	}

	public void setResKey(String resKey) {
		this.resKey = resKey;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public void setAttribute(String key, String value) {
		mAttrs.put(key, value);
	}

	public String getAttribute(String key) {
		return mAttrs.get(key);
	}

	public List<Article> getResNews() {
		return resNews;
	}

	public void setResNews(List<Article> resNews) {
		this.resNews = resNews;
	}

	@Override
	public String toString() {
		return "WechatResponse [resId=" + resId + ", resType=" + resType
				+ ", resContent=" + resContent + ", resSaveType=" + resSaveType
				+ ", resCreateTime=" + resCreateTime + ", resStatus="
				+ resStatus + ", resKey=" + resKey + ", resName=" + resName
				+ "]";
	}

}
