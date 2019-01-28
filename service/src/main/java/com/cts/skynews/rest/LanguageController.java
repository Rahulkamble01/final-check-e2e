package com.cts.skynews.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.skynews.bean.Language;
import com.cts.skynews.service.LanguageService;

@RestController
@RequestMapping("/language")
public class LanguageController {

	@Autowired
	private LanguageService languageService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LanguageController.class);
	
	@GetMapping("/list")
	public List<Language> fetchAllLanguage(){
		LOGGER.info("START : Inside fetchAllLanguage() of LanguageController Class ");
		return languageService.fetchAllLanguage();
	}
}
