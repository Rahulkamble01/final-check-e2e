package com.cts.skynews.bean;

public class ArticleStatus {

	private boolean saved;
	private boolean articleExists;
	public boolean isSaved() {
		return saved;
	}
	public void setSaved(boolean saved) {
		this.saved = saved;
	}
	public boolean isArticleExists() {
		return articleExists;
	}
	public void setArticleExists(boolean articleExists) {
		this.articleExists = articleExists;
	}
	
	
}
