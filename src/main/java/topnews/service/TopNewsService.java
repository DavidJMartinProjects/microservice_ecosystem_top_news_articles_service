package topnews.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import topnews.domain.NewsArticles;

public interface TopNewsService {
	ResponseEntity<NewsArticles> getTopNewsArticles();	
	ResponseEntity<Map<Integer, String>> getTopNewsTitles();
}
	