package com.cts.skynews.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.skynews.bean.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

	Article findArticleByTitle(String title);
}
