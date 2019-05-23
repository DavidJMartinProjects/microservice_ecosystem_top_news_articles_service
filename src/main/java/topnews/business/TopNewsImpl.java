package topnews.business;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import topnews.config.TopNewsConfig;
import topnews.domain.Articles;
import topnews.domain.NewsArticles;

@Component
public class TopNewsImpl implements TopNews {
	
	@Autowired
	TopNewsConfig topNewsConfig;	
	
	RestTemplate restTemplate;
	
	String topNewsArticlesApiKey;
	String topNewsArticlesApiUrl;
	
	Logger logger = LoggerFactory.getLogger(TopNewsImpl.class);	
		
	@PostConstruct
	public void init() {
		restTemplate = new RestTemplate();
		topNewsArticlesApiKey = topNewsConfig.getTopNewsArticlesApiKey();
		topNewsArticlesApiUrl = topNewsConfig.getTopNewsArticlesApiUrl();
	}
		
	@Override
	public ResponseEntity<NewsArticles> getTopArticles() {
		logger.info("getTopNewsArticles() : attempting to make request to top news articles at the following url : " +topNewsArticlesApiUrl);
		ResponseEntity<NewsArticles> newsArticlesResponse = restTemplate.getForEntity(topNewsArticlesApiUrl, NewsArticles.class);
		return newsArticlesResponse;
	}

	@Override
	public ResponseEntity<Map<Integer, String>> getArticleTitles() {	
		logger.info("getArticleTitles() : attempting to make request to top news articles at the following url : " +topNewsArticlesApiUrl);
		ResponseEntity<NewsArticles> newsArticlesResponse = restTemplate.getForEntity(topNewsArticlesApiUrl, NewsArticles.class);
		NewsArticles responseBody = newsArticlesResponse.getBody();
		return new ResponseEntity<Map<Integer, String>>(extractArticleTitles(responseBody.getArticles()), HttpStatus.OK);
	}

	private Map<Integer, String> extractArticleTitles(Articles[] articlesArr) {
		logger.info("extractArticleTitles() : extracting article titles.");
		Map<Integer, String> articlesMap = new HashMap<>();	
		for (int i = 0; i < articlesArr.length; i++) {
			articlesMap.put(i, articlesArr[i].getTitle());
		}
		return articlesMap;
	}	

}
