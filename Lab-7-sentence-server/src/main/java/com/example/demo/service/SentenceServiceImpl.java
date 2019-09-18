package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SentenceServiceImpl implements SentenceService {

	@Autowired
	private WordService wordService;
	@Override
	public String buildSentence() {
		
		return String.format("%s,%s,%s,%s,%s", 
						wordService.getSubject().toString(),
						wordService.getVerb().toString(),
						wordService.getArticle().toString(),
						wordService.getAdjective().toString(),
						wordService.getNoun().toString());
	}

}
