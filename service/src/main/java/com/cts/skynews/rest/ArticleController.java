package com.cts.skynews.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.skynews.bean.Article;
import com.cts.skynews.bean.ArticleStatus;
import com.cts.skynews.service.ArticleService;

@RequestMapping("/article")
@RestController
public class ArticleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	private ArticleService articleService;
	
	@PostMapping("/save")
	public ArticleStatus saveArticle(@RequestBody Article article){
		LOGGER.info("START : Inside saveArticle() method of ArticleController");
		LOGGER.debug("Aricle Object {}",article);
		return articleService.saveArticle(article);
	}
}
