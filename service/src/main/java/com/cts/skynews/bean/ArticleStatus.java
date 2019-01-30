package com.cts.skynews.bean;

public class ArticleStatus {

	private boolean saved;
	private boolean articleExists;
	private boolean markedFavourite;
	
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
	public boolean isMarkedFavourite() {
		return markedFavourite;
	}
	
	public void setMarkedFavourite(boolean markedFavourite) {
		this.markedFavourite = markedFavourite;
	}
	
	
}
