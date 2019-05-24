package topnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TopNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopNewsApplication.class, args);
	}

}
