package topnews.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("urls.top-news-articles")
public class TopNewsConfig {
	
	String topNewsArticlesApiKey;
	String topNewsArticlesApiUrl;
	
	public String getTopNewsArticlesApiKey() {
		return topNewsArticlesApiKey;
	}
	public void setTopNewsArticlesApiKey(String topNewsArticlesApiKey) {
		this.topNewsArticlesApiKey = topNewsArticlesApiKey;
	}
	public String getTopNewsArticlesApiUrl() {
		return topNewsArticlesApiUrl;
	}
	public void setTopNewsArticlesApiUrl(String topNewsArticlesApiUrl) {
		this.topNewsArticlesApiUrl = topNewsArticlesApiUrl;
	}	

}
