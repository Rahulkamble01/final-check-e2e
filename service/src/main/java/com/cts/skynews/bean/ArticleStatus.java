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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticleStatus other = (ArticleStatus) obj;
		if (articleExists != other.articleExists)
			return false;
		if (markedFavourite != other.markedFavourite)
			return false;
		if (saved != other.saved)
			return false;
		return true;
	}
	
	
}
