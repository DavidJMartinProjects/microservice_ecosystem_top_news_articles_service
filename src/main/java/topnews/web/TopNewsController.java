package topnews.web;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import topnews.domain.NewsArticles;

public interface TopNewsController {
	ResponseEntity<NewsArticles> getTopNewsArticles();	
	ResponseEntity<Map<Integer, String>> getTopNewsTitles();
}	
