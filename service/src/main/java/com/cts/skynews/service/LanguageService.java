package com.cts.skynews.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.skynews.bean.Language;
import com.cts.skynews.repository.LanguageRepository;

@Service
public class LanguageService {

	@Autowired
	private LanguageRepository languageRepository;
	//private LanguageDao languageDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(LanguageService.class);

	public List<Language> fetchAllLanguage() {
		LOGGER.info("START : Inside fetchAllLanguage() of LanguageService Class ");
		LOGGER.info("END : Inside fetchAllLanguage() of LanguageService Class ");
		//return languageDao.fetchAllLanguage();
		return languageRepository.findAll();
	}
}
