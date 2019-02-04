package com.cts.skynews.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "article")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ar_id")
	private int id;

	@Column(name = "ar_author")
	private String author;
	
	@NotNull(message = "Title cannot be empty")
	@Column(name = "ar_title")
	private String title;
	
	@NotNull(message = "Description cannot be empty")
	@Column(name = "ar_description")
	private String description;

	@NotNull(message = "URL cannot be empty")
	@Column(name = "ar_url")
	private String url;

	@Column(name = "ar_urltoimage")
	private String urlToImage;

	@Column(name = "ar_publishedat")
	private String publishedAt;

	@Column(name = "ar_content")
	private String content;

//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "articles")
//	private List<User> users;

	@Transient
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	public String getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", author=" + author + ", title=" + title + ", description=" + description
				+ ", url=" + url + ", urlToImage=" + urlToImage + ", publishedAt=" + publishedAt + ", content="
				+ content + ", email=" + email + "]";
	}

}
