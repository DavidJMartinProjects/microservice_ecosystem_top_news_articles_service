package topnews.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import topnews.domain.NewsArticles;
import topnews.service.TopNewsService;	

@RestController
public class TopNewsControllerImpl implements TopNewsController {
	
	@Autowired
	TopNewsService topNewsService;	
	
	Logger logger = LoggerFactory.getLogger(TopNewsControllerImpl.class);	

	@GetMapping("/")
	public ResponseEntity<NewsArticles> getTopNewsArticles() {
		logger.info("getTopNewsArticles() : recieved request for top ten news articles");
		return topNewsService.getTopNewsArticles();
	}
	
	@GetMapping("/titles")
	public ResponseEntity<Map<Integer, String>> getTopNewsTitles() {
		logger.info("getTopNewsTitles() : recieved request for top ten news article titles");
		return topNewsService.getTopNewsTitles();
	}

}
		