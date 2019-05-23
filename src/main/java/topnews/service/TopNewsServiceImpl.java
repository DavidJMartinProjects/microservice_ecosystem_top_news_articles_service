package topnews.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import topnews.business.TopNews;
import topnews.domain.NewsArticles;	

@Component
public class TopNewsServiceImpl implements TopNewsService {
	
	@Autowired	
	TopNews topNews;
	
	Logger logger = LoggerFactory.getLogger(TopNewsServiceImpl.class);	

	@Override
	public ResponseEntity<NewsArticles> getTopNewsArticles() {
		logger.info("getTopNewsArticles() : recieved request for top ten news articles");
		return topNews.getTopArticles();
	}
	
	public ResponseEntity<Map<Integer, String>> getTopNewsTitles() {
		return topNews.getArticleTitles();
	}
	
}
		