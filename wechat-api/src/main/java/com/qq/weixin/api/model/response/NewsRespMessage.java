package com.qq.weixin.api.model.response;

import java.util.List;

import com.qq.weixin.api.model.Article;
import com.qq.weixin.api.model.BaseMessage;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("xml")
public class NewsRespMessage extends BaseMessage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer ArticleCount;

	private List<Article> Articles;

	public NewsRespMessage() {
		super();
		MsgType = WX_MSG_TYPE_NEWS;
	}

	public Integer getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(Integer articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}

}
