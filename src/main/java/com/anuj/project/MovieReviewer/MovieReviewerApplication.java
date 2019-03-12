package com.anuj.project.MovieReviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.anuj.project.MovieReviewer")
public class MovieReviewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieReviewerApplication.class, args);
	}

}
