package topnews.business;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import topnews.domain.NewsArticles;

public interface TopNews {
	ResponseEntity<NewsArticles> getTopArticles();	
	ResponseEntity<Map<Integer, String>> getArticleTitles();
}
			