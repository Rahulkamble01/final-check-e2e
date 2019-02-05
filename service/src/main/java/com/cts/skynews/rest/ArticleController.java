package com.cts.skynews.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.skynews.bean.Article;
import com.cts.skynews.bean.ArticleStatus;
import com.cts.skynews.bean.User;
import com.cts.skynews.service.ArticleService;

@RequestMapping("/rest/article")
@RestController
public class ArticleController extends SkyNewsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	private ArticleService articleService;
	
	@PostMapping("/save")
	public ArticleStatus saveArticle(@RequestBody Article article){
		LOGGER.info("START : Inside saveArticle() method of ArticleController");
		LOGGER.debug("Aricle Object {}",article);
		return articleService.saveArticle(article);
	}
	
	
	
	@GetMapping("/fetchfavArticle/{emailId}")
	public User saveArticle(@PathVariable String emailId){
		LOGGER.info("START : Inside saveArticle() method of ArticleController");
		LOGGER.debug("Email Id : {}",emailId);
		return articleService.fetchAllFavArticles(emailId);
	}
	
	@PostMapping("/remove")
	public User removeFavArticle(@RequestBody Article article){
		LOGGER.info("START : Inside removeFavArticle() method of ArticleController");
		LOGGER.debug("Aricle Object {}",article);
		 return articleService.reomveFavouredMark(article);
	}
}
